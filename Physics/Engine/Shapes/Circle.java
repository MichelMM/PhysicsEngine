package Physics.Engine.Shapes;
import Physics.Engine.particula;

import java.awt.*;

public class Circle extends particula {
    //protected static final Color MORADO = new Color(80, 80, 200);  // (Red, Green, Blue)
    private double radius = 1;

    public Circle(){
        this(1);
    }

    public Circle(double radius){
        super();
        setRadius(radius);
    }

    public Circle(double radius, double masa){
        super(masa);
        setRadius(radius);
    }

    public Circle(double radius, double masa,double x, double y){
        super(x,y,masa);
        setRadius(radius);
    }

    public void setRadius(double r){
        if(r<=0)this.radius =1;
        this.radius = r;
    }

    public double getRadius(){
        return this.radius;
    }

    public void proUpdate(int t, Circle c){
        this.update(t);
        double dx = this.getPosX()-c.getPosX();
        double dy = this.getPosY()-c.getPosY();
        double dist = Math.sqrt(dx*dx+dy*dy);
        if(dist<=this.getRadius()*.0375+c.getRadius()*.0375){
            this.setColor(0,255,0);
        }
    }
}
