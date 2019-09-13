package br.com.ufms.so.jantardosfilosofos;

import java.util.Random;

public class Garfo extends Thread {
    private final int garfoEsquerda;
    private final int garfoDireita;

    public Garfo(int garfoEsquerda, int garfoDireita) {
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
    }

    @Override
    public void run(){
        while (true){
            try{
                sorteiaGarfoDireito();
                sorteiaGarfoEsquerdo();
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sorteiaGarfoEsquerdo() {
        int garfoEsquerdo;
        Random d = new Random();
        garfoEsquerdo = d.nextInt(5);
        System.out.println("O garfo da esquerdo sorteado "+ garfoEsquerdo);
    }

    private void sorteiaGarfoDireito() {
        int garfoDireito;
        Random d = new Random();
        garfoDireito = d.nextInt(5);
        System.out.println("O garfo da direita sorteado "+ garfoDireito);
    }

    public int getGarfoEsquerda() {
        return garfoEsquerda;
    }

    public int getGarfoDireita() {
        return garfoDireita;
    }
}
