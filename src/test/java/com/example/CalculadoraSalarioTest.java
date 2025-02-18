package com.example;

import org.junit.jupiter.api.*;
import com.example.Funcionario;
import com.example.CalculadoraSalario;
import com.example.Cargo;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraSalarioTest {

    private final CalculadoraSalario calculadora = new CalculadoraSalario();

    @Test
    void deveCalcularSalarioParaDesenvolvedorComSalarioMaiorQue3000() {
        Funcionario desenvolvedor = new Funcionario("João", "joao@example.com", 5000, Cargo.DESENVOLVEDOR);
        double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
        assertEquals(4000, salarioLiquido, 0.01);
    }

    @Test
    void deveCalcularSalarioParaDesenvolvedorComSalarioMenorQue3000() {
        Funcionario desenvolvedor = new Funcionario("Maria", "maria@example.com", 2000, Cargo.DESENVOLVEDOR);
        double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
        assertEquals(1800, salarioLiquido, 0.01);
    }

    @Test
    void deveCalcularSalarioParaDBAComSalarioMaiorQue2000() {
        Funcionario dba = new Funcionario("Carlos", "carlos@example.com", 2500, Cargo.DBA);
        double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
        assertEquals(1875, salarioLiquido, 0.01);
    }

    @Test
    void deveCalcularSalarioParaDBAComSalarioMenorQue2000() {
        Funcionario dba = new Funcionario("Ana", "ana@example.com", 1500, Cargo.DBA);
        double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
        assertEquals(1275, salarioLiquido, 0.01);
    }

    @Test
    void deveCalcularSalarioParaGerenteComSalarioMaiorQue5000() {
        Funcionario gerente = new Funcionario("Marcos", "marcos@example.com", 6000, Cargo.GERENTE);
        double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
        assertEquals(4200, salarioLiquido, 0.01);
    }

    @Test
    void deveCalcularSalarioParaGerenteComSalarioMenorQue5000() {
        Funcionario gerente = new Funcionario("Clara", "clara@example.com", 4000, Cargo.GERENTE);
        double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
        assertEquals(3200, salarioLiquido, 0.01);
    }

    @Test
    void deveCalcularSalarioParaTestadorComSalarioMaiorQue2000() {
        Funcionario testador = new Funcionario("Luis", "luis@example.com", 2500, Cargo.TESTADOR);
        double salarioLiquido = calculadora.calcularSalarioLiquido(testador);
        assertEquals(1875, salarioLiquido, 0.01);
    }

    @Test
    void deveCalcularSalarioParaTestadorComSalarioMenorQue2000() {
        Funcionario testador = new Funcionario("Rosa", "rosa@example.com", 1500, Cargo.TESTADOR);
        double salarioLiquido = calculadora.calcularSalarioLiquido(testador);
        assertEquals(1275, salarioLiquido, 0.01);
    }
}
