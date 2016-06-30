package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by user on 6/30/2016.
 */
public class RunApp {
    public static void main(String[] args){
        Circles b = new Circles();
        System.out.println("the default circle area is:"+b.getAreaPub());
        System.out.println("-------------------------------------------");
        Circle a = new Circle();
        a.getAreaDef();
        System.out.println("-------------------------------------------");
        Canvas c = new Canvas();
        c.getArea();
        System.out.println("-------------------------------------------");
        Shape s =new Shape();
        s = new Circle(10);
        System.out.println("shape area is:"+s.area());
        System.out.println("-------------------------------------------");
        ShapeBehaviour n;
        n = new Square(10);
        System.out.println("shapebehaviour area is:"+n.area());
        System.out.println("-------------------------------------------");
        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));


    }
}
