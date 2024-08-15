package freegamerdev.limited_lives.DataClasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LifeDataManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Type LIFE_DATA_TYPE = new TypeToken<LifeData>() {}.getType();
    private static final Path LIFE_DATA_FILE = Paths.get("config/limitedlives/lives_data.json");

    public static LifeData loadLifeData() throws IOException {
        if (Files.exists(LIFE_DATA_FILE)) {
            String jsonData = Files.readString(LIFE_DATA_FILE);
            return gson.fromJson(jsonData, LIFE_DATA_TYPE);
        } else {
            // If the file doesn't exist, create it and initialize with default data
            LifeData defaultData = new LifeData();
            saveLifeData(defaultData); // Save default data to file
            return defaultData;
        }
    }

    public static void saveLifeData(LifeData lifeData) throws IOException {
        String jsonData = gson.toJson(lifeData, LIFE_DATA_TYPE);
        Files.createDirectories(LIFE_DATA_FILE.getParent()); // Create directories if they don't exist
        Files.writeString(LIFE_DATA_FILE, jsonData);
    }
}