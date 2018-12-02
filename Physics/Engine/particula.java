package Physics.Engine;

import Physics.Engine.R2_2D;

import java.awt.*;

public class particula {//se debe de volver abstracta, no debe de haber nada static

    //    private double posX;//posicion relativa al origen, metros
//    private double posY;//posicion relativa al origen, metros
//    private double velX=0;//velocidad, metros/s
//    private double velY=0;//velocidad, metros/s
//    private double accX=0;//aceleracion, m/s^2
//    private double accY=0;//aceleracion, m/s^2
//    private double forX=0;//fuerza, N
//    private double forY=0;//fuerza, N
    private Vector pos = new Vector();
    private Vector vel = new Vector();
    private Vector acc = new Vector();
    private Vector forc= new Vector();
    private double masa=0;//masa candidata a ser final, kg
    private Color color = new Color(80, 80, 200);


    public particula(){
        pos.setX(R2_2D.getxOrigin());
        pos.setY(R2_2D.getyOrigin());
    }

    public particula(double masa){
        this();
        setMasa(masa);
    }

    public particula(double posX, double posY, double masa){
        this(masa);
        this.pos.setX(posX);
        this.pos.setY(posY);
    }

    public void update(int time){//funcion actualizar particula
        //a=F/m
        this.acc.setX(this.forc.getX()/this.masa);
        this.acc.setY((this.forc.getY()/this.masa)-(9.81));//considerar gravedad como negativa, para abajo
        /*
        Y+
        ^
        |
        |
        |
        *----------->X+
         */

        //velocidad
        this.vel.setX(this.vel.getX()+this.acc.getX()*time/1000_000);
        this.vel.setY(this.vel.getY()+this.acc.getY()*time/1000_000);

        //posicion
        this.pos.setX(this.pos.getX()+this.vel.getX()*time/1000_000);
        this.pos.setY(this.pos.getY()+this.vel.getY()*time/1000_000);
    }

    public void move(char r_a, double despX, double despY){//movimiento relativo o absoluto
        this.pos.setX((r_a=='r')?this.pos.getX()+despX:despX);
        this.pos.setY((r_a=='r')?this.pos.getY()+despX:despX);
    }

    public void sumForX(double forX){
        setForX(getForX()+forX);
    }

    public void sumForY(double forY){
        setForY(getForY()+forY);
    }

    public void sumFor(double mag, double dir){
        setForX(getForX()+(mag*Math.cos(dir)));
        setForY(getForY()+(mag*Math.sin(dir)));
    }

    public double getPosX(){
        return this.pos.getX();
    }

    public double getPosY(){
        return this.pos.getY();
    }

    public Vector getPos() {
        return new Vector(this.getPosX(),this.getPosY());
    }

    public double getMasa(){
        return masa;
    }

    public double getVelX(){
        return this.vel.getX();
    }

    public double getVelY(){
        return this.vel.getY();
    }

    public Vector getVel() {
        return new Vector(this.getVelX(),this.getVelY());
    }

    public double getAccX(){
        return this.acc.getX();
    }

    public double getAccY(){
        return this.acc.getY();
    }


    public double getForX(){
        return this.forc.getX();
    }

    public double getForY(){
        return this.forc.getY();
    }

    public void setVelX(double velX){//fuerza el cambio
        this.vel.setX(velX);
    }

    public void setAccX(double accX){//fuerza cambio
        this.acc.setX(accX);
    }

    public void setForX(double forX){//fuerza cambio
        this.forc.setX(forX);
    }

    public void setVelY(double velY){//fuerza el cambio
        this.vel.setY(velY);
    }

    public void setVel(double mag, double dir){
        setVelX(mag*Math.cos(dir*Math.PI/180));
        setVelY(mag*Math.sin(dir*Math.PI/180));
    }

    public void setAccY(double accY){//fuerza cambio
        this.acc.setY(accY);
    }

    public void setForY(double forY) {//fuerza cambio
        this.forc.setY(forY);
    }

    public void setMasa(double masa){
        if(masa>0)this.masa=masa;
    }

    public static void busyWaitMicros(long micros){
        long waitUntil = System.nanoTime() + (micros * 1_000);
        while(waitUntil > System.nanoTime()){
        }//http://www.rationaljava.com/2015/10/measuring-microsecond-in-java.html
    }

    public void setColor(int r, int g, int b){
        this.color = new Color(r,g,b);
    }

    public Color getColor(){
        return this.color;
    }

    @Override
    public String toString(){
        return String.format("Posicion: (%.2f, %.2f)\nVelocidad: (%.2f, %.2f)\nAceleracion: (%.2f, %.2f)\nFuerza: (%.2f, %.2f)\nMasa: %.2f",pos.getX(),pos.getY(),vel.getX(),vel.getY(),acc.getX(),acc.getY(),forc.getX(),forc.getY(),masa);
    }

    /*public static void main(String[] args){
        particula carro = new particula(1500);
        //carro.sumForX(14715);
        //carro.setVelY(20);
        carro.setVel(20,70);
        System.out.println(System.nanoTime());
        for(int i=0;i<3_8000;i++){
            //busyWaitMicros(100);//velocidad de simulacion tiempo real es 100
            carro.update(100);
        }
        System.out.println(carro);
        System.out.println(System.nanoTime());
    }*/
}
