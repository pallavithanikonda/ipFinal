import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoCaller {
    private ArrayList<TasksList> tasksLists = new ArrayList<>();
    private JSONFileManager fm = new JSONFileManager();
    private static String membersFileName = "tasks-list.json";

    private void loadTasksList(){
        tasksLists.clear();
        tasksLists = fm.readFileTasksList("files/tasks-list.json");
    }
    private void printTasksList(){
        System.out.println("The Current tasks List is :");
        System.out.format("%2s%25s%20s%30s%32s","TaskId","TaskName","Project","Due date","Status");
        System.out.println("");
        System.out.println("***************************************************************************************************************************");
        for(TasksList tasksList:tasksLists){
            System.out.format("%2s%30s%16s%32s%32s",tasksList.getId(),tasksList.getName(),tasksList.getProject(),tasksList.getDate(),tasksList.getStatus());
            System.out.println("");
        }
        System.out.println("***************************************************************************************************************************");
    }
    private void addTask(ArrayList<TasksList> newTasksLists){
        JSONObject object = fm.convertTasksToJson(newTasksLists);
        fm.writeJsonToFile(object,"files/","tasks-list.json");
    }
    private void editTask(String id){

        System.out.println("The current values are: (if you leave empty the old values will be taken)");
        System.out.format("%2s%25s%20s%30s%32s","TaskId","TaskName","Project","Due date","Status");
        System.out.println("");
        System.out.println("***************************************************************************************************************************");
        for(TasksList tasksList:tasksLists){
            if(tasksList.getId().equals(id)){
                System.out.format("%2s%30s%16s%32s%32s",tasksList.getId(),tasksList.getName(),tasksList.getProject(),tasksList.getDate(),tasksList.getStatus());
                System.out.println("");
                System.out.println("Enter task name:");
                String name = userInput();
                tasksList.setName(name.equals("")? tasksList.getName():name);
                System.out.println("Enter Project");
                String project = userInput();
                tasksList.setProject(project.equals("")? tasksList.getProject():project);
                System.out.println("Enter Due date (YYYY-MM-DD)");
                String date = userInput();
                tasksList.setDate(date.equals("")?tasksList.getDate():date);
                System.out.println("Enter the status");
                String status = userInput();
                tasksList.setStatus(status.equals("")?tasksList.getStatus():status);
                break;
            }
        }
        addTask(tasksLists);
    }
    private void removeTask(String id){
        for(TasksList tasksList:tasksLists){
            if(tasksList.getId().equals(id)){
                tasksList.setId("");
            }
        }
        addTask(tasksLists);
    }
    public void mainApp() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        int openTasks =0;
        int closedTasks = 0;
        loadTasksList();
        for(TasksList tasksList:tasksLists){
            if(tasksList.getStatus().equals("open"))
                openTasks=openTasks+1;
            if(tasksList.getStatus().equals("done"))
                closedTasks=closedTasks+1;
        }
        int total = openTasks+closedTasks;
        System.out.println("******************");
        System.out.println("Welcome to ToDoLy ");
        System.out.println("******************");
        // Write a function to read  X and Y from Excel
        System.out.println("You have "+openTasks+" tasks todo and "+closedTasks+" tasks are done! ");
        // Provide options to user to choose
        while (true){
            System.out.println("Pick an option:");
            System.out.println("(1) Show Task List (by date or project)");
            System.out.println("(2) Add New Task");
            System.out.println("(3) Edit Task (update, mark as done)");
            System.out.println("(4) Remove the task");
            System.out.println("(5) Quit");
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
                    printTasksList();
                    break;
                case 2:
                    System.out.println("Provide the details to Add New Task");
                    TasksList tList = new TasksList();
                    int nextId = total+1;
                    tList.setId(""+nextId);
                    System.out.println("Enter task name:");
                    String name = userInput();
                    tList.setName(name);
                    System.out.println("Enter Project");
                    String project = userInput();
                    tList.setProject(project);
                    System.out.println("Enter Due date (YYYY-MM-DD)");
                    String date = userInput();
                    tList.setDate(date);
                    tList.setStatus("open");
                    tasksLists.add(tList);
                    addTask(tasksLists);
                    break;
                case 3:
                    printTasksList();
                    System.out.println("Choose the task Id to Edit Task");
                    String id = userInput();
                    editTask(id);
                    break;
                case 4:
                    System.out.println("Choose the task Id to Edit Task");
                    String removeID = userInput();
                    removeTask(removeID);
                    break;
                case 5:
                    //quit
                    System.exit(0);
            }
        }
    }


    public String userInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
