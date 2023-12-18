package somaog.QnaApiJ11._desk;

class SuperClass{
    Integer a;
    public void printA(){
        System.out.println(a);
    }
}

class SubClassA extends SuperClass{
   SubClassA(){
       a = 11;
   }
}

class SubClassB extends SuperClass{
    SubClassB(){
        a = 12;
    }
}

public class AB {
    public static void main(String[] args) {
        SubClassA myA = new SubClassA();
        SubClassB myB = new SubClassB();

        myA.printA();
        myB.printA();
    }
}
