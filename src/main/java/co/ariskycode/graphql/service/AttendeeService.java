package co.ariskycode.graphql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ariskycode.graphql.model.Attendee;
import co.ariskycode.graphql.model.AttendeeTalk;
import co.ariskycode.graphql.model.Talk;
import co.ariskycode.graphql.repository.AttendeeRepository;
import co.ariskycode.graphql.repository.AttendeeTalkRepository;

@Service
public class AttendeeService {

	@Autowired
	private AttendeeRepository attendeeRepository;

	@Autowired
	private AttendeeTalkRepository attendeeTalkRepository;

	public List<Attendee> findAll() {
		return attendeeRepository.findAll();
	}

	public List<Attendee> findAllAttendiesForTalk(Talk talk) {
		List<AttendeeTalk> attendeesForTalk = attendeeTalkRepository.findAllByTalkId(talk.getId());

		return attendeesForTalk.stream().map(e -> attendeeRepository.findById(e.getAttendeeId())).filter(Optional::isPresent)
				.map(Optional::get).collect(Collectors.toList());
	}
}