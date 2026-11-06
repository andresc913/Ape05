import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("datos/temporal.txt");

        try {
            // Crear la carpeta datos si no existe.
            File carpeta = archivo.getParentFile();
            if (carpeta != null && !carpeta.exists()) {
                carpeta.mkdirs();
            }

            if (archivo.exists()) {
                System.out.println("El archivo temporal.txt ya existe.");
            } else if (archivo.createNewFile()) {
                System.out.println("Archivo temporal.txt creado correctamente.");
            } else {
                System.out.println("No fue posible crear el archivo.");
            }

            // Simula la confirmación del usuario antes de borrar.
            boolean confirmarBorrado = true;

            if (confirmarBorrado) {
                boolean eliminado = archivo.delete();
                System.out.println("Resultado de la eliminacion: " + eliminado);
            } else {
                System.out.println("Eliminacion cancelada. El archivo se conserva.");
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
