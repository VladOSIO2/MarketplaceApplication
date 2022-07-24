import utility.CommandHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, this is a Marketplace application!\nType /help for available commands");
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("/exit")) {
                System.out.println("Exiting from the program... Have a good day!");
                break;
            }
            System.out.println(CommandHandler.handle(command));
        }
    }
}
