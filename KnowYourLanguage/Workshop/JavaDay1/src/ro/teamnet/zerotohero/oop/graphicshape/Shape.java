package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 6/30/2016.
 */
public class Shape extends AbstractShape implements ShapeBehaviour {
    protected int color;
    protected float saturation;

    public void setColor(int color){
       this.color=color;
    }
    public void setSaturation(float saturation){
        this.saturation=saturation;
    }
//    public double area(){
//         return this.color+this.saturation;
//    }


    @Override
    public double area() {
        return super.area();
    }
}
