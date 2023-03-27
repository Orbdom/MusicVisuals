package c21376161;

import example.MyVisual;
import processing.core.PApplet;
import processing.core.PShape;

public class Dima {
    Wave w;
    Boat boat, boat1, boat2;
    MyVisual mv;

    float rot = 0;
    PShape duck;
    DuckVortex vortex;

    public Dima(MyVisual mv){
        this.mv = mv;
        w = new Wave(this.mv, 200);

        boat = new Boat(w, 125, 50, 0);
        boat1 = new Boat(w, 300, 100, 0,boat.Hull);
        boat2 = new Boat(w, 500, 100, 0,boat.Hull);
        boat.Debug = true;
        boat1.Debug = true;
        boat2.Debug = true;

        duck = mv.loadShape("duck.obj");
        vortex = new DuckVortex(mv, duck);
    }

    public void Visual(int VisIndex){
        switch(VisIndex){
            case 0:{
                mv.stroke(255);
                w.SetWave();
                w.RenderWave(-3f);

                boat.Render(0.05f,0.4f,1.5f);
                boat1.Render(0.05f,0.7f,1.5f);
                boat2.Render(0.05f,0.1f,1.5f);
            }
            break;

            case 1:{
                mv.lights();
                mv.translate(5*mv.width/6,mv.height/2,0);
                //mv.fill(255,255,255);
                mv.noFill();
                mv.stroke(255,0,0);
                mv.strokeWeight(10);
                mv.rotateX(PApplet.PI/2.0f);
                mv.rotateX(-PApplet.PI/6.0f);
                //mv.rotateY(rot);
                //mv.rotateZ(rot);
                rot+= 0.01f;
                mv.translate(0,0,-50);

                mv.scale(60);
                vortex.Render();
            }
            break;

            default:
            break;
        }
    }
}
