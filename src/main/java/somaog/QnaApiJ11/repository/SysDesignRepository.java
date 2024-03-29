package somaog.QnaApiJ11.repository;

import org.springframework.context.annotation.Configuration;
import org.xml.sax.SAXException;
import somaog.QnaApiJ11.XMLInputHandlers.InitXMLFilesToMemory;
import somaog.QnaApiJ11.XMLInputHandlers.TetelLista;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;


@Configuration
public class SysDesignRepository extends TetelRepository{

    public SysDesignRepository() throws ParserConfigurationException, SAXException, FileNotFoundException,Exception {
        //itt fel kell tolteni TetelLIst.createNew(tetelList)
        tetelLista = TetelLista.createNew(InitXMLFilesToMemory.getAll("sysdesign.xml"));
        nextRandom();
    }
}
