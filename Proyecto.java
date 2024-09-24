package ALS;


import java.util.Scanner;





public class producto {


    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
 
    private final String nombre;
    private double precio;
    private int stock;

    public producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
    }
     public static void mostrarProductos(List<String> productos) {
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }
    }

    public static boolean confirmarEliminacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Estás seguro de que deseas eliminar este producto? (S/N): ");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s");
    }

    public static void eliminarProducto(String archivo, int indice) throws IOException {
        List<String> productos = new ArrayList<>();

        // Leer el archivo y cargar productos en la lista
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                productos.add(linea);
            }
        }

        // Eliminar el producto seleccionado
        productos.remove(indice);

        // Sobreescribir el archivo sin el producto eliminado
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String producto : productos) {
                bw.write(producto);
                bw.newLine();
            }
        }

        System.out.println("El producto ha sido eliminado correctamente.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String archivo = "productos.txt";
        List<String> productos = new ArrayList<>();

        // Cargar los productos del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                productos.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Mostrar productos y seleccionar el que se desea eliminar
        System.out.println("Productos disponibles:");
        mostrarProductos(productos);

        System.out.print("Selecciona el número del producto que deseas eliminar: ");
        int indice = scanner.nextInt() - 1;
        
// se crea este if para crear la confirmacion para eliminar el producto 
        if (confirmarEliminacion()) {
            try {
                eliminarProducto(archivo, indice);
            } catch (IOException e) {
                System.out.println("Error al eliminar el producto: " + e.getMessage());
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }
}
}
