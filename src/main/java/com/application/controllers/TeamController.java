package com.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

	@GetMapping("/welcome/")
	@ResponseStatus(HttpStatus.OK)
	public String welcomeMessage() {
		return "Hello World From First Docker Application";
	}
}
