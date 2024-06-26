package lista_03.classes.main_menu;

import java.util.Scanner;

import lista_03.classes.calculadora.Calculadora;
import lista_03.classes.limpar_console.LimparConsole;
import lista_03.classes.menu_meses.MenuMeses;
import lista_03.classes.produto.Produto;

public class MainMenu {

  public int user_action;

  public int mes_index;
  public int index_do_dia;
  public int index_do_produto;
  public Produto produtos_vendidos[][][] = new Produto[12][31][50];
  public boolean meses_com_vendas[] = new boolean[12];
  public boolean dias_com_venda[][] = new boolean[12][31];
  Scanner ler_dados = new Scanner(System.in);

  public void iniciarMenu() {
    do {
      System.out.println("--- Escolha uma opção --- ");
      System.out.println("1 - Registrar vendas");
      System.out.println("2 - Ver registros de venda de todos os meses");
      System.out.println("3 - Ver registros de um mes específico");
      System.out.println("4 - Sair");

      this.user_action = ler_dados.nextInt();
      ler_dados.nextLine();

      switch (this.user_action) {
        case 1:
          LimparConsole.limparConsole();
          System.out.println("--- Digite o número do mês --- ");
          System.out.println("Janeiro -> 1");
          System.out.println("Fevereiro -> 2");
          System.out.println("...Dezembro -> 12");
          int mes = ler_dados.nextInt();
          // System.out.println("--- Digite o dia do mês --- ");
          // int dia = ler_dados.nextInt();
          this.menuAdiconarProdutosPorMesDia(mes);
          break;
        case 2:
          LimparConsole.limparConsole();
          this.mostrarDadosSalvos();
          break;
        case 3:
          LimparConsole.limparConsole();
          this.mostrarDadosDeUmMesEspecifico();
          break;
        case 4:
          System.out.println("Fechando programa ...");
          break;
        default:
          System.out.println("Opção inválida!!!");
          break;

      }
    } while (this.user_action != 4);
    ler_dados.close();
  }

  public void menuAdiconarProdutosPorMesDia(int mes_atual) {
    if (mes_atual < 1 || mes_atual > 12) {
      System.out.println("Mês não reconhecido, tente novamente");
      return;
    }

    int escolhaParaMesAtual;
    this.mes_index = --mes_atual;
    this.index_do_dia = 0;
    int diasTotaisDoMesAtual = MenuMeses.diasDoMes(mes_index + 1);

    do {
      this.index_do_produto = this.verificarSeDiaAtualJaTemProdutosAdicionados(this.mes_index, this.index_do_dia);
      System.out.println("-----------");
      System.out.println("Mês de " + MenuMeses.nomeDoMes(this.mes_index + 1));
      System.out.println("1 - Adicionar produtos para o dia " + (this.index_do_dia + 1) + ". É possível adicionar mais "
          + (50 - index_do_produto) + " produtos no dia de hoje!");
      System.out.println("2 - Selecionar o dia");
      System.out.println("3 - Avançar para o próximo mês ");
      System.out.println("4 - Retornar para o mês anterior ");
      System.out.println("5 - Finalizar Vendas e retornar ao menu anterior");
      System.out.println("-----------");
      escolhaParaMesAtual = ler_dados.nextInt();
      ler_dados.nextLine();

      switch (escolhaParaMesAtual) {
        case 1:
          this.pegarDadosDoProduto();
          System.out.println();
          break;
        case 2:
          LimparConsole.limparConsole();
          System.out.println("Mês de " + MenuMeses.nomeDoMes(this.mes_index + 1));
          System.out.println("Total de dias do mês atual: " + diasTotaisDoMesAtual);
          System.out.println("Digite o dia desejado:");
          this.index_do_dia = MenuMeses.validarDiaEscolhidoPeloUsuário(ler_dados.nextInt(), diasTotaisDoMesAtual);
          ler_dados.nextLine();
          break;
        case 3:
          LimparConsole.limparConsole();
          if (this.mes_index == 11) {
            System.out.println("Último mês do ano, impossível de avançar");
            break;
          }
          this.mes_index += 1;
          this.index_do_dia = 0;
          break;
        case 4:
          LimparConsole.limparConsole();
          if (this.mes_index == 0) {
            System.out.println("Primeiro mês do ano, impossível de retornar");
            break;
          }
          this.mes_index -= 1;
          this.index_do_dia = 0;
          break;
        case 5:
          LimparConsole.limparConsole();
        default:
          break;
      }
    } while (escolhaParaMesAtual != 5);
  }

  public void pegarDadosDoProduto() {
    Calculadora calc = new Calculadora();
    Produto venda_atual = new Produto();

    System.out.println("Nome do produto");
    venda_atual.setNome(ler_dados.nextLine());

    System.out.println("Quantidade vendida");
    venda_atual.setQuantidadeVendida(ler_dados.nextInt());

    System.out.println("Qual o valor unitário dos produtos? !(escreva no formato n,n caso seja decimal)!");
    venda_atual.setPrecoDaVenda(calc.setPrecoDaVenda(venda_atual.quantidade_vendida, ler_dados.nextDouble()));

    venda_atual.setValorDoDesconto(calc.desconto_em_reais);

    System.out.println("Valor da compra: " + String.format(" %.2f", venda_atual.preco_da_venda));
    System.out.println("Digite o valor pago pelo cliente para calcular o troco e salvar os dados");
    calc.setTrocoDoCliente(ler_dados.nextDouble());

    if (calc.troco_do_cliente < 0) {
      System.out.println("Está faltando R$" + String.format(" %.2f", calc.troco_do_cliente * -1));
      venda_atual.setValorEmFalta(calc.troco_do_cliente * -1);
    } else if (calc.troco_do_cliente > 0) {
      System.out.println("Devolva R$" + String.format(" %.2f", calc.troco_do_cliente));
      venda_atual.setValorDoTroco(calc.troco_do_cliente);
    } else {
      System.out.println("Não precisa de troco");
      venda_atual.setValorDoTroco(0.0);
    }

    this.produtos_vendidos[this.mes_index][this.index_do_dia][this.index_do_produto] = venda_atual;
    this.meses_com_vendas[mes_index] = true;
    this.dias_com_venda[this.mes_index][this.index_do_dia] = true;
    this.index_do_produto++;
  }

  public void mostrarDadosSalvos() {
    int total_de_vendas_no_ano = 0;
    double valor_total_em_vendas_no_ano = 0;

    System.out.println("");
    System.out.println("Histórico de produtos");
    System.out.println("");
    for (int mes = 0; mes < 12; mes++) { // for para passar pelos meses
      if (this.meses_com_vendas[mes] == false) {
        System.out.println("Nada salvo no mês de " + MenuMeses.nomeDoMes(mes + 1));
        System.out.println(" ------------- ");
        continue;
      }
      System.out.println("Produtos salvos no mês de " + MenuMeses.nomeDoMes(mes + 1));
      for (int dia = 0; dia < 31; dia++) { // for para passar pelos dias do mês
        if (this.dias_com_venda[mes][dia] == false) {
          continue;
        }
        System.out.println("Produtos dia " + (dia + 1));
        for (int produto = 0; produto < 50; produto++) { // for para passar pelos produtos do dia
          if (produtos_vendidos[mes][dia][produto] == null) {
            continue;
          }
          System.out.println("Produto " + (produto + 1) + ":");
          System.out.println(produtos_vendidos[mes][dia][produto].toString() + "\n");
          total_de_vendas_no_ano++;
          valor_total_em_vendas_no_ano += produtos_vendidos[mes][dia][produto].preco_da_venda;
        }
        System.out.println(" ------------- ");
      }
    }

    System.out.println("\n");
    System.out.println("Total de vendas no ano: " + total_de_vendas_no_ano);
    System.out.println("Total arrecadado com vendas no ano: R$ " + valor_total_em_vendas_no_ano);
    System.out.println("\n");
  }

  public void mostrarDadosDeUmMesEspecifico() {
    int escolha_de_acao_do_usuario;
    do {
      System.out.println("-----------");
      System.out.println("Escolha uma opção");
      System.out.println("1 - Ver todas as vendas de um mês");
      System.out.println("2 - Ver todas as vendas de um dia do mês");
      System.out.println("3 - Retornar ao menu anterior");
      System.out.println("-----------");
      escolha_de_acao_do_usuario = ler_dados.nextInt();

      switch (escolha_de_acao_do_usuario) {
        case 1:
          LimparConsole.limparConsole();
          System.out.println("--- Digite o número do mês --- ");
          System.out.println("Janeiro -> 1");
          System.out.println("Fevereiro -> 2");
          System.out.println("...Dezembro -> 12");
          this.mostrarDadosDoMesEscolhido(ler_dados.nextInt() - 1);
          break;
        case 2:
          System.out.println("--- Digite o número do mês --- ");
          System.out.println("Janeiro -> 1");
          System.out.println("Fevereiro -> 2");
          System.out.println("...Dezembro -> 12");
          int mes = ler_dados.nextInt();
          System.out.println("--- Digite o dia do mês --- ");
          int dia = ler_dados.nextInt();
          this.mostrarDadosDoMesMaisDiaEscolhido(mes - 1, dia - 1);
          break;
        case 3:
          LimparConsole.limparConsole();
          break;
        default:
          break;
      }
    } while (escolha_de_acao_do_usuario != 3);
  }

  public int verificarSeDiaAtualJaTemProdutosAdicionados(int mes, int dia) {
    int posicao;
    int index = 0;
    while (produtos_vendidos[mes][dia][index] != null) {
      index++;
      if (index == 50) {
        break;
      }
    }
    posicao = index;
    return posicao;
  }

  public void mostrarDadosDoMesEscolhido(int numero_do_mes) {
    String nome_mes_atual = MenuMeses.nomeDoMes(numero_do_mes + 1);
    int vendas_mensal_total = 0;
    double valor_total_em_vendas_no_mes = 0;

    if (nome_mes_atual == "Nenhum mês encontrado") {
      return;
    }

    System.out.println("Produtos do mês de " + nome_mes_atual);

    for (int dia = 0; dia < MenuMeses.diasDoMes(numero_do_mes + 1); dia++) {
      if (this.dias_com_venda[numero_do_mes][dia] == false) {
        continue;
      }
      System.out.println("Produtos dia " + (dia + 1));
      for (int produto = 0; produto < 50; produto++) { // for para passar pelos produtos do dia
        if (produtos_vendidos[numero_do_mes][dia][produto] == null) {
          continue;
        }
        System.out.println("Produto " + (produto + 1) + ":");
        System.out.println(produtos_vendidos[numero_do_mes][dia][produto].toString() + "\n");
        vendas_mensal_total++;
        valor_total_em_vendas_no_mes += produtos_vendidos[numero_do_mes][dia][produto].preco_da_venda;
      }
      System.out.println(" ------------- ");
    }
    if (vendas_mensal_total == 0) {
      System.out.println("Nenhuma venda no mês de " + nome_mes_atual);
    }
    System.out.println("\n");
    System.out.println("Total de vendas no mês de " + nome_mes_atual + ": " + vendas_mensal_total);
    System.out.println("Total arrecadado com vendas no mês: " + nome_mes_atual + " R$ "
        + String.format("%.2f", valor_total_em_vendas_no_mes));
    System.out.println("\n");
  }

  public void mostrarDadosDoMesMaisDiaEscolhido(int numero_do_mes, int numero_do_dia) {
    int vendas_de_um_dia = 0;
    double valor_total_em_vendas_no_dia = 0;
    String nome_mes_atual = MenuMeses.nomeDoMes(numero_do_mes + 1);
    if (nome_mes_atual == "Nenhum mês encontrado") {
      return;
    } else if (numero_do_dia + 1 > MenuMeses.diasDoMes(numero_do_mes + 1) || numero_do_dia + 1 < 1) {
      System.out.println("Dia inválido");
      return;
    }
    System.out.println("Produtos no dia " + (numero_do_dia + 1) + " do mês de " + nome_mes_atual);
    for (int produto = 0; produto < 50; produto++) {
      if (produtos_vendidos[numero_do_mes][numero_do_dia][produto] == null) {
        continue;
      }
      System.out.println("Produto " + (produto + 1) + ":");
      System.out.println(produtos_vendidos[numero_do_mes][numero_do_dia][produto].toString() + "\n");
      vendas_de_um_dia++;
      valor_total_em_vendas_no_dia += produtos_vendidos[numero_do_mes][numero_do_dia][produto].preco_da_venda;
    }

    System.out.println("\n");
    System.out.println(
        "Total de vendas no dia: " + (numero_do_dia + 1) + " do mês de: " + nome_mes_atual + ": " + vendas_de_um_dia);
    System.out
        .println("Total arrecadado com vendas no dia: " + (numero_do_dia + 1) + " do mês de: " + nome_mes_atual + "R$ "
            + String.format("%.2f", valor_total_em_vendas_no_dia));
    System.out.println("\n");
  }
}

// Dona Gabrielinha está utilizando o sistema e isso melhorou muito sua
// produtividade na loja, porém ela identificou que apenas salvar aleatoriamente
// a venda não é algo tão útil. Ela então te contacta novamente e realiza o
// orçamento da alteração. Segundo ela, seria ótimo poder salvar a quantidade de
// vendas totais(valor) em um dia de um mês. Ela também gostaria de buscar a
// quantidade de vendas total pelo mês e dia.