package movies;

import java.util.ArrayList;

public class Movie {
	private String name;
	private ArrayList actors;
	private int year;

	public Movie(String name, int year) {
		this.name = name;
		this.year = year;
		this.actors = new ArrayList();
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public ArrayList addActor(Actor a) {
		actors.add(a);
		if (!(a.getMovies().contains(this))) {
			a.addMovie(this);
		}
		return actors;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Movie))
			return false;
		Movie s = (Movie) other;
		return name.equals(s.name) && year == s.year;
	}

	public ArrayList getActors() {
		return actors;
	}

	public String toString() {
		return name.toString() + ", " + String.valueOf(year) + helper4(actors);
	}

	// helper method 4 returns string representation of items of an arraylist
	// with line separator in between
	public String helper4(ArrayList<Actor> actors) {
		if (actors.size() == 0)
			return "";
		else if (actors.size() == 1)
			return (String) (System.lineSeparator()) + actors.get(0).getName().toString();
		else {
			String g = "";
			for (int i = 0; i < actors.size(); i++) {
				if (i == 0)
					g = (String) (System.lineSeparator()) + actors.get(i).getName().toString();
				else {
					g = g + (String) (System.lineSeparator()) + actors.get(i).getName().toString();
				}
			}
			return g;
		}
	}
}
