import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese un mensaje: ");
        String mensaje = teclado.nextLine();

        try {
            FileWriter archivo = new FileWriter("estudiantes.txt", true);
            archivo.write(mensaje + System.lineSeparator());
            archivo.close();

            System.out.println("La información se guardó correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }

        teclado.close();
    }
}
