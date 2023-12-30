package somaog.QnaApiJ11.XMLInputHandlers;

import org.springframework.util.ResourceUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class InitXMLFilesToMemory {

    public static void main() throws IOException, SAXException, ParserConfigurationException {

        final String GONDOL = "min, max, muveletigeny (legjobb, legrosszabb, osszahasonlitas,)" +
                "muveletek(beszur, torol, lekerdez kovi, lekerdez max) , rendezzuk elore, osszuk fel(shell sort), ";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        TetelHandler tetelHandler = new TetelHandler();
        boolean quit = false;
        Scanner sc = new Scanner(System.in);



        TetelLista result = tetelHandler.getTetelek();


        //reads all files specified in getAll if input is "", else reads only input file
        List<Tetel> articles = getAll("designpatterns.xml");
        //shuffle questions
        Collections.shuffle(articles);

        Iterator<Tetel> it = articles.iterator();
        Tetel articleOne;
        String command = "";

        System.out.println("s - skip question, q - quit ");

        //s - skip, q quit,
//        while(it.hasNext() && !quit){
//            articleOne = it.next();
//            System.out.print(articleOne.getQuestion());
//            if(sc.next().equals("s")) continue;
//            System.out.print(articleOne.getAnswer());
//            command = sc.next();
//
//            if(command.equals("q")) quit = true;
//        }

        while(it.hasNext()){
            articleOne = it.next();
            System.out.print(articleOne.getQuestion());
            System.out.print(articleOne.getAnswer());

        }






    }

    /*
    *    static fujnction to parse  xml to memory, returns list of Tetel
    *  */

    public static List<Tetel> getAll(String file) throws ParserConfigurationException, SAXException, FileNotFoundException {

        final String fileOne = "bintree.xml";
        final String fileTwo = "graph.xml";
        final String fileThree = "JavaFogalmak.xml";
        final String fileFour = "searchandsort.xml";
        final String fileFive = "tervmintak.xml";
        final String fileSix = "preciseJava.xml";

        List<Tetel> allTetel = new ArrayList<>();
        List<String> allFiles = new ArrayList<>();

        if(!file.equals("")){
            allFiles.add(file);
        }else{
            allFiles.add(fileOne);
            allFiles.add(fileTwo);
            allFiles.add(fileThree);
            allFiles.add(fileFour);
            allFiles.add(fileFive);
            allFiles.add(fileSix);

        }


        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        TetelHandler tetelHandler = new TetelHandler();

        boolean quit = false;
        Scanner sc = new Scanner(System.in);
        TetelLista result;

//        File file2 = ResourceUtils.getFile("classpath:designpatterns.xml");

        try{
            for(String s : allFiles){
                //itt a classpath pontosan hova mutat resources v resources/static
                saxParser.parse("classpath:"+s, tetelHandler);
                result = tetelHandler.getTetelek();
                allTetel.addAll(result.getTetelList());
            }

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Cant find the file. ");
            System.exit(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        Collections.shuffle(allTetel);

        return allTetel;

    }


}
