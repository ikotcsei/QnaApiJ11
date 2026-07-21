package somaog.QnaApiJ11.repository;

import org.springframework.context.annotation.Configuration;
import somaog.QnaApiJ11.XMLInputHandlers.InitXMLFilesToMemory;
import somaog.QnaApiJ11.XMLInputHandlers.Tetel;
import somaog.QnaApiJ11.XMLInputHandlers.TetelListManager;

import java.util.Iterator;

@Configuration
public class JavaBasicRepositoryInOrder extends InOrderTetelRepository {

        private Iterator<Tetel> it;


        public JavaBasicRepositoryInOrder()  throws Exception {

            tetelListManager = TetelListManager.createNew(InitXMLFilesToMemory.getAll("javabasic.xml"));
            it = tetelListManager.getTetelList().iterator();
//            initTetelList();
        }

        public Tetel readNext(){
            if(!it.hasNext()){
                //reset iterator to item 0, than return item 0
                it = tetelListManager.getTetelList().iterator();
                return it.next();
            }
            return it.next();
        }
    }

