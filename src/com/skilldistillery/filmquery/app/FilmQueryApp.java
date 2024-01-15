package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor filmDatabase = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.run();
	}

	private void run() {
		Scanner userInputScanner = new Scanner(System.in);

		System.out.println("Welcome to FilmQuery!!");

		while (true) {
			displayMenu();
			int userChoice = userInputScanner.nextInt();
			userInputScanner.nextLine();

			switch (userChoice) {
			case 1:
				searchFilmById(userInputScanner);
				break;
			case 2:
				searchFilmByKeyword(userInputScanner);
				break;
			case 3:
				System.out.println("Goodbye....");
				userInputScanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}

	private void displayMenu() {
		System.out.println("****************************************");
		System.out.println("*             FilmQuery                *");
		System.out.println("****************************************");
		System.out.println("| Option |         Description         |");
		System.out.println("|--------|-----------------------------|");
		System.out.println("|   1    | Search by Film ID           |");
		System.out.println("|   2    | Search by Keyword           |");
		System.out.println("|   3    | Exit Application            |");
		System.out.println("***************************************");
	}

	private void searchFilmById(Scanner inputScanner) {
		System.out.println("Please enter the Film ID: ");
		int filmId = inputScanner.nextInt();
		inputScanner.nextLine();
		Film foundFilm = filmDatabase.findFilmById(filmId);

		if (foundFilm == null) {
			System.out.println("Film not found.");
		} else {
			displayFilmDetails(foundFilm);
		}
	}

	private void searchFilmByKeyword(Scanner inputScanner) {
		System.out.println("Please enter the keyword: ");
		String keyword = inputScanner.nextLine();
		List<Film> matchingFilms = filmDatabase.findFilmByQuery(keyword);

		if (matchingFilms.isEmpty()) {
			System.out.println("No matching films found.");
		} else {
			displayMatchingFilms(matchingFilms);
		}
	}

	private void displayFilmDetails(Film film) {
		System.out.println("***************************************");
		System.out.println("|             Film Found");
		System.out.println("|-------------------------------------");
		System.out.println("|  Title   | " + film.getTitle());
		System.out.println("|  Year    | " + film.getReleaseYear());
		System.out.println("|  Rating  | " + film.getRating());
		System.out.println("|  Language| " + film.getLanguage());
		System.out.println("|  Desc.   | " + film.getDescription());
		System.out.println("|-------------------------------------");
		System.out.println("|  Cast                               ");
		System.out.println("|=====================================");

				System.out.println(film.printActors());
		System.out.println("***************************************");
	}

	private void displayMatchingFilms(List<Film> matchingFilms) {
		System.out.println("***************************************");
		System.out.println("|           Matching Films            ");
		System.out.println("|------------------------------------");
		System.out.println("|  Title   | Year | Rating | Language |");
		System.out.println("|------------------------------------");

		for (Film film : matchingFilms) {
			System.out.printf("|  %-7s| %-5s| %-7s| %-10s|\n", film.getTitle(), film.getReleaseYear(), film.getRating(),
					film.getLanguage());
		}

		System.out.println("|------------------------------------");
		System.out.println("***************************************");
	}
}
