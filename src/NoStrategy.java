public class NoStrategy {
    public static void main(String[] args) {

        int formaPagamento = 1; // 1- Cartão de crédito, 2- Boleto, 3- Pix
        double valorTotalCompra = 100;

        if(formaPagamento == 1){
            System.out.println("Processando pagamento via Crédito");
            System.out.println("Pagamento de: " + valorTotalCompra + " Aprovado");
        }else if(formaPagamento == 2){
            System.out.println("Processando pagamento via Boleto");
            System.out.println("Pagamento de: " + valorTotalCompra + " Aprovado");
        }else if(formaPagamento == 3){
            System.out.println("Processando pagamento via Pix");
            System.out.println("Pagamento de: " + valorTotalCompra + " Aprovado");
        }else{
            throw new IllegalStateException("Forma de pagamento inválida");
        }
    }
}
