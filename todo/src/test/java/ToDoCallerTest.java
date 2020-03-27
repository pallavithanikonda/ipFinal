import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToDoCallerTest {

    ToDoCaller toDoCaller = new ToDoCaller();

    @Test
    public void loadTasksList() {
         ArrayList<TasksList> taskList= toDoCaller.loadTasksList();
        assertNotNull(taskList);
    }
}