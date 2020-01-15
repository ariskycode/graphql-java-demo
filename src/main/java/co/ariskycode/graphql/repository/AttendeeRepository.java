package co.ariskycode.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ariskycode.graphql.model.Attendee;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
	
}