import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class that reads and writes JSON files.
 */
public class JSONFileManager {


    public ArrayList<TasksList> readFileTasksList(String taskFile){
        ArrayList<TasksList> jsonTasks = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(taskFile)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // loop tasks array
            JSONArray tasksObject = (JSONArray) jsonObject.get("tasks");
            Iterator<String> iterator = tasksObject.iterator();
            while (iterator.hasNext()) {
                TasksList tasks = new TasksList();
                Object slide = iterator.next();
                JSONObject jsonObject2 = (JSONObject) slide;
                tasks.setName((String) jsonObject2.get("name"));
                tasks.setId((String) jsonObject2.get("id"));
                tasks.setProject((String) jsonObject2.get("project"));
                tasks.setStatus((String) jsonObject2.get("status"));
                tasks.setDate((String) jsonObject2.get("duedate"));
                jsonTasks.add(tasks);
            }

        } catch (IOException e) {
            System.out.println("JSON IOException..!");
        } catch (ParseException e) {
            System.out.println("JSON ParseException..!");
        }

        return jsonTasks;
    }


    public JSONObject convertTasksToJson(ArrayList<TasksList> tasks){
        //Main JSON object
        JSONObject object = new JSONObject();

        //Create a JSON array
        JSONArray array = new JSONArray();

        for(int index = 0; index < tasks.size(); index++)
        {
            //Second JSON object with an array
            if(tasks.get(index).getId().equals(""))
                continue;
            JSONObject arrayElement = new JSONObject();
            arrayElement.put("name", tasks.get(index).getName());
            arrayElement.put("id", tasks.get(index).getId());
            arrayElement.put("project", tasks.get(index).getProject());
            arrayElement.put("status", tasks.get(index).getStatus());
            arrayElement.put("duedate", tasks.get(index).getDate());

            //insert in the array
            array.add(arrayElement);
        }

        //put everything inside the object
        object.put("tasks", array);

        return object;
    }


    public void writeJsonToFile(JSONObject object, String filePath, String fileName){
        //Check if directory exists, otherwise create it
        File directory = new File(filePath);
        if(!directory.isDirectory()){
            boolean createDirectory = directory.mkdir();
            if(!createDirectory){
                System.out.println("No file path exists!");
                return;
            }
        }

        //Write on the file
        try (FileWriter file = new FileWriter(filePath + fileName)) {
            file.write(object.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}