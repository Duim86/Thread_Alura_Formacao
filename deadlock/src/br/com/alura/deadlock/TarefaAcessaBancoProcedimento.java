package br.com.alura.deadlock;

public class TarefaAcessaBancoProcedimento implements Runnable {
    private final PoolDeConexao pool;
    private final GerenciadorDeTransacao tx;

    public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }



    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("comecando a tx");
            tx.begin();

            synchronized (tx) {
                System.out.println("peguei a conexao");
                pool.getConnection();
            }
        }

    }
}
