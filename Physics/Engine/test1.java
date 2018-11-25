package Physics.Engine;

import Physics.Engine.Shapes.Circle;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class test1 extends JPanel {

    //	Crear un color café personalizado. No se permitirá modificarlo
    //private static final Color MORADO = new Color(80, 80, 200);  // (Red, Green, Blue)
    public Circle carro = new Circle(50,1500);
    public Circle carro2 = new Circle(30,1500,20,2);
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

    public void paint(Graphics g) {
        super.paint(g);
        //g.setColor(MORADO);
        drawShape(carro,g);
        drawShape(carro2,g);
        //Agregar aqui nuevos elementos
        //g.fillOval((int)(carro.getPosX()*20),510-(int)(carro.getPosY()*20),50,50);
        carro.proUpdate(8333*v_sim,carro2);
        carro2.proUpdate(8333*v_sim,carro);


    }

}
