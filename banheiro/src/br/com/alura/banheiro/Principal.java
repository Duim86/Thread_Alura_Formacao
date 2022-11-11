package br.com.alura.banheiro;

public class Principal {

    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();

        new Thread(new TarefaNumero1(banheiro), "João").start();
        new Thread(new TarefaNumero2(banheiro), "Pedro").start();
        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
        limpeza.setDaemon(true);
//        new Thread(new TarefaNumero1(banheiro), "Maria").start();
//        new Thread(new TarefaNumero2(banheiro), "Ana").start();


        limpeza.start();
    }
}
