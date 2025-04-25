import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main{

    public static Map<String,Integer> listaPersona = new HashMap<>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //crea a las personas, puedes descomentar esta seccion para guardar los archivos
       /* Persona p = new Persona();
        p.setNombre("Andres");
        p.setEdad(22);
        Persona p2 = new Persona();
        p2.setNombre("Maria");
        p2.setEdad(22);
        Persona p3 = new Persona();
        p3.setNombre("Jose");
        p3.setEdad(22);
        Persona p4 = new Persona();
        p4.setNombre("Miguel");
        p4.setEdad(22);


        OutputStream outputStream = new FileOutputStream("salida.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(p);
        objectOutputStream.writeObject(p2);
        objectOutputStream.writeObject(p3);
        objectOutputStream.writeObject(p4);

        objectOutputStream.close();*/
        
        //esto es solo un contador que nos ayudara a verificar la velocidad del programa
        Long time = System.currentTimeMillis();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("salida.dat"));

        try {
            while (true){
                Persona P = (Persona) objectInputStream.readObject();
                listaPersona.put(P.getNombre(), P.getEdad());

            }
        }catch (EOFException e){

        }
        for (Map.Entry<String,Integer> entry : listaPersona.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Long time2 = System.currentTimeMillis();
        System.out.println((double) (time2 - time ) /1000);
    }
}
class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    String nombre;
    int edad;
    public Persona() {}
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getEdad() {
        return edad;
    }
    @Override

    public String toString() {
        return "Nombre: " + this.nombre + ", Edad: " + this.edad;
    }
}
