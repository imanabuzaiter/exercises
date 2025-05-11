# exercise 1
חלק 3 :
1: תיאור כללי של הפרויקט.
In this exercise, we  will build a simple command line program in Java that  simulates a terminal. The user will be able to type commands such as pwd, mkdir, ls, and cd and receive output accordingly, while working with the computer's file system
2: הוראות כיצד לקמפל ולהריץ את הקוד
We ran the code by clicking the Run button in Java.4
3: דוגמה להרצת הפקודות
pwd
C:\Users\Admin > pwd
C:\Users\Admin

mkdir
C:\Users\Admin\Downloads > mkdir testFolder
Directory created

ls
C:\Users\Admin\Downloads > ls
[FILE] 1 الصح.jpg
[FILE] 1.jpg
[FILE] 2.jpg
[FILE] 3.jpg
[FILE] 4.jpg
[FILE] desktop.ini
[FILE] Example of a final project proposal report (1).docx

cd
C:\Users\Admin > cd Downloads
C:\Users\Admin\Downloads >

touch
C:\Users\Admin\IdeaProjects\exercise 1 > touch myFile
File created: myFile

help
C:\Users\Admin\IdeaProjects\exercise 1 > help
Available commands:
pwd          - Print working directory
ls           - List directory contents
cd [name]    - Change directory
mkdir [name] - Create new directory
touch [name] - Create new file
help         - Show this help message
exit         - Exit the shell

exit
C:\Users\Admin\IdeaProjects\exercise 1 > exit
Goodbye!

4: הערות בקוד שמסבירות כל שיטה
import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
    private File currentDirectory;

    public ShellCommandHandler() {
        this.currentDirectory = new File(System.getProperty("user.dir"));
        // TODO: Initialize currentDirectory to the user's current working directory
        // Hint: Use System.getProperty("user.dir")
    }

    public void printWorkingDirectory() {
        System.out.println(currentDirectory.getAbsolutePath());
        // TODO: Print the absolute path of the current directory
    }

    public void listDirectory() {
        File[] files = currentDirectory.listFiles();

        // Print name of the all files present in that path
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                System.out.println(file.isDirectory() ? "[DIR] " +
                        file.getName() : "[FILE] " + file.getName());
            }


        } else {
            System.out.println("The folder is empty.");
        }


            // TODO: List all files and directories in the current directory
        // For directories, prefix with "[DIR] "
        // For files, prefix with "[FILE]"
    }

    public void changeDirectory(String name) {
        if (name.equals("..")) {
            File parent = currentDirectory.getParentFile();
            if (parent != null) {
                currentDirectory = parent;
            }
        } else {
            File newDir = new File(currentDirectory, name);
            if (newDir.exists() && newDir.isDirectory()) {
                currentDirectory = newDir;
            } else {
                System.out.println("Directory not found.");
            }
        }
        // TODO: Implement the change directory command
        // If name is null, show usage message: "Usage: cd [directory_name]"
        // If name is "..", move to parent directory if possible
        // Otherwise, try to move to the specified directory
        // If directory doesn't exist, print error message: "Directory not found: [name]"
    }

    public void makeDirectory(String name) {
        File newDir = new File(currentDirectory, name);

        if (!newDir.exists()) {
            if (newDir.mkdir()) {
                System.out.println("Directory created");
            } else {
                System.out.println("Directory not created");
            }
        } else {
            System.out.println("Directory already exists.");
        }

        // TODO: Implement the make directory command
        // If name is null, show usage message: "Usage: mkdir [directory_name]"
        // If directory already exists, print: "Directory already exists."
        // If directory creation is successful, print: "Directory created: [name]"
        // If directory creation fails, print: "Failed to create directory."
    }

    public void createFile(String name) {
        // TODO: Implement the create file command
        try {
// If name is null, show usage message: "Usage: touch [file_name]"
            if (name == null) {
                System.out.println("Usage: touch [file_name]");
                return;
            }

            File newFile = new File(currentDirectory, name);

            if (newFile.exists()) {
                System.out.println("File already exists.");
            } else {
// If file creation is successful, print: "File created: [name]"
                try {
                    if (newFile.createNewFile()) {
                        System.out.println("File created: " + name);
                    } else {
                        System.out.println("Failed to create file.");
                    }
                } catch (IOException e) {
// If file creation fails, print error message with exception details
                    System.err.println("Error creating file: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printHelp() {
        System.out.println("Available commands:");
        System.out.println("pwd          - Print working directory");
        System.out.println("ls           - List directory contents");
        System.out.println("cd [name]    - Change directory");
        System.out.println("mkdir [name] - Create new directory");
        System.out.println("touch [name] - Create new file");
        System.out.println("help         - Show this help message");
        System.out.println("exit         - Exit the shell");

        // TODO: Implement help command to print information about all available commands
        // List all commands with their descriptions
    }

    public File getCurrentDirectory() {
        return currentDirectory;
        // TODO: Return the current directory
        // Replace this with your implementation
    }
}
