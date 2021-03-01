package com.revature.controllers;

import java.util.List;

import com.revature.beans.Response;

public interface ResponseController {

	Response addResponse(Response r);
	
	String addManyResponses(String json);
	
	/**
	 * <strong>deleteResponse</strong> captures HTTP DELETE requests sent 
	 * to the URI "/response/id" where id is a number. It accepts the id
	 * of a Response that exists in the database and deletes it.
	 * @param id A valid id of a response in the database
	 * @return True on success, false otherwise
	 */

	boolean deleteResponse(int id) ;
	Response getResponse(int id) ;
	List<Response> getAllResponse();
	boolean updateResponse(int id,Response r);

}
