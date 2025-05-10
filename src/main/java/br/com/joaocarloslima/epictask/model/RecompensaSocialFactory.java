package br.com.joaocarloslima.epictask.model;

public class RecompensaSocialFactory implements RecompensaFactory {
    @Override
    public Recompensa criarRecompensa() {
        return new RecompensaSocial();
    }
}
