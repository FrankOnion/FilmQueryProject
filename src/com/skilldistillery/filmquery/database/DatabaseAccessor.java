package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

// Interface to define database operations
public interface DatabaseAccessor {
  
  // Find a film by its unique ID
  public Film findFilmById(int filmId);
  
  // Find an actor by their unique ID
  public Actor findActorById(int actorId);
  
  // Find a list of actors associated with a film by the film's ID
  public List<Actor> findActorsByFilmId(int filmId);
  
  // Find a list of films matching a given search query
  public List<Film> findFilmByQuery(String query);
}
