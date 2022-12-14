package br.com.alura.lista.lista;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable {
    private final List<String> lista;
    private final int numeroDoThread;

    public TarefaAdicionarElemento(List<String> lista, int numeroDoThread) {
        this.lista = lista;
        this.numeroDoThread = numeroDoThread;
    }

    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            lista.add("Thread: " + numeroDoThread + " - " + i);
        }
    }
}
