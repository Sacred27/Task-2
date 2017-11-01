
package task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task {

    static float count;
    static Map utfSymb = new HashMap<Integer, Integer>();
    
    static void reading(String name)
    {
        InputStreamReader fr = null;
        BufferedReader reader = null;
                try {
            if(!new File(name).exists()) {System.out.println(name+" not found"); System.exit(0);}
            FileInputStream file = new FileInputStream(name);
            fr = new InputStreamReader(file, "UTF-8");
            reader = new BufferedReader(fr);
            int symbol;
            while ((symbol = reader.read()) != -1) {
                if(utfSymb.containsKey(symbol)) utfSymb.put(symbol, (int)utfSymb.get(symbol)+1);
                else utfSymb.put(symbol,1);
                count++;   
            }
        }
          catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(name+" not found");
        } catch (IOException e) {
            e.printStackTrace();          
        }
                finally
                {
                    try{
                    reader.close();
                    }
                    catch(IOException e){e.printStackTrace();}
                    try{
                    fr.close();
                    }
                    catch(IOException e){e.printStackTrace();}
                }
                
    }
    
    static void computing()
    {
        utfSymb.forEach((k,v) -> System.out.println("Symbol "+(char)(int)k+" with a frequency - " + (int)v/count));
    }
    
    public static void main(String[] args) {
        reading("D:\\file.txt");
        computing();
       
    }
    
}
