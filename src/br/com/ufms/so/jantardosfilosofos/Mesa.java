package br.com.ufms.so.jantardosfilosofos;

import java.util.concurrent.Semaphore;

public class Mesa {

    /**
     * Semaforo para controlar o acesso compartilhado
     * passando por parametro o valor 1, indicando que
     * o semaforo esta disponivel.
     */
    static Semaphore mutex = new Semaphore(1);
    static int quantidadeFilosofos = 5;

    static int[] estadoFilosofo = new int[quantidadeFilosofos];
    static Semaphore[] semaforos = new Semaphore[quantidadeFilosofos];
    static Filosofo[] filosofos = new Filosofo[quantidadeFilosofos];

     public static void main(String[] args) {
        inicializarMesa();

    }

    public static void inicializarMesa(){
        for (int i = 0; i < estadoFilosofo.length; i++) {
            estadoFilosofo[i] = 0;
        }

        filosofos[0] = new Filosofo("Sócrates", 0);
        filosofos[1] = new Filosofo("Platão", 1);
        filosofos[2] = new Filosofo("Aristótoles", 2);
        filosofos[3] = new Filosofo("Tales", 3);
        filosofos[4] = new Filosofo("Parmênides", 4);

        for (int i = 0; i < filosofos.length; i++) {
            System.out.println("garfo [Esquerdo]  " + i + " - filosofo  " + filosofos[i].getNome()+ " - garfo [Direito] " + (i + 1) % 5);
        }

        for (int i = 0; i < semaforos.length; i++) {
            semaforos[i] = new Semaphore(0);
        }

        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i].start();
        }

        try {
            Thread.sleep(10000);
            System.exit(0);
        } catch (InterruptedException e) {
            System.out.println("Erro Mesa.iniciarMesa(): " + e.getMessage());
        }
    }
}
