package com.example;

import com.example.Cargo;
import com.example.Funcionario;

public class CalculadoraSalario {

    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        double desconto = calcularDesconto(funcionario.getCargo(), salarioBase);
        return salarioBase - desconto;
    }

    private double calcularDesconto(Cargo cargo, double salarioBase) {
        switch (cargo) {
            case DESENVOLVEDOR:
                return salarioBase >= 3000 ? salarioBase * 0.20 : salarioBase * 0.10;
            case DBA:
            case TESTADOR:
                return salarioBase >= 2000 ? salarioBase * 0.25 : salarioBase * 0.15;
            case GERENTE:
                return salarioBase >= 5000 ? salarioBase * 0.30 : salarioBase * 0.20;
            default:
                throw new IllegalArgumentException("Cargo não reconhecido");
        }
    }
}
