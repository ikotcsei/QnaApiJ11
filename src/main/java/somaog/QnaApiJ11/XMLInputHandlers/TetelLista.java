package somaog.QnaApiJ11.XMLInputHandlers;

import java.util.List;

public class TetelLista {

    //get last item, amit utljara szurtunk be biztos h az az utolso ?
    private List<Tetel> tetelList;




    TetelLista(){
        tetelList = null;
    }

    TetelLista(List<Tetel> tetelList){

        this.tetelList = tetelList;
    }

    public static TetelLista createNewEmpty(){

        return new TetelLista();
    }

    public static TetelLista createNew(List<Tetel> tetelList){

        return new TetelLista(tetelList);
    }

    public boolean isEmpty(){
        return tetelList.isEmpty();
    }

    public List<Tetel> getTetelList() {
        return tetelList;
    }

    public void setTetelList(List<Tetel> tetelList) {
        this.tetelList = tetelList;
    }

    public void addTetel(Tetel b){
        tetelList.add(b);
    }

    public Tetel getLastInserted(){
        if(tetelList.isEmpty()) return null;
        return tetelList.get(tetelList.size()-1);
    }

}
