
class lca_binarLifting{

    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        int a =sc.nextInt();
        int b = sc.nextInt();
        lca_binarLifting ob = new lca_binarLifting();
        ob.lca(a,b);
        lca(a,b);

    }

    public int lca( int a , int b){
        // do dfs to store 2^0 parent of every node
        // create binary table out of it

        // get to same height for both nodes
        // check if both nodes are same i.e either a or b is lca
        //do lifting 
        // return lca

    }

}