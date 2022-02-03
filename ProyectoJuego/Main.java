import java.util.Scanner;

public class Main
{
    public void myMain() 
    {
        //Variables de ejecución
        int x = 2;
        int y = 1;
        int z = 0;
		int opcionEscogida;
        int opcionEscogidaComprobada;
        String usuario = "noUser";

		//Creación de objetos
		MenuJuego miMenu = new MenuJuego();
		Scanner sc = new Scanner(System.in);
        Usuario miUsuario = new Usuario();
        Puntuacion miPuntuacion = new Puntuacion();
        HundirLaFlota miFlota = new HundirLaFlota();
        Ahorcado miHorca = new Ahorcado();
    
        while (x == 1) //Ejecución continua del programa
        {
            while (y == 0) //Se sale del programa y se detiene la ejecución
            {
                y = 0;
                x = 1;
            }
            while (y == 1) //Se ejecuta el menú inicial
            {
                miMenu.dibujarMenu(); //Muestra el menú de selección
                opcionEscogida = sc.nextInt(); //obtiene la opción del menú
                    //Primero comprobamos que el valor metido por el usuario es un valor entre 1 y 5 y no otra cosa
                miMenu.compruebaOpcion(opcionEscogida); //Llama al método que comprueba si es correcta
                opcionEscogidaComprobada = miMenu.devuelveOpcion();
                if (opcionEscogidaComprobada == 1) //Esta es la opción de que el valor es correcto
                {
                    z = 2; //Para pasar a la siguiente fase de ejecución
                    y = 1; //Para cerrar la condición
                }
                else if (opcionEscogidaComprobada == 2)
                {
                    //Método que te riña cuando te equivocas con el menú
                    miMenu.limpiaMenu();
                    miMenu.opcionEscogidaMal();
                    z = 10; //Para pasar a la siguiente fase de ejecución
                    y = 1; //Para cerrar la condición
                }
                else{
                    //Método que te insulta si haces el gamba
                    miMenu.limpiaMenu();
                    miMenu.insultaUsuario();
                    z = 10;
                    y = 1; //Para cerrar la condición
                }
            }
            while (y == 2)  //Si intenta jugar sin usuario, se comprueba si existe usuario -- Si existe = 3 ------ No existe = 4 --
            {               //Si intenta ver puntuación le mostrará mensaje de error ya que aún no existe ningún usuario.
                if (opcionEscogida == 4)
                {
                    miMenu.limpiaMenu();
                    System.out.println("No puedes consultar ninguna puntuación si aún no existe ningún usuario. " +
                    "\nCrea primero un usuario y juega alguna partida para poder consultar sus datos.");
                    z = 4;
                    y = 2;
                }
                if (opcionEscogida == 2 || opcionEscogida == 3) //Ahora comprobamos si el usuario existe, en caso contrario le obligamos a crear un usuario
                {
                    miMenu.limpiaMenu();
                    miUsuario.compruebaUsuario();
                    if (miUsuario.compruebaUsuario() == true) //devuelve true porque no existe ningún usuario, le envía a crear uno
		            {
			            z = 4;
                        y = 2;
		            }
		            else if (miUsuario.compruebaUsuario() == false) //devuelve false porque si que existe un usuario
		            {
                        z = 3;
                        y = 2;
                    }
                    else
                    {
                        z = 4;
                        y = 2;
                    }
                }
            }
            while (y == 3) //Ya existe el usuario
            {
                usuario = miUsuario.obtenDatosUsuario();
                z = 5;
                y = 3;
            }
            while (y == 4) //Se ejecuta la creación de nuevo usuario
            {
                miMenu.limpiaMenu();
                System.out.println("Antes de jugar, necesita crear un usuario que almacene sus resultados de juego.");
                miUsuario.creaUsuarioNuevo();
                usuario = miUsuario.obtenDatosUsuario();
                z = 5;
                y = 4;
            }
            while (y == 5) //Se ejecuta la acción que el usuario deseaba en un inicio
            {
                if (opcionEscogida == 1) //Esta es la opción con la cual puede crear otro nuevo usuario.
                {
                    miMenu.limpiaMenu();
                    z = 11;
                    y = 5;
                }
                if (opcionEscogida == 2) //Esta es la opción para iniciar el juego del Ahorcado
                {
                    miMenu.limpiaMenu();
                    z = 6;
                    y = 5;
                }
                if (opcionEscogida == 3) //Esta es la opción para iniciar el juego de Hundir la Flota
                {
                    miMenu.limpiaMenu();
                    z = 7;
                    y = 5;
                }
                if (opcionEscogida == 4) //Esta es la opción para consultar los puntos del jugador
                {
                    miMenu.limpiaMenu();
                    z = 8;
                    y = 5;

                }
                if (opcionEscogida == 5) //Esta es la opción para cerrar el juego
                {
                    miMenu.limpiaMenu();
                    z = 99;
                    y = 5;
                }
            }
            while (y == 6) //Se ejecuta el juego del Ahorcado
            {
                miHorca.nuevoAhorcado();
            }
            while (y == 7) //Se ejecuta el juego de Hundir La Flota
            {
                miFlota.nuevaFlota();
            }
            while (y == 8) //Se consulta la puntuación del Usuario
            {
                miPuntuacion.consultaPuntos();
            }
            while (y == 9) //Se modifican los datos del Usuario
            {
                System.out.println("En esta pantalla puede usted crear un nuevo usuario.");
                miUsuario.creaOtroUsuario();
                z = 11;
                y = 9;
            }
            while (y == 10) //Te devuelve a ingresar tus datos de nuevo para que escojas bien la opción
            {
                
            }
            while (y == 11) //Te devuelve de nuevo del menú si ya hemos terminado la interacción
            {
                z = 1;
                y = 11;
            }

            // Aquí almaceno los modificadores de valores
            if (z == 1)
            {
                y = 1;
            }
            if (z == 2)
            {
                y = 2;
            }
            if (z == 3)
            {
                y = 3;
            }
            if (z == 4)
            {
                y = 4;
            }
            if (z == 5)
            {
                y = 5;
            }
            if (z == 6)
            {
                y = 6;
            }
            if (z == 7)
            {
                y = 7;
            }
            if (z == 8)
            {
                y = 8;
            }
            if (z == 9)
            {
                y = 9;
            }
            if (z == 10)
            {
                y = 10;
            }
            if (z == 11)
            {
                y = 11;
            }
            if (z == 99) //Ejecuta la salida EXIT del programa con y == 0 && x == 1
            {
                y = 0;
                x = 1;
            }
        }     
    }
}

