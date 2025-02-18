package somaog.QnaApiJ11._desk;


import java.util.List;

/*  **** setup local servers : start frontend,
                               start backend;


   ***build n deploy  :

                CTRL + F5 !!! CTRL + F5 !!! empty cache ? or skip ... HELLO !!!! *********** CTRL + F5 !!!


                - localhost -> ezittegybukfenc.de:8080/QA/  miatt xml-fileokban XMLTrans
                - app.properties beallit
                - frontend  globals.js ben. currentServerURL = productionURL;

                npm run build, read _buildScripts/
                copy dist/bundle.js -> /static/, dist/index.html -> /templates/, <script defer="defer" src="bundle.js"></script>
                modify xml file links for production ???? ez mar nem kell sztem

                mvn clean install

                mvn package -> csak akkor compile ha kell, testfuttat, masolja a static es a template
                mappakat targetbe. thymeleaf template indexet serveli ami kerese a ./static/bundle.js-t
                - static es target mappak maguktol updatelodnek compile eseten

                move war to prod server : deployWar.bat


    add a new topic (xml file)  :
       - copy file to /resources/
       - create repo file extend from TetelRepository
       - autowire to controller
       - add url to controller

    addimage :
      ../static/<xml_filename>/ - be masolni
      links : productionURL + /<xml_filename>/fileneve
      <images>http://ezittegybukfenc.de:8080/QA/javabasic/j_mem1.jpg</images>

  FEATURE TO ADD :

    kotcsei links : https://kotcsei.web.elte.hu/
    read in a row - : ne random adja a tetelt hanem sorban : uj link + next / prev buttons
    reload a telo lehuzasara - kovetkezot adja  - ez routing problema sztem

    dynamicall read all picture files and add :

    dynamically add xml file :
       - check a dir every 60sec, load if theres a new on
            linux tomcat : /var/lib/tomcat9/webapps/..... basicalgos.xml
            dynamicreposity manager , load, reload- update, delete ??? - eleg tomcat restart + filetorles
            dynamicfrontend repo valasztas

    0. deployment - production todos

       - 404 resource not found error tho in dev environment working.
         probably FE routing error , follow this : (html5 pushstate problem)
         https://stackoverflow.com/questions/41246261/react-routing-is-able-to-handle-different-url-path-but-tomcat-returns-404-not-av/41249464#41249464

    1. functionalites,todos
          add :


             0. tudast feltolteni - napi X  , sysdesignnal kezd

             0- frontendet szebbre, tomcat serveren routing : redirect to ezittegybukfenc:8080/QA/ , h reload jo legyen
                - rewrite valve, web.xml, rewrites.config

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
                    minden xml filehoz route, js frontend kell, ezt vhogy sablonnal megoldani
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
