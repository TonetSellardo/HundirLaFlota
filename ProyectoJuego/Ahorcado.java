import java.util.Scanner;
import java.util.Random;

public class Ahorcado 
{
    //Constructor de la clase
    public Ahorcado () {}

    //Atributos de la clase
    private Scanner sc = new Scanner(System.in);
    private Random r = new Random();
    private MenuJuego miMenu = new MenuJuego();
    private int dificultad = 0;
    private int convertidor = 0;
    private int contadorErrores = 0;
    private int x = 0;
    private char [] letrasNoAceptadas = new char[30];
    private String [] filasAhorcado = new String[10];
    {
        filasAhorcado [0] = "    |-----------|  ";
        filasAhorcado [1] = "    |           |  ";
        filasAhorcado [2] = "    |           |  ";
        filasAhorcado [3] = "    |              ";
        filasAhorcado [4] = "    |              ";
        filasAhorcado [5] = "    |              ";
        filasAhorcado [6] = "    |              ";
        filasAhorcado [7] = "    |              ";
        filasAhorcado [8] = "    |              ";
        filasAhorcado [9] = "---------          ";
    }

    private String [] erroresAhorcado = new String[6];
    {
        erroresAhorcado [0] = "    |           O  ";
        erroresAhorcado [1] = "    |           V  ";
        erroresAhorcado [2] = "    |          ¡V  ";
        erroresAhorcado [3] = "    |          ¡V¡ ";
        erroresAhorcado [4] = "    |          ()  ";
        erroresAhorcado [5] = "    |          ( ) ";
    }
    
    private String [] palabrasAhorcado = new String [10];
    {
        palabrasAhorcado[0] = "LIBRETA";
        palabrasAhorcado[1] = "BOLIGRAFO";
        palabrasAhorcado[2] = "ESTUCHE";
        palabrasAhorcado[3] = "MOCHILA";
        palabrasAhorcado[4] = "LIBRO";
        palabrasAhorcado[5] = "SACAPUNTAS";
        palabrasAhorcado[6] = "LAPIZ";
        palabrasAhorcado[7] = "GOMA";
        palabrasAhorcado[8] = "ROTULADOR";
        palabrasAhorcado[9] = "TIJERAS";
    }

    //Constructor del método
    public void nuevoAhorcado()
    {
        //Atributos del método
        String [] filasPartida = new String[10];
        String [] erroresPartida = new String[6];
        int numeroPalabra = 0;
        int tamañoPalabra = 0;
        int numeroLetra = 0;
        int contador = 0;
        String palabraPorAdivinar = "";
        String espaciosPorAdivinar = "";
        char letraDeInicio;
        for (int i = 0; i < 10; i++)
        {
            filasPartida[i] = filasAhorcado[i];
        }
        for (int j = 0; j < 6; j++)
        {
            erroresPartida[j] = erroresAhorcado[j];
        }

        //Introducción del juego
        System.out.println(
          "                         Bienvenido al juego del Ahorcado \n" +
        "\n    Las reglas del juego son las siguientes:" +
        "\n1.- Debes encontrar la palabra antes de que cometas el máximo de errores permitidos." +
        "\n2.- Debes introducir una letra cada vez, si esta letra existe, se mostrará en la palabra," +
        "\n       tantas veces como se encuentre en la palabra." +
        "\n3.- Si la letra que has introducido no se encuentra entre las que forman la palabra," +
        "\n       se sumará a las letras que has introducido pero que no eran válidas." + 
        "\nPISTA: Todas las palabras tienen en común que son material escolar" + "\n");

        //Sistema de dificultad
        System.out.println("Escoge el nivel de dificultad que deseas:"+
        "\nPulsa 1 para dificultad facil: 6 intentos"+
        "\nPulsa 2 para dificultad media: 4 intentos"+
        "\nPulsa 3 para dificultad dificil: 2 intentos");
        dificultad = sc.nextInt();

        //Comprueba la dificultad introducida
        if (dificultad > 3 || dificultad < 1)
        {
            miMenu.limpiaMenu();
            System.out.println("Creo yo que introducir un número escogiendo entre 1, 2 y 3 no es tan dificil."+
            "\nDeja de hacer el mongolo e introducelo bien, anda.");
            dificultad = sc.nextInt();
        }
        else
        {
            if (dificultad == 1)
            {
                miMenu.limpiaMenu();
                System.out.println("Has escogido la dificultad Facil. Jeje, que blandengue.");
            }
            if (dificultad == 2)
            {
                miMenu.limpiaMenu();
                System.out.println("Has escogido la dificultad Media. Bueno, no está mal.");
            }
            if (dificultad == 3)
            {
                miMenu.limpiaMenu();
                System.out.println("Has escogido la dificultad Dificil. Así me gusta, poniendole ganas al asunto."+
                "\nComo recompensa por ponerle valor al asunto, te voy a recompensar dejandote tener 3 intentos."+
                "\n                            ¡Pero no te acostumbres!");
            }
        }

        if (dificultad <= 3 && dificultad >= 1)
        {
            if (dificultad == 1)
            {
                miMenu.limpiaMenu();
                System.out.println("Has escogido la dificultad Facil. Jeje, que blandengue.");
            }
            if (dificultad == 2)
            {
                miMenu.limpiaMenu();
                System.out.println("Has escogido la dificultad Media. Bueno, no está mal.");
            }
            if (dificultad == 3)
            {
                miMenu.limpiaMenu();
                System.out.println("Has escogido la dificultad Dificil. Así me gusta, poniendole ganas al asunto."+
                "\nComo recompensa por ponerle valor al asunto, te voy a recompensar dejandote tener 3 intentos."+
                "\n                            ¡Pero no te acostumbres!\n");
            }
        }

        //Elección de la palabra con Random y analisis de la misma
        numeroPalabra = r.nextInt(10);
        palabraPorAdivinar = palabrasAhorcado[numeroPalabra];
        tamañoPalabra = palabrasAhorcado[numeroPalabra].length();
        numeroLetra = r.nextInt(tamañoPalabra);
        letraDeInicio = palabraPorAdivinar.charAt(numeroLetra);
        for (int i = 0; i < tamañoPalabra; i++)
        {
            if (i == numeroLetra)
            {
                espaciosPorAdivinar = espaciosPorAdivinar + letraDeInicio;
            }
            else
            {
                espaciosPorAdivinar = espaciosPorAdivinar + "_";
            }
        }
        
        //Dibujar el mapa
        //miMenu.limpiaMenu();
        for (int i = 0; i < 10; i++)
        {
            System.out.println(filasPartida[i]);
        }
        System.out.println("Numero de errores cometidos: " + contador);
        System.out.println("Palabra por adivinar: " + espaciosPorAdivinar); 
        

        //Ejecución del juego

        while (x == 1)
        {
            if (dificultad == 1)
            {
                while (contadorErrores == 7)
                {
        
                }
                if (contadorErrores == 1)
                {
                    filasPartida[3] = erroresPartida[0];
                }
                if (contadorErrores == 2)
                {
                    filasPartida[4] = erroresPartida[1];
                }
                if (contadorErrores == 3)
                {
                    filasPartida[4] = erroresPartida[2];
                }
                if (contadorErrores == 4)
                {
                    filasPartida[4] = erroresPartida[3];
                }
                if (contadorErrores == 5)
                {
                    filasPartida[5] = erroresPartida[4];
                }
                if (contadorErrores == 6)
                {
                    filasPartida[5] = erroresPartida[5];
                }
            }
            if (dificultad == 2)
            {
                while (contadorErrores == 7)
                {
        
                }
                if (contadorErrores == 1)
                {
                    filasPartida[3] = erroresPartida[0];
                }
                if (contadorErrores == 2)
                {
                    filasPartida[4] = erroresPartida[1];
                }
                if (contadorErrores == 3)
                {
                    filasPartida[4] = erroresPartida[2];
                    filasPartida[4] = erroresPartida[3];
                }
                if (contadorErrores == 4)
                {
                    filasPartida[5] = erroresPartida[4];
                    filasPartida[5] = erroresPartida[5];
                }
            }
            if (dificultad == 3)
            {
                while (contadorErrores == 7)
                {
                    if (contadorErrores == 1)
                    {
                        filasPartida[3] = erroresPartida[0];
                        filasPartida[4] = erroresPartida[1];
                    }
                    if (contadorErrores == 2)
                    {
                        filasPartida[4] = erroresPartida[2];
                        filasPartida[4] = erroresPartida[3];
                    }
                    if (contadorErrores == 3)
                    {
                        filasPartida[5] = erroresPartida[4];
                        filasPartida[5] = erroresPartida[5];
                    }
                }
            }
        }
    }

}