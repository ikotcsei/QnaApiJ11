package somaog.QnaApiJ11.repository;

import somaog.QnaApiJ11.XMLInputHandlers.Tetel;
import somaog.QnaApiJ11.XMLInputHandlers.TetelListManager;

import java.util.Random;

/**
 *
 * make this class noninitable ?
 *
 *  class that holds the data imported from xml files*
 *
 * */
public class RandomTetelRepository extends TetelRepository{

    TetelListManager tetelListManager = TetelListManager.createNewEmpty();
    Tetel lastRandomTetel = null;
    Random rand = new Random();


    public RandomTetelRepository() {
    }

    public void printRepo(){
        if(tetelListManager.getTetelList().isEmpty()){
            System.out.println("the tetellist is empty.");
            return;
        }
        for(Tetel s : tetelListManager.getTetelList()){
            System.out.println(s);
        }
    }

    // retrieves the first tetel in the tetellist
    public Tetel getFirstItem(){
        return tetelListManager.getTetelList().get(0);
    }

    /*
       retrieve Tetel via lastRandomTetel set by nextRandom
    * */
    public Tetel readNextRandomTetel() throws Exception {
        /* eloolvasas itt h ne kelljen htmlcontrollerbe initNextRandomTetel()-t  hivni */
        return lastRandomTetel;
    }

    /**
    *    sets the lastRandomTetel field to a random Tetel from the tetellist, sets lastRandomTetel field
    *    so random number can be read from lastRandomTetel more times
    */
    public void initNextRandomTetel() throws Exception {

        rand = new Random();
        if(!tetelListManager.isEmpty()){
            lastRandomTetel = tetelListManager.getTetelList().get(rand.nextInt(tetelListManager.getTetelList().size()));
        }
        else throw new Exception(" ures a tetellista ! ");

    }


/*  initalizes random tetellist
    sets the lastRandomTetel field so it is readable, prereads
* */
    @Override
    void initTetelList() throws Exception {
        initNextRandomTetel();
    }
}
