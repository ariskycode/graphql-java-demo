package co.ariskycode.graphql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ariskycode.graphql.model.Attendee;
import co.ariskycode.graphql.model.AttendeeTalk;
import co.ariskycode.graphql.model.Speaker;
import co.ariskycode.graphql.model.SpeakerTalk;
import co.ariskycode.graphql.model.Talk;
import co.ariskycode.graphql.repository.AttendeeTalkRepository;
import co.ariskycode.graphql.repository.SpeakerTalkRepository;
import co.ariskycode.graphql.repository.TalkRepository;

@Service
public class TalkService {

	@Autowired
	private TalkRepository talkRepository;

	@Autowired
	private SpeakerTalkRepository speakerTalkRepository;

	@Autowired
	private AttendeeTalkRepository attendeeTalkRepository;

	public List<Talk> findAll() {
		return talkRepository.findAll();
	}

	public List<Talk> findAllTalksBySpeaker(Speaker speaker) {
		List<SpeakerTalk> talksBySpeaker = speakerTalkRepository.findAllBySpeakerId(speaker.getId());

		return talksBySpeaker.stream()
				.map(e -> talkRepository.findById(e.getTalkId())).filter(Optional::isPresent)
				.map(Optional::get).collect(Collectors.toList());
	}

	public List<Talk> findAllTalksByAttendee(Attendee attendee) {
		List<AttendeeTalk> talksWithAttendee = attendeeTalkRepository.findAllByAttendeeId(attendee.getId());

		return talksWithAttendee.stream()
				.map(e -> talkRepository.findById(e.getTalkId())).filter(Optional::isPresent)
				.map(Optional::get).collect(Collectors.toList());

	}
	
	public Talk save(Talk talk) {
		return talkRepository.save(talk);
	}
}