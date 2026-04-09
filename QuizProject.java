package com.studyopedia;
import java.sql.*;
import java.util.Scanner;

public class QuizProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/quiz_db";
        String user = "root";
        String pass = "";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            // USER NAME
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            // INSERT USER
            String insertUser = "INSERT INTO users(name) VALUES(?)";
            PreparedStatement pstUser = con.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
            pstUser.setString(1, name);
            pstUser.executeUpdate();

            ResultSet rsUser = pstUser.getGeneratedKeys();
            int userId = 0;
            if (rsUser.next()) {
                userId = rsUser.getInt(1);
            }

            // SHOW QUIZZES
            System.out.println("\nAvailable Quizzes:");
            Statement stQuiz = con.createStatement();
            ResultSet rsQuiz = stQuiz.executeQuery("SELECT * FROM quizzes");

            while (rsQuiz.next()) {
                System.out.println(rsQuiz.getInt("id") + ". " + rsQuiz.getString("quiz_name"));
            }

            System.out.print("Choose quiz: ");
            int quizChoice = sc.nextInt();

            int score = 0;

            // FETCH QUESTIONS
            PreparedStatement pstQ = con.prepareStatement("SELECT * FROM questions WHERE quiz_id=?");
            pstQ.setInt(1, quizChoice);
            ResultSet rs = pstQ.executeQuery();

            while (rs.next()) {

                System.out.println("\n" + rs.getString("question"));
                System.out.println("1. " + rs.getString("option1"));
                System.out.println("2. " + rs.getString("option2"));
                System.out.println("3. " + rs.getString("option3"));
                System.out.println("4. " + rs.getString("option4"));

                long startTime = System.currentTimeMillis();

                System.out.print("Enter answer (1-4): ");
                int ans = sc.nextInt();

                long endTime = System.currentTimeMillis();

                if ((endTime - startTime) > 10000) {
                    System.out.println("Time up!");
                } else {
                    if (ans == rs.getInt("correct_option")) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Wrong!");
                        System.out.println("Correct answer: " + rs.getInt("correct_option"));
                    }
                }
            }

            // SHOW SCORE
            System.out.println("\nYour Score: " + score);

            // SAVE RESULT
            String resultQuery = "INSERT INTO results(user_id, score) VALUES(?,?)";
            PreparedStatement pstResult = con.prepareStatement(resultQuery);
            pstResult.setInt(1, userId);
            pstResult.setInt(2, score);
            pstResult.executeUpdate();

            // LEADERBOARD
            System.out.println("\n--- Leaderboard ---");

            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(
                "SELECT users.name, results.score FROM results " +
                "JOIN users ON users.id = results.user_id " +
                "ORDER BY score DESC LIMIT 5"
            );

            while (rs2.next()) {
                System.out.println(rs2.getString("name") + " - " + rs2.getInt("score"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}