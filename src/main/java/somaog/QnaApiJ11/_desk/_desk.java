package somaog.QnaApiJ11._desk;


import java.util.List;

/*  build n deploy  :
                CTRL + F5 !!!
                - localhost -> ezittegy xml-fileokban XMLTrans
                -app.properties beallit
                -frontend App.js req. beallit production url-re

                npm run build
                copy dist/bundle.js -> /static/, dist/index.html -> /templates/, <script defer="defer" src="bundle.js"></script>
                modify xml file links for production

                mvn clean install

                mvn package -> csak akkor compile ha kell, testfuttat, masolja a static es a template
                mappakat targetbe. thymeleaf template indexet serveli ami kerese a ./static/bundle.js-t
                - static es target mappak maguktol updatelodnek compile eseten


    add a new qna :
       - copy file to /resources/
       - create repo file extend from TetelRepository
       - autowire to controller
       - add url to controller

    dynamically add xml file :
       - check a dir every 60sec, load if theres a new on
            linux tomcat : /var/lib/tomcat9/webapps/..... basicalgos.xml
            dynamicreposity manager , load, reload- update, delete ??? - eleg tomcat restart + filetorles
            dynamicfrontend repo valasztas



    1. functionalites,todos
          add :

             0. tudast feltolteni - napi X  , sysdesignnal kezd

             0- valamiert a sysdesignban az image linkkent jelenik meg, legyen image render egybol ?
                xml-ek rendbe, image-re cserel a link ha kell

             0.01.
                  link , image tagek oda vissza irasa xml-ben production serverhez
                  linkhez - linknev/felirat

            0.0001 - functionality : add next tetel btn to FE, instead of reload
            0.02 frontendrol elerheto legyen egyszerre tobb is, dinamikus frissites
                  file felmasol -> dinamikus konyvtars  -> membetolt, felulir stb ->
                  api lekerdezni , filenev -> route legeneralni react router linket



             0.03 exclude package from build XMLTrans
                https://maven.apache.org/plugins/maven-javadoc-plugin/examples/exclude-package-names.html

??? https://stackoverflow.com/questions/61767538/devtools-failed-to-load-sourcemap-for-webpack-node-modules-js-map-http-e
ez mozilla bug : https://discourse.mozilla.org/t/resend-request-in-network-tab-is-immediately-blocked/112551


             - meg hatra :

                        -dinamik file load  - ez raer, tudom folyamatosan irni, es neha deploy
                        -frontend normalis : telefon teszt
                        -<fogalmak> -hozzaadni, megjelenites?

             -frontend JS :
                    - image /static/x.jpg a localhost:8080/x.jpg-n erheto el , atnezni a linkeket
                    - betumeret kisebbre, telora optimalizalni vhogy : kis kepernyo kis betu
                    egy mukodo verzio amit tudok hasznalni / tesztelni , linkgerenalas, dp es ba is.
                    es deploy

                    anxios router  ezittegy/ -> localhost/dp, ...
                    kepmegjelenites hogy lesz ? serve static backend or frontend
                    minden xml filehoy route, js frontend kell, ezt vhogy sablonnal megoldani
                    kepek vhogy normalis embeddel

             - checkout resttemplate and restclient tests
             - converters in a springboot app :
                https://docs.spring.io/spring-framework/reference/core/validation/convert.html
                spring type conversion : obj -> json, xml, dates stb....
                https://www.baeldung.com/spring-type-conversions
                add - converter, dto, resources, etcetc

             - frontend JS, linkek (kepek  ? ) normalis megjelenitese
                - controllert kijavitani - ehhez kell tymeleaf v JAVASCRIPT - inkabb hogy ezt tanuljam.
                - kell <image> de kesobb kene megcsinalni
             - add <every> tag to xml - amit mindenhol renderel az adott xml- hez
             - logging ?
             - exceptions
             - only one image or link displayed per Tetel, the last one.
                ha null akkor ne
             - dyn add xml file
                serve resource : in war, filesystem,....
                https://www.baeldung.com/spring-mvc-static-resources

                https://stackoverflow.com/questions/36288643/serve-dynamically-changing-static-content-with-spring-boot
                spring.web.resources.static-locations=classpath:/files/,classpath:/static-files



        later :
           js , generate html outside controller .
    2. test
    3. deploy  CI/CD setup
*
* */
public class _desk {

    public static void main(String[] args) {



    }

    class Proxy{

        Target target;

        void proxyCall(){
            //if enabled
            target.doSg();
        }
    }

    class Target{

        //target methods
        void doSg(){

        }
    }





}
