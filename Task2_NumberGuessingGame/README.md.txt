# Number Guessing Game

## Overview

This is a Java-based Number Guessing Game developed as part of the Oasis Infobyte Java Development Internship.

The game generates a random number between 1 and 100. The player must guess the correct number within a limited number of attempts. The game includes multiple rounds, difficulty levels, a scoring system, and performance evaluation.

## Features

* Random number generation (1–100)
* Three difficulty levels:

  * Easy (10 attempts)
  * Medium (7 attempts)
  * Hard (5 attempts)
* Multiple rounds
* Score calculation based on remaining attempts
* Higher/Lower hints
* Input validation
* Final performance evaluation

## Technologies Used

* Java
* VS Code
* GitHub

## Project Structure

```text
Task2_NumberGuessingGame
│
├── NumberGuessingGame.java
└── README.md
```

## How to Run

### Compile the Program

```bash
javac NumberGuessingGame.java
```

### Run the Program

```bash
java NumberGuessingGame
```

## Sample Output

```text
=================================
      GUESS THE NUMBER GAME
=================================

Choose Difficulty Level:
1. Easy (10 Attempts)
2. Medium (7 Attempts)
3. Hard (5 Attempts)

Round 1
Guess a number between 1 and 100

Enter your guess: 50
Too Low!

Enter your guess: 75
Too High!

Enter your guess: 61
Correct! You guessed the number.

Points Earned: 50
```

## Scoring System

Points are awarded based on the number of attempts remaining.

Formula:

Points = (Remaining Attempts + 1) × 10

## Learning Outcomes

* Java Basics
* Conditional Statements
* Loops
* Random Number Generation
* User Input Handling
* Score Management
* Problem Solving

## Author

Arati Salve

Java Development Intern – Oasis Infobyte
