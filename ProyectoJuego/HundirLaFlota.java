import java.util.Scanner;

public class HundirLaFlota 
{
    //Atributos de la clase

    //Constructor de la clase
	public HundirLaFlota() {}

    //Métodos de la clase
    public void nuevoAhorcado()
    {
        //Instrucciones iniciales

        //Dibujar el mapa
        String[][] casillasTablero = new String[10][10];
        String [] letrasTablero = new String [10];
        String [] numerosTablero = new String [10];
        letrasTablero[0] = "  A  ";
        letrasTablero[1] = "  B  ";
        letrasTablero[2] = "  C  ";
        letrasTablero[3] = "  D  ";
        letrasTablero[4] = "  E  ";
        letrasTablero[5] = "  F  ";
        letrasTablero[6] = "  G  ";
        letrasTablero[7] = "  H  ";
        letrasTablero[8] = "  I  ";
        letrasTablero[9] = "  J  ";
        numerosTablero[0] = " 1 ";
        numerosTablero[1] = " 2 ";
        numerosTablero[2] = " 3 ";
        numerosTablero[3] = " 4 ";
        numerosTablero[4] = " 5 ";
        numerosTablero[5] = " 6 ";
        numerosTablero[6] = " 7 ";
        numerosTablero[7] = " 8 ";
        numerosTablero[8] = " 9 ";
        numerosTablero[9] = "10 ";
        System.out.print("   ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(letrasTablero[i]);
            if (i == 9)
            {
                System.out.println("");    
            }
        }
        for (int i = 0; i < 10; i++)
        {
            System.out.print(numerosTablero[i]);
            for (int j = 0; j < 10; j++)
            {
                casillasTablero[i][j] = " [ ] ";
                System.out.print(casillasTablero[i][j]);
                if (j == 9)
                {
                    System.out.println("");
                }
            }
        }
    }
}