package decodificadoradn;

import decodificadoradn.controller.UIController;
import decodificadoradn.ui.Interfaz;

public class DecodificadorADN {

    public static void main(String[] args) {
        Interfaz ui = new Interfaz();
        UIController uiC = new UIController(ui);
        uiC.iniciar();
    }
}
