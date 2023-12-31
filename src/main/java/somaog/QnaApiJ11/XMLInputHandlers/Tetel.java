package somaog.QnaApiJ11.XMLInputHandlers;

import somaog.QnaApiJ11.utility.StringToHtmlConverter;

import java.util.ArrayList;
import java.util.List;


/**

        Base class for handling the xml , based on xml structure
        stores question answer and links text in string
        and htmlQuestion and htmlAnswer text in HTML format

*/
public class Tetel {


    private String question;
    private String answer;

    /*  convert and store the text in html format
        these can be lazy inited ?
    * */
    private String htmlQuestion;
    private String htmlAnswer;

    // store the links appeared in tetel
    private List<String> links = new ArrayList<>();

    private List<String> images = new ArrayList<>();



    public String getAnswer() {
        return answer;
    }

    public String getHtmlAnswer() {
        return htmlAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getHtmlQuestion() {
        return htmlQuestion;
    }

    public void setQuestion(String question) {

        this.question = question;
        //convert
        this.htmlQuestion = StringToHtmlConverter.stringToHTMLString(question);
    }

    public void setAnswer(String answer) {

        this.answer = answer;
        this.htmlAnswer = StringToHtmlConverter.stringToHTMLString(answer);
    }

    @Override
    public String toString() {
        return this.question + "\n" + this.answer + "\n" + links.toString() + "\n" + images.toString();
    }

    public String toHtmlString() {
        return this.htmlQuestion + this.htmlAnswer;
    }

    public String answerInHtmlString() {
        return this.htmlAnswer;
    }

    public String questionInHtmlString() {
        return this.htmlQuestion;
    }

    public void addLink(String link) {
        this.links.add(link);
    }


    public String getLastLink() {
        if (links.isEmpty()) return null;
        return links.get(links.size() - 1);
    }

    public void addImage(String image){
        this.images.add(image);
    }

    public String getLastImage(){
        if(images.isEmpty()) return null;
        return images.get(images.size() - 1);
    }


}
