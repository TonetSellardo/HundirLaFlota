import java.sql.SQLOutput;
import java.util.Scanner;

public class Tablero {
    private String tipusVaixell;
    private String[][] tableroAliado = new String[12][12];
    private String[][] tableroEnemigo = new String[12][12];
    private String[][] tableroOculto = new String[12][12];
    private String name;
    private int respuestaUsuario;
    private int filera;
    private int columna;
    private int punts = 0;
    private int contadorAliado= 0, contadorEnemigo = 0,
            contadorFallo = 0;
    private int numeroBarcos =0;
    private boolean isOcupado = true;
    private boolean control;

    public Tablero(String name){
        this.name = name;
        crearTabler();
    }

    public void mostrarTabler() {
        System.out.println(name + "           PC");
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

    private String [][] inicializarTablero(){
        String [] linea = { "|"," "," "," "," "," ",
                " "," "," "," "," ","|"};
        final String [] lineaSuperior= {"-", "-", "-", "-",
                "-", "-", "-", "-", "-", "-", "-", "-"};
        String [][] tableroAux = {
                lineaSuperior,
                linea.clone(),
                linea.clone(),
                linea.clone(),
                linea.clone(),
                linea.clone(),
                linea.clone(),
                linea.clone(),
                linea.clone(),
                linea.clone(),
                linea.clone(),
                lineaSuperior
        };
        return tableroAux;
    }

    public void crearTabler() {
        tableroAliado = inicializarTablero();
        tableroEnemigo = inicializarTablero();
        tableroOculto = inicializarTablero();
    }

    public void comprobarPosicionSiEstaFueraDelTablero
            (int columna, int filera)
            throws FueraDelTableroExcepcion {
        if(filera < 0 || filera >= 12 ||
                columna < 0 || columna >=12) {
            throw new FueraDelTableroExcepcion();
        }
    }

    public void comprobarCoordenadasOcupadas(int columna,
                                             int filera)
    throws PosicionOcupadaExcepcion {
        if (!tableroAliado[filera][columna].equals(" ")) {
            System.out.println("Esta posició està ocupada");
            throw new PosicionOcupadaExcepcion();
        }
    }

    public void introduirCoordenadas(){
        Scanner teclado = new Scanner(System.in);
        try{
            System.out.println("Vaixell: "
                    + (numeroBarcos + 1));
            System.out.println("En quina columna el vols posar");
            columna = teclado.nextInt();
            System.out.println("En quina filera el vols posar");
            filera = teclado.nextInt();
            comprobarPosicionSiEstaFueraDelTablero
                    (columna, filera);
            comprobarCoordenadasOcupadas(columna, filera);
        } catch (Exception ex){
            introduirCoordenadas();
        }
    }

    public void introduirVaixellperTipo(String tipo){
        System.out.println("Es va a introduir el vaixells " +
                "tipus " + tipo);
        do {
            introduirCoordenadas();
            if ( !tipo.contains("A") ) {
                byte orientacion = orientacionBarco();
            }
            tableroAliado[filera][columna] = "A";
            numeroBarcos++;
            mostrarTabler();
        } while (numeroBarcos <= 3);
    }
    public void rellenarCasillasBarco(byte orientacion,String tipo,){
        switch(orientacion){
            case 1 :
                rellenarCasillasBarcoArriba();
                break;
            case 2 :
                rellenarCasillasBarcoDerecha();
                break;
            case 3 :
                rellenarCasillasBarcoAbajo();
                break;
            case 4 :
                rellenarCasillasBarcoIzquierda();
                break;
        }
    }
    private void rellenarCasillasBarcoArriba() {
        if()


    }
    private void rellenarCasillasBarcoDerecha() {
    }
    private void rellenarCasillasBarcoAbajo() {
    }

    private void rellenarCasillasBarcoIzquierda() {
    }



    public byte orientacionBarco() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige numero para orientación"
                + " del barco:\n 1: Arriba\n "
                + " 2: Derecha\n"
                + " 3: Abajo\n"
                + " 4: Izquierda");
        Byte orientacion = sc.nextByte();
        return orientacion;
    }

    public void introuirVaixellE(){
        System.out.println("Es va a introduir el vaixells " +
                "tipus A");
        do {
            introduirCoordenadas();
            tableroAliado[filera][columna] = "A";
            numeroBarcos++;
            mostrarTabler();
        } while (numeroBarcos <= 3);
    }

    public void introduirVaixell() {
        tipusVaixell = "E";
        numeroBarcos = 0;
        for (int i = 0; i < 3; i++) {
            do {
                System.out.println("Vaixell: " + tipusVaixell
                        + " " + (i + 1));
                System.out.println("En quina columna" +
                        " el vols posar");
                columna = Game.teclado.nextInt();
                System.out.println("En quina filera el vols posar");
                filera = Game.teclado.nextInt();
                System.out.println("Amb quina orientació" +
                        " el vols posar?:");
                System.out.println("[1] Cap amunt");
                System.out.println("[2] Cap abaix");
                System.out.println("[3] Cap l'esquerra");
                System.out.println("[4] Cap la dreta");
                isOcupado = true;
                respuestaUsuario = Game.teclado.nextInt();
                switch (respuestaUsuario) {
                    case 1:
                        if(filera - 1 < 0){
                            System.out.println("Posició no valida");
                            if(i != 0) {
                                i--;
                                numeroBarcos = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroAliado[filera - j][columna].equals(" ")
                                        && isOcupado) {
                                    System.out.println("Esta posició està ocupada");
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroAliado[filera - j][columna] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 2:
                        if(filera + 1 >= 12){
                            System.out.println("Posició no valida");
                            if(i != 0) {
                                i--;
                                numeroBarcos = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroAliado[filera + j][columna].equals(" ")
                                        && isOcupado) {
                                    System.out.println("Esta posició està ocupada");
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroAliado[filera + j][columna] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 3:
                        if(columna - 1 < 0){
                            System.out.println("Posició no valida");
                            if(i != 0){
                                i--;
                                numeroBarcos = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroAliado[filera][columna - j].equals(" ")
                                        && isOcupado) {
                                    System.out.println("Esta posició està ocupada");
                                    if (i != 0) {
                                        i--;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroAliado[filera][columna - j] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 4:
                        for (int j = 0; j < 2; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ")
                                    && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
                                }
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 2; j++) {
                                tableroAliado[filera][columna + j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Posició no valida");
                }
                mostrarTabler();
            } while (numeroBarcos);
        }
        tipusVaixell = "I";
        for (int i = 0; i < 2; i++) {
            do {
                System.out.println("Vaixell: " + tipusVaixell + " " + (i + 1));
                System.out.println("En quina columna el vols posar");
                columna = Game.teclado.nextInt();
                System.out.println("En quina filera el vols posar");
                filera = Game.teclado.nextInt();
                System.out.println("Amb quina orientació el vols posar?:");
                System.out.println("[1] Cap amunt");
                System.out.println("[2] Cap abaix");
                System.out.println("[3] Cap l'esquerra");
                System.out.println("[4] Cap la dreta");
                isOcupado = true;
                numeroBarcos = true;
                respuestaUsuario = Game.teclado.nextInt();
                switch (respuestaUsuario) {
                    case 1:
                        if(filera - 2 < 0){
                            System.out.println("Posició no valida");
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }
                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                    System.out.println("Esta posició està ocupada");
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroAliado[filera - j][columna] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 2:
                        if(filera + 2 >=12){
                            System.out.println("Posició no valida");
                            if(i != 0){
                                i--;
                                numeroBarcos = false;
                            }
                        }
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
                                    numeroBarcos = false;
                                }
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 3; j++) {
                                tableroAliado[filera + j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                        break;
                    case 3:
                        if(columna - 2 < 0) {
                            System.out.println("Posició no valida");
                            if(i != 0){
                                i--;
                                numeroBarcos = false;
                            }
                        }
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera][columna - j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
                                    numeroBarcos = false;
                                }
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 3; j++) {
                                tableroAliado[filera][columna - j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                        break;
                    case 4:
                        if(columna + 2 >=12){
                            System.out.println("Posició no valida");
                            if(i != 0){
                                i--;
                                numeroBarcos = false;
                            }
                        }
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ") && isOcupado || columna + 2 >=12) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
                                    numeroBarcos = false;
                                }
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 3; j++) {
                                tableroAliado[filera][columna + j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Posició no valida");
                }
                mostrarTabler();
            } while (numeroBarcos);
        }
        tipusVaixell = "O";
        do {
            System.out.println("Vaixell: " + tipusVaixell);
            System.out.println("En quina columna el vols posar");
            columna = Game.teclado.nextInt();
            System.out.println("En quina filera el vols posar");
            filera = Game.teclado.nextInt();
            System.out.println("Amb quina orientació el vols posar?:");
            System.out.println("[1] Cap amunt");
            System.out.println("[2] Cap abaix");
            System.out.println("[3] Cap l'esquerra");
            System.out.println("[4] Cap la dreta");
            isOcupado = true;
            numeroBarcos = true;
            respuestaUsuario = Game.teclado.nextInt();
            switch (respuestaUsuario) {
                case 1:
                    if(filera - 3 < 0){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroAliado[filera - j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 2:
                    if(filera + 3 >= 12){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroAliado[filera + j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 3:
                    if(columna - 3 < 0){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroAliado[filera][columna - j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroAliado[filera][columna - j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 4:
                    if(columna + 3 >= 12){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroAliado[filera][columna + j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Posició no valida");
            }
            mostrarTabler();
        } while (numeroBarcos);
        tipusVaixell = "U";
        do {
            System.out.println("Vaixell: " + tipusVaixell);
            System.out.println("En quina columna el vols posar");
            columna = Game.teclado.nextInt();
            System.out.println("En quina filera el vols posar");
            filera = Game.teclado.nextInt();
            System.out.println("Amb quina orientació el vols posar?:");
            System.out.println("[1] Cap amunt");
            System.out.println("[2] Cap abaix");
            System.out.println("[3] Cap l'esquerra");
            System.out.println("[4] Cap la dreta");
            isOcupado = true;
            numeroBarcos = true;
            respuestaUsuario = Game.teclado.nextInt();
            switch (respuestaUsuario) {
                case 1:
                    if(filera - 4 < 0){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroAliado[filera - j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 2:
                    if(filera + 4 >= 12){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroAliado[filera + j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 3:
                    if(columna - 4 < 0){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroAliado[filera][columna - j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroAliado[filera][columna - j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 4:
                    if(columna + 4 >= 12){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroAliado[filera][columna + j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Posició no valida");
            }
            mostrarTabler();
        } while (numeroBarcos);
    }

    public void introduirVaixellEnemic() {
        tipusVaixell = "A";
        for (int i = 0; i < 3; i++) {
            numeroBarcos = true;
            do {
                filera = (int) (Math.random() * 12);
                columna = (int) (Math.random() * 12);

                if (!tableroEnemigo[filera][columna].equals(" ")) {
                    System.out.println("");
                    if (i != 0) {
                        i--;
                        numeroBarcos = false;
                    }

                } else {
                    tableroEnemigo[filera][columna] = tipusVaixell;
                    numeroBarcos = false;

                }
            } while (numeroBarcos);
        }

        tipusVaixell = "E";
        for (int i = 0; i < 3; i++) {
            do {
                columna = (int) (Math.random() * 12);
                filera = (int) (Math.random() * 12);
                isOcupado = true;
                numeroBarcos = true;
                respuestaUsuario = (int) (Math.random() * 5);
                switch (respuestaUsuario) {
                    case 1:
                        if (filera - 1 < 0) {
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroEnemigo[filera - j][columna] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (filera + 1 >= 12) {
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroEnemigo[filera + j][columna] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (columna - 1 < 0) {
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroEnemigo[filera][columna - j] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (columna + 1 >= 12) {
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroEnemigo[filera][columna + j] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    default:
                        respuestaUsuario = (int) (Math.random() * 5);
                }
            } while (numeroBarcos);
        }
        tipusVaixell = "I";
        for (int i = 0; i < 2; i++) {
            do {
                columna = (int) (Math.random() * 12);
                filera = (int) (Math.random() * 12);
                isOcupado = true;
                numeroBarcos = true;
                respuestaUsuario = (int) (Math.random() * 5);
                switch (respuestaUsuario) {
                    case 1:
                        if (filera - 2 < 0) {
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }

                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroEnemigo[filera - j][columna] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (filera + 2 >= 12) {
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }

                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {

                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroEnemigo[filera + j][columna] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (columna - 2 < 0) {
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }

                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroEnemigo[filera][columna - j] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (columna + 2 >= 12) {
                            if (i != 0) {
                                i--;
                                numeroBarcos = false;
                            }

                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        numeroBarcos = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroEnemigo[filera][columna + j] = tipusVaixell;
                                    numeroBarcos = false;
                                }
                            }
                        }
                        break;
                    default:
                        respuestaUsuario = (int) (Math.random() * 5);
                }
            } while (numeroBarcos);
        }
        tipusVaixell = "O";
        do {
            columna = (int) (Math.random() * 12);
            filera = (int) (Math.random() * 12);
            isOcupado = true;
            numeroBarcos = true;
            respuestaUsuario = (int) (Math.random() * 5);
            switch (respuestaUsuario) {
                case 1:
                    if (filera - 3 < 0){
                        numeroBarcos = true;
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroEnemigo[filera - j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 2:
                    if(filera + 3 >= 12){
                        numeroBarcos = true;
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroEnemigo[filera + j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 3:
                    if(columna - 3 < 0){
                        numeroBarcos = true;
                    } else {
                        for (int j = 0; j < 3; j++) {
                            if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroEnemigo[filera][columna - j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 4:
                    if(columna + 3 >= 12){
                        numeroBarcos = true;
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroEnemigo[filera][columna + j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                default:
                    respuestaUsuario = (int) (Math.random() * 5);
            }
        } while (numeroBarcos);
        tipusVaixell = "U";
        do {
            columna = (int) (Math.random() * 12);
            filera = (int) (Math.random() * 12);
            isOcupado = true;
            numeroBarcos = true;
            respuestaUsuario = (int) (Math.random() * 5);
            switch (respuestaUsuario) {
                case 1:
                    if (filera - 4 < 0){
                        numeroBarcos = true;
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroEnemigo[filera - j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 2:
                    if(filera + 4 >= 12){
                        numeroBarcos = true;
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroEnemigo[filera + j][columna] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 3:
                    if(columna - 4 < 0){
                        numeroBarcos = true;
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroEnemigo[filera][columna - j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                case 4:
                    if(columna + 4 >= 12){
                        numeroBarcos = true;
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroEnemigo[filera][columna + j] = tipusVaixell;
                                numeroBarcos = false;
                            }
                        }
                    }
                    break;
                default:
                    respuestaUsuario = (int) (Math.random() * 5);
            }
        } while (numeroBarcos);
    }

    public void disparar(){
        numeroBarcos = true;
        do {
            System.out.println("Dime en quina columna vols disparar");
            columna = Game.teclado.nextInt();
            System.out.println("Dime en quina fila vols disparar");
            filera = Game.teclado.nextInt();
            if(columna < 0 || columna >= 12 || filera < 0 || filera >=12){
                numeroBarcos = true;
                System.out.println("Posició no valida");
            }
            else{
                numeroBarcos = false;
            }
        }while(numeroBarcos);
        if(!tableroEnemigo[filera][columna].equals(" ") && !tableroOculto[filera][columna].equals("!")){
            tableroOculto[filera][columna] = "!";
            System.out.println("HAS GOLPEJAT AL OBJECTIU!!!!! (+1 punt)");
            punts++;
        }
        else{
            tableroOculto[filera][columna] = "?";
            System.out.println("No has acertat...");
        }
        do {
            columna = (int) (Math.random() * 10)+ 1;
            filera = (int) (Math.random() * 10)+ 1;
            if (tableroAliado[filera][columna].equals("X") || tableroAliado[filera][columna].equals("?")) {
                control = true;
            } else if(!tableroAliado[filera][columna].equals(" ")){
                control = false;
                tableroAliado[filera][columna] = "X";
                System.out.println("Te han golpejat...");
            } else{
                control = false;
                System.out.println("No te han golpejat!");
            }
        }while(control);
    }

    public boolean comprobarFin(){
        for(int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (tableroAliado[i][j].equals("X")) {
                    contadorEnemigo++;
                }
                if (tableroOculto[i][j].equals("!")) {
                    contadorAliado++;
                }
            }
        }
        if(contadorAliado == 24 || contadorEnemigo == 24){
            return true;
        }
        else{
            contadorEnemigo = 0; contadorAliado = 0;
            return false;
        }
    }

    public int finalitzar(){
        contadorEnemigo = 0; contadorAliado = 0;
        for(int i = 1; i < 11; i++){
            for (int j = 1; j < 11; j++){
                if(tableroAliado[i][j].equals("X")) {
                    contadorEnemigo++;
                }
                if(tableroOculto[i][j].equals("!")){
                    contadorAliado++;
                }
                if(tableroOculto[i][j].equals("?")){
                    contadorFallo++;
                }
            }
        }
        punts += (24-contadorEnemigo);
        punts -= contadorFallo;
        return punts;
    }
}