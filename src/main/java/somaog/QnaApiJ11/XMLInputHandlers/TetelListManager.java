package somaog.QnaApiJ11.XMLInputHandlers;

import somaog.QnaApiJ11.utility.CustomTetelMapper;

import java.io.IOException;
import java.util.List;


/** List of Tetel entries, used by repositories to retrive Tetel Items
 *
 */
public class TetelListManager {

    //get last item, amit utljara szurtunk be biztos h az az utolso ?
    private List<Tetel> tetelList;


    TetelListManager() {
        tetelList = null;
    }

    TetelListManager(List<Tetel> tetelList) {

        this.tetelList = tetelList;
    }

    public static TetelListManager createNewEmpty() {

        return new TetelListManager();
    }

    public static TetelListManager createNew(List<Tetel> tetelList) {

        return new TetelListManager(tetelList);
    }

    public boolean isEmpty() {
        return tetelList.isEmpty();
    }

    public List<Tetel> getTetelList() {
        return tetelList;
    }

    public void setTetelList(List<Tetel> tetelList) {
        this.tetelList = tetelList;
    }

    public void addTetel(Tetel b) {
        tetelList.add(b);
    }

    public Tetel getLastInserted() {
        if (tetelList.isEmpty()) return null;
        return tetelList.get(tetelList.size() - 1);
    }

    public void testJsonRepr() throws IOException {
        for(Tetel t : tetelList){
            CustomTetelMapper.doTheMapping(t);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Tetel i: tetelList
             ) {
            sb.append(i.toString());
        }
        return sb.toString();
    }

}
