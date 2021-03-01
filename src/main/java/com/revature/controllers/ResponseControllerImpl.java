package com.revature.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Question;
import com.revature.beans.Response;
import com.revature.services.ResponseService;

@RestController
@CrossOrigin
public class ResponseControllerImpl implements ResponseController {
	@Autowired
	ResponseService rs;

	@Override
	@PostMapping(value = "/response", consumes = "application/json", produces = "application/json")
	public Response addResponse(@RequestBody Response r) {
		// TODO Auto-generated method stub
		try {
			return rs.addResponse(r);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	@DeleteMapping(value = "/response/{id}")
	public boolean deleteResponse(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return rs.deleteResponse(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@GetMapping(value = "/response/{id}", produces = "application/json")
	public Response getResponse(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return rs.getResponse(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/response", produces = "application/json")
	public List<Response> getAllResponse() {
		// TODO Auto-generated method stub
		try {
			return rs.getAllResponse();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PostMapping(value = "/responsejson", consumes="application/json")
	public String addManyResponses(@RequestBody String json) {
		JSONObject responses = new JSONObject(json);
		List<List<String>> allQuestions = new ArrayList<List<String>>();
		List<List<String>> allAnswers = new ArrayList<List<String>>();
		try {
			JSONArray data = responses.getJSONArray("data");
			for (int i=0;i<data.length();++i) {
				JSONObject response = data.getJSONObject(i);
				List<String> questions = new ArrayList<String>();
				List<String> answers = new ArrayList<String>();
				Iterator<String> keys=response.keys();
				while (keys.hasNext()) {
					String question=keys.next();
					answers.add(response.getString(question));
					questions.add(question);
				}
				allQuestions.add(questions);
				allAnswers.add(answers);
			}
		} catch (JSONException e) {
			return "Error";
		}
		System.out.println(allQuestions.size());
		System.out.println(allAnswers.size());
		return "OK";
	}
	
	@Override
	@PutMapping(value = "/response/{id}", consumes = "application/json")
	public boolean updateResponse(@PathVariable("id") int id, @RequestBody Response r) {
		// TODO Auto-generated method stub
		try {
			return rs.updateResponse(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
