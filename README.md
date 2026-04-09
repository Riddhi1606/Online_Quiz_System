# Online Quiz System (Java + MySQL)

## 📌 Overview

This project is a console-based Online Quiz System developed using Java and MySQL. It allows users to attempt quizzes, calculates scores, and stores results in a database. The system includes multiple quizzes, timer-based answering, and a leaderboard feature.

---

## 🚀 Features

* User registration (name input)
* Multiple quiz selection
* Questions fetched dynamically from database
* Timer-based answering (10 seconds per question)
* Immediate feedback (correct/wrong answer)
* Score calculation
* Result storage in database
* Leaderboard (Top 5 scores)

---

## 🛠 Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL (XAMPP / phpMyAdmin)
* Eclipse IDE

---

## 🗂 Project Structure

QuizProject/
├── src/
├── bin/
├── quiz_db.sql
├── README.txt

---

## 🗄 Database Setup

1. Start XAMPP and run MySQL
2. Open phpMyAdmin (http://localhost/phpmyadmin)
3. Create database:
   quiz_db
4. Run the SQL queries provided in quiz_db.sql file

---

## ▶️ How to Run

1. Open project in Eclipse
2. Add MySQL Connector JAR file to Build Path
3. Ensure MySQL is running
4. Run `QuizProject.java`
5. Enter your name
6. Select a quiz
7. Answer questions within time

---

## 🧪 Sample Output

Enter your name: Riddhi

Available Quizzes:

1. Java Quiz
2. Math Quiz

Choose quiz: 1

Java is?

1. Language
2. Animal
3. Car
4. Food

Enter answer: 1
Correct!

Your Score: 2

--- Leaderboard ---
Riddhi - 2

---

## ⚙️ Working

* User enters name
* System stores user in database
* User selects a quiz
* Questions are fetched from database
* User answers within time limit
* Score is calculated
* Result is stored in database
* Leaderboard is displayed

---

## 🔮 Future Enhancements

* Add timer countdown display
* Add admin panel for adding questions
* Add user login system
* GUI version using JavaFX

---

## 👩‍💻 Author

Riddhi Sharma
