package CODSOFT;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class project2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the chatbot! Type 'quit' to exit.");

        while (true) {
            System.out.print("User: ");
            String userInput = scanner.nextLine().toLowerCase();

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = formatter.format(date);

            switch (userInput) {
                case "quit":
                    System.out.println("Chatbot: Goodbye!");
                    scanner.close();
                    return;
                case "hello":
                case "hi":
                    System.out.println(" Hello! How can I help you today?");
                    break;
                case "how are you":
                    System.out.println(" I'm doing well, thanks for asking!");
                    break;
                case "what is your name":
                    System.out.println("My name is Chatbot!");
                    break;
                case "what is the time":
                    System.out.println("Chatbot: The current time is " + currentTime);
                    break;
                case "what is the date":
                    System.out.println("Chatbot: The current date is " + currentTime);
                    break;
                default:
                    System.out.println("Chatbot: Sorry, I didn't understand that. Please try Inbuilt Question as i'm not updated yet!");
            }
        }
    }
}