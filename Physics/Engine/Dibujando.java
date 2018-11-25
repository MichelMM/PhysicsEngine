package Physics.Engine;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

// La clase a desarrollar heredará las características de toda ventana (JFrame)
public class Dibujando extends JFrame {

    //	El lienzo del juego.
    private Lienzo1 lienzo = new Lienzo1();

    public Dibujando() {
//		Llamada al constructor de JFrame que recibe el título
        super("Dibujando en una ventana");

//		Establecer el tamaño en pixeles: ancho, alto
        setSize(800, 600);

//		Centrar la ventana con respecto al escritorio
        setLocationRelativeTo(null);

//		Cuando se presione el botón cerrar o Alt+F4, termina la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		Que no se permita el cambio de tamaño de la ventana
//		setResizable(false);

//		Quitarle los bordes a la ventana
//		setUndecorated(true);

//		Accedemos al contenedor principal de la ventana (para pintar sobre él)
        Container c = getContentPane();

//		El lienzo del juego tendrá fondo blanco
        lienzo.setBackground(Color.WHITE);

//		Agregamos el lienzo que dibuja el juego al contenedor principal
//		El lienzo ocupará todo el espacio del contenedor
//		A su vez, el tamaño del contenedor estará en función del tamaño de la ventana
        c.add(lienzo);

//		Cuando ya esté lista la ventana, se muestra
        setVisible(true);
    }


    public static void main(String[] args) {
//		Crear/mostrar la ventana.
        new Dibujando();
//		No es necesario asignar el objeto a una variable porque no se va a utilizar
    }

}
