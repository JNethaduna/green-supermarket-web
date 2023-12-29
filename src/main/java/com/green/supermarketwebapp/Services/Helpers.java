package com.green.supermarketwebapp.services;

import java.util.stream.Stream;

import org.json.JSONObject;

public class Helpers {
  public static JSONObject parseJson(String json) {
    return new JSONObject(json);
  }

  public static String formatCategory(String category) {
    return Stream.of(category.split("-"))
        .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
        .reduce("", (acc, word) -> acc + word + " ").trim();
  }
}
