package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

// Implementation of the DatabaseAccessor interface
public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String USER = "student";
	private static final String PASSWORD = "student";

	// Find a film by its unique ID
	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT * FROM film WHERE id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet results = ps.executeQuery();

			if (results.next()) {
				film = new Film();

				// Set film properties from database
				film.setId(results.getInt("id"));
				film.setTitle(results.getString("title"));
				film.setDescription(results.getString("description"));
				film.setReleaseYear(results.getString("release_year"));
				film.setLanguageId(results.getInt("language_id"));
				film.setRentalDuration(results.getInt("rental_duration"));
				film.setRentalRate(results.getDouble("rental_rate"));
				film.setLength(results.getInt("length"));
				film.setReplacementCost(results.getDouble("replacement_cost"));
				film.setRating(results.getString("rating"));
				film.setSpecialFeatures(results.getString("special_features"));

				// Set actors by calling findActorsByFilmId method
				film.setActors(findActorsByFilmId(filmId));
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	// Find an actor by their unique ID
	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, actorId);
			ResultSet actorResult = ps.executeQuery();

			if (actorResult.next()) {
				actor = new Actor();

				// Set actor properties from database
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	// Find a list of actors associated with a film by the film's ID
	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_actor.film_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				Actor actor = new Actor(id, firstName, lastName);

				actors.add(actor);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	// Find a list of films matching a given search query
	@Override
	public List<Film> findFilmByQuery(String query) {
		List<Film> films = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + query + "%");
			ps.setString(2, "%" + query + "%");
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				Film film = new Film();

				// Set film properties from database
				film.setId(results.getInt("id"));
				film.setTitle(results.getString("title"));
				film.setDescription(results.getString("description"));
				film.setReleaseYear(results.getString("release_year"));
				film.setLanguageId(results.getInt("language_id"));
				film.setRentalDuration(results.getInt("rental_duration"));
				film.setRentalRate(results.getDouble("rental_rate"));
				film.setLength(results.getInt("length"));
				film.setReplacementCost(results.getDouble("replacement_cost"));
				film.setRating(results.getString("rating"));
				film.setSpecialFeatures(results.getString("special_features"));

				// Set actors by calling findActorsByFilmId method
				film.setActors(findActorsByFilmId(results.getInt("id")));

				films.add(film);
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}
}
