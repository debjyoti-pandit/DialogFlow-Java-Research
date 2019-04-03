package com.example.dialogflow.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dialogflow.beans.FulfillmentRequest;
import com.example.dialogflow.beans.FulfillmentResponse;

@RestController
public class DialogFlowAPI {

	@GetMapping("/checkStatus")
	public String helloWorld() {
		return "You have successfully deployed your first Hello World Spring Boot Application";
	}
	
	@GetMapping("/webhook")
	public String getWebhook() {
		System.out.println("IN GET REQUEST");
		return "GET WEBHOOK CALLED";
	}
	
	@PostMapping("/webhook")
	@ResponseBody
	public ResponseEntity<FulfillmentResponse> postWebhook(@RequestBody FulfillmentRequest fulfillmentRequest) {
		System.out.println("Printing the fulfillment request came by post request");
		System.out.println(fulfillmentRequest.getResponseId());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		FulfillmentResponse fulfillmentResponse = new FulfillmentResponse();
		fulfillmentResponse.setFulfillmentText("Fulfillment set succesfully");
		return new ResponseEntity<FulfillmentResponse>(fulfillmentResponse, headers, HttpStatus.OK);
	}
}
