class Cola {

    // 1. Atributos de la cola
    private int[] elementos;
    private int cantidad;

    // 2. Constructor
    public Cola(int capacidad) {
        elementos = new int[capacidad];
        cantidad = 0;
    }

    // 3. Comprobar si está vacía
    public boolean estaVacia() {
        return cantidad == 0;
    }

    // 4. Comprobar si está llena
    public boolean estaLlena() {
        return cantidad == elementos.length;
    }

    // 5. Insertar un elemento (ENQUEUE)
    public boolean encolar(int valor) {

        if (estaLlena()) {
            return false;
        }

        elementos[cantidad] = valor;
        cantidad++;

        return true;
    }

    // 6. Eliminar el primer elemento (DEQUEUE)
    public Integer desencolar() {

        if (estaVacia()) {
            return null;
        }

        int eliminado = elementos[0];

        // Desplazar los elementos hacia la izquierda
        for (int i = 1; i < cantidad; i++) {
            elementos[i - 1] = elementos[i];
        }

        cantidad--;

        return eliminado;
    }

    // 7. Consultar el primer elemento (PEEK)
    public Integer frente() {

        if (estaVacia()) {
            return null;
        }

        return elementos[0];
    }

    // 8. Mostrar todos los elementos
    public void mostrar() {

        if (estaVacia()) {
            System.out.println("La cola esta vacia.");
            return;
        }

        System.out.print("Cola: ");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(elementos[i] + " ");
        }

        System.out.println();
    }
}


// PROGRAMA PRINCIPAL
public class Main {

    public static void main(String[] args) {

        Cola cola = new Cola(5);

        System.out.println("=== EJEMPLO DE UNA COLA ===");

        // Insertar elementos
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.mostrar();

        // Consultar el primer elemento
        System.out.println("Primer elemento: " + cola.frente());

        // Eliminar el primer elemento
        System.out.println("Elemento eliminado: " + cola.desencolar());
        cola.mostrar();

        // Insertar otro elemento
        cola.encolar(40);
        cola.mostrar();

        // Comprobar el estado de la cola
        System.out.println("¿Esta vacia? " + cola.estaVacia());
        System.out.println("¿Esta llena? " + cola.estaLlena());

        // Eliminar los elementos restantes
        System.out.println("Eliminando elementos:");

        while (!cola.estaVacia()) {
            System.out.println(cola.desencolar());
        }

        cola.mostrar();
    }
}