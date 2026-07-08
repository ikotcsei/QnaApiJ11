package somaog.QnaApiJ11.FileLoader;

import somaog.QnaApiJ11.QnaApiJ11Application;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;



public class _PathExamples {

    // dont use this with external files, classpath is for resources packaged with dev files
    final String SpringClasspath = "classpath:";  // this points to projectname/target/classes, use only dev




    public static void main(String[] args) throws URISyntaxException {

        /*
        this will get the config.txt sitting next to the jar which contains QnaApi....
        this solution works after deployment with tomcat etc. preferred
        * */

        Path jarDir = Paths.get(
                QnaApiJ11Application.class.getProtectionDomain()
                        .getCodeSource()
                        .getLocation()
                        .toURI()
        ).getParent();

        Path config = jarDir.resolve("config.txt");

        System.out.println(config.toAbsolutePath());

        /*
        *   This path will point to project root
        *
        * */

        Path projectRoot = Paths.get("").toAbsolutePath();

        /*
        this path will target teszt.xml based on the projects root dir   rootdir/teszt.xml
        */

        Path path = Paths.get("teszt.xml");
        System.out.println(path.toAbsolutePath());
        File f =new File(path.toAbsolutePath().toString());
        System.out.println(f.exists());

    }

    public _PathExamples() throws URISyntaxException {

    }
}
