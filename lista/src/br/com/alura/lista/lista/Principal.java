package br.com.alura.lista.lista;

import java.util.Vector;

public class Principal {
    public static void main(String[] args) throws InterruptedException {


        Vector<String> lista = new Vector<>();

        for(int i=0; i<10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }
        Thread.sleep(2000);

        for(int i=0; i<lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
    }
}
