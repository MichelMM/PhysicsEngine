package Physics.Engine;

import Physics.Engine.Shapes.Circle;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

// La clase a desarrollar heredará las características de toda ventana (JFrame)
public class TestDibujo extends JFrame {

    //	El lienzo del juego.
    public test1 lienzo = new test1();

    public TestDibujo() {
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
        TestDibujo n=new TestDibujo();

        n.lienzo.carro.setVel(20,45);
        n.lienzo.carro.setColor(200,10,10);
        n.lienzo.carro2.setVel(20,130);
        n.lienzo.carro3.setVel(20, 90);

        n.lienzo.v_sim=1;

        int tiempo = (3_800_000/8333);
        particula.busyWaitMicros(150_000);//Esperar a que cargue
         for(int i=0;i<tiempo;i=i+n.lienzo.v_sim){
            particula.busyWaitMicros(8333);//velocidad de simulacion tiempo real es 100 arriba de 1500 es aceptable, en 2500 ya es estable
             n.lienzo.repaint();
        }
        System.out.println(n.lienzo.carro);


//		No es necesario asignar el objeto a una variable porque no se va a utilizar
    }

}
