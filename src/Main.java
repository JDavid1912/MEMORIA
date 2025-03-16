import java.util.ArrayList;
import java.util.List;

class Empleado {
    private static int contadorGlobal = 0; // Memoria estática para el contador global

    private int id;
    private String nombre;
    private String cargo;

    // Constructor
    public Empleado(String nombre, String cargo) {
        this.id = ++contadorGlobal; // Incrementa el contador y asigna el ID
        this.nombre = nombre;
        this.cargo = cargo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Empleado {" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Cargo='" + cargo + '\'' +
                '}';
    }
}

public class Main {
    private List<Empleado> empleados; // Memoria dinámica para almacenar empleados

    // Constructor
    public Main() {
        this.empleados = new ArrayList<>();
    }

    // Método para agregar un empleado
    public void agregarEmpleado(String nombre, String cargo) {
        Empleado nuevoEmpleado = new Empleado(nombre, cargo);
        empleados.add(nuevoEmpleado);
    }

    // Método para mostrar todos los empleados
    public void mostrarEmpleados() {
        for (Empleado emp : empleados) {
            System.out.println(emp);
        }
    }

    public static void main(String[] args) {
        Main gestion = new Main();
// Se agregan empleados
        gestion.agregarEmpleado("Juan Pérez", "Desarrollador");
        gestion.agregarEmpleado("Ana Gómez", "Diseñadora");
        gestion.agregarEmpleado("Carlos López", "Gerente");

        System.out.println("Lista de empleados:");
        gestion.mostrarEmpleados();
    }
}
