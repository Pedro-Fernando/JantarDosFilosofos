package br.com.ufms.so.jantardosfilosofos;

import java.util.PrimitiveIterator;

public class Filosofo extends Thread {

    private int id;
    private String nome;

    public Filosofo(String nome, int id) {
        this.nome = nome;
        this.id = id;

        System.out.printf("Filosofo %s sertou a mesa.\n", this.nome);
    }

    public void pensar() {
        Mesa.estadoFilosofo[this.id] = Acao.PENDANDO.getValor();
        System.out.printf("O Filosofo %s está pensando...\n", this.nome);
    }

    public void comer() throws InterruptedException {
        Mesa.estadoFilosofo[this.id] = Acao.COMENDO.getValor();
        System.out.printf("O Filosofo %s está comendo.\n", this.nome);

        try{
            Thread.sleep(1000L);
        }catch (InterruptedException e){
            System.out.println("Erro ao Comer: " + e.getMessage());
        }
    }

    public void comFome(){
        Mesa.estadoFilosofo[this.id] = Acao.FAMINTO.getValor();
        System.out.printf("O Filosofo %s está faminto.\n", this.nome);
    }

    /**
     * Como o garfo é um recurso compartilhado é necessario travar este recruso
     * usando o mutex.aquaire() e apos a tentativa obtendo sucesso ou nao deve
     * liberar o acesso com o mutex.release().
     */
    public void pegarGarfo() throws InterruptedException {
        Mesa.mutex.acquire();
        this.comFome();

        this.verificardisponibilidadeDosGarfos();
        Mesa.mutex.release();

        Mesa.semaforos[this.id].acquire();
    }

    public void largarGarfo() throws InterruptedException {
        Mesa.mutex.acquire();
        pensar();

        Mesa.filosofos[estadoVizinhoEsquerda()].verificardisponibilidadeDosGarfos();
        Mesa.filosofos[estadoVizinhoDireita()].verificardisponibilidadeDosGarfos();
        Mesa.mutex.release();
    }

    public void verificardisponibilidadeDosGarfos() throws InterruptedException {
      if (isFilosofoAtualFaminto()){
          if (!isVizinhosComendo()){
              this.comer();
              Mesa.semaforos[this.id].release();
          }else System.out.printf("Filosofo %s não conseguiu comer.\n", this.nome);
      }

    }

    private boolean isFilosofoAtualFaminto() {
        return Mesa.estadoFilosofo[this.id] == Acao.FAMINTO.getValor() ;
    }

    private boolean isVizinhosComendo() {
        return Mesa.estadoFilosofo[estadoVizinhoDireita()] == Acao.COMENDO.getValor() && Mesa.estadoFilosofo[estadoVizinhoEsquerda()] == Acao.COMENDO.getValor();
    }



    public int estadoVizinhoDireita() {
        return (this.id + 1) % 5;
    }

    public int estadoVizinhoEsquerda() {
        if (this.id == 0) {
            return 4;
        } else {
            return (this.id - 1) % 5;
        }
    }
    @Override
    public void run() {
        try {
            pensar();
            System.out.println("");
            do {
                pegarGarfo();
                Thread.sleep(1000L);
                largarGarfo();
            } while (true);
        } catch (InterruptedException e) {
            System.out.println("Erro Run Filosofos: " + e.getMessage());
            return;
        }
    }

    public String getNome() {
        return nome;
    }
}
