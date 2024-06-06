package SegundoBim.Lista3SegBim;

import javax.swing.JOptionPane;

public class CustomExceptionf extends RuntimeException {
    CustomExceptionf(String errorMsg){
        JOptionPane.showMessageDialog(null, 
        errorMsg, 
        "ERRO", 
        JOptionPane.ERROR_MESSAGE);
    }
}

