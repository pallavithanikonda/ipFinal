#ToDoly by Software Development Academy - KTH  
ToDoly is a todo list application written in Java that uses a text based user interface. The application will allow a user to create new tasks, assign them a title and due date, and choose a project for that task to belong to.
## Prerequisites
Java version 8+ 
(Please use the link to download Java - https://www.oracle.com/java/technologies/javase-downloads.html)

## Description
The project is a simple application that supports listing, creating, editing and removing tasks from the task list.
The tasks are saved and loaded from a file on disk(We are using JSON file to store the data).

## Running the app 

- Download a zip and unpack the code or git clone the code.
- In the terminal go to the `src` directory in the project directory
- Compile the code
If it is linux or mac, open the terminal and run the below code
```
javac todo/src/main/java/*.java
```
If it is Windows machine, please open the CMD and run the below code 
```
javac todo/src/main/java/*.java
```
- To start the application, run the main `ToDoCallerAppMain` class.
```
java javac todo/src/main/java/ToDoCallerAppMain
```

## User Manual
To use the ToDoly, follow the instructions below:

- Select an option from the main menu:
```sh
******************
Welcome to ToDoLy 
******************
You have 3 tasks todo and 2 tasks are done! 
Pick an option:
(1) Show Task List (by date or project)
(2) Add New Task
(3) Edit Task (update, mark as done)
(4) Remove the task
(5) Save & Quit
```
#### Listing tasks
- For listing the tasks, choose option number `1`.
It will display all the tasks and also will give an options to choose other options.
```
The Current tasks List is :
TaskId                 TaskName             Project                      Due date                          Status
***************************************************************************************************************************
 1            Bring food to home            home                      2020-03-24                            open
 2                     Go to gym        personal                      2020-03-24                            open
 3                         clean            home                      2020-04-21                            open
 4                            gr            home                      2020-05-12                            done
 5                          test          office                      2020-06-12                            done
***************************************************************************************************************************
Pick an option:
(1) Show Task List (by date or project)
(2) Add New Task
(3) Edit Task (update, mark as done)
(4) Remove the task
(5) Save & Quit
```

#### Add a new task/tasks
- For creating a new task, choose option number `2`. 
In order to create/add a task all the required fields must be entered:
```
he user have selected option:2
Provide the details to Add New Task
Enter task name:
helloSay
Enter Project
office
Enter Due date (YYYY-MM-DD)
2020-03-24
Pick an option:
(1) Show Task List (by date or project)
(2) Add New Task
(3) Edit Task (update, mark as done)
(4) Remove the task
(5) Save & Quit 
```
The task status is automatically set to open and task Id will be incremented automatically, when is created.

#### Editing tasks
- For editing tasks, choose option number `3`. 
A list of all tasks is printed in order to choose a task that should be edited.
When the task is chosen, a submenu with 6 options is displayed:
```
The user have selected option:3
The Current tasks List is :
TaskId                 TaskName             Project                      Due date                          Status
***************************************************************************************************************************
 1            Bring food to home            home                      2020-03-24                            open
 2                     Go to gym        personal                      2020-03-24                            open
 3                         clean            home                      2020-04-21                            open
 4                            gr            home                      2020-05-12                            done
 5                          test          office                      2020-06-12                            done
 6                      helloSay          office                      2020-03-24                            open
***************************************************************************************************************************
Choose the task Id to Edit Task: `3`
```
Choose any task Id - `3`
```
The current values are: (if you leave empty the old values will be taken)
TaskId                 TaskName             Project                      Due date                          Status
***************************************************************************************************************************
 3                         clean            home                      2020-04-21                            open
Enter task name:
clean again 
Enter Project

Enter Due date (YYYY-MM-DD)
2020-04-22
Enter the status

Pick an option:
(1) Show Task List (by date or project)
(2) Add New Task
(3) Edit Task (update, mark as done)
(4) Remove the task
(5) Save & Quit
```

#### Remove the task
We have an option to delete the task totaly from our TodoLy with option -  `4`
The task will be deleted from the list
```
The user have selected option:4
Choose the task Id to Edit Task
6
The Current tasks List is :
TaskId                 TaskName             Project                      Due date                          Status
***************************************************************************************************************************
 1            Bring food to home            home                      2020-03-24                            open
 2                     Go to gym        personal                      2020-03-24                            open
 3                  clean again             home                      2020-04-22                            open
 4                            gr            home                      2020-05-12                            done
 5                          test          office                      2020-06-12                            done
***************************************************************************************************************************
Pick an option:
(1) Show Task List (by date or project)
(2) Add New Task
(3) Edit Task (update, mark as done)
(4) Remove the task
(5) Save & Quit
```

## Save & Quit
Please choose Option `5` to save and quit.


## Author:
> Pallavi Thanikonda
> Individual project - SDA 7
> KTH