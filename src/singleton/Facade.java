package singleton;

import pojo.Roupa;

public class Facade {

    public static double total = 0;
    private CarrinhoDeRoupas carrinho;
    private Financeiro biblioteca;

    public Facade() {
        carrinho = CarrinhoDeRoupas.getInstance();
        biblioteca = new Financeiro();
    }

    public void cadastrarNovaRoupa(Roupa roupa) {
        carrinho.addRoupas(roupa);

    }

    public void consultarRoupa(String pesq) {
        carrinho.consultarRoupa(pesq);
    }

    public String cobrar() {
        biblioteca.listaRoupas = carrinho.getListRoupas();
        return biblioteca.precoTotal();
    }

    public void pagamento(Double valorPago) {
        biblioteca.realizarPagamento(valorPago);
    }

    public void removerRoupa(int id) {
        carrinho.removeRoupa(id);
    }

    public void limparCarrinho(String resp) {
        carrinho.limparCarrinho(resp);
    }

}
