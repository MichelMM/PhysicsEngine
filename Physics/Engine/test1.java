package Physics.Engine;

import Physics.Engine.Shapes.Boundary;
import Physics.Engine.Shapes.Circle;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class test1 extends JPanel {

    //	Crear un color café personalizado. No se permitirá modificarlo
    //private static final Color MORADO = new Color(80, 80, 200);  // (Red, Green, Blue)
    public Circle carro = new Circle(2,150,3,3);
    public Circle carro2 = new Circle(4,150,23,5);
    public Circle carro3 = new Circle(4,150,31,5);
    public Circle carro4 = new Circle(10,150,31,40);
    public Boundary borde = Boundary.getInstance();
    public int v_sim =1;
    public static int zoom=1;
    //	Sobreescribimos el método paint para modificar el dibujado original de un pánel (Gris)
//	El objeto g recibido me permitirá acceder a las funciones de pintado

    public static void drawShape(particula p, Graphics g){
        g.setColor(p.getColor());
        if(p instanceof Circle){
            Circle circle = (Circle)p;
            //el primer 2 es por ser el radio y el segundo es el factor de escala de pixeles a metros
            //se le resta a la posicion porque la coordenada no es el centro del circulo, es una esquina
            g.fillOval((int)((circle.getPosX()-circle.getRadius())*zoom),600-(int)((circle.getPosY()+circle.getRadius())*zoom),(int)circle.getRadius()*zoom*2,(int)circle.getRadius()*zoom*2);
        }
    }

    public static void colision(int t,Boundary borde,Circle ...circulos) {
        ArrayList<Circle> figuras= new ArrayList<>() ;
        for(Circle c:circulos) {
            figuras.add(c);
        }
        for(int i=0;i<figuras.size();i++) {
            borde.proUpdate(t,figuras.get(i));
            for(int j=i+1;j<figuras.size();j++) {
                figuras.get(i).proUpdate(t, figuras.get(j));
                figuras.get(j).update(t);
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        //g.setColor(MORADO);
        drawShape(carro,g);
        drawShape(carro2,g);
        drawShape(carro3,g);
        drawShape(carro4,g);
        //Agregar aqui nuevos elementos
        //g.fillOval((int)(carro.getPosX()*20),510-(int)(carro.getPosY()*20),50,50);


       /*carro.proUpdate(2333*v_sim,carro2);
        carro2.update(2333*v_sim);*/
        colision(8333,borde,carro,carro2,carro3,carro4);//Original 8333


    }

}
