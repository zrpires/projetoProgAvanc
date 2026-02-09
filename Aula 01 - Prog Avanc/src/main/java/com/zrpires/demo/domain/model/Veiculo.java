package com.zrpires.demo.domain.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String placa;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false, updatable = false)
    private int anoFabricacao;

    @Column(nullable = false)
    private double quilometragemAtual;

    @Column(nullable = false)
    private double valorVeiculo;

    public void registrarRota(double kmRodados) {
        if (kmRodados <= 0) {
            throw new IllegalArgumentException("Quilometragem inválida");
        }
        this.quilometragemAtual += kmRodados;
    }

    public abstract boolean precisaRevisao();
    public abstract double calcularSeguroAnual();

    public Long getId() { return id; }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public int getAnoFabricacao() { return anoFabricacao; }
    public double getQuilometragemAtual() { return quilometragemAtual; }
    public double getValorVeiculo() { return valorVeiculo; }

    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setValorVeiculo(double valorVeiculo) { this.valorVeiculo = valorVeiculo; }
}