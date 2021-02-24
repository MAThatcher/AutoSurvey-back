package com.revature.controllers;

<<<<<<< Updated upstream
public class AnswerControllerImpl implements AnswerController {

=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Answer;
import com.revature.services.AnswerService;

@RestController
@CrossOrigin
public class AnswerControllerImpl implements AnswerController {

	@Autowired
	private AnswerService answerService;

	// None of these methods need a try/catch, it's already handled via
	// AnswerService!

	@Override
	@PostMapping(value = "/answers", consumes = "application/json", produces = "application/json")
	public Answer addAnswer(Answer a) {
		try {
			return answerService.addAnswer(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	@GetMapping(value = "/answers/{id}")
	public Answer getAnswer(int id) {
		try {
			return answerService.getAnswer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/answers")
	public List<Answer> getAllAnswers() {
		try {
			return answerService.getAllAnswers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PutMapping(value = "/answers/{id}", consumes = "application/json")
	public Answer updateAnswer(Answer a) {
		try {
			return answerService.updateAnswer(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DeleteMapping(value = "/answers/{id}")
	public boolean deleteAnswer(@PathVariable("id") int id) {
		try {
			return answerService.deleteAnswer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

>>>>>>> Stashed changes
}
