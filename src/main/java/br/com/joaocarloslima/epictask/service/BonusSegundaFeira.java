package br.com.joaocarloslima.epictask.service;

import br.com.joaocarloslima.epictask.model.TipoDesafio;

public class BonusSegundaFeira implements BonusStrategy {
    @Override
    public int calcularBonus(int valorBase, TipoDesafio tipo) {
        return (int) (valorBase * 1.5);
    }
}
