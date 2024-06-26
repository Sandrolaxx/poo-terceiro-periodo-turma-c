import java.util.Scanner;

public class Calendar {
    int month;
    int day;
    double saleValor;
    double[][] anualSales = new double[31][13];

    public Calendar(int day, int month) {
        this.month = month;
        this.day = day;
        recordSales();
    }

    public void recordSales() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual mês você quer salvar a data?\n[1]Janeiro\n[2]Fevereiro\n[3]Março\n[4]Abril");
        System.out.println("[5]Maio\n[6]Junho\n[7]Julho\n[8]Agosto\n[9]Setembro\n[10]Outubro\n[11]Novembro\n[12]Dezembro");
        month = sc.nextInt();
        sc.nextLine();

        System.out.println("Qual o dia deste mês você quer criar suas vendas?");
        day = sc.nextInt();

        System.out.println("Qual o valor que vocẽ quer salvar nesta data?");
        saleValor = sc.nextInt();

        System.out.println("Valor salvo: " + saleValor);
        anualSales[day][month] += saleValor;
        System.out.println("Valor total das vendas do dia " + (day) + "/" + (month));
        System.out.println("Valor salvo na matriz: " + anualSales[day][month]);
    }

    public static void consultSales(int day, int month, double[][] anualSales) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Valor total das vendas do dia " + (day) + "/" + (month));

        System.out.println(anualSales[day][month]);
    }
}
