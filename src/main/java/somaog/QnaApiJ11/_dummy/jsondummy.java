package somaog.QnaApiJ11._dummy;

import java.util.ArrayList;
import java.util.List;


/*
*   classes fort testing gson object mapping to json
*
* */
class jsondummy {

    List<dummylink> list;
    Integer i = 1;
    String str = "janos";

    jsondummy(){
        list = new ArrayList<>(10);
        for(int i=0;i<10;i++){
            list.add(new dummylink());
        }
    }

}

class dummylink{
    private String name="dummyname";
    private String url="dummyurl";
}
