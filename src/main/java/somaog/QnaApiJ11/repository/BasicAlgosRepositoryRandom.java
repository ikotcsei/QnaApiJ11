package somaog.QnaApiJ11.repository;

import org.springframework.context.annotation.Configuration;
import org.xml.sax.SAXException;
import somaog.QnaApiJ11.XMLInputHandlers.InitXMLFilesToMemory;
import somaog.QnaApiJ11.XMLInputHandlers.TetelListManager;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;


@Configuration
public class BasicAlgosRepositoryRandom extends RandomTetelRepository {

    public BasicAlgosRepositoryRandom() throws ParserConfigurationException, SAXException, FileNotFoundException,Exception {
        //itt fel kell tolteni TetelLIst.createNew(tetelList)
        tetelListManager = TetelListManager.createNew(InitXMLFilesToMemory.getAll("basicalgos.xml"));
        initTetelList();

    }
}
