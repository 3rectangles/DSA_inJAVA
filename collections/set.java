package collections;

import java.util.*;

public class set {
    public static void main(String[] args) {

    }
}


/**
 Since Set is an interface, we cannot create objects from it.
 In order to use functionalities of the Set interface, we can use these classes:
 HashSet : A hash table-backed implementation, offers constant-time performance for basic operations. requires hash and equal func
 LinkedHashSet: hash table and linked list-backed implementation,gives predictable iteration order, which is the order in which elements were inserted
 EnumSet
 TreeSet : red-black tree-backed implementation of sorted set . log(n) for all operations. requires comparator func

 has collection interface methods:
 add() - adds the specified element to the set
 iterator() - returns an iterator that can be used to access elements of the set sequentially
 remove() - removes the specified element from the set
 clear() - removes all the elements from the set
 size() - returns the length (number of elements) of the set
 toArray() - returns an array containing all the elements of the set
 contains() - returns true if the set contains the specified element
hashCode() - returns a hash code value (address of the element in the set)

 Set interface methods:
 addAll() - union of set : adds all the elements of the specified collection to the set
 removeAll() - difference : removes all the elements from the set that is present in another specified set
 retainAll() - intersection: retains all the elements in the set that are also present in another specified set
 containsAll() -  subset : returns true if the set contains all the elements of the specified collection

 */

class student{

    int roll;
    String name;

    static  int nroll=0; // shared among class, wont be acccesible from object
    public student(String name) {
        this.name = name;
        this.roll = nroll;
        nroll++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return roll == student.roll && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll, name);
    }
}

/**
 * HASHSET
 *
 */
class hashset{
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        set.add(5); // Time complexity: O(1) on average, O(n) in worst case
        set.remove(10); // Time complexity: O(1) on average, O(n) in worst case
        boolean containsElement = set.contains(5);    // Time complexity: O(1) on average, O(n) in worst case
     }

        public static void hash_objects(){
            Set<student> s1 =new HashSet<>();
            s1.add(new student("rahul"));
    }
}

/**
 * TreeMap and TreeSet are both Navigable and Sorted,
 * which is not the case for HashMap and HashSet. By default, the order is the natural order,
 * however, this can be changed by providing a Comparator in the constructor.
 * TreeSet: implementation of sorted set, can iterate and use binary search. use red-black tree
METHODS:
 first(): returns first elem TreeSet is not null else it will throw NoSuchElementException.
 last():
 floor(): This method returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
 set.pollFirst(); // removes first
 set.pollLast();
 set.lower(); // returns elem strictly smaller than
 set.higher();
 set.ceiling(); // returns elem >= ( it returns elm hence datatype should be the object)
 set.subSet(); ( it returns elm hence datatype should be the Sortedset or naviable set)
 set.tailSet(); greater or equal to
 set.headSet(); strictly less than ( emelements from beginning)


 1) set.contains(item)       O(lg(n))
 2) tail = set.tailSet(item) O(1)
 3) tail.first()             O(lg(n))
 4) Over all                 O(lg(n))
 */


// ques: each movie has genre and popularity square. query will be made to change score,& get most
//popular movie in the genre

class movie{
    String name; int score;String genre;
    public movie(String name, int score, String genre) {
        this.name = name;
        this.score = score;
        this.genre = genre;
    }
}

// treeset can be used as multiset in c++.
// can take duplicate objects just have to provide comparator func for it

class treeset {

    static  Comparator<movie> cmp=(movie m1, movie m2)->
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
        Boolean flag = set.contains(new movie("titanic",12,"factual")); //if want to check only
        //score then have to change hash function

         // Other TreeSet methods...
        System.out.println("Size of TreeSet: " + set.size());
        System.out.println("Is TreeSet empty? " + set.isEmpty());
        System.out.println("First movie: " + set.first().name);
        System.out.println("Last movie: " + set.last().genre);

        // search for movie having score equal to key using binary search
        int key;
        Scanner sc = new Scanner(System.in);
        key = sc.nextInt();
        // giving examples to higher / lower /floor & ceiling



        // Get a subset of movies with scores between 10 and 20 (inclusive)
        SortedSet<movie> subset = set.subSet(new movie("", 10, ""), new movie("", 21, ""));

// Get a headset of movies with scores strictly less
        SortedSet<movie> headset = set.headSet(new movie("", 15, ""), true);

// Get a tailset of movies with scores greater than or equal to 8
        SortedSet<movie> tailset = set.tailSet(new movie("", 8, ""), true);

        for (movie x: headset)
        {
            System.out.println(x.score);
        }
        Iterator<movie> itr= headset.iterator();
        System.out.println("\n\n ssssssss");
        while(itr.hasNext())
        {
            System.out.println(itr.next().score);

        }

        // Example: Update the score of "titanic" to 15
        movie titanic = new movie("titanic", 12, "factual");
        set.remove(titanic);
        titanic.score = 15;
        set.add(titanic);




        // iterate through all movies
        for( movie mv : set)
        {
            System.out.println(mv.name);
        }
        // Obtain iterator
        Iterator<movie> iterator = set.iterator();
        while (iterator.hasNext()) {
                movie mov = iterator.next();
                System.out.println(mov.name);
        }

        movie ceil =  set.ceiling(new movie("", 14, ""));
        if( ceil != null)
            System.out.println("\n"+ceil.score);


    }

}


