package co.ariskycode.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ariskycode.graphql.model.AttendeeTalk;

@Repository
public interface AttendeeTalkRepository extends JpaRepository<AttendeeTalk, Long> {
	
	List<AttendeeTalk> findAllByAttendeeId(Long attendeeId);

	List<AttendeeTalk> findAllByTalkId(Long talkId);
	
}