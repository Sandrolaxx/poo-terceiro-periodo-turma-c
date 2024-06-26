package primeiro_bimestre.lista1;

import java.util.Scanner;

public class MainLista1{

    public static float calcularValorCliente(int qtd,float valor,Vendas armazemDeVendas[],int qtdVendas, float desconto){
        if (qtd>10){
            valor = valor * (int)qtd;
            desconto = valor * (float)0.05;
            valor = valor - desconto;
            System.out.println("O cliente recebeu um desconto de 5%");
            armazemDeVendas[qtdVendas] = new Vendas(qtd,valor,desconto);
            return desconto;
        }else{
            valor = valor * (int)qtd;
            armazemDeVendas[qtdVendas] = new Vendas(qtd,valor,desconto);
            return valor;
        }
    }

    public int returnQtdVendas(int qtd){
        return qtd;
    }

    public static float calcularTrocoCliente(float n1, float n2){
        return n1 - n2;
    }

    public static boolean testarCalendario(int diaMes,int condicao){
        boolean teste = ((diaMes<=0 || diaMes>condicao) ? true : false);
        return teste;
    }
    public static int getDia(Scanner read){
        boolean continuarGet = true;
        int diaCalendario = 0;

        while(continuarGet == true){
            System.out.println("Escolha o dia que você quer armazenar: ");
            diaCalendario = read.nextInt();
            continuarGet = testarCalendario(diaCalendario, 30);
        }
        return diaCalendario;
    }

    public static int getMes(Scanner read){
        boolean continuarGet = true;
        int mesCalendario = 0;

        while(continuarGet == true){
            System.out.println("Escolha o mês que você quer armazenar, utilize números para se referir ao mês. ");
            mesCalendario = read.nextInt();
            continuarGet = testarCalendario(mesCalendario, 12);
        }
        return mesCalendario;
    }
    public static int getQtd(Scanner read){
        System.out.println("Digite a quantidade que vendeu neste dia: ");
        int qtdCalendario = read.nextInt();
        return qtdCalendario;
    }
    
    public static void main(String[] args){

        int qtdVendas = 0;
        Vendas[] armazemDeVendas = new Vendas[50];
        int[][] calendarioVendas = new int[12][30];
        Scanner read = new Scanner(System.in);
        boolean continuar = true;

        while(continuar == true){
        
            System.out.println("Calculadora escolha a opcao desejada: ");
            System.out.println("1-Calcular preco de venda");
            System.out.println("2-Calcular troco");
            System.out.println("3-Histórico de vendas");
            System.out.println("4-Armazenar vendas");
            System.out.println("5-Verificar vendas");
            System.out.println("0-Sair");
            int escolha;
            escolha = read.nextInt();
            
            switch (escolha){
                case 1:
                    int qtd;
                    float valor;

                    System.out.println("Digite a quantidade de produtos: ");
                    qtd = read.nextInt();

                    System.out.println("Digite o valor do produto: ");
                    valor = read.nextFloat();

                    float resultado1 = calcularValorCliente(qtd,valor,armazemDeVendas,qtdVendas,0);
                    qtdVendas += 1;

                    System.out.println("O valor que terá que ser pago é: R$"+resultado1);
                    System.out.println("Voltando para o menu principal...");
                break;
                case 2:
                    float valorCompra;
                    float valorEntregue;
                    float resultado2;
                    
                    System.out.println("Digite o valor da compra do cliente: ");
                    valorCompra = read.nextFloat();
        
                    System.out.println("Digite o valor entregue pelo cliente: ");
                    valorEntregue = read.nextFloat();
        
                    resultado2 = calcularTrocoCliente(valorEntregue, valorCompra);
                    if(resultado2 < 0){
                        System.out.println("Valor insuficiente para a compra, falta R$"+Math.abs(resultado2)+" para efetuar a compra");
                    }else{
                        System.out.println("O valor do troco será: R$"+resultado2);
                        System.out.println("Voltando para o menu principal...");
                    }
                break;
                case 3:
                    System.out.println("PRINT DE OBJETOS");
                    for(int i=0;i<qtdVendas;i++){
                        System.out.println("VENDA "+(i+1));
                        System.out.println("QUANTIDADE: "+armazemDeVendas[i].getQtd());
                        System.out.println("VALOR: R$"+armazemDeVendas[i].getValor());
                        System.out.println("DESCONTO: R$"+armazemDeVendas[i].getDesconto());
                        System.out.println("============================");
                    }
                break;
                case 4:
                    calendarioVendas[getMes(read)-1][getDia(read)-1] = getQtd(read);
                    System.out.println("Armazenado com sucesso"); 
                break;
                case 5:
                    int mesCalendario = getMes(read);
                    int diaCalendario = getDia(read);
                    System.out.println("VENDAS DO MÊS "+mesCalendario+" DO DIA "+diaCalendario);
                    System.out.println("Quantidade de vendas: "+calendarioVendas[mesCalendario-1][diaCalendario-1]);
                break;
                case 0:
                    System.out.println("Saindo da aplicação");
                    continuar = false;   
                break;
                default:
                    System.out.println("Erro, número indisponível");
                break;
            }
        }
        read.close();
    }
}