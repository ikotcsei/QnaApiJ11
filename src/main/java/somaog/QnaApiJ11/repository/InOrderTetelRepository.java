package somaog.QnaApiJ11.repository;

import somaog.QnaApiJ11.XMLInputHandlers.Tetel;
import somaog.QnaApiJ11.XMLInputHandlers.TetelListManager;

import java.util.Iterator;

/*
    class for managing tetels inorder - normal - mode
* */
public class InOrderTetelRepository extends TetelRepository{

//    private Iterator<Tetel> it = null;

    InOrderTetelRepository(){
        tetelListManager = TetelListManager.createNewEmpty();
//        it = tetelListManager.getTetelList().iterator();
        System.out.println("whatever");
    }
    public void initNextTetel(){

    }

//    public Tetel readNext(){
//        if(!it.hasNext()){
//            //reset iterator to item 0, than return item 0
//            it = tetelListManager.getTetelList().iterator();
//            return it.next();
//        }
//        return it.next();
//    }

    @Override
    void initTetelList() throws Exception {
    }
}
