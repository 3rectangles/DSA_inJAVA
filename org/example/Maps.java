package org.example;

import javax.swing.*;
import java.util.*;

/**
 implemented by :
 hashmap: unordered , hashtable O(1)
 treemap: sorted ordered. O(n)
 METHODS:
 put(K key, V value)
 get(Object key):
 containsKey(Object key):




  */
class movies{
String name; int score; String genre;

    public movies(String name, int score, String genre) {
        this.name = name;
        this.score = score;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        movies movies = (movies) o;
        return score == movies.score && Objects.equals(name, movies.name) && Objects.equals(genre, movies.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, genre);
    }
}
public class Maps {

    Comparator<movies> cmp = (mv1,mv2) ->{
      if (mv1.score ==mv2.score)
          return mv1.name.compareTo(mv2.name);
      return mv1.score - mv2.score;
    };
    static Map<String, TreeSet<movies>> genremap = new HashMap<>();
    Map<String, Integer> movieScores = new HashMap<>();
    Map<String, String> movieGenres = new HashMap<>();
    public static void main(String[] args) {
        Maps ob= new Maps();
        
//        Map<String, TreeSet<movies>> genremap = new HashMap<>();
//        Scanner sc= new Scanner(System.in);
//        String genre = sc.next();
        movies movie1 = new movies("Movie1", 8, "Action");
        movies movie2 = new movies("Movie2", 8, "Action");
        movies movie3 = new movies("Movie3", 9, "Drama");
        String genre = movie3.genre;

        // add a movies
        movies mv = new movies("war",112, "Action");
        ob.addmovies(genremap,mv);
        ob.addmovies(genremap,movie1);
        ob.addmovies(genremap,movie3);
        ob.addmovies(genremap,mv);
        ob.addmovies(genremap,movie2);



        // returns the most popular movies in genre
        String key_genre = "Action";
        System.out.println( ob.hashmap(genremap, key_genre));

        for( movies x: genremap.get("Action"))
        {
            System.out.println("-------  "+x.name + " " + x.score + " " + x.genre);
        }
        // update the movie score
        String name ="war";
        int score = 4;

        System.out.println( ob.update_movie(name,score,genremap));
        for( movies x: genremap.get("Action"))
        {
            System.out.println("////////  "+x.name + " " + x.score + " " + x.genre);
        }

        // returns the most popular movies in genre
        key_genre = "Action";
        System.out.println( ob.hashmap(genremap, key_genre));
        System.out.println( " popular in drama "+ob.hashmap(genremap, "Drama"));
    }
    public Boolean update_movie(String name, int score, Map<String, TreeSet<movies>> um){
        // check if this movie exists
        if (movieScores.get(name) == null) return false;

        String  genre = movieGenres.get(name);
        int oldsc= movieScores.get(name);
        movieScores.put(name,score);

        um.get(genre).remove(new movies(name,oldsc,"")); //name & score are imp
        // bec these are used in comparator func
        um.get(genre).add(new movies(name,score,genre));
        return  true;
    }

    public void addmovies(Map<String, TreeSet<movies>> um, movies mv){
        String genre= mv.genre;
        // if it's the first genre then add the empty treeset with comparator function
        um.computeIfAbsent(genre, k -> new TreeSet<>(cmp));
/**
        if (um.get(genre) == null) {
            um.put(genre, new  TreeSet<movies>(cmp)) ;
        }
 */
        // add the movie to the list
        um.get(genre).add(mv);
        movieScores.put(mv.name,mv.score);
        movieGenres.put(mv.name,mv.genre);

        
    }

    public String hashmap(Map<String, TreeSet<movies>> um, String genre){
        //To use a custom object as a key in a HashMap, override equal & hashcode
        // for uniqueness & for handling hash collisions.
        TreeSet<movies> set = um.get(genre);
        if(set !=null)
            return set.last().name; 
        else
            return null;

    }
}

