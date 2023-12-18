package somaog.QnaApiJ11.XMLInputHandlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class TetelHandler extends DefaultHandler {


    private static final String QUESTIONLIST = "questionlist";
    private static final String TETEL = "tetel";
    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";
    private static final String LINKS = "links";

    //list of tetel
    private TetelLista tetelek;

//    private List<String> links;
    //tmp storage building more line long tags
    private StringBuilder answerRowBuilder = new StringBuilder();
//    private StringBuilder linkBuilder = new StringBuilder();


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        answerRowBuilder.append(new String(ch, start, length));

    }

    @Override
    public void startDocument() throws SAXException {

        tetelek = new TetelLista();
        answerRowBuilder = new StringBuilder();
//        linkBuilder = new StringBuilder();

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
                tetelek.getLastInserted().addLink(answerRowBuilder.toString());

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
