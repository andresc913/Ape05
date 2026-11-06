import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SistemaVentas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalAcumulado = 0.0;

        try (BufferedWriter escritor = new BufferedWriter(
                new FileWriter("ventas.txt", true))) {

            while (true) {
                System.out.print("\nNombre del producto (escriba fin para terminar): ");
                String nombre = sc.nextLine().trim();

                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }

                try {
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(sc.nextLine());

                    System.out.print("Cantidad vendida: ");
                    int cantidad = Integer.parseInt(sc.nextLine());

                    double subtotal = precio * cantidad;
                    double descuento = subtotal >= 100 ? subtotal * 0.10 : 0.0;
                    double total = subtotal - descuento;
                    totalAcumulado += total;

                    System.out.printf("Subtotal: $%.2f%n", subtotal);
                    System.out.printf("Descuento: $%.2f%n", descuento);
                    System.out.printf("Total a pagar: $%.2f%n", total);

                    escritor.write("Producto: " + nombre);
                    escritor.newLine();
                    escritor.write("Precio: $" + String.format("%.2f", precio)
                            + " | Cantidad: " + cantidad);
                    escritor.newLine();
                    escritor.write("Subtotal: $" + String.format("%.2f", subtotal)
                            + " | Descuento: $" + String.format("%.2f", descuento));
                    escritor.newLine();
                    escritor.write("Total: $" + String.format("%.2f", total));
                    escritor.newLine();
                    escritor.write("------------------------------");
                    escritor.newLine();
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese valores numericos validos. Intente nuevamente.");
                }
            }

            escritor.write("TOTAL ACUMULADO DE ESTA SESION: $"
                    + String.format("%.2f", totalAcumulado));
            escritor.newLine();
            escritor.write("================================");
            escritor.newLine();

            System.out.printf("%nTotal acumulado de las ventas realizadas: $%.2f%n",
                    totalAcumulado);
            System.out.println("La informacion se guardo en ventas.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
