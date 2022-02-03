public class Ahorcado
{
    public static void main (String [] args)
    {
        int x = 1;
        int erroresPermitidos = 0;
        int dificultadEscogida = 0;
        int dificultadComprobada = 0;
        int erroresCometidos = 0;
        int tamañoPalabraEscogida = 0;
        String palabraEscogidaAzar;
        
        MenuAhorcado menu = new MenuAhorcado();
        DibujoAhorcado dibujo = new DibujoAhorcado();
        PuntosAhorcado puntos = new PuntosAhorcado();
        PalabrasAhorcado palabras = new PalabrasAhorcado();
        DificultadAhorcado dificultad = new DificultadAhorcado();
        
        
        menu.presentacionAhorcado();
        dificultad.escogeDificultad();
        dificultadEscogida = dificultad.getDificultad();
        while (x == 1)
        {
            dificultadComprobada = dificultad.compruebaDificultad(dificultadEscogida);
            if (dificultadComprobada == 0)
            {
                menu.limpiaMenu();
                System.out.println("Has introducido mal el valor de la dificultad. Introducelo de nuevo");
                dificultad.escogeDificultad();
                dificultadEscogida = dificultad.getDificultad();
            }
            else if (dificultadComprobada > 0)
            {
                x = 2;
            }
        }
        x = 1;
        
        if (dificultadComprobada == 1)
        {
            menu.limpiaMenu();
            erroresPermitidos = 9;
            System.out.println("Has escogido la dificultad Facil. Jeje, que blandengue.");
        }
        
        if (dificultadComprobada == 2)
        {
            menu.limpiaMenu();
            erroresPermitidos = 6;
            System.out.println("Has escogido la dificultad Media. Bueno, no está mal.");
        }
        
        if (dificultadComprobada == 3)
        {
            menu.limpiaMenu();
            erroresPermitidos = 3;
            System.out.println("Has escogido la dificultad Dificil. Así me gusta, poniendole ganas al asunto.");
        }
        //Ejecución del juego
        /*while (x == 1)
        {
            palabraEscogidaAzar = palabras.escogePalabra();
            tamañoPalabraEscogida = palabraEscogidaAzar.length();
            dibujo.dibujaHorca();
            //palabras.detallesPalabra(palabraEscogidaAzar);
        }*/
    }
}