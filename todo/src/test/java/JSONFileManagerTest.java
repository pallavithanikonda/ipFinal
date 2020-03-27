import org.json.simple.JSONObject;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JSONFileManagerTest {
    private ArrayList<TasksList> tasksLists = new ArrayList<>();
    private JSONFileManager fm = new JSONFileManager();
    private static String membersFileName = "files/tasks-list.json";
    JSONObject object = new JSONObject();

    @Test
    public void readFileTasksList() {
        tasksLists.clear();
        tasksLists = fm.readFileTasksList(membersFileName);
        assertEquals(tasksLists.isEmpty(), true);
    }

    @Test
    public void convertTasksToJson() {
        object = fm.convertTasksToJson(tasksLists);
        assertNotNull(object);
    }

    @Test
    public void writeJsonToFile() {
        fm.writeJsonToFile(object,"files/","test.json");
        File tempFile = new File("files/test.json");
        assertNotNull(tempFile);
    }
}