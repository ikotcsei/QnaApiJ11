package somaog.QnaApiJ11.repository;

import somaog.QnaApiJ11.XMLInputHandlers.TetelListManager;

public abstract class TetelRepository {

    TetelListManager tetelListManager = TetelListManager.createNewEmpty();
    /*
    * init
    * setnext
    * retrievenext
    * reinit?
    * */
/*
    initalizes the tetel list
* */
    abstract void initTetelList() throws Exception;
}
