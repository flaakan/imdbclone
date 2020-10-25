package se.experis.johnny.imdbclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.johnny.imdbclone.entity.Actor;
import se.experis.johnny.imdbclone.service.ActorService;
import se.experis.johnny.imdbclone.util.ResponseObject;


@RestController
@RequestMapping("/api/actor")
public class ActorController {

    @Autowired
    ActorService actorService;


    /**
     * Get Actor by a specified id. If the actor exists, returns a ResponseObject
     * with the Actor, a success message and HttpStatus.OK. If the actor is not found
     * returns Actor as null, a unsuccessful message and HttpStatus.NOT_FOUND.
     * @param actorId the id of the actor.
     * @return ResponseObject, with the Actor, a message and the status.
     */
    @GetMapping("/{actorId}")
    public ResponseEntity<ResponseObject> getActorByActorId(@PathVariable long actorId){
        ResponseObject response = new ResponseObject();
        try{
            response.setObject(actorService.findActorById(actorId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Actor with id " + actorId);
        }catch (Exception e){
            response.setMessage("Actor with id " + actorId + " not found");
            response.setStatus(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,response.getStatus());
    }


    /**
     * Gets all the actors in the database.
     * @return ResponseObject with all the actors, success message and HttpStatus.OK.
     */
    @GetMapping("/all")
    public ResponseEntity<ResponseObject> getAllActors(){
        ResponseObject response = new ResponseObject();
        response.setObject(actorService.findAllActors());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Find all Actors");
        return ResponseEntity.ok(response);
    }


    /**
     * Posts a new Actor to the database.
     * @param actor the actor to insert into database.
     * @return ResponseObject with the created object, message and HttpStatus.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createActor(@RequestBody Actor actor){
        ResponseObject response = new ResponseObject();
        actor.setId(null);
        try{
            response.setObject(actorService.createActor(actor));
            response.setMessage("Actor created successfully!");
            response.setStatus(HttpStatus.CREATED);
        }
        catch (Exception e){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Actor was not created");
            response.setObject(actor);
        }
        return new ResponseEntity<>(response,response.getStatus());
    }

    /**
     * Updates a specific actor based on actorId.
     * @param actorId the actors id.
     * @param actor all the fields to update.
     * @return ResponseObject with the updated object, message and HttpStatus.
     */
    @PutMapping("/update/{actorId}")
    public ResponseEntity<ResponseObject> updateActor(@PathVariable long actorId, @RequestBody Actor actor){
        ResponseObject response = new ResponseObject();
        try{
            response.setObject(actorService.updateActor(actorId,actor));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Actor with id " + actorId + " has been updated");
        }catch (Exception e){
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("There is no actor with id " + actorId + "! The update was unsuccessful.");
        }

        return new ResponseEntity(response,response.getStatus());
    }


    /**
     * Deletes an actor based on actorId.
     * @param actorId the id of the actor to delete
     * @return ResponseObject with the deleted object, message and HttpStatus.
     */
    @DeleteMapping("/delete/{actorId}")
    public ResponseEntity<ResponseObject> deleteActorById(@PathVariable long actorId){
        ResponseObject response = new ResponseObject();
        try{
            response.setObject(actorService.deleteActorById(actorId));
            response.setMessage("Actor with id " + actorId + " deleted successfully!");
            response.setStatus(HttpStatus.OK);
        } catch (Exception e) {
            response.setObject(actorId);
            response.setMessage("Actor not deleted! There is no actor with the id " + actorId);
            response.setStatus(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response,response.getStatus());
    }
}
