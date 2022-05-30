package ru.mephi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;


public class JSONPars {

    ArrayList<Reactor> jsonReactors;

    public void getJSONArray(String directory) {
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader(directory)) {
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);
            JSONArray reactorJsonArray = (JSONArray) rootJsonObject.get("ReactorType");
            jsonReactors = new ArrayList<>();
            for (Object o : reactorJsonArray) {
                JSONObject jo = (JSONObject) o;
                String type = (String) jo.get("type");
                Double burnup = (Double) jo.get("burnup");
                Double kpd = (Double) (jo.get("kpd"));
                Double enrichment = (Double) jo.get("enrichment");
                Double termalCapacity = ((Double) jo.get("termalCapacity"));
                Double electricalCapacity =  ((Double) jo.get("electricalCapacity"));
                Double lifeTime = ((Double) jo.get("lifeTime"));
                Double firstLoad = ((Double) jo.get("firstLoad"));
                String source = "JSON";
                Reactor newReactor = new Reactor(type, burnup, kpd, enrichment, termalCapacity,
                        electricalCapacity, lifeTime, firstLoad, source);
                jsonReactors.add(newReactor);
            }
        }
        catch (Exception e) {
            System.out.println("pars error " + e.toString());
        }

    }
}
