package somaog.QnaApiJ11._desk;

import java.util.Arrays;
import java.util.List;

/*  add a new qna :
       create repo file extend from this
       - autowire to controller
       - add url to controller

    dynamically add xml file :
       - check a dir every 60sec, load if theres a new on
       - how to add dynamically a new url ???
             - create urls and bind it later ?
             - create a new url in a file, reload spring context from file runtime, enable the urls
               https://www.baeldung.com/spring-boot-enable-disable-endpoints-at-runtime


    1. functionalites
        add

        later :
           js , generate html outside controller .
    2. test
    3. deploy  CI/CD setup
*
* */
public class _desk {

    public static void main(String[] args) {
        System.out.println(recfakt(5));
        List<String> myS = Arrays.asList("asdf","jklé");
//        List<Integer> myA = Arrays.asList();
//        System.out.println(myA.get(0));
    }

    public static int recfakt(int n){
        if( n > 2)  return n * recfakt( n-1 );
        else return 1;
    }


}
