package br.com.joaocarloslima.epictask.model;

public class RecompensaMeditacaoFactory implements RecompensaFactory {
    @Override
    public Recompensa criarRecompensa() {
        return new RecompensaMeditacao();
    }
}
