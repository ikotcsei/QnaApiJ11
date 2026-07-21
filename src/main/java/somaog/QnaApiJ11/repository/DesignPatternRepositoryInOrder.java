package somaog.QnaApiJ11.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import somaog.QnaApiJ11.XMLInputHandlers.InitXMLFilesToMemory;
import somaog.QnaApiJ11.XMLInputHandlers.Tetel;
import somaog.QnaApiJ11.XMLInputHandlers.TetelListManager;

import java.util.Iterator;

@Configuration
public class DesignPatternRepositoryInOrder extends InorderTetelRepository{

    @Value( "${inputfile}" )
    private String inputfile;
    private Iterator<Tetel> it = new Iterator<Tetel>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Tetel next() {
            return null;
        }
    };


    public DesignPatternRepositoryInOrder(@Value(value = "${inputfile}") String inputfile) throws Exception {

        this.inputfile = inputfile;

        tetelListManager = TetelListManager.createNew(InitXMLFilesToMemory.getAll(this.inputfile));
        initTetelList();
    }

    public Tetel readNext(){
        if(!it.hasNext()){
            //reset iterator to item 0, than return item 0
        }
        return it.next();
    }
}
