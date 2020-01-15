package co.ariskycode.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ariskycode.graphql.model.SpeakerTalk;

@Repository
public interface SpeakerTalkRepository extends JpaRepository<SpeakerTalk, Long> {

	List<SpeakerTalk> findAllBySpeakerId(Long speakerId);

	List<SpeakerTalk> findAllByTalkId(Long talkId);
	
}