import java.util.Arrays;

public class Main {
    private static String[][] tableroAliado = new String[12][12];
    private static String[][] tableroEnemigo = new String[12][12];
    private static String[][] tableroOculto = new String[12][12];

    private static String [][] inicializarTablero(){
        String [] linea = { "|"," "," "," "," "," "," "," "," "," "," ","|"};
        final String [] lineaSuperior= {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"};

        String [][] tableroAux = new String [12][];

        for (int i = 0; i < tableroAux.length; i++) {
            if(i == 0 || i == tableroAux.length-1)
                tableroAux[i] = lineaSuperior;
            else
                tableroAux[i] = linea.clone();
        }

        return tableroAux;
    }



    public static void main(String[] args) {
        tableroAliado = inicializarTablero();
        tableroEnemigo = inicializarTablero();
        tableroOculto = inicializarTablero();
        tableroAliado[5][11] ="A";
        for (int i = 0; i < 12; i++) {
            System.out.println("");
            for (int j = 0; j < 12; j++) {
                System.out.print(tableroAliado[i][j]);
            }
            System.out.print("   ");
            for (int j = 0; j < 12; j++) {
                System.out.print(tableroOculto[i][j]);
            }
        }
        System.out.println("");
    }
}
