# 🎯 Implementações do Padrão Strategy no Java

Este repositório contém 4 implementações diferentes do padrão Strategy no Java, explorando desde abordagens mais básicas até versões modernas que aproveitam os novos recursos da linguagem. 🚀

---

## 🛠️ Implementações

### 1️⃣ **Sem Strategy (Abordagem Tradicional com IF/ELSE)**

💡 **Descrição:** Esta é a abordagem mais simples, onde utilizamos estruturas de controle como `if-else` para determinar a forma de pagamento. Apesar de funcional, não é escalável e pode se tornar difícil de manter.

```java
public class NoStrategy {
    public static void main(String[] args) {
        int formaPagamento = 1; // 1- Cartão de crédito, 2- Boleto, 3- Pix
        double valorTotalCompra = 100;

        if(formaPagamento == 1){
            System.out.println("Processando pagamento via Crédito");
            System.out.println("Pagamento de: " + valorTotalCompra + " Aprovado");
        } else if(formaPagamento == 2){
            System.out.println("Processando pagamento via Boleto");
            System.out.println("Pagamento de: " + valorTotalCompra + " Aprovado");
        } else if(formaPagamento == 3){
            System.out.println("Processando pagamento via Pix");
            System.out.println("Pagamento de: " + valorTotalCompra + " Aprovado");
        } else {
            throw new IllegalStateException("Forma de pagamento inválida");
        }
    }
}
```

---

### 2️⃣ **Com Strategy (Abordagem Clássica)**

💡 **Descrição:** Aplicamos o padrão Strategy na sua forma tradicional, usando interfaces para abstrair diferentes estratégias de pagamento. Uma implementação clara e escalável! ✨

```java
interface FormasPagamento {
    void pagar(double valor);
}

class CartaoCredito implements FormasPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Processando pagamento via Crédito");
        System.out.println("Pagamento de: " + valor + " Aprovado");
    }
}

// Outras classes seguem o mesmo padrão...
```

---

### 3️⃣ **Com Strategy Usando Recursos Modernos do Java**

💡 **Descrição:** Utilizamos `enum` e `Consumer` para tornar o código mais limpo e moderno. Uma abordagem poderosa e elegante para versões mais recentes do Java. 🌟

```java
enum TipoPagamento {
    CARTAO_CREDITO(MetodosPagamento::cartaoCredito),
    PIX(MetodosPagamento::pix),
    BOLETO(MetodosPagamento::boleto);

    private Consumer<Double> estrategiaPagamento;

    TipoPagamento(Consumer<Double> estrategia) {
        this.estrategiaPagamento = estrategia;
    }

    public void pagar(double valor) {
        estrategiaPagamento.accept(valor);
    }
}
```

---

### 4️⃣ **Com Strategy para Java 8+**

💡 **Descrição:** Para ambientes que utilizam Java 8, implementamos o padrão Strategy com uma solução que evita `if-else` e ainda mantém o código escalável. 🕶️

```java
enum MetodosDePagamento {
    CARTAO_CREDITO(1, CartaoDeCredito.class),
    BOLETO(2, BoletoAvista.class),
    PIX(3, PixAvista.class);

    private int codigo;
    private Class<? extends FormasDePagamento> formaPagamento;

    MetodosDePagamento(int codigo, Class<? extends FormasDePagamento> forma) {
        this.codigo = codigo;
        this.formaPagamento = forma;
    }

    public static FormasDePagamento obterFormaPagamento(int codigo) {
        for (MetodosDePagamento met : values()) {
            if (met.codigo == codigo) {
                try {
                    return met.formaPagamento.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new IllegalStateException("Forma de pagamento inválida!");
                }
            }
        }
        throw new IllegalStateException("Forma de pagamento não encontrada!");
    }
}
```

---

## 📂 Estrutura do Projeto

O projeto está dividido em:

- **src/main/java:** Contém as implementações principais.
- **src/test/java:** Testes para validar cada implementação.

---

## 🛡️ Licença

Este projeto está licenciado sob a MIT License. Sinta-se à vontade para usá-lo e adaptá-lo. 💻

---

### ⭐ Dê uma estrela no repositório!
Se você gostou deste projeto, não se esqueça de dar uma ⭐ no repositório e compartilhar com a sua rede! 😊
