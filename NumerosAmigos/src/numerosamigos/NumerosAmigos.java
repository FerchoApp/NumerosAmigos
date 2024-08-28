package numerosamigos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NumerosAmigos {

    public static void main(String[] args) {

        int numeros1[] = {220, 1184, 2620, 5020, 6232};
        int numeros2[] = {284, 1210, 2924, 5564, 6332};

        int size = numeros1.length;
        int valor1;
        int valor2;
        int sumaDivisores1;
        int sumaDivisores2;

        // Nombre del archivo CSV
        String csvFile = "numeros_amigos.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            // Escribir los encabezados en el archivo CSV
            writer.println("Numero 1;Numero 2;Tiempo (ns)");

            for (int i = 0; i < size; i++) {
                long startTime = System.nanoTime();
                
                valor1 = numeros1[i];
                valor2 = numeros2[i];

                sumaDivisores1 = sumaDivisores(valor1);
                sumaDivisores2 = sumaDivisores(valor2);

                String resultado;
                if (sumaDivisores1 == valor2 && sumaDivisores2 == valor1) {
                    resultado = "son números amigos.";
                } else {
                    resultado = "no son números amigos.";
                }

                System.out.println(valor1 + " y " + valor2 + " " + resultado);

                // Imprimir en consola las sumas de divisores
                System.out.println(sumaDivisores1);
                System.out.println(sumaDivisores2);

                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                // Imprimir el tiempo de ejecución en consola
                System.out.println("Program took " + duration + " nanoseconds");

                // Escribir los datos en el archivo CSV
                writer.printf("%d;%d;%d%n", valor1, valor2,duration);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int sumaDivisores(int valor) {
        int suma = 0;

        for (int i = 1; i <= valor / 2; i++) {
            if (valor % i == 0) {
                suma += i;
            }
        }
        return suma;
    }
}
