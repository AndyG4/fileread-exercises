
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("file");
        words.add("view");
        words.add("In");
    }

    public static void main(String[] args) {
        String path="C:\\Users\\elmic\\OneDrive\\Escritorio\\JAVA\\JAVAPRO\\file.txt";


        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String linea;
            while((linea = br.readLine())!=null){
                words.add(linea);
            }
        }catch (IOException exception){

        }

        for(String a : words){
            int temp = 0;
            char[] cadena = a.toCharArray();
            for (int i = 0; i < cadena.length; i++) {
                if(cadena[i]=='A'||cadena[i]=='B'||cadena[i]=='C'){
                    temp++;
                }

            }
            if(temp==2){
                System.out.println(a);
            }
        }
    }
}
