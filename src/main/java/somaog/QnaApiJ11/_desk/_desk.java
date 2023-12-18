package somaog.QnaApiJ11._desk;

public class _desk {

    public static void main(String[] args) {
        System.out.println(recfakt(5));

    }

    public static int recfakt(int n){
        if( n > 3)  return n * recfakt( n-1 );
        else return 1;
    }
}
