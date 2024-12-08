package main;

import java.util.ArrayList;
import java.util.Collections;

import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Title;

public class Main {
    public static void main(String[] args) {
        Movie harryPotter = new Movie("Harry Potter", 2001, true);
        Movie avatar = new Movie("Avatar", 2014, true);
        Serie lost = new Serie("Lost", 2000, false, 8, false);

        ArrayList<Title> listWatched = new ArrayList<>();
        listWatched.add(harryPotter);
        listWatched.add(avatar);
        listWatched.add(lost);

//		for (Title title : listWatched) {
//			System.out.println(title.toString());
//		}

//		listWatched.forEach(title -> System.out.println(title));

        listWatched.forEach(System.out::println);

        ArrayList<String> searchArtist = new ArrayList<>();
        searchArtist.add("Adam Sandler");
        searchArtist.add("Paulo");
        searchArtist.add("Lucas");

        Collections.sort(searchArtist);
        System.out.println(searchArtist);

    }
}