package com.skilldistillery.filmquery.entities;

import java.util.Objects;

// Class to represent an Actor
public class Actor {
	private int id;
	private String firstName;
	private String lastName;

	// Default constructor
	public Actor() {
	}

	// Constructor with parameters
	public Actor(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getter methods
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	// Setter methods
	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Calculate hash code based on firstName, id, and lastName
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}

	// Compare this Actor with another object for equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName);
	}

	// Return a formatted string representation of the Actor
	@Override
	public String toString() {
		return firstName + " " + lastName + "\n";
	}
}
