package Physics.Engine;

public class R1_1D {//Espacio una dimension
    protected static double X_ORIGIN = 0;//no final porque puede en algun momento requerir moverse el origen

    public static double getxOrigin(){
        return X_ORIGIN;
    }
    public static void moveXOrigin(char r_a, double desp){//movimiento relativo o absoluto
        X_ORIGIN=(r_a=='r')?X_ORIGIN+desp:desp;
    }
}
