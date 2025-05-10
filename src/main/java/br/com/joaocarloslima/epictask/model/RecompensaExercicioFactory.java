package br.com.joaocarloslima.epictask.model;

public class RecompensaExercicioFactory implements RecompensaFactory {
    @Override
    public Recompensa criarRecompensa() {
        return new RecompensaExercicio();
    }
}
