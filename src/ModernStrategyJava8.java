public class ModernStrategyJava8 {
    public static void main(String[] args) {
        int formaPagamento = 1;  //1- Cartao de Crédito, 2- Boleto, 3- Pix;
        double valorCompra = 100;

        MetodosDePagamento.obterFormaPagamento(formaPagamento).pagar(valorCompra);
    }
}

enum MetodosDePagamento {
    CARTAO_CREDITO(1, CartaoDeCredito.class),
    BOLETO(2, BoletoAvista.class),
    PIX(3, PixAvista.class);

    private int codigo;
    private Class<? extends FormasDePagamento> formaPagamento;

    MetodosDePagamento(int codigo, Class<? extends FormasDePagamento> forma){
        this.codigo = codigo;
        this.formaPagamento = forma;
    }

    public static FormasDePagamento obterFormaPagamento(int codigo){
        for(MetodosDePagamento met : values()){
            if(met.codigo == codigo){
                try{
                    return met.formaPagamento.getDeclaredConstructor().newInstance();
                }catch (Exception e){
                    throw new IllegalStateException("Forma de pagamento inválida!");
                }
            }
        }
        throw new IllegalStateException("");
    }
}

interface FormasDePagamento{
    void pagar(double valor);
}

class CartaoDeCredito implements FormasDePagamento{

    @Override
    public void pagar(double valor) {

    }
}

class BoletoAvista implements FormasDePagamento{

    @Override
    public void pagar(double valor) {

    }
}

class PixAvista implements FormasDePagamento{

    @Override
    public void pagar(double valor) {

    }
}
