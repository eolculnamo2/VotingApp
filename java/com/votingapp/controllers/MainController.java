package com.votingapp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.votingapp.functions.HelperFunctions;
import com.votingapp.models.Chart;
import com.votingapp.models.NewChart;
import com.votingapp.models.ReadChart;
import com.votingapp.models.ReadOneChart;
import com.votingapp.models.VoteChart;

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
		
		HelperFunctions helpers = new HelperFunctions();
		String json = helpers.jsonToString(request.getInputStream());
		
		ObjectMapper objectMapper = new ObjectMapper();
		Chart chart = objectMapper.readValue(json, Chart.class);
		
		new NewChart(chart.getQuestion(),chart.getOption(),chart.getCreator());
		return "index";
	}
	
	@RequestMapping(value="/get-charts", method=RequestMethod.GET)
	@ResponseBody
	public String getCharts () throws JsonProcessingException {
		
		ReadChart charts = new ReadChart();
		ObjectMapper objectMapper = new ObjectMapper();
		String payload = objectMapper.writeValueAsString(charts.allCharts);
		return payload;
	}
	
	@RequestMapping(value="/get-chart", method=RequestMethod.GET)
	@ResponseBody
	public String getChart (@RequestParam(value="id") int id) throws JsonProcessingException {
		
		ReadOneChart charts = new ReadOneChart(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String payload = objectMapper.writeValueAsString(charts.allCharts);
		return payload;
	}
	
	@RequestMapping(value="/submit-vote", method=RequestMethod.POST)
	@ResponseBody
	public void submitVote(HttpServletRequest request) throws IOException {
		
		HelperFunctions helpers = new HelperFunctions();
		String json = helpers.jsonToString(request.getInputStream());
		
		ObjectMapper objectMapper = new ObjectMapper();
		Chart chart = objectMapper.readValue(json, Chart.class);
		
		@SuppressWarnings("unused")
		VoteChart charts = new VoteChart(chart.getId(), chart.getOption());
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
