# Online Examination System

## Overview

The Online Examination System is a Java-based console application developed as part of the Oasis Infobyte Java Development Internship.

This project simulates an online examination environment where users can securely log in, update their profile, attempt multiple-choice questions (MCQs), and receive instant results. The system also includes a timer feature with automatic submission when the allotted time expires.

## Features

### User Authentication

* Secure login using username and password
* Session management for authenticated users

### Profile Management

* Update user profile information
* Change account password

### Online Examination

* Multiple Choice Questions (MCQs)
* Option selection for each question
* Skip questions if desired

### Timer and Auto Submit

* Countdown timer during examination
* Warning message before exam completion
* Automatic submission when time expires

### Result Evaluation

* Instant result generation
* Correct, wrong, and unanswered question tracking
* Score calculation and display

### Session Management

* Logout functionality
* Secure session termination

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Collections Framework (ArrayList, HashMap)
* Multithreading (Timer Implementation)
* VS Code

## Project Structure

```text
Task4_OnlineExamination
│
├── OnlineExamSystem.java
└── README.md
```

## Functional Modules

### Login Module

Authenticates users using valid username and password credentials.

### Update Profile Module

Allows users to modify their profile information and update passwords.

### Examination Module

Displays MCQs and records user responses.

### Timer Module

Monitors exam duration and automatically submits the exam when the time limit is reached.

### Result Module

Evaluates answers and displays the final score.

### Logout Module

Closes the current session and returns the user to the main menu.

## Default Login Credentials

```text
Username: admin
Password: password123
```

## How to Run

### Compile the Program

```bash
javac OnlineExamSystem.java
```

### Run the Program

```bash
java OnlineExamSystem
```

## Sample Menu

```text
=== WELCOME TO THE ONLINE EXAMINATION SYSTEM ===

1. Login
2. Exit
```

## Learning Outcomes

* Java Programming Fundamentals
* Object-Oriented Programming
* User Authentication Systems
* Collections Framework
* Multithreading
* Session Management
* Console-Based Application Development

## Future Enhancements

* Database Integration (MySQL)
* User Registration Module
* Admin Panel
* Larger Question Bank
* Question Categories
* Result History Tracking

## Author

Arati Salve

Java Development Intern – Oasis Infobyte
