import java.util.Scanner;
import java.util.ArrayList;

class Empleado { // Creación de la clase empleado
    private static int contadorEmpleados = 0; // Memoria estática
    private int id;
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.id = ++contadorEmpleados;
        this.nombre = nombre;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Salario: $" + salario;
    }
}

class GestorEmpleados {
    private ArrayList<Empleado> empleados; // Memoria dinámica

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(String nombre, double salario) {
        Empleado nuevoEmpleado = new Empleado(nombre, salario);
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado agregado: " + nuevoEmpleado);
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("Lista de empleados:");
        for (Empleado emp : empleados) {
            System.out.println(emp);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Se enseña el menu de opciones al ususario
            System.out.println("\n1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            // Se crea el comando swich para las opciones que puede elegir el ususario
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.nextLine(); // Variable de String para digitar el nombre
                    System.out.print("Ingrese el salario del empleado: ");
                    double salario = scanner.nextDouble(); // Variable de double para digitar el salario si contiene desimales
                    gestor.agregarEmpleado(nombre, salario);
                    break;
                case 2:
                    gestor.mostrarEmpleados();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }
}