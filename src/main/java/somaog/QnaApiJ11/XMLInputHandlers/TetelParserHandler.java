package somaog.QnaApiJ11.XMLInputHandlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


/**  class for parsing the xml file
    <tetel>
            <question>
                tries
            </question>
            <links>https://en.wikipedia.org/wiki/Trie</links><ln>linknev-ez egybol a link utan jojjon</ln>
            <links>https://.....</links>
            <answer>
                valami valasz
            </answer>
    </tetel>

   ide is teszteket kene, min max, jol formazott hogy nez ki
   pl hibas :
         <answer>
         <links></links>
            valami valasz
         <ln>linknev-ez egybol a link utan jojjon</ln>
         </answer>

**/
public class TetelParserHandler extends DefaultHandler {


    private static final String QUESTIONLIST = "questionlist";
    private static final String TETEL = "tetel";
    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";
    private static final String LINKS = "links";
    private static final String LN = "ln";
    private static final String IMAGES = "images";


    //list of tetel
    private TetelLista tetelek;

    //tmp storage building more line long tags
    //egymasba nem fuzheto tagek eseten eleg answerrowbuilder
    private StringBuilder answerRowBuilder = new StringBuilder();


    //the link struct object  link { String url, String name}
    //stored here until </links> tag, and add
    private Link linkbuilder;


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        answerRowBuilder.append(new String(ch, start, length));

    }

    @Override
    public void startDocument() throws SAXException {

        tetelek = new TetelLista();
        answerRowBuilder = new StringBuilder();

    }

    /*
      what to do on starting <tag> elements,  callback function.
     */
    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case QUESTIONLIST:
                tetelek.setTetelList(new ArrayList<>());
                break;
            case TETEL:
                tetelek.addTetel(new Tetel());
                break;
            case QUESTION:
                answerRowBuilder = new StringBuilder();
                break;
            case ANSWER:
                answerRowBuilder = new StringBuilder();
                break;
            case LINKS:
                answerRowBuilder = new StringBuilder();
                linkbuilder = new Link();
                break;
            case IMAGES:
                answerRowBuilder = new StringBuilder();
                break;
            case LN:
                answerRowBuilder = new StringBuilder();
                break;

        }
    }

    /*
          what to do on ending <tag> elements,  callback function.
    */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case QUESTION:
                latestArticle().setQuestion(answerRowBuilder.toString());
                break;
            case ANSWER:
                latestArticle().setAnswer(answerRowBuilder.toString());
                break;
            case LINKS:
                linkbuilder.setUrl(answerRowBuilder.toString());
                linkbuilder.setName(answerRowBuilder.toString());
                tetelek.getLastInserted().addLink(linkbuilder);
                break;
            case IMAGES:
                tetelek.getLastInserted().addImage(answerRowBuilder.toString());
                break;
            case LN:
                tetelek.getLastInserted().getLastLink().setName(answerRowBuilder.toString());
                break;

        }
    }

    private Tetel latestArticle() {
        List<Tetel> articleList = tetelek.getTetelList();
        int latestArticleIndex = articleList.size() - 1;
        return articleList.get(latestArticleIndex);
    }

    public TetelLista getTetelek() {
        return tetelek;
    }


}
