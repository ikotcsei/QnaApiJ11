package somaog.QnaApiJ11.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import somaog.QnaApiJ11.XMLInputHandlers.InitXMLFilesToMemory;
import somaog.QnaApiJ11.XMLInputHandlers.TetelListManager;


/*  class for the xml files in mem
* */
@Configuration
public class DesignPatternRepositoryRandom extends RandomTetelRepository {

    //ezeket vhogy annotataion + konfig fileal megoldani
    private String testFile = "teszt.xml";

    // this is why https://stackoverflow.com/questions/72622054/cant-read-variables-from-application-properties
    @Value( "${inputfile}" )
    private String inputfile;

    //the preferred way is to create one initalization class outsi
    // this is why https://stackoverflow.com/questions/72622054/cant-read-variables-from-application-properties


    // this is why https://stackoverflow.com/questions/72622054/cant-read-variables-from-application-properties
    public DesignPatternRepositoryRandom(@Value(value = "${inputfile}") String inputfile) throws Exception {

        this.inputfile = inputfile;

        //ez a 2 utasitas egyutt kell fusson init resz, mehet super konstruktorba ?
        //vhogy ezt kene garantalni

        tetelListManager = TetelListManager.createNew(InitXMLFilesToMemory.getAll(this.inputfile));
        initTetelList();

//        System.out.println(tetelLista.toString());

 //     uncomment this for test print the json form to the console
//        tetelLista.testJsonRepr();



//        org.springframework.web.client.RestTemplate
//        RestTemplate myR = new RestTemplate();
//        List<MessageConverter> myL = myR.getMessageConverters();



    }



}
