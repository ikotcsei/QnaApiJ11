package somaog.QnaApiJ11.repository;

import somaog.QnaApiJ11.XMLInputHandlers.TetelLista;

/*
    class for managing tetels inorder - normal - mode
* */
public class InorderTetelRepository extends TetelRepository{

    //ezt abstract classba
    TetelLista tetelLista = TetelLista.createNewEmpty();

    @Override
    void initTetelList() throws Exception {
        //create iterator, set iterator, read tetellist
    }
}
