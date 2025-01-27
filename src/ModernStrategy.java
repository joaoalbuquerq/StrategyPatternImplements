import java.util.function.Consumer;

public class ModernStrategy {

    public static void main(String[] args) {

        String formaPagamentoSelecionada = "PIX";
        double valorCompra = 100;
        TipoPagamento.valueOf(formaPagamentoSelecionada).pagar(valorCompra);
    }

}

class MetodosPagamento{
    public static void cartaoCredito(double valor){
        System.out.println("Processando pagamento via Crédito");
        System.out.println("Pagamento de: " + valor + " Aprovado");
    }

    public static void boleto(double valor){
        System.out.println("Processando pagamento via Boleto");
        System.out.println("Pagamento de: " + valor + " Aprovado");
    }

    public static void pix(double valor){
        System.out.println("Processando pagamento via Pix");
        System.out.println("Pagamento de: " + valor + " Aprovado");
    }
}


enum TipoPagamento {
    CARTAO_CREDITO(MetodosPagamento::cartaoCredito),
    PIX(MetodosPagamento::pix),
    BOLETO(MetodosPagamento::boleto);

    private Consumer<Double> estrategiaPagamento;

    TipoPagamento(Consumer<Double> estrategia){
        this.estrategiaPagamento = estrategia;
    }

    public void pagar(double valor){
        estrategiaPagamento.accept(valor);
    }
}