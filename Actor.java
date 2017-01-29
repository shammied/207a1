package movies;

import java.util.ArrayList;

public class Actor {
	private String name;
	private ArrayList movies;

	public Actor(String name) {
		this.name = name;
		this.movies = new ArrayList();
	}
	public String getName() {
			return name;
	}
	public boolean actedWith(Actor a) {
		int count = 0;
		for (int i = 0; i < max(movies.size(), a.movies.size()); i++) {
			if (a.movies.contains(movies.get(i))) {
				count += 1;
				
			}
			if (movies.contains(a.movies.get(i))) {
				count += 1;
			}
		}
		if (count >= 1) return true;
		else {
			return false;
		
		}
	}
	// helper method 1 returns the maximum int of two given ints
	public int max(int int1, int int2) {
		return Math.max(int1, int2);
	}
	public boolean actedIn(Movie m) {
		return movies.contains(m);
	}
	public ArrayList addMovie(Movie m) {
		movies.add(m);
		if (!(m.getActors().contains(this))) {
			m.addActor(this);
		}
		return movies;
	}
	public boolean equals(Object other) {
		if (!(other instanceof Actor) )
			return false;
		Actor r = (Actor)other;
		return name.equals(r.name) && movies.containsAll(r.movies) && r.movies.containsAll(movies);
	}
	public String toString() {
		return name.toString() + " (" + helper2(movies) + ")";
	}
	// helper method 2 returns string representation of items of an arraylist separated by comma
	public String helper2(ArrayList<Movie> movies) {
	    if(movies.size() == 0)return "";
	    else if(movies.size() == 1)return movies.get(0).getName().toString();
	    else {
	        String g = "";
	        for (int i = 0; i < movies.size() ; i++) {
	            if(i == 0) g = movies.get(i).getName().toString();
	            else {
	                g = g + ", " + movies.get(i).getName().toString();
	            }
	        }
	        return g;
	    } 
	}
	//helper method 3 gets the movies arraylist from an Actor
	public ArrayList getMovies(){
		return movies;
		
	}
}
