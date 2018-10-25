package com.votingapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.votingapp.models.NewChart;

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
	
	@RequestMapping(value="/create-new-chart", method= RequestMethod.POST)
	@ResponseBody
	public String createNewChart(HttpServletRequest request, Model model) {
		
		System.out.println(request);
		
		String question = request.getParameter("question");
		String option = request.getParameter("option");
		String creator = request.getParameter("creator");
		
		System.out.println(creator);
		new NewChart(question,option,creator);
		return "index";
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
