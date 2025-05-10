package br.com.joaocarloslima.epictask.service;

import br.com.joaocarloslima.epictask.model.TipoDesafio;

public class BonusSaudavel implements BonusStrategy {
    @Override
    public int calcularBonus(int valorBase, TipoDesafio tipo) {
        if (tipo == TipoDesafio.EXERCICIO || tipo == TipoDesafio.MEDITACAO) {
            return valorBase + 10;
        }
        return valorBase;
    }
}
