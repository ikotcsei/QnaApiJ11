package somaog.QnaApiJ11.XMLInputHandlers;

import somaog.QnaApiJ11.utility.StringToHtmlConverter;

import java.util.ArrayList;
import java.util.List;

public class Tetel {

    /*

Base class for handling the xml , based on xml structure

 */

    private String question;
    private String answer;

    /*  convert and store the text in html format
        these can be lazy inited ?
    * */
    private String htmlQuestion;
    private String htmlAnswer;

    private List<String> links = new ArrayList<>();

    public String getAnswer() {
        return answer;
    }
    public String getHtmlAnswer() { return htmlAnswer; }

    public String getQuestion() {
        return question;
    }
    public String getHtmlQuestion() { return htmlQuestion; }

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
    public String toString(){
        return this.question + this.answer;
    }

    public String toHtmlString() { return this.htmlQuestion + this.htmlAnswer; }

    public String answerToHtmlString(){ return this.htmlAnswer; }

    public String questionToHtmlString(){ return this.htmlQuestion; }

    public void addLink(String link){
        this.links.add(link);
    }

    public String getLastLink(){
        if(links.isEmpty()) return null;
        return links.get(links.size()-1);
    }



}
