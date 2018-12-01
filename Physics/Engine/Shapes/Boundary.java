package Physics.Engine.Shapes;
import Physics.Engine.test1;
import Physics.Engine.particula;

public class Boundary {

    private static Boundary instance = new Boundary();

    private Boundary(){

    }

    public void proUpdate(int t, particula p){
        if(p instanceof Circle){
            Circle c = (Circle)p;
            if(((c.getPosX()-c.getRadius())<=0)||((c.getPosX()+c.getRadius())>=800/test1.zoom)){//izquierdo derecho, valores cambian por el zoom
                c.setVelX(-c.getVelX());
            }
            if(((c.getPosY()+c.getRadius())>=600/test1.zoom)||((c.getPosY()-c.getRadius())<=0)){
                c.setVelY(-c.getVelY());
            }
        }
    }

    public static Boundary getInstance(){
        return instance;
    }

}
