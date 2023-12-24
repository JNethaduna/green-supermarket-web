package com.green.supermarketwebapp.services;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Helpers {
  public JSONObject parseJson(String json) {
    return new JSONObject(json);
  }
}
