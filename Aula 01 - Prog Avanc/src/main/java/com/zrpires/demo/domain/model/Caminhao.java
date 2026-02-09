package com.zrpires.demo.domain.model;

import jakarta.persistence.Entity;

@Entity
public class Caminhao extends Veiculo {

    private double capacidadeCarga;
    private int quantidadeEixos;
    private double cargaTransportadaAcumulada;

    public void registrarCarga(double toneladas) {
        this.cargaTransportadaAcumulada += toneladas;
    }

    @Override
    public boolean precisaRevisao() {
        return getQuilometragemAtual() % 10000 == 0 ||
                cargaTransportadaAcumulada >= 500;
    }

    @Override
    public double calcularSeguroAnual() {
        return (getValorVeiculo() * 0.02) + (50 * capacidadeCarga);
    }

    public double getCapacidadeCarga() { return capacidadeCarga; }
    public int getQuantidadeEixos() { return quantidadeEixos; }

    public void setCapacidadeCarga(double capacidadeCarga) { this.capacidadeCarga = capacidadeCarga; }
    public void setQuantidadeEixos(int quantidadeEixos) { this.quantidadeEixos = quantidadeEixos; }
}