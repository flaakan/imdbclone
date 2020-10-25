package se.experis.johnny.imdbclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.johnny.imdbclone.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
}
