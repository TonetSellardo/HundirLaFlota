import java.util.Scanner;

public class MainOpcional {
    
    public void myMainOpcional()
    {
        //Variables de ejecución
        int opcionEscogida, opcionEscogidaComprobada;

        //Creación de objetos
        MenuJuego miMenu = new MenuJuego();
        Scanner sc = new Scanner(System.in);


        //Ejecución del programa
        miMenu.dibujarMenu(); //Muestra el menú de selección
        opcionEscogida = sc.nextInt();
        miMenu.compruebaOpcion(opcionEscogida); //Primero comprobamos que el valor metido por el usuario es un valor entre 1 y 5 y no otra cosa
        opcionEscogidaComprobada = miMenu.devuelveOpcion();
        if (opcionEscogidaComprobada == 1)
        {

        }
        else if (opcionEscogidaComprobada == 2)
        {

        }
        else{

        }

        System.out.println(miMenu.devuelveOpcion()); //Solo para debug
        
        
        

        //Ahora comprobamos si el usuario existe, en caso contrario le obligamos a crear un usuario
        /*if (compruebaUsuario == true)
        {
            miUsuario.obtenDatosUsuario();
        }
        else
        {
            miUsuario.creaUsuarioNuevo();
        }*/
    }
}