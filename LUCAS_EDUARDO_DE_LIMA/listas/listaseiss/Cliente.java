package listas.listaseiss;

public class Cliente extends Pessoa {
  

        public Cliente(String nome, Integer idade, Endereco endereco) {
            super(nome, idade, endereco);
        }
    
        @Override
        public void apresentarse() {
            System.out.println("Olá eu sou o " + nome + " tenho " + idade + " anos.");
        }
    }
    

