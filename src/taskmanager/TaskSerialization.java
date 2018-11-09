package taskmanager;

import com.google.gson.*;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class TaskSerialization implements JsonSerializer<Task>, JsonDeserializer<Task> { 
    public JsonElement serialize(Task src, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("Name", src.taskName);
        object.addProperty("Description", src.taskDescription);
        object.addProperty("Date", src.taskDate.getTime());
        return object;
    }
    public Task deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        String name = new String(object.get("Name").getAsString());
        String description = new String(object.get("Description").getAsString());
        Date date = new Date(object.get("Date").getAsLong());
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("hh:mm:ss dd/MM/yyyy");
        String dateText = format.format(date);
        try {
            return new Task(name, description, dateText);
        } catch (Exception ex) {
            Logger.getLogger(TaskSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}