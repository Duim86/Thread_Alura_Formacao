package br.com.alura.banheiro;

public class Banheiro {

    private boolean ehSujo = true;
    public void fazNumero1() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            esperaLaFora(nome);

            System.out.println(nome + " fazendo coisa rápida");

            dormeUmPouco(5000);

            this.ehSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");

        }
    }


    public void fazNumero2() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " batendo na porta");

        synchronized (this) {

            System.out.println(nome + " entrando no banheiro");

            esperaLaFora(nome);

            System.out.println(nome + " fazendo coisa demorada");

            dormeUmPouco(10000);
            this.ehSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");

        }
    }

    public void limpa() {
        String nome = Thread.currentThread().getName();

        if(!ehSujo) {
            System.out.println(nome + ", não está sujo, vou sair");
            return;
        }

        System.out.println(nome + " batendo na porta");
        synchronized (this) {

            System.out.println(nome + " entrando no banheiro");
            System.out.println(nome + " limpando o banheiro");
            this.ehSujo = false;

            dormeUmPouco(13000);

            this.notifyAll();
            System.out.println(nome + " saindo do banheiro");
        }
    }

    private void esperaLaFora(String nome) {
        while (ehSujo) {
            System.out.println(nome + " , eca, banheiro tá sujo");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void dormeUmPouco(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
