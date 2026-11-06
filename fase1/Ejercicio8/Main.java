import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] materias = {
            "Programacion",
            "Matematica",
            "Fisica",
            "Bases de Datos",
            "Ingles"
        };

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("materias.txt"))) {
            for (String materia : materias) {
                escritor.write(materia);
                escritor.newLine();
            }
            System.out.println("Archivo materias.txt creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
