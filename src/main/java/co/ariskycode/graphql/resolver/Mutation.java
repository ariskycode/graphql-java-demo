package co.ariskycode.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import co.ariskycode.graphql.model.Speaker;
import co.ariskycode.graphql.model.Talk;
import co.ariskycode.graphql.service.SpeakerService;
import co.ariskycode.graphql.service.TalkService;

@Component
public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private TalkService talkService;
	
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
