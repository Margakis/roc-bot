package jn.rocbot.info;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import jn.rocbot.Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ShipStore {
    public static ArrayList<Ship> SHIPS = new ArrayList<>();

    static {
        JsonParser parser = new JsonParser();

        try {
            JsonObject shipsjson = parser.parse(new JsonReader(new FileReader("res/ships.json"))).getAsJsonObject();
            JsonArray ships = (JsonArray) shipsjson.get("ships");

            for (JsonElement jsonelementship : ships){
                JsonObject jsonship = jsonelementship.getAsJsonObject();

                Ship ship = new Ship(jsonship.get("name").getAsString(), jsonship.get("weapon").getAsString(),
                        jsonship.get("aura").getAsString(), jsonship.get("zen").getAsString());
                SHIPS.add(ship);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
