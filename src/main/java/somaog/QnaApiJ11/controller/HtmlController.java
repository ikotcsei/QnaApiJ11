package somaog.QnaApiJ11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import somaog.QnaApiJ11.repository.BasicAlgosRepository;
import somaog.QnaApiJ11.repository.DesignPatternRepository;

@Controller  // to return HTML, no restcontroller and responsebody annotations.
public class HtmlController {

    @Autowired
    DesignPatternRepository designPatternRepository;

    @Autowired
    BasicAlgosRepository basicAlgosRepository;

    @GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody // will return a String
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
    }

    @GetMapping(value = "/dp", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody // will return a String
    public String getFirstDesignPattern() throws Exception {

        //ezt nem itt kene meghivni , errre vmit
        designPatternRepository.nextRandom();

        //ez meg majd thymeleaf + javascript
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<style>" +
                ".button2 {width: 50%;}" +
                "</style>" +
                "<body>\n" +
//                "<font size=2>" +
                designPatternRepository.getRandom().questionToHtmlString() +
                "<button class=\"button2\" onclick=\"displayText()\">Click Me!</button> <div id=\"textField\" style=\"display: none;\">"+
                             designPatternRepository.getRandom().answerToHtmlString() +
                "</div>" +
//                "</font>" +

                "<script>" +
                "function displayText() {"+
                        "var text = document.getElementById(\"textField\");"+
                        "text.style.display = \"block\"; }" +
                "</script>" +



                "</body>\n" + "</html>";
    }

    @GetMapping(value = "/ba", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody // will return a String
    public String getFirstBasicAlgos() throws Exception {

        //ezt nem itt kene meghivni , errre vmit
        basicAlgosRepository.nextRandom();
//        System.out.println(basicAlgosRepository.getRandom().answerToHtmlString());
//        System.out.println(basicAlgosRepository.getRandom().getAnswer());
//        System.out.println(basicAlgosRepository.getRandom().getHtmlAnswer());
//        System.out.println(basicAlgosRepository.getRandom().answerToHtmlString());


        //ez meg majd thymeleaf + javascript
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<style>" +
                ".button2 {width: 50%;}" +
                "</style>" +
                "<body>\n" +

                basicAlgosRepository.getRandom().questionToHtmlString() +
                "<button class=\"button2\" onclick=\"displayText()\">Click Me!</button> <div id=\"textField\" style=\"display: none;\">"+
                basicAlgosRepository.getRandom().answerToHtmlString() +
                //ezt akkor kene megjeleniteni ha nem nu
                "<a href=" + basicAlgosRepository.getRandom().getLastLink()+">link text</a>"+
                "</div>" +

                "<script>" +
                "function displayText() {"+
                "var text = document.getElementById(\"textField\");"+
                "text.style.display = \"block\"; }" +
                "</script>" +



                "</body>\n" + "</html>";
    }


    //return html template from resources/static/login.html
    @GetMapping(value = "/links", produces = MediaType.TEXT_HTML_VALUE)
    public String loginAsHTML() {
        return "links.html";
    }


    //return html template from resources/static/deeper/access.html
    @GetMapping(value = "/access")
    public String accessAsHTML() {
        return "/deeper/access.html";
    }


    @GetMapping(value = "/htmlentity")
    public ResponseEntity<String> returnHTMLentity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");

        return new ResponseEntity<>("<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + "Welcome from html entity response \n" + "</body>\n" + "</html>", headers, HttpStatus.OK);
    }

}
