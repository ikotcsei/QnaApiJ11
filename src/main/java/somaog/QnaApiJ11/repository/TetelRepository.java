package somaog.QnaApiJ11.repository;

import somaog.QnaApiJ11.XMLInputHandlers.Tetel;
import somaog.QnaApiJ11.XMLInputHandlers.TetelLista;

import javax.management.RuntimeErrorException;
import java.util.Random;

/*make this class noninitable ?*/
public class TetelRepository {
    TetelLista tetelLista = TetelLista.createNewEmpty();
    Tetel lastRandomTetel = null;
    Random rand = new Random();


    public TetelRepository() {
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

    public Tetel getFirst(){
        return tetelLista.getTetelList().get(0);
    }

    public Tetel getRandom() throws Exception {

        return lastRandomTetel;
    }

    /*
    *    retrieves a random number from the tetellist
    * */
    public void nextRandom() throws Exception {

        rand = new Random();
        if(!tetelLista.isEmpty()){
            lastRandomTetel = tetelLista.getTetelList().get(rand.nextInt(tetelLista.getTetelList().size()));
        }
        else throw new Exception(" ures a tetellista ! ");

    }


}
