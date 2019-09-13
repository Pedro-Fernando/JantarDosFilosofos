package br.com.ufms.so.jantardosfilosofos;

public class Filosofo extends Thread {

    private int id;
    private String nome;
    private Acao acao;
    private Garfo garfo;

    public Filosofo(String nome, Garfo garfo) {
        this.nome = nome;
        this.garfo = garfo;

        System.out.printf("Filosofo %s sertou a mesa.\n", this.nome);
    }

    public void pensar() throws InterruptedException {
        System.out.printf("O Filosofo %s está pensando...\n", this.nome);
        Thread.sleep(1000L);
    }

    @Override
    public void run() {
        while (true) {
            if (this.garfo.getGarfoDireita() == 5) {
                System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoDireita());

                if (this.garfo.getGarfoEsquerda() == 4) {

                    try {
                        System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        comer();
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.printf("O Filosofo %s largou o garfo [%d]\n", this.nome, this.garfo.getGarfoDireita());
                }
            } else {
                try {
                    pensar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            if (this.garfo.getGarfoDireita() == 1) {
                System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoDireita());

                if (this.garfo.getGarfoEsquerda() == 5) {

                    try {
                        System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        comer();
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.printf("O Filosofo %s largou o garfo [%d]\n", this.nome, this.garfo.getGarfoDireita());
                }
            } else {
                try {
                    pensar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            if (this.garfo.getGarfoDireita() == 2) {
                System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoDireita());

                if (this.garfo.getGarfoEsquerda() == 1) {

                    try {
                        System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        comer();
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.printf("O Filosofo %s largou o garfo [%d]\n", this.nome, this.garfo.getGarfoDireita());
                }
            } else {
                try {
                    pensar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (this.garfo.getGarfoDireita() == 3) {
                System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoDireita());

                if (this.garfo.getGarfoEsquerda() == 2) {

                    try {
                        System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        comer();
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.printf("O Filosofo %s largou o garfo [%d]\n", this.nome, this.garfo.getGarfoDireita());
                }
            } else {
                try {
                    pensar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            if (this.garfo.getGarfoDireita() == 4) {
                System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoDireita());

                if (this.garfo.getGarfoEsquerda() == 3) {

                    try {
                        System.out.printf("O Filosofo %s pegou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        comer();
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                        System.out.printf("O Filosofo %s largou o garfo [%d].\n", this.nome, this.garfo.getGarfoEsquerda());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.printf("O Filosofo %s largou o garfo [%d]\n", this.nome, this.garfo.getGarfoDireita());
                }
            } else {
                try {
                    pensar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void comer() throws InterruptedException {
        System.out.printf("O Filosofo %s está comendo.\n", this.nome);
        Thread.sleep(1000L);
    }
}
