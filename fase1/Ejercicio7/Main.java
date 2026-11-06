import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("datos/prueba.txt");

        try {
            // Crear la carpeta padre si todavía no existe.
            File carpeta = archivo.getParentFile();
            if (carpeta != null && !carpeta.exists()) {
                carpeta.mkdirs();
            }

            if (archivo.exists()) {
                System.out.println("El archivo ya existe.");
            } else if (archivo.createNewFile()) {
                System.out.println("Archivo creado correctamente.");
            } else {
                System.out.println("No fue posible crear el archivo.");
            }

            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Ruta: " + archivo.getPath());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
