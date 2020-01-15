package co.ariskycode.graphql.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import co.ariskycode.graphql.model.Speaker;
import co.ariskycode.graphql.model.Talk;
import co.ariskycode.graphql.service.SpeakerService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TalkResolver implements GraphQLResolver<Talk> {
	
	private final SpeakerService speakerService;

	public List<Speaker> speakers(Talk talk) {
		return speakerService.findAllSpeakersForTalk(talk);
	}
	
}
