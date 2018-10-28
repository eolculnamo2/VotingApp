package com.votingapp.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HelperFunctions {
	public String jsonToString(InputStream body) {
		BufferedReader br = new BufferedReader(new InputStreamReader(body));
		
		String json = "";
		
		if(br != null) {
			try {
				json = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json;
	}
}
