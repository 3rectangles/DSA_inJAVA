package try1;

public class trial {

    public static void main(String[] args) {

        trial ob= new trial();
        System.out.println(ob.add(7));
    }
    public int add(int a){

        return a+addfive(2);
    }
    public int addfive(int x){
        return x*5;
    }
}
