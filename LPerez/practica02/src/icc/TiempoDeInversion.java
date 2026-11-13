package icc;

import java.util.Scanner;

/**
 * Programa que simula una inversión de dinero. Pide al usuario su nombre,
 * el monto a invertir y las fechas de inicio y fin, y muestra cuántos días
 * dura la inversión y su rendimiento al 12%.
 *
 * @author Lesly Elizabeth Pérez Facio
 * @version 1.0
 */
public class TiempoDeInversion {

    /**
     * Método principal. Ejecuta la simulación de inversión y la repite
     * mientras el usuario responda que si
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Inciso (a): dar la bienvenida y solicitar el nombre
        System.out.println("Bienvenido al simulador de inversión.");
        System.out.println("Por favor, escribe tu nombre:");

        // Inciso (b): recabar el nombre
        String nombre = in.nextLine();

        String respuesta;
        do {
            // Inciso (c): saludar al inversionista y preguntar por el monto
            System.out.println("Hola " + nombre + ". ¿Cuál es el monto que desea invertir?");

            // Inciso (d): recabar el monto
            double monto = in.nextDouble();
            in.nextLine();

            // Inciso (e): preguntar por la fecha de inicio (formato dd/mes/aaaa)
            System.out.println("Escribe la fecha de inicio de la inversión.");
            System.out.println("Día (dd):");

            // Inciso (f): recabar la fecha de inicio
            int dia = in.nextInt();
            in.nextLine();
            System.out.println("Mes (nombre, por ejemplo enero):");
            String mes = in.nextLine();
            System.out.println("Año (aaaa):");
            int anio = in.nextInt();
            in.nextLine();
            Fecha fechaInicio = new Fecha(dia, anio, mes);

            // Inciso (g): preguntar por la fecha de fin (formato dd/mes/aaaa)
            System.out.println("Escribe la fecha de fin de la inversión (formato dd/mes/aaaa).");
            System.out.println("Día (dd):");

            // Inciso (h): recabar la fecha de fin
            dia = in.nextInt();
            in.nextLine();
            System.out.println("Mes (nombre, por ejemplo enero):");
            mes = in.nextLine();
            System.out.println("Año (aaaa):");
            anio = in.nextInt();
            in.nextLine();
            Fecha fechaFin = new Fecha(dia, anio, mes);

            // Inciso (i): mostrar los días de la inversión y el rendimiento al 12%
            int dias = fechaInicio.obtenerDiferenciaDias(fechaFin);
            double rendimiento = monto * 0.12 * dias / 365;

            System.out.println("Tu inversión durará " + dias + " días.");
            System.out.println("Tu rendimiento al 12% sería: $" + rendimiento);

            // Inciso (j): preguntar si desea hacer otra simulación
            System.out.println("¿Deseas hacer otra simulación? (escribe si o no)");
            respuesta = in.nextLine().trim().toLowerCase();
        } while (respuesta.equals("si"));

        System.out.println("Gracias por usar el simulador. ¡Hasta luego!");
    }
}
