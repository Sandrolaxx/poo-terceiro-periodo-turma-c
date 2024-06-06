package KAUE_ORLANDINI.PrimeiroBimestre.Lista2;

public class Loja extends Endereco {
    
    private String nomeFantasia;
   
    private String razaoSocial;
    
    private String cnpj;
    
    private String cidade;
   
    private String bairro;
   
    private String rua;
    
    private String estado;
    
    private String complemento;
    
    private double numero;

    private double[] vendedores = new double[2];
    
    private double[] clientes = new double[4];

    private double vendedoress;

    private double clientess;
   
    

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua, String estado, String complemento,
            Double numero, double[] clientes,double[] vendedores, double vendedoress, double clientess) {
            super(bairro, cidade, rua, estado, numero, complemento);
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.estado = estado;
        this.complemento = complemento;
        this.numero = numero;
        this.clientes = clientes;
        this.vendedores = vendedores;
        this.vendedoress = vendedoress;
        this.clientess = clientess;
    }

    void contarClientes() {
        double clientess = clientes[0] + clientes[1] + clientes[2];
        System.out.println(clientess);
    }
    
    void contarVendedores() {
        vendedoress = vendedores[0] + vendedores[1];
        System.out.println(vendedoress);
    } 

    void apresentarse() {
        System.out.println("nome: ".concat(nomeFantasia).concat(", cnpj: ").concat(cnpj).concat(", endereco: ").concat(rua));
    }
    
    void apresentarLogradouro() {
        System.out.println("estado: ".concat(estado).concat(", cidade: ").concat(cidade).concat(", bairro: ").concat(bairro).concat(", rua: ").concat(rua).concat(", numero: ") + String.valueOf(numero).concat(", complemento:").concat(complemento));
    }

    public double[] getVendedores() {
        return vendedores;
    }

    public double[] getClientes() {
        return clientes;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public double getVendedoress() {
        return vendedoress;
    }

    public double getClientess() {
        return clientess;
    }

    
}
