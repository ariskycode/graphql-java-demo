package co.ariskycode.graphql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ariskycode.graphql.model.Speaker;
import co.ariskycode.graphql.model.SpeakerTalk;
import co.ariskycode.graphql.model.Talk;
import co.ariskycode.graphql.repository.SpeakerRepository;
import co.ariskycode.graphql.repository.SpeakerTalkRepository;

@Service
public class SpeakerService {

	@Autowired
	private SpeakerRepository speakerRepository;

	@Autowired
	private SpeakerTalkRepository speakerTalkRepository;

	public List<Speaker> findAll() {
		return speakerRepository.findAll();
	}

	public List<Speaker> findAllSpeakersForTalk(Talk talk) {
		List<SpeakerTalk> speakersForTalk = speakerTalkRepository.findAllByTalkId(talk.getId());

		return speakersForTalk.stream().map(e -> speakerRepository.findById(e.getSpeakerId())).filter(Optional::isPresent)
				.map(Optional::get).collect(Collectors.toList());
	}

	public Speaker save(Speaker speaker) {
		return speakerRepository.save(speaker);
	}
	
	public Speaker findByName(String name) {
		return speakerRepository.findByName(name);
	}
}