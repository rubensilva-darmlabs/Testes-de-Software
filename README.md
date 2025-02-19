# 📌 Atividade TDD (1)

## 📖 Introdução

Este projeto implementa uma calculadora de salário líquido para diferentes cargos utilizando **Test-Driven Development (TDD)**. O desenvolvimento seguiu o ciclo **Red-Green-Refactor**, garantindo que cada funcionalidade fosse implementada de forma testável e confiável.

---

## 📌 Ciclos do TDD

Cada ciclo de desenvolvimento consistiu em três passos:

1. **Red** – Criamos um teste que falha, pois a funcionalidade ainda não foi implementada.
2. **Green** – Implementamos a funcionalidade mínima necessária para que o teste passe.
3. **Refactor** – Melhoramos o código, mantendo os testes passando.

A seguir, detalhamos cada ciclo do processo.

---

## 🔄 **Teste 1: salario maior que 3000**

### ✅ **Teste adicionado**
```java
@Test
void deveCalcularSalarioParaDesenvolvedorComSalarioMaiorQue3000() {
    Funcionario desenvolvedor = new Funcionario("João", "joao@example.com", 5000, Cargo.DESENVOLVEDOR);
    double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
    assertEquals(4000, salarioLiquido, 0.01);
}
```

### 🔴 **Código antes**
O método `calcularSalarioLiquido` ainda não existia.

### 🟢 **Código depois**
Criamos a classe `CalculadoraSalario` com a lógica inicial:

```java
public double calcularSalarioLiquido(Funcionario funcionario) {
    double salarioBase = funcionario.getSalarioBase();
    double desconto = calcularDesconto(funcionario.getCargo(), salarioBase);
    return salarioBase - desconto;
}

private double calcularDesconto(Cargo cargo, double salarioBase) {
    if (cargo == Cargo.DESENVOLVEDOR) {
        return salarioBase >= 3000 ? salarioBase * 0.20 : salarioBase * 0.10;
    }
    return 0;
}
```

### 📌 **Descrição**
Criamos a estrutura inicial da `CalculadoraSalario`, adicionando a lógica de desconto para devs.

---

## 🔄 **Teste 2: Dev com salário menor a 3000**

### ✅ **Teste adicionado**
```java
@Test
void deveCalcularSalarioParaDesenvolvedorComSalarioMenorQue3000() {
    Funcionario desenvolvedor = new Funcionario("Maria", "maria@example.com", 2000, Cargo.DESENVOLVEDOR);
    double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
    assertEquals(1800, salarioLiquido, 0.01);
}
```

### 🔴 **Código antes**
O código já possuía a lógica de cálculo de desconto para desenvolvedores.

### 🟢 **Código depois**
Nenhuma alteração necessária.

---

## 🔄 **Teste 3: DBA com salário maior a 2000**

### ✅ **Teste adicionado**
```java
@Test
void deveCalcularSalarioParaDBAComSalarioMaiorQue2000() {
    Funcionario dba = new Funcionario("Carlos", "carlos@example.com", 2500, Cargo.DBA);
    double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
    assertEquals(1875, salarioLiquido, 0.01);
}
```

### 🔴 **Código antes**
O cálculo de salário só considerava os devs.

### 🟢 **Código depois**
Foi adicionada a lógica para colocar o salario dos DBA:

```java
case DBA:
    return salarioBase >= 2000 ? salarioBase * 0.25 : salarioBase * 0.15;
```


---

## 🔄 **Teste 4: DBA com salário menor a 2000**

### ✅ **Teste adicionado**
```java
@Test
void deveCalcularSalarioParaDBAComSalarioMenorQue2000() {
    Funcionario dba = new Funcionario("Ana", "ana@example.com", 1500, Cargo.DBA);
    double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
    assertEquals(1275, salarioLiquido, 0.01);
}
```

### 🔴 **Código antes**
O código já incluía a lógica correta.

---

## 🔄 **Teste 5: Gerente com salário maior que 5000**

### ✅ **Teste adicionado**
```java
@Test
void deveCalcularSalarioParaGerenteComSalarioMaiorQue5000() {
    Funcionario gerente = new Funcionario("Marcos", "marcos@example.com", 6000, Cargo.GERENTE);
    double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
    assertEquals(4200, salarioLiquido, 0.01);
}
```

### 🔴 **Código antes**
Não havia lógica para os gerentes.

### 🟢 **Código depois**
Adicionamos:

```java
case GERENTE:
    return salarioBase >= 5000 ? salarioBase * 0.30 : salarioBase * 0.20;
```

### 📌 **Descrição**
Incluímos a regra para os gerentes.

---

## 🔄 **Ciclo 6: Testador com salário maior que 2000**

### ✅ **Teste adicionado**
```java
@Test
void deveCalcularSalarioParaTestadorComSalarioMaiorQue2000() {
    Funcionario testador = new Funcionario("Luis", "luis@example.com", 2500, Cargo.TESTADOR);
    double salarioLiquido = calculadora.calcularSalarioLiquido(testador);
    assertEquals(1875, salarioLiquido, 0.01);
}
```

### 🔴 **Código antes**
Não havia lógica para testadores.

### 🟢 **Código depois**
Foi adicionada a regra:

```java
case TESTADOR:
    return salarioBase >= 2000 ? salarioBase * 0.25 : salarioBase * 0.15;
```

### 📌 **Descrição**
Testadores seguem a mesma regra dos DBAs.

---

## 📌 **Código Final**

### 🔹 **Classe `Funcionario`**
```java
public class Funcionario {
    private String nome;
    private String email;
    private double salarioBase;
    private Cargo cargo;

    public Funcionario(String nome, String email, double salarioBase, Cargo cargo) {
        this.nome = nome;
        this.email = email;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    public double getSalarioBase() { return salarioBase; }
    public Cargo getCargo() { return cargo; }
}
```

### 🔹 **Classe `Cargo`**
```java
public enum Cargo {
    DESENVOLVEDOR, DBA, TESTADOR, GERENTE
}
```

### 🔹 **Classe `CalculadoraSalario`**
```java
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
```

---

## 🎯 **Conclusão**
Eu tive certas dificuldades, pois ficava as vezes desenvolvendo e não realizando os testes em primeiro lugar.
```
