package try1;

import java.util.*;

// can be used as multiset in c++.
// can take duplicate objects just have to provide comparator func for it

class treeset {

   static  Comparator<movie> cmp=( movie m1, movie m2)->
    {
        if( m1.score != m2.score)
            return m1.score-m2.score;
        else
            return m1.name.compareTo(m2.name);
    };

    /**
    static TreeSet<movie> set = new TreeSet<>( (m1, m2) ->
    {
        if( m1.score != m2.score)
            return m1.score-m2.score;
        else
            return m1.name.compareTo(m2.name);

    }); //ascending order based on movie score
*/
    static TreeSet<movie> set = new TreeSet<>(cmp);
    public static void main(String[] args) {



        set.add(new movie("titanic",12,"factual"));
        set.add(new movie("m1",10,"factual"));
        set.add(new movie("m2",14,"factual"));
        set.add(new movie("m3",-1212,"factual"));
        set.add(new movie("m3",212,"factual"));
        set.add(new movie("a4",212,"factual"));
        Boolean flag = set.contains(new movie("titanic",12,"factual"));
        System.out.println("boolean "+ flag);
        //score then have to change hash function
        // Get a subset of movies with scores between 10 and 20 (inclusive)
        SortedSet<movie> subset = set.subSet(new movie("", -11111, ""), new movie("", 111111111, ""));

        // Get a headset of movies with scores  strictly less than
        SortedSet<movie> headset = set.headSet(new movie("", 14, ""));

        // Get a tailset of movies with scores greater than or equal to
        SortedSet<movie> tailset = set.tailSet(new movie("", 14, ""));

        for (movie x: subset)
        {
           // movie mv =itr.next();
            System.out.println(x.name +"  "+x.score);
        }
        Iterator<movie> itr= headset.iterator();
        System.out.println("\n\n ssssssss");
        while(itr.hasNext())
        {
            movie mv =itr.next();
            System.out.println(mv.name +"  "+mv.score);

        }

        movie ceil =  set.ceiling(new movie("", 14, ""));
        if( ceil != null)
        System.out.println("\n"+ceil.score);




    }

}




class movie{
    String name; // public
    int score;
    String genre;

    public movie(String name, int score, String genre) {
        this.name = name;
        this.score = score;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        movie movie = (movie) o;
        return score == movie.score && Objects.equals(name, movie.name) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, genre);
    }
}

