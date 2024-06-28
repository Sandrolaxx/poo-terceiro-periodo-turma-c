package SegundoBimestre.ATV3;

import javax.swing.JOptionPane;

public class Excecao extends RuntimeException {
    public Excecao(String erro) {
        super(erro);
        JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}