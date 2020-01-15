package co.ariskycode.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ariskycode.graphql.model.Speaker;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
	
}