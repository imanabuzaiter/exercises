import java.util.Scanner;

public class MiniShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ShellCommandHandler handler = new ShellCommandHandler();
        System.out.println("Welcome to MiniShell! Type 'help' for a list of commands.");

        while (true) {
            System.out.print(handler.getCurrentDirectory().getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;


            switch (command) {
                case "pwd":
                    handler.printWorkingDirectory();
                    break;

                case "ls":
                    handler.listDirectory();
                    break;

                case "cd":
                    if (argument != null) {
                        handler.changeDirectory(argument);
                    } else {
                        System.out.println("Missing folder name.");
                    }
                    break;

                case "mkdir":
                    if (argument != null) {
                        handler.makeDirectory(argument);
                    } else {
                        System.out.println("Missing folder name.");
                    }
                    break;

                case "touch":
                    if (argument != null) {
                        handler.createFile(argument);
                    } else {
                        System.out.println("Missing file name.");
                    }
                    break;

                case "help":
                    handler.printHelp();
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    return;


//                 TODO: Implement the command switch structure
//                 You need to handle the following commands:
//                 - pwd: Print working directory
//                 - ls: List files in current directory
//                 - cd: Change directory
//                 - mkdir: Create new directory
//                 - touch: Create new file
//                 - help: Show help information
//                 - exit: Exit the program
//
//                 Your code should call the appropriate methods from the ShellCommandHandler class
//


                default:
                    System.out.println("Unknown command. Type 'help' to see available commands.");



            }
        }
    }
}