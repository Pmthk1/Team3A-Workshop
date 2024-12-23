package Team3A;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Team3A {
    public static void main(String[] args) {
        String filePath = "C:/Team3A/Output/Textfile.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("");
        } catch (IOException e) {
            System.out.println("An error occurred while initializing the file: " + e.getMessage());
            return;
        }

        boolean continueInput = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (continueInput) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Christian Era (Year of Birth): ");
                int yearOfBirth = scanner.nextInt();

                System.out.print("Enter Software Testing Score: ");
                int score = scanner.nextInt();
                scanner.nextLine();

                int currentYear = 2024;
                int age = currentYear - yearOfBirth;

                String grade;
                if (score >= 80) {
                    grade = "A";
                } else if (score >= 75) {
                    grade = "B+";
                } else if (score >= 70) {
                    grade = "B";
                } else if (score >= 65) {
                    grade = "C+";
                } else if (score >= 60) {
                    grade = "C";
                } else if (score >= 55) {
                    grade = "D+";
                } else if (score >= 50) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                try (FileWriter writer = new FileWriter(filePath, true)) {
                    writer.write("Name : " + name + "\n");
                    writer.write("Age : " + age + "\n");
                    writer.write("Software Testing Grade : " + grade + "\n");
                    writer.write("--------------------------\n");
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file: " + e.getMessage());
                }

                System.out.print("Do you want to add another entry? (yes/no): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    continueInput = false;
                }
            }
        }

        System.out.println("Data collection complete. Output written to: " + filePath);
    }
}
