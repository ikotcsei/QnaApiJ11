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
import somaog.QnaApiJ11.repository.JavaBasicRepository;
import somaog.QnaApiJ11.repository.SysDesignRepository;
import somaog.QnaApiJ11.utility.Car;
import somaog.QnaApiJ11.utility.CustomTetelMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;





@Controller  // to return HTML, no restcontroller and responsebody annotations.
public class HtmlController {

    @Autowired
    DesignPatternRepository designPatternRepository;

    @Autowired
    BasicAlgosRepository basicAlgosRepository;

    @Autowired
    SysDesignRepository sysDesignRepository;

    @Autowired
    JavaBasicRepository javaBasicRepository;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
    @GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
    public @ResponseBody  String welcomeAsHTML() {
        return "hello world.";
    }


    //json convert egyelore igy mukodik de ronda
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081", "http://ezittegybukfenc.de", "http://192.168.0.62", "http://192.168.0.153:8081"})
    @GetMapping(value = "/jsontest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> produceDesignPattern() throws Exception {
//          https://www.baeldung.com/spring-boot-json
//     es az objektet service-n keresztul olvassa ki, kell tetelservice
        //elvileg jackson2 library automappel vhogy springboot-ban
        designPatternRepository.nextRandom();

//        System.out.println(CustomTetelMapper.doTheMapping(new _dummy.jsondummy()));

        return ResponseEntity.ok().body(
                CustomTetelMapper.doTheMapping(designPatternRepository.getRandom())
        );


    }


    //json convert egyelore igy mukodik de ronda
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081", "http://ezittegybukfenc.de", "http://192.168.0.62", "http://192.168.0.153:8081"})
    @GetMapping(value = "/sysdesign", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> produceSysDesign() throws Exception {
//          https://www.baeldung.com/spring-boot-json
//     es az objektet service-n keresztul olvassa ki, kell tetelservice
        //elvileg jackson2 library automappel vhogy springboot-ban
        sysDesignRepository.nextRandom();
        return ResponseEntity.ok().body(
                CustomTetelMapper.doTheMapping(sysDesignRepository.getRandom())
        );


    }

    //json convert egyelore igy mukodik de ronda
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081", "http://ezittegybukfenc.de", "http://192.168.0.62", "http://192.168.0.153:8081"})
    @GetMapping(value = "/basicalgos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> produceBasicAlgos() throws Exception {
//          https://www.baeldung.com/spring-boot-json
//     es az objektet service-n keresztul olvassa ki, kell tetelservice
        //elvileg jackson2 library automappel vhogy springboot-ban
        basicAlgosRepository.nextRandom();
        return ResponseEntity.ok().body(
                CustomTetelMapper.doTheMapping(basicAlgosRepository.getRandom())
        );


    }

    //json convert egyelore igy mukodik de ronda
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081", "http://ezittegybukfenc.de", "http://192.168.0.62", "http://192.168.0.153:8081"})
    @GetMapping(value = "/basicjava", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> produceJavaBasic() throws Exception {
//          https://www.baeldung.com/spring-boot-json
//     es az objektet service-n keresztul olvassa ki, kell tetelservice
        //elvileg jackson2 library automappel vhogy springboot-ban
        javaBasicRepository.nextRandom();
        return ResponseEntity.ok().body(
                CustomTetelMapper.doTheMapping(javaBasicRepository.getRandom())
        );


    }

    // testing automapper jackson - ide kell autoconverting
    //https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-config/message-converters.html
    //https://www.baeldung.com/spring-type-conversions
    //https://www.baeldung.com/spring-httpmessageconverter-rest
    //https://docs.spring.io/spring-android/docs/current/reference/html/rest-template.html#MappingJackson2HttpMessageConverter
    //https://docs.spring.io/spring-android/docs/current/reference/html/rest-template.html
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/jsontest2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> welcomeAsJSON2() throws IOException {
//          https://www.baeldung.com/spring-boot-json
//     es az objektet service-n keresztul olvassa ki, kell tetelservice
        //elvileg jackson2 library automappel vhogy springboot-ban
        return ResponseEntity.ok(new Car(1,2));

    }

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
