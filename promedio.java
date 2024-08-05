import java.util.Scanner;

/** 
*Esta es la clase promedio que se encarga de realizar las suma de los examenes.
*@author Luis Berreondo
*@since 2024-07-30
*/


public class promedio {
 
public static void main(String []  args) {
 //Se declara la variable scan para leer datos de linea de comandos.

Scanner sacn = new Scanner(System.in);

// Se coloca int antes de cada varible para que asi el código funcione correcta mente.
  int exa_a = sacn.nextInt(); 
  int exa_b = sacn.nextInt();
  int exa_c = sacn.nextInt();
  int exa_d = sacn.nextInt();


 int promedio =  exa_a + exa_b + exa_c + exa_d ;
// Este es el procedimiento que se lleva para que se puedan sumar los resultados de los exámenes.

System.out.println(promedio);
//El system.out.println se coloca para ver el resultado de nuestro procedimiento en el código.

}

}