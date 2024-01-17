package somaog.QnaApiJ11.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import somaog.QnaApiJ11.XMLInputHandlers.Tetel;

import java.io.File;
import java.io.IOException;

/*  class for map tetel object to JSON
*
* */
public class CustomTetelMapper {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    CustomTetelMapper(){

    }

    public static String doTheMapping(Object in) throws IOException {
//        System.out.println(gson.toJson(in));
        return gson.toJson(in);
    }



}
