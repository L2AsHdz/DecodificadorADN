package decodificadoradn.controller;

import decodificadoradn.ui.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class UIController implements ActionListener{
    private Interfaz ui;

    public UIController(Interfaz ui) {
        this.ui = ui;
        ui.getBtnFind().addActionListener(this);
    }
    
    public void iniciar(){
        ui.pack();
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.getBtnFind() == e.getSource()) {
            String secuencia1 = ui.getTxt_secuencia1().getText();
            String secuencia2 = ui.getTxt_secuencia2().getText();
            String resultado = buscarSubSecuenciaRepetida(secuencia1, secuencia2);
            
            JOptionPane.showMessageDialog(null, resultado, "Resultado", 
                JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
    }

    private String buscarSubSecuenciaRepetida(String secuencia1, String secuencia2) {
        String temp = "";
        String resultado = "";
        
        int[][] matriz = crearMatriz(secuencia1, secuencia2);

        for (int i = 0; i < secuencia1.length(); i++) {
            for (int j = 0; j < secuencia2.length(); j++) {
                if (matriz[i][j] == 1) {
                    int iTemp = i;
                    int jTemp = j;
                    while (iTemp < secuencia1.length() && jTemp < secuencia2.length()) {
                        if (matriz[iTemp][jTemp] == 1) {
                            temp += secuencia1.charAt(iTemp);
                        } else {
                            break;
                        }
                        iTemp++;
                        jTemp++;
                    }

                    if (temp.length() > resultado.length()) {
                        resultado = temp;
                    }
                    temp = "";
                }
            }
        }
        
        return resultado;
    }
    
    private int[][] crearMatriz(String secuencia1, String secuencia2){
        int[][] matriz = new int[secuencia1.length()][secuencia2.length()];
        for (int i = 0; i < secuencia1.length(); i++) {
            for (int j = 0; j < secuencia1.length(); j++) {
                if (secuencia1.charAt(i) == secuencia2.charAt(j)) {
                    matriz[i][j] = 1;
                }
            }
        }
        return matriz;
    }
    
    private void limpiarCampos(){
        ui.getTxt_secuencia1().setText("");
        ui.getTxt_secuencia2().setText("");
        ui.getTxt_secuencia1().requestFocus();
    }
}
