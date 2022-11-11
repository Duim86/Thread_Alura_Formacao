package br.com.alura.threads;

public class ImprimeNumeros implements Runnable{


    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("Imprimindo na thread " + Thread.currentThread() + " o número " + i);
        }
    }
}
