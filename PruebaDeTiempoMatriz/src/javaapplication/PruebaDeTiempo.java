package javaapplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaDeTiempo {
    public static void main(String[] args) {
        int filas = 0;
        int columnas = 0;
        
        // Nombre del archivo CSV
        String csvFile = "resultados_pruebas.csv";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // Escribir la cabecera del CSV
            writer.write("Prueba;Filas;Columnas;Duracion(ms)");
            writer.newLine();
            
            for (int k = 0; k <= 4; k++) {
                filas += 1000;
                columnas += 1000;
                int[][] matriz = new int[filas][columnas];
                long startTime = System.currentTimeMillis();
                
                // Llenar la matriz con valores aleatorios
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        matriz[i][j] = (int) (Math.random() * 100);
                    }
                }
                
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                
                // Escribir los resultados en el archivo CSV
                writer.write(String.format("Prueba %d;%d;%d;%d", k + 1, filas, columnas, duration));
                writer.newLine();
                
                System.out.println("Duración de la prueba " + (k + 1) + ": " + duration + " milisegundos.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

