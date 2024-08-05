import java.util.Scanner;

/** 
*Esta es la clase de luz nos ayuda a calcular cuanto gasta una persona en luz
*@author Luis Berreondo
*@since 2024-07-28
*/

public class luz {
//El nombre del algoritmo

public static void main(String [] args){

Scanner scan = new Scanner(System.in);

 int kwh = scan.nextInt();
 int consumo = scan.nextInt();
// Datos de Entrada que se usan para el proceos

int total = kwh * consumo;
//El procceso para la salida esperada
 
System.out.println(total);
//La salida esperada

}
}
