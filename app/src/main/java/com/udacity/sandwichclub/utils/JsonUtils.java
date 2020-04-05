package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        JSONObject sandwichJson = null;
        Sandwich sandwich = new Sandwich();
        List<String> alsoKnownAs = new ArrayList<String>();
        List<String> ingredients = new ArrayList<String>();
        try {
            sandwichJson = new JSONObject(json);
            // Parsing mainName
            JSONObject nameObject = sandwichJson.getJSONObject("name");
            sandwich.setMainName(nameObject.getString("mainName"));
            // Parsing alsoKnownAs
            JSONArray akaArray = nameObject.getJSONArray("alsoKnownAs");
            for (int i = 0; i < akaArray.length(); i++)
                alsoKnownAs.add(akaArray.getString(i));
            sandwich.setAlsoKnownAs(alsoKnownAs);
            // Parsing placeOfOrigin
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));
            // Parsing description
            sandwich.setDescription(sandwichJson.getString("description"));
            // Parsing image
            sandwich.setImage(sandwichJson.getString("image"));
            // Parsing ingredients
            JSONArray ingredientsArray = nameObject.getJSONArray("ingredients");
            for (int i = 0; i < ingredientsArray.length(); i++)
                ingredients.add(ingredientsArray.getString(i));
            sandwich.setIngredients(ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
