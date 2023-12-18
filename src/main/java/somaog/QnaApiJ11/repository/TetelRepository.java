package somaog.QnaApiJ11.repository;

import somaog.QnaApiJ11.XMLInputHandlers.Tetel;
import somaog.QnaApiJ11.XMLInputHandlers.TetelLista;

import java.util.Random;

public class TetelRepository {
    TetelLista tetelLista;
    Tetel lastRandomTetel;


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

    public void nextRandom(){
        Random rand = new Random();
        lastRandomTetel = tetelLista.getTetelList().get(rand.nextInt(tetelLista.getTetelList().size()));
    }


}
