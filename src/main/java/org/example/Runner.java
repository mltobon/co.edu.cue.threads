package org.example;

public class Runner extends Thread {
    private final int distanciaTotal = 100; // Distancia total de la carrera en metros
    private int distanciaRecorrida = 0;

    public Runner(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaTotal) {
            int avance = (int) (Math.random() * 10) + 1; // Avance entre 1 y 10 metros
            distanciaRecorrida += avance;
            System.out.println(getName() + " ha avanzado a " + distanciaRecorrida + " metros.");
            try {
                Thread.sleep(1000); // Descanso de 100ms entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " ha completado la carrera!");
    }

    public static void main(String[] args) {
        Runner corredor1 = new Runner("Corredor 1");
        Runner corredor2 = new Runner("Corredor 2");

        corredor1.start();
        corredor2.start();
    }
}