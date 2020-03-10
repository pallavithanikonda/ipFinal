import java.rmi.server.ExportException;
import java.util.Scanner;

public class ToDoCaller {
    public static void main(String[] args) {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        System.out.println("******************");
        System.out.println("Welcome to ToDoLy ");
        System.out.println("******************");
        // Write a function to read  X and Y from Excel
        System.out.println("You have X tasks todo and Y tasks are done! ");
        // Provide options to user to choose
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        // get the option as an int
        int option=0;
        try{
            option = scanner.nextInt();
        } catch(Exception e) {
            System.out.println("Please enter only given options");
        }

        System.out.println("The user have selected option:" + option);

        switch (option) {
            case 1:
                System.out.println("Show Task List");
                ToDoTasksFile fileCall = new ToDoTasksFile();
                try{
                    fileCall.readExcel();
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Exception pls try again");
                }
                break;
            case 2:
                System.out.println("Add New Task");
                // Write to code to add a task to a file
                break;
            case 3:
                System.out.println("Edit Task");
                // Write a function which will allow us to edit the tasks in a file
                break;
            case 4:
                System.out.println("Save and Quit");
                // Write a function to save and close the file
                break;
        }
    }
    public int add(int a, int b){
        return a+b;
    }
}
