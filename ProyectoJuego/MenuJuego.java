import java.util.Scanner;

public class MenuJuego {
    //Atributos de la clase
    int opcionEscogidaInt;

	//Constructor de la clase
	public MenuJuego() {}
	
	//Metodo que pinte el menú
	public void dibujarMenu()  
    {
        //Inicio de menú
        System.out.println("--------------------------------------------------");
        //linea
        System.out.print("|");
        System.out.print("                                                ");
        System.out.println("|");
        //linea y titulo
        System.out.print("|");
        System.out.print("               Escoja una opción                "); //Escoja una opción
        System.out.println("|");
        //línea
        System.out.print("|");
        System.out.print("                                                "); 
        System.out.println("|");
        //Linea y expliación
        System.out.print("|");
        System.out.print("   Escriba el número indicado y pulse 'Enter'   "); //Pulse el número indicado y Enter
        System.out.println("|");
        //línea
        System.out.print("|");
        System.out.print("                                                "); 
        System.out.println("|");
        //1a opcion
        System.out.print("|");
        System.out.print("     [1] Introduzca nombre del jugador          "); //[1] Introduzca nombre del jugador
        System.out.println("|");
        //2a opcion
        System.out.print("|");
        System.out.print("     [2] Jugar al Ahorcado                      "); //[2] Jugar al ahorcado
        System.out.println("|");
        //3a opcion
        System.out.print("|");
        System.out.print("     [3] Jugar a Hundir la flota                "); //[3] Jugar a Hundir la flota
        System.out.println("|");
        //4a opcion
        System.out.print("|");
        System.out.print("     [4] Ver las últimas puntuaciones           "); //[4] Ver las últimas puntuaciones
        System.out.println("|");        
        //5a opcion
        System.out.print("|");
        System.out.print("     [5] Salir del programa                     "); //[5] Salir del programa
        System.out.println("|"); 
        //linea
        System.out.print("|");
        System.out.print("                                                ");
        System.out.println("|");
        //Fin de menú
        System.out.println("--------------------------------------------------");
    }

	//Método que borra la consola
    public void limpiaMenu()
    {
        System.out.println("\f");
        System.out.flush();
    }

	
	//Método que compruebe la opción del menú
	public void compruebaOpcion(int opcion)
    {
        if (opcion >= 1 && opcion <= 5)
        {
            opcionEscogidaInt = 1;
        }
        else
        {
            opcionEscogidaInt = 2;
        }
    }
	
    //Método que devuelva el estado de la opción escogida
    public int devuelveOpcion()
    {
        if (opcionEscogidaInt == 1)
        {
            return 1;
        }
        else if (opcionEscogidaInt == 2)
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }

	//Método que te riña cuando te equivocas con el menú
    public void opcionEscogidaMal()
    {

    }

    //Método que ...




}
