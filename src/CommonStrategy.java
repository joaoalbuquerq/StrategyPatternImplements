public class CommonStrategy {
    public static void main(String[] args) {

        int formaPagamento = 1; // 1- Cartão de crédito, 2- Boleto, 3- Pix
        double valorTotalCompra = 100;

        var metodoPagamento = switch (formaPagamento){
            case 1 -> new CartaoCredito();
            case 2 -> new Boleto();
            case 3 -> new Pix();
            default -> throw new IllegalStateException("Forma de pagamento inválida");
        };

        var processadorPagamento = new ProcessadorPagamentos(metodoPagamento);
        processadorPagamento.pagar(valorTotalCompra);

    }
}

class ProcessadorPagamentos {
    private FormasPagamento formaPagamento;

    public ProcessadorPagamentos(FormasPagamento formaPagamento){
        this.formaPagamento = formaPagamento;
    }

    public void pagar(double valorPagamento){
        formaPagamento.pagar(valorPagamento);
    }
}

interface FormasPagamento{
    void pagar(double valor);
}

class CartaoCredito implements FormasPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Processando pagamento via Crédito");
        System.out.println("Pagamento de: " + valor + " Aprovado");
    }
}

class Boleto implements FormasPagamento{

    @Override
    public void pagar(double valor) {
        System.out.println("Processando pagamento via Boleto");
        System.out.println("Pagamento de: " + valor + " Aprovado");
    }
}

class Pix implements FormasPagamento{

    @Override
    public void pagar(double valor) {
        System.out.println("Processando pagamento via Pix");
        System.out.println("Pagamento de: " + valor + " Aprovado");
    }
}
