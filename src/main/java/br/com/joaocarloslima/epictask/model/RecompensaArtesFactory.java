package br.com.joaocarloslima.epictask.model;

public class RecompensaArtesFactory implements RecompensaFactory {
    @Override
    public Recompensa criarRecompensa() {
        return new RecompensaArtes();
    }
}
