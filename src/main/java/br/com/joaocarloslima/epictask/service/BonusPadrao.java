package br.com.joaocarloslima.epictask.service;

import br.com.joaocarloslima.epictask.model.TipoDesafio;

public class BonusPadrao implements BonusStrategy {
    @Override
    public int calcularBonus(int valorBase, TipoDesafio tipo) {
        return valorBase;
    }
}
