package co.ariskycode.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import co.ariskycode.graphql.model.Speaker;
import co.ariskycode.graphql.model.Talk;
import co.ariskycode.graphql.service.SpeakerService;
import co.ariskycode.graphql.service.TalkService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
	
	private final SpeakerService speakerService;
	private final TalkService talkService;
	
	public Speaker addSpeaker(String name) {
		Speaker speaker = new Speaker();
		speaker.setName(name);
		return speakerService.save(speaker);
	}

	public Talk addTalk(String title) {
		Talk talk = new Talk();
		talk.setTitle(title);
		return talkService.save(talk);
	}

}
