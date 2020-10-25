package se.experis.johnny.imdbclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.experis.johnny.imdbclone.entity.Actor;
import se.experis.johnny.imdbclone.repository.ActorRepository;

import java.time.LocalDate;
import java.util.List;


@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;


    /**
     * Finds an actor based on actorId and returns the actor if found.
     * Otherwise throw an exception to the controller to handle.
     * @param actorId id of the actor to check for
     * @return Actor the actor with id  = actorId.
     * @throws Exception to be handled in the controller if the actor does not exist.
     */
    public Actor findActorById(long actorId) throws Exception {

        if(actorRepository.existsById(actorId)){
            return actorRepository.findById(actorId).get();
        }
        else{
            throw new Exception();
        }
    }

    /**
     * Finds all actors in the database.
     * @return all the actors in the database as a list.
     */
    public List<Actor> findAllActors(){
        return actorRepository.findAll();
    }

    /**
     * Adds a new actor to the database, with checkers to see if this actor
     * has first name and last name.
     * @param actor the actor to be inserted.
     * @return The actor that was inserted.
     * @throws Exception to be handled by the controller if the requirements are not met.
     */
    public Actor createActor(Actor actor) throws Exception {
        if(actor.getFirstName() != null && actor.getLastName() != null){
           return actorRepository.save(actor);
        }else{
            throw new Exception();
        }
    }


    /**
     * Updates all the fields for a specific actor based on actorId.
     * @param actorId the actor to update.
     * @param actor the values to update.
     * @return Actor, the updated actor.
     * @throws Exception to be handled by the controller if there is no actor with id = actorId.
     */
    public Actor updateActor(long actorId,Actor actor) throws Exception {
        if(actorRepository.existsById(actorId)){
           Actor updateActor = actorRepository.findById(actorId).get();
           String firstName = (actor.getFirstName() != null && actor.getFirstName() != "") ? actor.getFirstName(): updateActor.getFirstName();
           String lastName = (actor.getLastName() != null && actor.getLastName() != "") ? actor.getLastName(): updateActor.getLastName();
           LocalDate dateOfBirth = (actor.getDateOfBirth() != null) ? actor.getDateOfBirth(): updateActor.getDateOfBirth();
           String imdbUrl =  (actor.getImdbUrl() !=null && actor.getImdbUrl() !="") ? actor.getImdbUrl(): updateActor.getImdbUrl();
           String imageUrl =  (actor.getImageUrl() !=null && actor.getImdbUrl() !="") ? actor.getImageUrl(): updateActor.getImageUrl();
           updateActor.setFirstName(firstName);
           updateActor.setLastName(lastName);
           updateActor.setDateOfBirth(dateOfBirth);
           updateActor.setImdbUrl(imdbUrl);
           updateActor.setImageUrl(imageUrl);
            return actorRepository.save(updateActor);
        }else{
            throw new Exception();
        }
    }

    /**
     * Deletes an actor based on actor id.
     * @param actorId the id of the actor to delete.
     * @return The deleted actor.
     * @throws Exception to be handled by the controller if there is no actor with id = actorId.
     */

    public Actor deleteActorById(long actorId) throws Exception {
        if(actorRepository.existsById(actorId)){
            Actor actor = actorRepository.findById(actorId).get();
            actorRepository.delete(actor);
            return actor;
        }else{
            throw new Exception();
        }
    }
}
