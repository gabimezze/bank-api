package com.bank.api.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Account {
     private Long id;

    @NotBlank
    private String nomeTitular;

    @NotBlank
    private String cpfTitular;

    @PastOrPresent
    private LocalDate dataAbertura;

    @Min(0)
    private double saldo;

    private boolean ativa;

    @Pattern(regexp = "(corrente|poupanca|salario)")
    private String tipo;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeTitular() { return nomeTitular; }
    public void setNomeTitular(String nomeTitular) { this.nomeTitular = nomeTitular; }

    public String getCpfTitular() { return cpfTitular; }
    public void setCpfTitular(String cpfTitular) { this.cpfTitular = cpfTitular; }

    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

}
