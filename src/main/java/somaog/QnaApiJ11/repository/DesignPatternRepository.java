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


    public DesignPatternRepository() throws Exception {

        //ez a 2 egyutt kell fusson init resz, mehet super konstruktorba ?
        //vhogy ezt kene garantalni

        tetelLista = TetelLista.createNew(InitXMLFilesToMemory.getAll("designpatterns.xml"));
        nextRandom();


    }



}
