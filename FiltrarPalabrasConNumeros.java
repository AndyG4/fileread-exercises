
import java.io.*;
import java.util.ArrayList;

public class FiltrarPalabrasConNumeros {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
        ArrayList<String> palabras = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file1));
            FileWriter fileWriter = new FileWriter(file2)
        ){
            String linea;
            while ((linea = br.readLine())!=null){
                palabras.add(linea);
            }

            String [] cadena = new String[0];
                for (String palabra: palabras){
                    cadena = palabra.split(" ");
                }
            boolean contiene = false;
                StringBuilder stringBuilder = new StringBuilder();
                for (String a :  cadena){
                    contiene = a.matches(".*\\d.*");
                    if (contiene==true){
                        stringBuilder.append(a).append(" ");

                    }

                }
            System.out.println(stringBuilder.toString());
                fileWriter.write(stringBuilder.toString().trim());

            
        }



    }



}
