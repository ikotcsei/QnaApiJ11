package somaog.QnaApiJ11._desk;


import java.util.List;

/*  add a new qna :
       - copy file to /resources/
       - create repo file extend from TetelRepository
       - autowire to controller
       - add url to controller

    dynamically add xml file :
       - check a dir every 60sec, load if theres a new on
       - how to add dynamically a new url ???
             - create urls and bind it later ?
             - create a new url in a file, reload spring context from file runtime, enable the urls
               https://www.baeldung.com/spring-boot-enable-disable-endpoints-at-runtime


    1. functionalites,todos
        add :
             - frontend JS : sajat projektbe javascript helloworld
             - tudast feltolteni - napi X
             -frontend JS :
                    add js project, helloworld,
                    deploy, works ?
                    json endpoint for react
                    connect to endpoint

             - frontend JS, linkek (kepek  ? ) normalis megjelenitese
                - controllert kijavitani - ehhez kell tymeleaf v JAVASCRIPT - inkabb hogy ezt tanuljam.
                - kell <image> de kesobb kene megcsinalni
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
