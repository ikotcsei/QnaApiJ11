package somaog.QnaApiJ11.repository;

import somaog.QnaApiJ11.XMLInputHandlers.Tetel;
import somaog.QnaApiJ11.XMLInputHandlers.TetelLista;

import java.util.Random;

/**
 *
 * make this class noninitable ?
 *
 *  class that holds the data imported from xml files*
 *
 * */
public class RandomTetelRepository extends TetelRepository{

    TetelLista tetelLista = TetelLista.createNewEmpty();
    Tetel lastRandomTetel = null;
    Random rand = new Random();


    public RandomTetelRepository() {
    }

    public void printRepo(){
        if(tetelLista.getTetelList().isEmpty()){
            System.out.println("the tetellist is empty.");
            return;
        }
        for(Tetel s : tetelLista.getTetelList()){
            System.out.println(s);
        }
    }

    // retrieves the first tetel in the tetellist
    public Tetel getFirstItem(){
        return tetelLista.getTetelList().get(0);
    }

    /*
       retrieve Tetel via lastRandomTetel set by nextRandom
    * */
    public Tetel readNextRandomTetel() throws Exception {
        return lastRandomTetel;
    }

    /**
    *    sets the lastRandomTetel field to a random Tetel from the tetellist, sets lastRandomTetel field
    *    so random number can be read from lastRandomTetel more times
    */
    public void initNextRandomTetel() throws Exception {

        rand = new Random();
        if(!tetelLista.isEmpty()){
            lastRandomTetel = tetelLista.getTetelList().get(rand.nextInt(tetelLista.getTetelList().size()));
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
