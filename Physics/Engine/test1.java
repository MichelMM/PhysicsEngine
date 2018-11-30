package Physics.Engine;

import Physics.Engine.Shapes.Circle;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class test1 extends JPanel {

    //	Crear un color café personalizado. No se permitirá modificarlo
    //private static final Color MORADO = new Color(80, 80, 200);  // (Red, Green, Blue)
    public Circle carro = new Circle(100,150);
    public Circle carro2 = new Circle(100,150,20,0);
    public Circle carro3 = new Circle(100,150,28,0);
    public int v_sim =1;
    //	Sobreescribimos el método paint para modificar el dibujado original de un pánel (Gris)
//	El objeto g recibido me permitirá acceder a las funciones de pintado

    public static void drawShape(particula p, Graphics g){
        g.setColor(p.getColor());
        if(p instanceof Circle){
            Circle circle = (Circle)p;
            g.fillOval((int)(circle.getPosX()*20),510-(int)(circle.getPosY()*20),(int)circle.getRadius(),(int)circle.getRadius());
        }
    }
    
    public static void colision(int t,Circle ...circulos) {
    	ArrayList<Circle> figuras= new ArrayList<>() ;
    	for(Circle c:circulos) {
    		figuras.add(c);
    	}
    	for(int i=0;i<figuras.size();i++) {
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
        //Agregar aqui nuevos elementos
        //g.fillOval((int)(carro.getPosX()*20),510-(int)(carro.getPosY()*20),50,50);
        
        
       /*carro.proUpdate(2333*v_sim,carro2);
        carro2.update(2333*v_sim);*/
        colision(8333, carro,carro2, carro3);


    }

}
