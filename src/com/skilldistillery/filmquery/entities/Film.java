package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

// Class to represent a Film
public class Film {
	private int id;
	private String title;
	private String description;
	private String releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String language;

	private List<Actor> actors;

	// Default constructor
	public Film() {
	}

	// Constructor with parameters
	public Film(int id, String title, String description, String releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	// Constructor with parameters including actors
	public Film(int id, String title, String description, String releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}

	// Get the language name based on languageId
	public String getLanguage() {
		switch (languageId) {
		case 1:
			language = "English";
			break;
		case 2:
			language = "Italian";
			break;
		case 3:
			language = "Japanese";
			break;
		case 4:
			language = "Mandarin";
			break;
		case 5:
			language = "French";
			break;
		case 6:
			language = "German";
			break;
		default:
			language = "Unknown";
			break;
		}
		return language;
	}

	// Getter methods
	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public int getLength() {
		return length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public List<Actor> getActors() {
		return actors;
	}

	// Setter methods
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	// Calculate hash code based on various properties
	@Override
	public int hashCode() {
		return Objects.hash(actors, description, id, languageId, length, rating, releaseYear, rentalDuration,
				rentalRate, replacementCost, specialFeatures, title);
	}

	// Compare this Film with another object for equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description) && id == other.id
				&& languageId == other.languageId && length == other.length && Objects.equals(rating, other.rating)
				&& Objects.equals(releaseYear, other.releaseYear) && rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

	// Return a formatted string representation of the Film
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Film id: ").append(id).append("\n").append(" title: ").append(title).append(", description: ")
				.append(description).append(", releaseYear: ").append(releaseYear).append("\n").append(" language id: ")
				.append(languageId).append(", rental duration: ").append(rentalDuration).append(", rental rate: ")
				.append(rentalRate).append(", length: ").append(length).append(", replacement cost: ")
				.append(replacementCost).append(", rating: ").append(rating).append(", special features: ")
				.append(specialFeatures).append("\n").append("Actors: \n");

		for (Actor actor : actors) {
			sb.append("  ").append(actor.getFirstName()).append(" ").append(actor.getLastName()).append("\n");
		}

		return sb.toString();
	}

	// Return a string representation of actors
	public String printActors() {
		StringBuilder sb = new StringBuilder();

		for (Actor actor : actors) {
			sb.append("  ").append(actor.getFirstName()).append(" ").append(actor.getLastName()).append("\n");
		}

		return sb.toString();

	}

	// Return a string representation of actors
	public String printActors(List<Actor> actors) {
		StringBuilder sb = new StringBuilder();

		for (Actor actor : actors) {
			sb.append("  ").append(actor.getFirstName()).append(" ").append(actor.getLastName()).append("\n");
		}

		return sb.toString();
	}

}
