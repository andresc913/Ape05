import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistroProductos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        try {
            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.print("Cantidad disponible: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            double total = precio * cantidad;

            // El valor true activa el modo append y conserva registros anteriores.
            try (BufferedWriter escritor = new BufferedWriter(
                    new FileWriter("productos.txt", true))) {
                escritor.write("Producto: " + nombre);
                escritor.newLine();
                escritor.write("Precio: $" + String.format("%.2f", precio));
                escritor.newLine();
                escritor.write("Cantidad: " + cantidad);
                escritor.newLine();
                escritor.write("Valor total: $" + String.format("%.2f", total));
                escritor.newLine();
                escritor.write("------------------------------");
                escritor.newLine();
            }

            System.out.println("\nProducto guardado correctamente.");
            System.out.printf("Valor total: $%.2f%n", total);
        } catch (NumberFormatException e) {
            System.out.println("El precio y la cantidad deben ser valores numericos.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
