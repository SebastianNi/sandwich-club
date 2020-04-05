package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichJson = new JSONObject(json);
            // Parsing mainName
            JSONObject nameObject = sandwichJson.getJSONObject("name");
            sandwich.setMainName(nameObject.getString("mainName"));
            // Parsing alsoKnownAs
            sandwich.setAlsoKnownAs(convertJSONArrayToList(nameObject.getJSONArray("alsoKnownAs")));
            // Parsing placeOfOrigin
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));
            // Parsing description
            sandwich.setDescription(sandwichJson.getString("description"));
            // Parsing image
            sandwich.setImage(sandwichJson.getString("image"));
            // Parsing ingredients
            sandwich.setIngredients(convertJSONArrayToList(sandwichJson.getJSONArray("ingredients")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }

    private static List<String> convertJSONArrayToList(JSONArray array) throws JSONException {
        if (array == null)
            return null;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++)
            list.add(array.getString(i));
        return list;
    }
}
