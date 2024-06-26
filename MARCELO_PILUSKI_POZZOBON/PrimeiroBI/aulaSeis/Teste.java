package aulaSeis;

import aulaSeis.src.Arma;
import aulaSeis.src.Professor;

public class Teste {
    public static void main(String[] args) {
        Professor marcelo = new Professor();

        marcelo.nome = "Marcelo Pozzobon";
        marcelo.materia = "POO em Python";
        
        marcelo.apresentarse();

        Arma awp = new Arma();

        awp.nome = "Fever Dream";
        awp.tipo = "AWP";
        awp.dano = 100;

        marcelo.arma = awp;
    }
}
