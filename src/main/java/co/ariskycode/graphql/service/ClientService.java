package co.ariskycode.graphql.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.ariskycode.graphql.model.GraphQLResponse;
import co.ariskycode.graphql.model.Speaker;

@Service
public class ClientService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Speaker> getSpeakers() {
		System.out.println("Calling endpoint /graphql");
		List<Speaker> speakers = new ArrayList<>();
		try {
			String query = "{\"query\":\"query {list: allSpeakers { id name }}\",\"variables\":null}";
			RequestEntity<String> request = RequestEntity.post(new URI("http://localhost:8080/graphql"))
						.accept(MediaType.APPLICATION_JSON).body(query);
			ResponseEntity<GraphQLResponse> response = restTemplate.exchange(request, GraphQLResponse.class);
			System.out.println(response.getBody().toString());
			response.getBody().getData().getList().forEach(map -> speakers.add(Speaker.builder()
						.id(Long.parseLong(map.get("id").toString()))
						.name(map.get("name").toString())
						.build()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return speakers;
	}
	
}
