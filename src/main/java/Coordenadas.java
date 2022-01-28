public class Coordenadas {
    public final static int NUMEROCOLUMNASTABLERO = 10;
    public final static int NUMEROFILASTABLERO = 10;
    private int origenX;
    private int origenY;


    public Coordenadas(int origenX, int origenY) throws FueraDelTableroExcepcion {
        if ( origenX < 0 || origenX >= NUMEROCOLUMNASTABLERO ) {
            throw new FueraDelTableroExcepcion();
        }
        if ( origenY < 0 || origenY >= NUMEROFILASTABLERO ) {
            throw new FueraDelTableroExcepcion();
        }
        this.origenX = origenX;
        this.origenY = origenY;
    }

    public int getOrigenX() {
        return origenX;
    }

    public int getOrigenY() {
        return origenY;
    }
}
