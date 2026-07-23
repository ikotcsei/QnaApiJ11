package somaog.QnaApiJ11.FileLoader;

import somaog.QnaApiJ11.XMLInputHandlers.TetelListManager;
import somaog.QnaApiJ11.repository.TetelRepository;

import java.util.HashMap;
import java.util.List;

/*
*  This class is responsible for updating the TetelManager when a file is modified.
*  When a  repository  is created should be registered here, the  FileLoadSchelduer
*  calls
* */

public class TetelManagerUpdater {
    //desigpatterns.xml, containing object
    HashMap<String, TetelRepository> tetelRepositoryMap;

    //search for  the  filename in  the repos, update the  tetelmanager. iteratorsshould  be updated
    void reloadFile(String filename, TetelListManager  tetelListManager){

        //tetelListManagerInmap.setTetelList(tetelListManager.getTetelList())
        //tetelListManagerInmap ha inorder akkor reset iterator -  tipus alapjan
        // ha random  akkor initnextrandomtetel() - tipus alapjan
    }

    //on creation register the  managers
    void register(String filename, TetelListManager  tetelListManager){

    }

}
