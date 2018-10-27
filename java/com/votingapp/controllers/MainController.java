package com.votingapp.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.votingapp.models.Chart;
import com.votingapp.models.NewChart;
import com.votingapp.models.ReadChart;

@Controller
public class MainController {

	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "index";
	}
	
	@GetMapping("/new-chart")
	public String newChart() {
		return "index";
	}
	
	@GetMapping("/survey")
	public String surveyPage() {
		return "index";
	}
	
	
	@GetMapping("/survey/*")
	public String surveysPage() {
		return "index";
	}
	
	@RequestMapping(value="/create-new-chart", method= RequestMethod.POST)
	@ResponseBody
	public String createNewChart(HttpServletRequest request, Model model) throws JsonParseException, JsonMappingException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String json = "";
		
		if(br != null) {
			try {
				json = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Chart chart = objectMapper.readValue(json, Chart.class);
		
		new NewChart(chart.getQuestion(),chart.getOption(),chart.getCreator());
		
		return "index";
	}
	
	@RequestMapping(value="/get-charts", method=RequestMethod.GET)
	@ResponseBody
	public String getChart () throws JsonProcessingException {
		ReadChart charts = new ReadChart();
		ObjectMapper objectMapper = new ObjectMapper();
		String payload = objectMapper.writeValueAsString(charts.allCharts);
		//JSONArray payload = new JSONArray(charts.allCharts);
		System.out.println(payload);
		return payload;
	}
	//ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
//	ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
//	try {
//		File jsBuild = new File("/Users/rbertram/Code/java-workspace/VotingApp/src/main/webapp/WEB-INF/views/test.js");
//		engine.eval(new FileReader(jsBuild));
//	}
//	catch(ScriptException e) {
//		e.printStackTrace();
//	}
	
}
