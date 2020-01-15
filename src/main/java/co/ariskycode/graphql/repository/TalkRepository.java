package co.ariskycode.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ariskycode.graphql.model.Talk;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {

}