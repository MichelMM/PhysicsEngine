package Physics.Engine;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Lienzo1 extends JPanel {

    //	Crear un color café personalizado. No se permitirá modificarlo
    private static final Color CAFE = new Color(140, 80, 40);  // (Red, Green, Blue)

    //	Sobreescribimos el método paint para modificar el dibujado original de un pánel (Gris)
//	El objeto g recibido me permitirá acceder a las funciones de pintado
    public void paint(Graphics g) {
//		Pintamos el lienzo con sus características originales: fondo blanco
        super.paint(g);
//		Esto es más barato que dibujar un rectángulo que cubra la totalidad del lienzo

//		Dibujar un rectángulo verde con x = 50, y = 70, ancho = 200, alto = 100
//		(x, y) denota la posición de la esquina superior izquierda del rectángulo
        g.setColor(Color.GREEN);
        g.fillRect(50, 70, 200, 100);

//		Dibujar un borde azul para el rectángulo anterior
        g.setColor(Color.BLUE);
        g.drawRect(50, 70, 200, 100);

//		Dibujar dos líneas horizontales que cubran la totalidad del ancho actual del pánel
//		Las líneas estarán en la mitad de la ventana
//		La línea es de color café
        g.setColor(CAFE);
        g.drawLine(0, getHeight() / 2,     getWidth(), getHeight() / 2);
        g.drawLine(0, getHeight() / 2 + 1, getWidth(), getHeight() / 2 + 1);
    }

}
