public class PuntosAhorcado
{
    public PuntosAhorcado() {}
    
    private int puntosCalculados;
    private int [] puntos = new int[3];
    {
        puntos[0] = 0;
        puntos[1] = 0;
        puntos[2] = 0;
    }
    
    public void calculadoraPuntos (int dificultad, String palabra, int intentos)
    {
        this.puntosCalculados = (palabra.length() + intentos) * dificultad;
    }
    
    public void setPuntos(int partidas, int puntosCalculados)
    {
        if (partidas == 1)
        {
            puntos[0] = puntosCalculados;
        }
        if (partidas == 2)
        {
            puntos[1] = puntosCalculados;
        }
        if (partidas == 3)
        {
            puntos[2] = puntosCalculados;
        }
        if (partidas > 3)
        {
            puntos[0] = puntos[1];
            puntos[1] = puntos[2];
            puntos[2] = puntosCalculados;
        }
    }
    
    public int getPuntos1 ()
    {
        return puntos[0];
    }
    
    public int getPuntos2 ()
    {
        return puntos[1];
    }
    
    public int getPuntos3 ()
    {    
        return puntos[2];
    }
}