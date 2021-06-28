package xyz.matthewtgm.json.files;

import xyz.matthewtgm.json.base.Json;
import xyz.matthewtgm.json.objects.JsonArray;
import xyz.matthewtgm.json.objects.JsonObject;
import xyz.matthewtgm.json.util.JsonHelper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {

    /**
     * Writes a file with the object specified as its contents
     *
     * @param object    the object being written
     * @param directory the directory to write to
     */
    public static void writeObj(String fileName, JsonObject<?, ?> object, File directory, boolean pretty) {
        System.out.println(fileName);
        System.out.println(directory);
        BufferedWriter writer = null;
        try {
            if (!directory.exists()) {
                if (!directory.mkdirs()) {
                    throw new IllegalStateException("Directory didn't exist, failed to create it.");
                }
            }
            String content = pretty ? JsonHelper.makePretty(object) : object.toJson();
            File file = new File(directory, fileName + ".json");
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new IllegalStateException("Failed to create JSON file.");
                }
            }
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                writer.flush();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    /**
     * Writes a file with the object specified as its contents
     *
     * @param array     the object being written
     * @param directory the directory to write to
     */
    public static void writeArr(String fileName, JsonArray<?> array, File directory, boolean pretty) {
        BufferedWriter writer = null;
        try {
            if (!directory.exists()) if (!directory.mkdirs()) throw new IllegalStateException("Directory didn't exist, failed to create it.");
            String content = pretty ? JsonHelper.makePretty(array) : array.toJson();
            File file = new File(directory, fileName + ".json");
            if (!file.exists()) if (!file.createNewFile()) throw new IllegalStateException("Failed to create JSON file.");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                writer.flush();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    /**
     * Writes a file with the object specified as its contents
     *
     * @param json      the object being written
     * @param directory the directory to write to
     */
    public static void write(String fileName, Json json, File directory, boolean pretty) {
        BufferedWriter writer = null;
        try {
            if (!directory.exists()) if (!directory.mkdirs()) throw new IllegalStateException("Directory didn't exist, failed to create it.");
            String content = pretty ? JsonHelper.makePretty(json) : json.toJson();
            File file = new File(directory, fileName + ".json");
            if (!file.exists()) if (!file.createNewFile()) throw new IllegalStateException("Failed to create JSON file.");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                writer.flush();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    /**
     * Writes a file with the object specified as its contents
     *
     * @param object    the object being written
     * @param directory the directory to write to
     */
    public static void writeObj(String fileName, JsonObject object, File directory) {
        writeObj(fileName, object, directory, false);
    }

    /**
     * Writes a file with the object specified as its contents
     *
     * @param array     the object being written
     * @param directory the directory to write to
     */
    public static void writeArr(String fileName, JsonArray array, File directory) {
        writeArr(fileName, array, directory, false);
    }

    /**
     * Writes a file with the object specified as its contents
     *
     * @param json      the object being written
     * @param directory the directory to write to
     */
    public static void write(String fileName, Json json, File directory) {
        write(fileName, json, directory, false);
    }

}