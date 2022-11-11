package br.com.alura.threads;

public class Principal {
    public static void main(String[] args) {

                new Thread(new ImprimeNumeros()).start();

                new Thread(new ImprimeNumeros()).start();
    }
}
