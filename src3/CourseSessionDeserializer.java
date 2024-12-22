import com.google.gson.*;
import java.lang.reflect.Type;

public class CourseSessionDeserializer implements JsonDeserializer<CourseSession> {

    @Override
    public CourseSession deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        CourseSession session = new CourseSession();
        session.setDay(jsonObject.get("day").getAsString()); // Map "day" to CourseSession's field
        session.setStartTime(jsonObject.get("startTime").getAsString());
        session.setEndTime(jsonObject.get("endTime").getAsString());

        return session;
    }
}
