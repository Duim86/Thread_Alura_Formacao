package br.com.alura.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {
    private String nomeArquivo;
    private String nome;

    public TarefaBuscaTextual(String nomeArquivo, String nome) {
        this.nomeArquivo = nomeArquivo;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(nomeArquivo));

            int lineNumber = 1;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if(line.toLowerCase().contains(nome.toLowerCase())) {
                    System.out.println(nomeArquivo + " - " + lineNumber + " - " + line);
                }
                lineNumber++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
