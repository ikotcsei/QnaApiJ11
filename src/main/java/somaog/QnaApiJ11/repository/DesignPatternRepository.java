package somaog.QnaApiJ11.repository;

import org.springframework.context.annotation.Configuration;
import org.xml.sax.SAXException;
import somaog.QnaApiJ11.XMLInputHandlers.InitXMLFilesToMemory;
import somaog.QnaApiJ11.XMLInputHandlers.TetelLista;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;


/*  class for the xml files in mem
* */
@Configuration
public class DesignPatternRepository extends TetelRepository{

//    private TetelLista designPattern;
//    private Tetel lastRandom;

    public DesignPatternRepository() throws ParserConfigurationException, SAXException, FileNotFoundException {
        //itt fel kell tolteni TetelLIst.createNew(tetelList)
        tetelLista = TetelLista.createNew(InitXMLFilesToMemory.getAll("designpatterns.xml"));
        nextRandom();
    }

//    public void printRepo(){
//        if(designPattern.getTetelList().isEmpty()){
//            System.out.println("the tetellist is empty.");
//            return;
//        }
//        for(Tetel s : designPattern.getTetelList()){
//            System.out.println(s);
//        }
//    }

//    public Tetel getFirst(){
//        return designPattern.getTetelList().get(0);
//    }
//
//    public Tetel getRandom() throws Exception {
//        return lastRandom;
//    }
//
//    public void nextRandom(){
//        Random rand = new Random();
//        lastRandom = designPattern.getTetelList().get(rand.nextInt(designPattern.getTetelList().size()));
//    }


}
