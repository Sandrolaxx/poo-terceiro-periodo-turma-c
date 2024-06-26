package lista4;

public class Teste {
    public static void main(String[] args) {
        Loja UVI = new Loja ();
        Vendedor isabela = new Vendedor();
        Cliente rosaria = new Cliente();
        
        isabela.nome = "Isabela";
        isabela.idade = 27;
        isabela.bairro = " Vila a ";
        isabela.rua = "melro";
        isabela.cidade = "Cascavel";
        isabela.loja = UVI;
        isabela.salarioBase = 1.400f; //f de float :)
        isabela.salarioRecebido [0] = 1.400f;
        isabela.salarioRecebido [1] = 1.400f;
        isabela.salarioRecebido [2] = 1.400f;

        rosaria.nome = "Rosaria";
        rosaria.idade =  24;
        rosaria.cidade = "Mondstadt";
        rosaria.bairro = "Aquario";
        rosaria.rua ="Klee";

        UVI.nomeFantasia ="UVI";
        UVI.razaoSocial = "UVILTDA";
        UVI.cpnj = "86.760.070/0001-63";
        UVI.bairro = "matilda";
        UVI.cidade = "Cascavel";
        UVI.rua = "Fatima";
        UVI.vendedor[0] = isabela;
        UVI.cliente [0] = rosaria;


        isabela.apresentarse();
        isabela.calcularMedia();
        isabela.calculaBonus();


        rosaria.apresentarse();

        UVI.apresentacao();
        UVI.contarClientes();
        UVI.contarVendedor();



        //2
        Loja Shogun = new Loja ();
        Vendedor kauana = new Vendedor();
        Cliente jean = new Cliente();
        
        kauana.nome = "kauana";
        kauana.idade = 20;
        kauana.bairro = " Vila B";
        kauana.rua = "gemeos";
        kauana.cidade = "Foz do Iguaçu";
        kauana.loja = Shogun;
        kauana.salarioBase = 1.400f; //f de float :)
        kauana.salarioRecebido [0] = 1.400f;
        kauana.salarioRecebido [1] = 1.400f;
        kauana.salarioRecebido [2] = 1.400f;

        jean.nome = "jean";
        jean.idade =  24;
        jean.cidade = "Mondstadt";
        jean.bairro = "eola";
        jean.rua ="ambar";

        Shogun.nomeFantasia ="Shogun";
        Shogun.razaoSocial = "ShogunLTDA";
        Shogun.cpnj = "87.768.077/0001-64";
        Shogun.bairro = "kitsune";
        Shogun.cidade = "inazuma";
        Shogun.rua = "thunder";
        Shogun.vendedor[0] = kauana;
        Shogun.cliente [0] = jean;


        kauana.apresentarse();
        kauana.calcularMedia();
        kauana.calculaBonus();


        jean.apresentarse();

        Shogun.apresentacao();
        Shogun.contarClientes();
        Shogun.contarVendedor();
    }


}
