package br.com.ufms.so.jantardosfilosofos;

public enum Acao {
    PENDANDO(0), FAMINTO(1), COMENDO(2);

    private int valor;

     Acao(int valor){
        this.valor = valor;
    }

    public int getValor(){
         return this.valor;
    }
}
