package com.zrpires.demo.domain.model;

import jakarta.persistence.Entity;

@Entity
public class Moto extends Veiculo {

    private int cilindrada;

    @Override
    public boolean precisaRevisao() {
        return getQuilometragemAtual() % 3000 == 0;
    }

    @Override
    public double calcularSeguroAnual() {
        return getValorVeiculo() * 0.05;
    }

    public int getCilindrada() { return cilindrada; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }
}