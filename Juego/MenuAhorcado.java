public class MenuAhorcado
{
    public MenuAhorcado() {}
    
    public void limpiaMenu()
    {
        System.out.print("\f");
        System.out.flush();
    }
    
    public void presentacionAhorcado()
    {
        System.out.println(
        "---------- El Juego del Ahorcado ---------- \n" +
        "\n    Las reglas del juego son las siguientes:" +
        "\n1.- Debes encontrar la palabra antes de que cometas el máximo de errores permitidos." +
        "\n2.- Debes introducir una letra cada vez, si esta letra existe, se mostrará en la palabra," +
        "\n       tantas veces como se encuentre en la palabra." +
        "\n3.- Si la letra que has introducido no se encuentra entre las que forman la palabra," +
        "\n       se sumará a las letras que has introducido pero que no eran válidas." + 
        "\nPISTA: Todas las palabras tienen en común que son material escolar" + "\n");
    }
    
    public void dibujaMenuAhorcado()
    {
        System.out.print("");
        
    }
}