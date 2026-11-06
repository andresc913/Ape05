import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("materias.txt");

        // Si no existe, se prepara con las cinco materias originales.
        try {
            if (!archivo.exists()) {
                try (BufferedWriter inicial = new BufferedWriter(new FileWriter(archivo))) {
                    String[] originales = {
                        "Programacion",
                        "Matematica",
                        "Fisica",
                        "Bases de Datos",
                        "Ingles"
                    };
                    for (String materia : originales) {
                        inicial.write(materia);
                        inicial.newLine();
                    }
                }
            }

            // append = true conserva el contenido anterior y agrega al final.
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true))) {
                escritor.write("Quimica");
                escritor.newLine();
                escritor.write("Estadistica");
                escritor.newLine();
            }

            System.out.println("Se agregaron dos asignaturas al final de materias.txt.");
        } catch (IOException e) {
            System.out.println("Error al modificar el archivo: " + e.getMessage());
        }
    }
}
