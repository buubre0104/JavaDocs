package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by user on 6/30/2016.
 */
public class Circle extends Shape{
    int xPos,yPos,radius;

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = 1;
        this.yPos = 2;
        this.radius = 3;
    }

    public Circle(int xPos) {
        this.xPos = 1;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = 2;
        this.yPos = 3;

    }

    public Circle() {
        this.yPos = 10;
        this.xPos = 20;
        this.radius = 30;
    }
    @Override
    public double area(){
        return PI*3;
    }
    @Override
    public String toString(){
        return ("center=( "+this.xPos+","+this.yPos+") and radius="+this.radius);
    }

    public void fillColor(){
         System.out.println(super.color);
    }
    public void fillColor(int p){
       super.color=p;
        System.out.println("The circle color is now: "+ super.color);
    }
    public void fillColor(float f){
        super.saturation=f;
        System.out.println("The circle saturation is now: "+ super.saturation);
    }

    public void getAreaDef(){
        Circle c = new Circle();
        c.fillColor();
        c.fillColor(10);
        c.fillColor((float)1.1);
    }

}
