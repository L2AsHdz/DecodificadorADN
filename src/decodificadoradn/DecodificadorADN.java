package decodificadoradn;

import decodificadoradn.ui.Interfaz;

public class DecodificadorADN {

    private static String secuencia1;
    private static String secuencia2;

    public static void main(String[] args) {
        Interfaz ui = new Interfaz();

        secuencia1 = ui.solicitarSecencia();
        secuencia2 = ui.solicitarSecencia();
        ui.mostrarResultado(buscarSubSecuenciaRepetida());
    }

    private static String buscarSubSecuenciaRepetida() {
        String temp = "";
        String resultado = "";
        
        int[][] matriz = crearMatriz();

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
    
    private static int[][] crearMatriz(){
        int[][] matriz = new int[secuencia1.length()][secuencia2.length()];
        for (int i = 0; i < secuencia1.length(); i++) {
            for (int j = 0; j < secuencia2.length(); j++) {
                if (secuencia1.charAt(i) == secuencia2.charAt(j)) {
                    matriz[i][j] = 1;
                }
            }
        }
        return matriz;
    }
}
