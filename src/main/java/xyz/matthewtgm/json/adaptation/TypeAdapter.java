package xyz.matthewtgm.json.adaptation;

import xyz.matthewtgm.json.entities.JsonElement;

import java.lang.reflect.Type;

public interface TypeAdapter<T> {

    JsonElement serialize(T source, Type type);
    T deserialize(JsonElement json, Type type);

}