import java.util.*;

// --- Model Classes ---
class User {
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex; // 1-based index for simplicity

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() { return questionText; }
    public String[] getOptions() { return options; }
    public int getCorrectAnswerIndex() { return correctAnswerIndex; }
}

// --- Main System ---
public class OnlineExamSystem {
    private static Map<String, User> users = new HashMap<>();
    private static List<Question> questionBank = new ArrayList<>();
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);
    
    // Timer flags
    private static volatile boolean timeUp = false;
    private static volatile boolean examSubmitted = false;

    public static void main(String[] args) {
        initializeData();
        System.out.println("=== WELCOME TO THE ONLINE EXAMINATION SYSTEM ===");
        
        while (true) {
            if (currentUser == null) {
                showMainMenu();
            } else {
                showDashboard();
            }
        }
    }

    private static void initializeData() {
        // Seed a default user (Username: admin, Password: password123)
        users.put("admin", new User("admin", "password123", "John Doe"));

        // Seed some sample MCQs
        questionBank.add(new Question("Which component is used to compile, debug and execute the Java program?", 
                new String[]{"JRE", "JIT", "JDK", "JVM"}, 3));
        questionBank.add(new Question("Which of these keywords is used to define interfaces in Java?", 
                new String[]{"Interface", "interface", "intf", "Inter"}, 2));
        questionBank.add(new Question("Which exception is thrown when string is parsed into a non-numeric format?", 
                new String[]{"IndexOutOfBoundsException", "NullPointerException", "NumberFormatException", "RuntimeException"}, 3));
    }

    private static void showMainMenu() {
        System.out.println("\n1. Login\n2. Exit");
        System.out.print("Select an option: ");
        int choice = getIntInput();

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                System.out.println("Thank you for using the system. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private static void showDashboard() {
        System.out.println("\n--- Dashboard (Logged in as: " + currentUser.getName() + ") ---");
        System.out.println("1. Update Profile & Password");
        System.out.println("2. Start Examination");
        System.out.println("3. Logout");
        System.out.print("Select an option: ");
        int choice = getIntInput();

        switch (choice) {
            case 1:
                updateProfile();
                break;
            case 2:
                startExam();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    // --- Core Functionalities ---

    // 1. Login Functionality
    private static void login() {
        System.out.print("\nEnter Username: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            currentUser = users.get(username);
            System.out.println("Login Successful! Welcome, " + currentUser.getName());
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    // 2. Update Profile and Password Functionality
    private static void updateProfile() {
        System.out.println("\n--- Update Profile ---");
        System.out.print("Enter new Name (Current: " + currentUser.getName() + "): ");
        scanner.nextLine(); // clear buffer
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) {
            currentUser.setName(newName);
        }

        System.out.print("Enter new Password: ");
        String newPassword = scanner.next();
        if (!newPassword.trim().isEmpty()) {
            currentUser.setPassword(newPassword);
            System.out.println("Profile and Password updated successfully!");
        }
    }

    // 3 & 4. Selecting Answers, Timer, and Auto-Submit Functionality
    private static void startExam() {
        timeUp = false;
        examSubmitted = false;
        int[] userAnswers = new int[questionBank.size()];
        Arrays.fill(userAnswers, -1); // -1 means unanswered

        int examDurationSeconds = 30; // 30-second quick exam for demo purposes
        System.out.println("\n--- Exam Started ---");
        System.out.println("You have " + examDurationSeconds + " seconds to complete the exam.");
        System.out.println("Type your answer (1-4) or '0' to skip. Press Enter after each answer.");

        // Start background Timer Thread
        Thread timerThread = new Thread(() -> {
            try {
                for (int i = examDurationSeconds; i > 0; i--) {
                    if (examSubmitted) return; // Stop timer if user submitted early
                    if (i == 10) {
                        System.out.println("\n[WARNING] 10 seconds remaining!");
                    }
                    Thread.sleep(1000);
                }
                if (!examSubmitted) {
                    timeUp = true;
                    System.out.println("\n\nTime is UP! Press Enter to auto-submit and see results...");
                }
            } catch (InterruptedException e) {
                // Thread interrupted
            }
        });
        timerThread.start();

        // Exam Question Loop
        for (int i = 0; i < questionBank.size(); i++) {
            if (timeUp) break;

            Question q = questionBank.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getQuestionText());
            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            System.out.print("Your answer (1-4): ");
            
            // Non-blocking prompt simulation step: if time runs out while waiting for input
            int ans = -1;
            if (scanner.hasNextInt()) {
                ans = scanner.nextInt();
            } else {
                scanner.next(); // clear non-int input
            }

            if (timeUp) {
                break; // Ignore input if time expired mid-typing
            }

            userAnswers[i] = ans;
        }

        // Process Submission
        examSubmitted = true;
        try {
            timerThread.join(); // Ensure timer finishes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        evaluateExam(userAnswers);
    }

    private static void evaluateExam(int[] userAnswers) {
        System.out.println("\n--- Exam Result / Auto-Submitted ---");
        int score = 0;
        for (int i = 0; i < questionBank.size(); i++) {
            Question q = questionBank.get(i);
            int selectedAns = userAnswers[i];
            System.out.print("Q" + (i + 1) + ": ");
            if (selectedAns == q.getCorrectAnswerIndex()) {
                score++;
                System.out.println("Correct");
            } else if (selectedAns == -1 || selectedAns == 0) {
                System.out.println("Unanswered (Correct answer was " + q.getCorrectAnswerIndex() + ")");
            } else {
                System.out.println("Wrong (You chose " + selectedAns + ", Correct was " + q.getCorrectAnswerIndex() + ")");
            }
        }
        System.out.println("\nYour Total Score: " + score + "/" + questionBank.size());
    }

    // 5. Closing Session and Logout Functionality
    private static void logout() {
        System.out.println("Logging out session for user: " + currentUser.getUsername());
        currentUser = null; // Clears the session references
        System.out.println("Session closed. Returning to main menu.");
    }

    // Helper to gracefully catch invalid integer choices
    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}