package c21376161;

import processing.core.PApplet;
import processing.core.PShape;

public class DuckVortex {
    private PShape Duck;
    private PApplet p;
    private float Rotator;

    public DuckVortex(PApplet p, PShape Duck){
        this.p = p;
        this.Duck = Duck;
        Rotator = 0;
    }

    public void Render(){
        p.pushMatrix();
        Duck.setStroke(false);
        //Duck.setStroke(p.color(0, 255, 0, 1)); // needs to be different from black
        Duck.setStrokeWeight(1.2f); // if the weight is too small, the stroke won't be visible (it will be occluded by the faces of the object (strokes in 3D can be tricky).
        Duck.setFill(p.color(255, 255, 0));
        p.shape(Duck);
        //p.rotate(Rotator,0,0,0.1f);
        Rotator+= 0.01f;
        //Rotator %= PApplet.TWO_PI;
        Ring(10,10,1);
        p.rotateY(PApplet.sin(Rotator)*0.5f);
        Ring(14,20,1.5f);
        p.rotateY(PApplet.sin(2.1f*Rotator)*0.5f);
        Ring(24,30,1.6f);

        p.popMatrix();
    }

    void Ring(int Amnt, float Radius, float Rot){
        p.rotate(Rotator * Rot);
        p.pushMatrix();
        p.pushStyle();
        p.scale(0.3f);
        for(int i = 0; i < Amnt; i++){
            p.rotate((PApplet.TWO_PI/(float)Amnt));
            p.translate(Radius,0);

            p.rotate(Rotator + i, 1,1,1);
            p.shape(Duck);
            p.rotate(-Rotator - i, 1,1,1);

            p.translate(-Radius,0);
        }

        p.popStyle();
        p.popMatrix();
    }

}
