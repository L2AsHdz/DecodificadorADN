package decodificadoradn.ui;

import java.util.Scanner;

public class Interfaz {
    
    private final Scanner sc = new Scanner(System.in);
    private final Scanner sc2 = new Scanner(System.in);
    
    public Interfaz() {
    }
    
    public String solicitarSecencia(int i){
        switch (i) {
            case 1:
                System.out.println("Ingrese secuencia A: ");
                break;
            case 2:
                System.out.println("Ingrese secuencia B: ");
                break;
        }
        String secuencia = sc.nextLine();
        return secuencia;
    }
    
    public void mostrarResultado(String result){
        System.out.println("\nLa subsecuencia comun mayor es: "+ result + "\n");
    }
    
    public int menu(){
        System.out.println("Decodificador ADN");
        System.out.println("1. Ingresar secuencias.");
        System.out.println("2. Salir");
        int opcion = sc2.nextInt();
        return opcion;
    }
}
