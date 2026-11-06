import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistroEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (BufferedWriter escritor = new BufferedWriter(
                new FileWriter("estudiantes.txt"))) {

            for (int i = 1; i <= 3; i++) {
                System.out.println("\nESTUDIANTE " + i);
                System.out.print("Ingrese el nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese la calificacion: ");
                double calificacion = Double.parseDouble(sc.nextLine());

                // Cada estudiante se guarda en dos lineas.
                escritor.write(nombre);
                escritor.newLine();
                escritor.write(String.valueOf(calificacion));
                escritor.newLine();
            }

            System.out.println("\nLos datos se guardaron en estudiantes.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("La calificacion debe ser un numero.");
        }

        sc.close();
    }
}
