package primeirob.atividadeObjeto;
// classe criada apenas para estudo e entendimento de DATE
import java.util.Date;
public class Util {
    public static void main(String[] args){
        Date dataAtual = new Date();
        Date dataSemHora = new Date(0, 0, 0); // soma x + 1900 (abril ==05)

        Date cincoAbril = new Date(124,3,05);
        Long epochCincoAbril = cincoAbril.getTime();
        Long diaAtualEmMilissegundos = cincoAbril.getTime();
        Long diaEmMs = 86400000l;
        System.out.println("Data Atual: "+ dataAtual);
        System.out.println("Data sem hora: "+ dataSemHora);
        System.out.println("epoch cinco de abril: "+ epochCincoAbril);
        System.out.println("Dia em Milissegundos: "+ diaAtualEmMilissegundos);
        // VER QUANTOS DIAS DE DIFERENCA
        System.out.println((dataAtual.getTime() - cincoAbril.getTime())/diaEmMs);
        // ver se o passou do praco
        if (dataAtual.getTime() > cincoAbril.getTime()) {
            System.out.println("passou do prazo");
        }
        //usando a funcao util em outro codigo
        if (Util.isDataMaior(dataAtual, cincoAbril)){
            System.out.println("testandoo");
        };
        System.out.println("teste 2: ");
        System.out.println(Util.diferenceTime(dataAtual,cincoAbril));

    }
    public static boolean isDataMaior(Date dataUm, Date dataDois){
        return dataUm.getTime() > dataDois.getTime();
    }
    public static Long diferenceTime(Date dataUm, Date dataDois){
        Long diaEmMs2 = 86400000l;
        return (dataUm.getTime() - dataDois.getTime())/diaEmMs2;
    }

}
