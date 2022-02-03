public class DibujoAhorcado
{
    public DibujoAhorcado() {}
    
    private String [] filasHorca = new String [10];
    {
        filasHorca[0] = "    |              ";
        filasHorca[1] = "    |              ";
        filasHorca[2] = "    |              ";
        filasHorca[3] = "    |              ";
        filasHorca[4] = "    |              ";
        filasHorca[5] = "    |              ";
        filasHorca[6] = "    |              ";
        filasHorca[7] = "    |              ";
        filasHorca[8] = "    |              ";
        filasHorca[9] = "---------          ";
    }
    
    private String [] erroresFilasAhorcado = new String [9];
    {
        erroresFilasAhorcado[0] = "    |-----------|  ";
        erroresFilasAhorcado[1] = "    |           |  ";
        erroresFilasAhorcado[2] = "    |           |  ";
        erroresFilasAhorcado[3] = "    |           O  ";
        erroresFilasAhorcado[4] = "    |           V  ";
        erroresFilasAhorcado[5] = "    |          ¡V  ";
        erroresFilasAhorcado[6] = "    |          ¡V¡ ";
        erroresFilasAhorcado[7] = "    |          (   ";
        erroresFilasAhorcado[8] = "    |          ( ) ";
    }
    
    public void dibujaHorca() { for (int i = 0; i < 10; i++) { System.out.println(filasHorca[i]);  } }
    
    public void dibujaError (int error)
    {
        switch(error) 
        {
            case 1:
                System.out.println(erroresFilasAhorcado[0]);
                for (int i = 1; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            case 2:
                System.out.println(erroresFilasAhorcado[0]);
                System.out.println(erroresFilasAhorcado[1]);
                for (int i = 2; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            case 3:
                System.out.println(erroresFilasAhorcado[0]);
                System.out.println(erroresFilasAhorcado[1]);
                System.out.println(erroresFilasAhorcado[2]);
                for (int i = 3; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            case 4: //Este pinta la cabeza
                System.out.println(erroresFilasAhorcado[0]);
                System.out.println(erroresFilasAhorcado[1]);
                System.out.println(erroresFilasAhorcado[2]);
                System.out.println(erroresFilasAhorcado[3]);
                for (int i = 4; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            case 5: //Este pinta el cuerpo
                System.out.println(erroresFilasAhorcado[0]);
                System.out.println(erroresFilasAhorcado[1]);
                System.out.println(erroresFilasAhorcado[2]);
                System.out.println(erroresFilasAhorcado[3]);
                System.out.println(erroresFilasAhorcado[4]);
                for (int i = 5; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            case 6:
                System.out.println(erroresFilasAhorcado[0]);
                System.out.println(erroresFilasAhorcado[1]);
                System.out.println(erroresFilasAhorcado[2]);
                System.out.println(erroresFilasAhorcado[3]);
                System.out.println(erroresFilasAhorcado[5]);
                for (int i = 5; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            case 7:
                System.out.println(erroresFilasAhorcado[0]);
                System.out.println(erroresFilasAhorcado[1]);
                System.out.println(erroresFilasAhorcado[2]);
                System.out.println(erroresFilasAhorcado[3]);
                System.out.println(erroresFilasAhorcado[6]);
                for (int i = 5; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            case 8:
                System.out.println(erroresFilasAhorcado[0]);
                System.out.println(erroresFilasAhorcado[1]);
                System.out.println(erroresFilasAhorcado[2]);
                System.out.println(erroresFilasAhorcado[3]);
                System.out.println(erroresFilasAhorcado[6]);
                System.out.println(erroresFilasAhorcado[7]);
                for (int i = 6; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            case 9:
                System.out.println(erroresFilasAhorcado[0]);
                System.out.println(erroresFilasAhorcado[1]);
                System.out.println(erroresFilasAhorcado[2]);
                System.out.println(erroresFilasAhorcado[3]);
                System.out.println(erroresFilasAhorcado[6]);
                System.out.println(erroresFilasAhorcado[8]);
                for (int i = 6; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
            default:
                for (int i = 0; i < 10; i++) { System.out.println(filasHorca[i]); }
                break;
        }
    }
}