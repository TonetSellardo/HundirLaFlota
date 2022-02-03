import java.util.Scanner;

public class DificultadAhorcado
{
    public DificultadAhorcado() {}
    
    private int dificultad;
    Scanner sc = new Scanner(System.in);
    
    public void escogeDificultad()
    {
        System.out.println("Escoge el nivel de dificultad que deseas:"+
        "\nPulsa 1 para dificultad facil: 9 intentos"+
        "\nPulsa 2 para dificultad media: 6 intentos"+
        "\nPulsa 3 para dificultad dificil: 3 intentos");
        dificultad = sc.nextInt();
    }
    
    public void cambiaDificultad()
    {
        System.out.println("¿Te arrepientes? ¿Era muy dificil? ¿O quizás pan comido y te las dabas de listo?" +
        "\nSea como sea, escoge de nuevo el nivel de dificultad que deseas:"+
        "\nRecuerda ->"+
        "\nPulsa 1 para dificultad facil: 9 intentos"+
        "\nPulsa 2 para dificultad media: 6 intentos"+
        "\nPulsa 3 para dificultad dificil: 3 intentos");
        dificultad = sc.nextInt();
    }
    
    public int compruebaDificultad(int dificultadEscogida)
    {
        if (dificultadEscogida >= 1 && dificultadEscogida <= 3)
        {
            return dificultadEscogida;
        }
        else
        {
            return 0;
        }
    }
    
    public void setDificultad(int dificultad)
    {
        this.dificultad = dificultad;
    }
    
    public int getDificultad()
    {
        return dificultad;
    }
}