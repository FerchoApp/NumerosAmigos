/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numerosamigos;

import java.util.Scanner;

public class NumerosAmigos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long startTime = System.nanoTime();

        
        System.out.print("Introduce el primer número: ");
        int numero1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int numero2 = scanner.nextInt();

        
        int sumaDivisores1 = sumaDivisores(numero1);
        int sumaDivisores2 = sumaDivisores(numero2);

        
        if (sumaDivisores1 == numero2 && sumaDivisores2 == numero1) {
            System.out.println(numero1 + " y " + numero2 + " son números amigos.");
        } else {
            System.out.println(numero1 + " y " + numero2 + " no son números amigos.");
        }

        System.out.println(sumaDivisores1);
        System.out.println(sumaDivisores2);
        
        long endTime = System.nanoTime();

      System.out.println("Program took " +
         (endTime - startTime) + "nanoseconds") ;
    }
    public static int sumaDivisores(int numero1) {
        int suma = 0;
        for (int i = 1; i <= numero1 / 2 ; i++) {
            if (numero1 % i == 0) {
                suma += i;
            }
        }
        return suma;
        
    }
    
}
