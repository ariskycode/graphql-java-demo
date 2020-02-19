package co.ariskycode.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.ariskycode.graphql.model.Speaker;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
	
	@Query("select s from Speaker s where s.name = :name")
	public Speaker findByName(@Param("name") String name);
	
}