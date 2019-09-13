package br.com.ufms.so.jantardosfilosofos;

public class Mesa {

    public static void main(String[] args) {
        inicializarMesa();

    }

    public static void inicializarMesa(){
        Garfo kitGarfos1 = new Garfo(5, 1);
        Garfo kitGarfos2 = new Garfo(1, 2);
        Garfo kitGarfos3 = new Garfo(2, 3);
        Garfo kitGarfos4 = new Garfo(3, 4);
        Garfo kitGarfos5 = new Garfo(4, 5);

        Filosofo pensadorContemporaneo1 = new Filosofo("Valesca Poposuda", kitGarfos1);
        Filosofo pensadorContemporaneo2 = new Filosofo("Falcão", kitGarfos2);
        Filosofo pensadorContemporaneo3 = new Filosofo(" Otávio Bundasseca", kitGarfos3);
        Filosofo pensadorContemporaneo4 = new Filosofo(" Aberta Demais De Oliveira.", kitGarfos4);
        Filosofo pensadorContemporaneo5 = new Filosofo(" Jean Claude Van Dame Da Silva", kitGarfos5);

        new Thread(pensadorContemporaneo1).start();
        new Thread(pensadorContemporaneo2).start();
        new Thread(pensadorContemporaneo3).start();
        new Thread(pensadorContemporaneo4).start();
        new Thread(pensadorContemporaneo5).start();
    }
}
