package br.com.joaocarloslima.epictask.service;

import br.com.joaocarloslima.epictask.model.TipoDesafio;

public interface BonusStrategy {
    int calcularBonus(int valorBase, TipoDesafio tipo);
}
