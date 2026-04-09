CREATE DATABASE quiz_db;
USE quiz_db;

-- Users
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50)
);

-- Quizzes
CREATE TABLE quizzes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quiz_name VARCHAR(50)
);

-- Questions
CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255),
    option1 VARCHAR(100),
    option2 VARCHAR(100),
    option3 VARCHAR(100),
    option4 VARCHAR(100),
    correct_option INT,
    quiz_id INT
);

-- Results
CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    score INT
);

-- Sample Data
INSERT INTO quizzes (quiz_name) VALUES ('Java Quiz'), ('Math Quiz');

INSERT INTO questions (question, option1, option2, option3, option4, correct_option, quiz_id) VALUES
('Java is?', 'Language', 'Animal', 'Car', 'Food', 1, 1),
('JVM stands for?', 'Java Virtual Machine', 'Java Very Much', 'Just VM', 'None', 1, 1),

('2+2=?', '3', '4', '5', '6', 2, 2),
('5*2=?', '10', '20', '15', '5', 1, 2);