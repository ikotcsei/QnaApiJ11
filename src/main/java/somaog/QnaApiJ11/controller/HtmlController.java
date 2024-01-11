package somaog.QnaApiJ11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import somaog.QnaApiJ11.repository.BasicAlgosRepository;
import somaog.QnaApiJ11.repository.DesignPatternRepository;

@Controller  // to return HTML, no restcontroller and responsebody annotations.
public class HtmlController {

    @Autowired
    DesignPatternRepository designPatternRepository;

    @Autowired
    BasicAlgosRepository basicAlgosRepository;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody // will return a String
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
    }

//    @CrossOrigin(origins = "http://localhost:8080")
//    @GetMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody // will return a String
//    public ResponseEntity welcomeAsJSON() {
         // https://www.baeldung.com/spring-boot-json
    // es az objektet service-n keresztul olvassa ki, kell tetelservice
//        return ResponseEntity.ok(javaobject);
//    }

    @GetMapping(value = "/dp", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody // will return a String
    public String getFirstDesignPattern() throws Exception {

        //ne repot kelljen meghivni hanem service-t
        designPatternRepository.nextRandom();

        //    <img src="localhost:8080/most.jpg" alt="Italian Trulli">
        // <image>localhost:8080/most.jpg</image>



        //ez meg majd thymeleaf + javascript
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<style>" +
                ".button2 {width: 25%; height: 15%;}" +
                "</style>" +
                "<body>\n" +

                "<div id=\"noId\" >"+
                designPatternRepository.getRandom().questionInHtmlString() +
                "</div>" +


                "<button class=\"button2\" onclick=\"displayText()\">Abrakadabra</button>"+
                " <div id=\"textField\" style=\"display: none;\">"+
                             designPatternRepository.getRandom().answerInHtmlString() +

                //ezt akkor kene megjeleniteni ha nem null a linkeke szama
                "<a href=" + designPatternRepository.getRandom().getLastLink()+">link text</a>"+
                "</div>" +

                //ezt is kell blokkolni, tovabba csak akkor kirajzolni ha nem null
//                "<img src=\"" + designPatternRepository.getRandom().getLastImage() + "\" width=\"500\" height=\"600\">"+


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

        //ne repot kelljen meghivni hanem service-t
        basicAlgosRepository.nextRandom();


        //ez meg majd thymeleaf + javascript
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<style>" +
                ".button2 {width: 25%; height: 15%;}" +
                "</style>" +
                "<body>\n" +

                "<div id=\"noId\" >"+
                basicAlgosRepository.getRandom().questionInHtmlString() +
                "</div>" +




                "<button class=\"button2\" onclick=\"displayText()\">Abrakadabra</button>"+
                " <div id=\"textField\" style=\"display: none;\">"+

                basicAlgosRepository.getRandom().answerInHtmlString() +

                //ezt akkor kene megjeleniteni ha nem null a linkeke szama
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
        return "XMLUnderConstruction/links.html";
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
