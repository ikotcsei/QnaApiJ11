package somaog.QnaApiJ11.repository;

import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;
import somaog.QnaApiJ11.XMLInputHandlers.InitXMLFilesToMemory;
import somaog.QnaApiJ11.XMLInputHandlers.TetelLista;
import somaog.QnaApiJ11.utility.Car;
import somaog.QnaApiJ11.utility.CustomTetelMapper;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.util.List;


/*  class for the xml files in mem
* */
@Configuration
public class DesignPatternRepository extends TetelRepository{


    public DesignPatternRepository() throws Exception {

        //ez a 2 egyutt kell fusson init resz, mehet super konstruktorba ?
        //vhogy ezt kene garantalni

//        tetelLista = TetelLista.createNew(InitXMLFilesToMemory.getAll("designpatterns.xml"));
//        tetelLista.testJsonRepr();
//        nextRandom();

//        org.springframework.web.client.RestTemplate
//        RestTemplate myR = new RestTemplate();
//        List<MessageConverter> myL = myR.getMessageConverters();

        //pring for testing
        tetelLista = TetelLista.createNew(InitXMLFilesToMemory.getAll("teszt.xml"));
        tetelLista.testJsonRepr();
        nextRandom();


    }



}
