package singleton;

import java.util.ArrayList;
import pojo.Roupa;

public class Financeiro {

    public static ArrayList<Roupa> listaRoupas = new ArrayList<Roupa>();

    public String precoTotal() {

        double total = Facade.total = 0.0;

        for (int i = 0; i < listaRoupas.size(); i++) {
            total += listaRoupas.get(i).getPreco();

        }
        if (listaRoupas.isEmpty()) {
            return "\nNenhuma Roupa para Pagar!";
        }
        return "Valor a ser pago pelo cliente: R$" + String.format("%.2f", total);
    }

    public void realizarPagamento(double valorPago) {

        if (valorPago <= 0.0) {
            System.out.println("\nValor Inválido!");

        } else if (valorPago >= Facade.total) {

            for (int i = 0; i < listaRoupas.size(); i++) {
                Facade.total += listaRoupas.get(i).getPreco();
            }
            if (Facade.total == 0) {
                System.out.println("\nExecutar cobrança primeiro.");

            } else if (Facade.total == valorPago) {
                System.out.println("\nPagamento Efetuado com Sucesso.");
                listaRoupas.removeAll(listaRoupas);
                Facade.total = 0.0;
            } else if (Facade.total <= valorPago) {
                Double somaTotal = valorPago - Facade.total;
                System.out.println("Troco: R$" + String.format("%.2f", somaTotal) + "\nPagamento Efetuado com Sucesso.");
                listaRoupas.removeAll(listaRoupas);
                Facade.total = 0.0;

            }

        }
        if (valorPago < Facade.total) {
            System.out.println("O Valor Pago está Incorreto. O Valor total é R$:" + Facade.total
                    + " e o Valor Pago é R$:" + valorPago);

        }
    }
}
