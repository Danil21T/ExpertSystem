package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class Writer {
    private String path = "Base/";

    public Writer(String name){
        path+=name+".txt";
    }

    public void putGame(String text){
        try{
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter writer = new BufferedWriter(fw);
            fw.write("\n"+text);
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
