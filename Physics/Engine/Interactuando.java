package Physics.Engine;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Interactuando extends JFrame {

    private Lienzo2 lienzo = new Lienzo2();

    public Interactuando() {
        super("Interactuando con una ventana");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Container c = getContentPane();
        lienzo.setBackground(Color.WHITE);
        c.add(lienzo);
//		Asociamos el objeto chismoso a la ventana para que el objeto
//		escuche los teclazos efectuados sobre la ventana
        addKeyListener(teclazos);
//		Si lo hubiéramos asociado al lienzo no detectaríamos teclazos, porque el pánel no es "Enfocable"

//		Asociamos el otro objeto chismoso al lienzo del juego para que
//		escuche las pulsaciones del ratón efectuados sobre el lienzo
        lienzo.addMouseListener(ratonazos);
//		Si lo hubiéramos asociado a la ventana, las coordenadas estarían desfasadas: por los bordes

        setVisible(true);
    }

    //	Creamos un objeto "chismoso" con la capacidad de detectar los teclazos
//	KeyListener es una interfaz que DEFINE 3 métodos
//	teclazos es un objeto que pertenece a una clase ANÓNIMA que IMPLEMENTA a la interfaz KeyListener
//	La clase anónima se compromete a implementar los 3 métodos
    KeyListener teclazos = new KeyListener() {
        //		Se presionó una tecla. Incluye teclas especiales.
        public void keyPressed(KeyEvent e) {
//			Qué tecla se presionó
            int code = e.getKeyCode();
            if(code == KeyEvent.VK_RIGHT)     lienzo.moveRight();
            else if(code == KeyEvent.VK_LEFT) lienzo.moveLeft();
            else if(code == KeyEvent.VK_UP)   lienzo.moveUp();
            else if(code == KeyEvent.VK_DOWN) lienzo.moveDown();
        }
        //		Se liberó una tecla. Incluye teclas especiales
        public void keyReleased(KeyEvent e) {

        }
        //		Presionar + liberar. Sólo para las teclas normales: letras, dígitos, símbolos.
        public void keyTyped(KeyEvent e) {

        }
    };

    //	Creamos otro objeto "chismoso" con la capacidad de detectar el mouse
//	MouseListener es una interfaz que DEFINE 5 métodos
//	Si sólo nos interesa implementar uno o dos métodos, podemos utilizar MouseAdapter en su lugar.
//	ratonazos es un objeto que pertenece a una clase ANÓNIMA que EXTIENDE a la clase MouseAdapter
//	La clase anónima ya no se compromete los 6 métodos porque MouseAdapter ya lo hizo (en blanco)
    MouseAdapter ratonazos = new MouseAdapter() {
        //		Se presionó algún botón del ratón. Aún no se libera
        public void mousePressed(MouseEvent e) {
//			Sólo me interesa el botón izquierdo
            int btn = e.getButton();
            if(btn != MouseEvent.BUTTON1) return;
//			Si es doble o triple click, no me interesa
            if(e.getClickCount() > 1) return;
//			En dónde se pulsó para colocar al rectángulo ahí
            lienzo.move(e.getX(), e.getY());
        }
    };


    public static void main(String[] args) {
        new Interactuando();
    }

}
