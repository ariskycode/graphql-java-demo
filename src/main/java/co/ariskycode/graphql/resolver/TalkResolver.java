package co.ariskycode.graphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import co.ariskycode.graphql.model.Speaker;
import co.ariskycode.graphql.model.Talk;
import co.ariskycode.graphql.service.SpeakerService;

@Component
public class TalkResolver implements GraphQLResolver<Talk> {
	
	@Autowired
	private SpeakerService speakerService;

	public List<Speaker> speakers(Talk talk) {
		return speakerService.findAllSpeakersForTalk(talk);
	}
	
}
