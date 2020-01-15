package co.ariskycode.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.ariskycode.graphql.model.Speaker;
import co.ariskycode.graphql.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/speakers")
	@ResponseStatus(HttpStatus.OK)
	public List<Speaker> getSpeakers() {
		return clientService.getSpeakers();
	}

}
