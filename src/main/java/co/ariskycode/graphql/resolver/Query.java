package co.ariskycode.graphql.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import co.ariskycode.graphql.model.Attendee;
import co.ariskycode.graphql.model.Human;
import co.ariskycode.graphql.model.Speaker;
import co.ariskycode.graphql.model.Talk;
import co.ariskycode.graphql.service.AttendeeService;
import co.ariskycode.graphql.service.SpeakerService;
import co.ariskycode.graphql.service.TalkService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

	private final AttendeeService attendeeService;
	private final SpeakerService speakerService;
	private final TalkService talkService;

	public List<Attendee> allAttendees() {
		return attendeeService.findAll();
	}
	
	public List<Speaker> allSpeakers() {
		return speakerService.findAll();
	}
	
	public List<Talk> allTalks() {
		return talkService.findAll();
	}
	
	public List<Object> allConference() {
		List allTalks = talkService.findAll();
		List allSpeakers = speakerService.findAll();
		allTalks.addAll(allSpeakers);
		return allTalks;
	}
	
	public List<Human> allHumans() {
		List allAttendees = attendeeService.findAll();
		List allSpeakers = speakerService.findAll();
		allAttendees.addAll(allSpeakers);
		return allAttendees;
	}

}