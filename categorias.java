import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class categorias {
    
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Escoja un producto ");
  
  //Esta funcion nos sirve para seleccionar el producto
  String producto = null;
          switch(producto){
             
              case 1: producto="Coca-Cola Original";
              break;
              case 2: producto="Coca-Cola Zero";
              break;
              case 3: producto="Coca-Cola Light";
              break;
              case 4: producto="Sprite";
              break;
              case 5: producto="Fanta";
              break;
              case 6: producto="powerade";
              break;
              case 7: producto="monster energy";
              break;
              default: producto="No corresponde a ningun dia";
              break;
          }
          System.out.println("El producto escogido es:"+ producto);
        
         


 }   
    }
//En esta conjunto de codigo es donde el usuario puede agregar un producto
   class Categoria {
          public Categoria() {
        }
    }
   
     public class Main {

    // Lista para almacenar las categorías
    private static List<Categoria> categorias = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String descripcion;
        String continuar;

        do {
            // Solicitar el nombre de la categoría
            System.out.print("Ingrese el nombre de la categoría: ");
            nombre = scanner.nextLine();

            // Solicitar la descripción de la categoría
            System.out.print("Ingrese la descripción de la categoría: ");
            descripcion = scanner.nextLine();

            // Crear la nueva categoría y agregarla a la lista
            Categoria nuevaCategoria = new Categoria(nombre, descripcion);
            categorias.add(nuevaCategoria);

            // Preguntar si desea agregar otra categoría
            System.out.print("¿Desea agregar otra categoría? (s/n): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        // Mostrar todas las categorías agregadas
        System.out.println("\nCategorías ingresadas:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

}

     
    
        
    
    
    
    
    
    
    
    
    

