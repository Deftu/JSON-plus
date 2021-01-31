package ga.matthewtgm.json.files;

import ga.matthewtgm.json.objects.JsonObject;
import ga.matthewtgm.json.parsing.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JsonReader {

    public static JsonObject read(String name, File directory) {
        try {
            if (!directory.exists()) {
                directory.mkdirs();
                Thread.sleep(1000);
            }
            File file = new File(directory, name + ".json");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            reader.lines().forEach(builder::append);
            return JsonParser.parse(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}