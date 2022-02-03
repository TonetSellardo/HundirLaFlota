import java.lang.Math;

public class PalabrasAhorcado
{
    public PalabrasAhorcado() {}
    
    private String palabra;
    private int numeroAleatorio;
    
    private String [] palabrasAhorcado = new String [15];
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
        palabrasAhorcado[10] = "AGENDA";
        palabrasAhorcado[11] = "PUPITRE";
        palabrasAhorcado[12] = "PIZARRA";
        palabrasAhorcado[13] = "CHINCHETA";
        palabrasAhorcado[14] = "SUBRAYADOR";
    }
    
    private char [] letrasAhorcado = new char [55];
    {
        letrasAhorcado[0] = 'A';
        letrasAhorcado[1] = 'B';
        letrasAhorcado[2] = 'C';
        letrasAhorcado[3] = 'D';
        letrasAhorcado[4] = 'E';
        letrasAhorcado[5] = 'F';
        letrasAhorcado[6] = 'G';
        letrasAhorcado[7] = 'H';
        letrasAhorcado[8] = 'I';
        letrasAhorcado[9] = 'J';
        letrasAhorcado[10] = 'K';
        letrasAhorcado[11] = 'L';
        letrasAhorcado[12] = 'M';
        letrasAhorcado[13] = 'N';
        letrasAhorcado[14] = 'Ñ';
        letrasAhorcado[15] = 'O';
        letrasAhorcado[16] = 'P';
        letrasAhorcado[17] = 'Q';
        letrasAhorcado[18] = 'R';
        letrasAhorcado[19] = 'S';
        letrasAhorcado[20] = 'T';
        letrasAhorcado[21] = 'U';
        letrasAhorcado[22] = 'V';
        letrasAhorcado[23] = 'W';
        letrasAhorcado[24] = 'X';
        letrasAhorcado[25] = 'Y';
        letrasAhorcado[26] = 'Z';
        letrasAhorcado[27] = 'a';
        letrasAhorcado[28] = 'b';
        letrasAhorcado[29] = 'c';
        letrasAhorcado[30] = 'd';
        letrasAhorcado[31] = 'e';
        letrasAhorcado[32] = 'f';
        letrasAhorcado[33] = 'g';
        letrasAhorcado[33] = 'h';
        letrasAhorcado[34] = 'i';
        letrasAhorcado[35] = 'j';
        letrasAhorcado[36] = 'k';
        letrasAhorcado[37] = 'l';
        letrasAhorcado[38] = 'm';
        letrasAhorcado[39] = 'n';
        letrasAhorcado[40] = 'ñ';
        letrasAhorcado[41] = 'o';
        letrasAhorcado[42] = 'p';
        letrasAhorcado[43] = 'q';
        letrasAhorcado[44] = 'r';
        letrasAhorcado[45] = 's';
        letrasAhorcado[46] = 't';
        letrasAhorcado[47] = 'u';
        letrasAhorcado[48] = 'v';
        letrasAhorcado[49] = 'w';
        letrasAhorcado[50] = 'x';
        letrasAhorcado[51] = 'y';
        letrasAhorcado[52] = 'z';
        
        letrasAhorcado[53] = 'Ç';
        letrasAhorcado[54] = 'ç';
    }
    
    public String escogePalabra()
    {
        numeroAleatorio = (int) (Math.random()*15+0);
        palabra = palabrasAhorcado[numeroAleatorio];
        return palabra;
    }
    
    public void detallesPalabra(String palabra, int errores, String letras, int intentos) 
    { 
        System.out.print("La palabra es: ");
        for (int i = 0; i < palabra.length(); i++) { System.out.print("_"); }
        System.out.println("");
        System.out.println("Has cometido " + errores + " errores.");
        System.out.println("Has introducido las siguientes letras erroneas: " + letras);
        System.out.println("Te quedan " + intentos + "intentos disponibles.");
    }
}