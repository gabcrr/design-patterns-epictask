package br.com.joaocarloslima.epictask.model;

public class RecompensaFinanceiroFactory implements RecompensaFactory {
    @Override
    public Recompensa criarRecompensa() {
        return new RecompensaFinanceiro();
    }
}
