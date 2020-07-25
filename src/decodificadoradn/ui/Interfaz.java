package decodificadoradn.ui;

import java.util.Scanner;

public class Interfaz {
    
    private final Scanner sc = new Scanner(System.in);
    
    public Interfaz() {
    }
    
    public String solicitarSecencia(){
        System.out.println("Ingrese secuencia");
        String secuencia = sc.nextLine();
        return secuencia;
    }
    
    public void mostrarResultado(String result){
        System.out.println("La cadena repetida es "+ result);
    }
}
