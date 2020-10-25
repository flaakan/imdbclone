# Imdbclone 

This project is created by [Johnny Hoang](https://github.com/flaakan).

Link to [Heroku](https://spring-boot-imdbclone.herokuapp.com/).

## Information
This is a project created with Java and React to show some information of famous actors with a link to their imdb. Through the api,  
you can create, update, delete and find a specific actor in the database. The website hosted on heroku will show all the actors  
in the database.

### Web page
The web page has one endpoint:
* `/` : This is the home page. It shows cards for all the actors in the database.


### API
The API is reached on /api. 
All of the endpoints starts with /api.
These are the usable endpoints:

* `/actor/{actorId}` : gets a specific actor.
* `/actor/all` : gets all actors.
* `/actor/create` : Creates a new actor.
* `/actor/update/{actorId}` : Updates the actor with the specified actorId.
* `/actor/delete/{actorId}` : Deltes the actor with the specified actorId.
