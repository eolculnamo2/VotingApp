package com.votingapp.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
	
	@RequestMapping(value="/get-homepage-data", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray getHomepageData() {
		JSONArray payload = new JSONArray();
		
		JSONObject obj1 = new JSONObject();
		try {
			obj1.put("title", "Favorite Color");
			obj1.put("user", "Rob");
			obj1.put("id", "123");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		payload.put(obj1);
		
		System.out.print(payload);
		
		return payload;
	}
}
