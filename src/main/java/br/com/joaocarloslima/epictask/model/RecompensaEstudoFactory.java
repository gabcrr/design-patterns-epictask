package br.com.joaocarloslima.epictask.model;

public class RecompensaEstudoFactory implements RecompensaFactory {
    @Override
    public Recompensa criarRecompensa() {
        return new RecompensaEstudo();
    }
}
