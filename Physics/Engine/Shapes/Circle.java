package Physics.Engine.Shapes;
import Physics.Engine.Vector;
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
    	//Nota* pro update se corre más de una vez a la que necesitamos o algo así
    	double e = 1;
        this.update(t);
        double dx = this.getPosX()-c.getPosX();
        double dy = this.getPosY()-c.getPosY();
        double dist = Math.sqrt(dx*dx+dy*dy);
        if(dist<=this.getRadius()*.0241+c.getRadius()*.0241){
            this.setColor(0,255,0);
        	Vector nor = new Vector(this.getPosX(),this.getPosY());
            nor.restaV(c.getPos());
            nor.unitarioV();
            
            double vel1p = nor.pPoint(this.getVel());
            double vel2p = nor.pPoint(c.getVel());
            
            double velP1p = ((this.getMasa()-e*c.getMasa())*vel1p + (1+e)*c.getMasa()*vel2p)/(this.getMasa()+c.getMasa());
            double velP2p = ((c.getMasa()-e*this.getMasa())*vel2p + (1+e)*this.getMasa()*vel1p)/(this.getMasa()+c.getMasa());
            
            Vector velP1 = new Vector(this.getVelX(),this.getVelY());            
            Vector velP2 = new Vector(c.getVelX(),c.getVelY());
            
            velP1.sumaV(new Vector((velP1p - vel1p)*nor.getX(),(velP1p - vel1p)*nor.getY()));
            velP2.sumaV(new Vector((velP2p - vel2p)*nor.getX(),(velP2p - vel2p)*nor.getY()));
            
            System.out.printf("Carro1		: %f i, %f j\n",this.getVelX(),this.getVelY());
            System.out.printf("Carro2		: %f i, %f j\n",c.getVelX(),c.getVelY()); 
            System.out.printf("Normalizado	: %f i, %f j\n",nor.getX(),nor.getY());
            System.out.printf("V1p : %f, V2p : %f\n",vel1p,vel2p);
            System.out.printf("V'1p: %f, V'2p: %f\n",velP1p,velP2p);
            System.out.printf("V'1			: %f i, %f j\n",velP1.getX(),velP1.getY());
            System.out.printf("V'2			: %f i, %f j\n",velP2.getX(),velP2.getY());
            
            this.setVelX(velP1.getX());
            this.setVelY(velP1.getY());
            
            c.setVelX(velP2.getX());
            c.setVelY(velP2.getY());
            
        }
    }
}
