package primeirob;
// A calculadora deve ser capaz de realizar as seguintes operações:

// 1. Cálculo de Preço Total:
//     Dona Gabrielinha deseja calcular o preço total da venda de um item, considerando a quantidade de uma planta vendida vezes seu preço unitário.
   
//     Entrada: Receber dois valores, primeiro a quantidade da referida planta, segundo a valor o preço da mesma.
//     Saída: Retornar o resultado do cálculo.
   
// 2. Cálculo de Troco:
//     A calculadora deve calcular o troco a ser dado ao cliente, considerando o valor pago.
   
//     Entrada: Receber dois valores, primeiro o valor recebido pelo cliente, segundo o valor total da compra.
//     Saída: Retornar o resultado do cálculo.

// 3. Criar Menu Console:
//     [1] - Calcular Preço Total
//     [2] - Calcular Troco    
//     [3] - Sair    

// INFORMAÇÕES IMPORTANTES!
// A ENTREGA CONSISTE NO LINK DO PULL REQUEST DO SEU GIT.
// APÓS ADICIONADO O LINK, MARCAR ATIVIDADE COMO ENTREGUE!
// ENTREGAS EM ATRASO SERÁ DESCONTADO METADE DA NOTA!!
// APÓS UMA SEMANA DA DATA INICIAL DA ATIVIDADE, NÃO SERÁ MAIS POSSÍVEL REALIZAR ENTREGA.
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import javax.swing.JOptionPane;

public class JavaAtividade{
    /**
     * @param args
     */
    public static void main(String[] args) {
        double menu = 0.0; // Use double para operações com valores monetários
        String menuDigitar;
        ArrayList<String> arrayList = new ArrayList<>();
        int tamanho;
        double quantidadeTotalFinal = 0.0;
        double vendaTotalFinal = 0.0;
        double descontosTotalFinal = 0.0;
        double[][] ano = new double[11][30];
        double[] mes = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        for (int i = 0; i < 11; i++) {
            ano[i] = mes.clone(); 
        }
        

        while (menu != 5) { // Condição corrigida para continuar o loop até que o usuário escolha a opção 3 (Sair)
            menuDigitar = JOptionPane.showInputDialog("---MENU--\n[1] - CALCULAR PRECO TOTAL\n[2] - CALCULAR TROCO\n" + //
                                "[3] - CADASTRAR VENDA\n[4] - CONSULTAR DIA DE VENDAS \n[5] - SAIR");
            menu = Double.parseDouble(menuDigitar);


            if (menu == 1) {
                String verify = "nao";
                // numero da lista
                tamanho = arrayList.size();
                String tamanhoString = String.valueOf(tamanho);

                // preco do produto
                String valorTotal = JOptionPane.showInputDialog("Insira o preco do produto: ");
                double valor = Double.parseDouble(valorTotal);
                // quantidade do produto
                String quantidadeTotal = JOptionPane.showInputDialog("Insira a quantidade: ");
                double quantidade = Double.parseDouble(quantidadeTotal);
                quantidadeTotalFinal = quantidadeTotalFinal + quantidade;
                // conta
                double total = valor * quantidade;

                // verificador de desconto
                if (quantidade >= 10){
                    descontosTotalFinal =  descontosTotalFinal + (0.05*total);
                    total = total * 0.95;
                    
                    verify = "sim";
                }
                vendaTotalFinal = vendaTotalFinal + total;
                String preco_final = String.valueOf(total);


                JOptionPane.showMessageDialog(null, "O preço total é: " + total);
                String vendaString = "\nVenda número: "+ tamanhoString + "\nQuantidade: "+ quantidadeTotal+ "\nValor aplicado: R$"+ valorTotal + "\nDesconto aplicado: "+ verify+"\nPreco final: "+ preco_final +"\n-------------\n";
                arrayList.add(vendaString);
                JOptionPane.showMessageDialog(null, "Venda registrada");
                JOptionPane.showMessageDialog(null, arrayList);
                JOptionPane.showMessageDialog(null, "Vendas totais: R$"+ vendaTotalFinal);
                JOptionPane.showMessageDialog(null, "Quantidade de flores vendidas: "+ quantidadeTotalFinal);
                JOptionPane.showMessageDialog(null, "Desconto dados: R$"+ descontosTotalFinal );
                
            } else if (menu == 2) {
                String troco_total = JOptionPane.showInputDialog("Insira o valor da compra: ");
                double troco_ = Double.parseDouble(troco_total);

                String pagamento_total = JOptionPane.showInputDialog("Insira o valor do pagamento ");
                double pagamento = Double.parseDouble(pagamento_total);

                double troco = pagamento - troco_;
                if (troco < 0 ){
                    while(troco<0){
                        pagamento_total = JOptionPane.showInputDialog("Insira um valor pagável: ");
                        pagamento = Double.parseDouble(pagamento_total);
                        troco = pagamento - troco_;
                    }
                }

                JOptionPane.showMessageDialog(null, "O troco é: " + troco);
            } else if (menu == 3) {
                
                String valorCompra = JOptionPane.showInputDialog("INSIRA O VALOR DA COMPRA: ");
                double valorCompraDouble = Double.parseDouble(valorCompra);

                String mesCompra = JOptionPane.showInputDialog("INSIRA O MES DA COMPRA: ");
                int mesUser = Integer.parseInt(mesCompra);

                String diaCompra = JOptionPane.showInputDialog("INSIRA O DIA DA COMPRA: ");
                int diaUser =  Integer.parseInt(diaCompra);



                for (int i = 0; i < 11; i++) {
                    for (int j = 0; j < 30; j++) {
                        if (i == mesUser-1 && j == diaUser-1) {
                            ano[i][j] += valorCompraDouble; // Modifica o valor do dia desejado
                        }
                    }
                }
                StringBuilder calendario = new StringBuilder();
                for (double[] semana : ano) {
                    calendario.append("MES:");
                    for (double diaAtual : semana) {
                        if (diaAtual == 0.0){
                            String diaDisplay = "   ";
                            calendario.append(diaDisplay).append(" | ");
                        } else {
                            calendario.append(diaAtual).append(" | ");
                        }
                    }
                    calendario.append("\n");
                }

                JOptionPane.showMessageDialog(null, calendario.toString(), "Registro", JOptionPane.PLAIN_MESSAGE);
            }else if (menu == 4) {
                String mesCompra = JOptionPane.showInputDialog("Insira o mês da consulta: ");
                int mesUser = Integer.parseInt(mesCompra);

                String diaCompra = JOptionPane.showInputDialog("Insira o dia da consulta: ");
                int diaUser = Integer.parseInt(diaCompra);

                if (mesUser >= 1 && mesUser <= 12 && diaUser >= 1 && diaUser <= 30) {
                    double vendasDia = ano[mesUser - 1][diaUser - 1];
                    JOptionPane.showMessageDialog(null, "Vendas do dia " + diaUser + " do mês " + mesUser + ": R$" + vendasDia, "Consulta de Vendas", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data inválida! Por favor, insira um mês de 1 a 12 e um dia de 1 a 30.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            
        }
    }
}
