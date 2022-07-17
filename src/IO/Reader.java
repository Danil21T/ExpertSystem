package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

public class Reader {
    private String path = "Base/";

    public Reader(String name){
        path+=name+".txt";
    }

    public Vector<String> getGame() {
        Vector<String> res = new Vector<>();
        File f = new File(path);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null){
                res.add(line);
                line = reader.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

}
