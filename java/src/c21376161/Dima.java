package c21376161;

import example.MyVisual;
import processing.core.PApplet;
import processing.core.PShape;

public class Dima {
    Wave WaveArray[];
    int WaveAmount = 3;

    Boat boats[], duckBoat;
    MyVisual mv;

    PShape duck, duck2;
    DuckVortex vortex;
    DuckCircle duckCircle;

    public Dima(MyVisual mv){
        this.mv = mv;
        
        //MainWave =  new Wave(this.mv, mv.width, mv.height/2, 200);
        //Wave2 =     new Wave(this.mv, mv.width, mv.height/2 - 10, 200);
        //Wave3 =     new Wave(this.mv, mv.width, mv.height/2 + 10, 200);

        WaveArray = new Wave[WaveAmount];
        for(int i = 0; i < WaveAmount; i++){
            WaveArray[i] = new Wave(mv, mv.width, mv.height/2 - (20 * (-1 + i)), 200);
        }

        //ship = mv.loadShape("Ship.obj");
        boats = new Boat[3];
        boats[0] = new Boat(WaveArray[1], 200, 50, 0);

        //boats[0].Debug  = true;

        for(int i = 1; i < boats.length; i++){
            boats[i] = new Boat(WaveArray[1], 200 * (i + 1), 100, 0, boats[0].Parent);
        }
        
        duck = mv.loadShape("duck.obj");
        duck.setFill(mv.color(40,255,255));
        duck2 = mv.loadShape("duck.obj");
        duck2.setFill(mv.color(40,255,255));

        duckBoat = new Boat(WaveArray[1], mv.width*0.9f, 100, 50, duck);
        duckBoat.Parent.scale(30);
        duckBoat.Parent.rotateX(PApplet.PI/2f);
        duckBoat.Parent.rotateY(-0.5f);
        duckBoat.Parent.scale(1,1,0.09f);

        vortex = new DuckVortex(mv, duck2);
        duckCircle = new DuckCircle(mv, duck2);
    }

    public void Visual(int VisIndex){

        mv.lights();
        mv.background(0);

        switch(VisIndex){
            case 0:{
                
                mv.stroke(255);

                mv.pushMatrix();
                mv.pushMatrix();
                for(int i = 0; i < WaveAmount; i++){
                    
                    mv.translate(0, 0, -10);

                    WaveArray[i].SetWave();
                    WaveArray[i].RenderWave(-i - 1);

                }
                mv.popMatrix();

                mv.translate(0,0,-20);    //makes Pshape render infront of wave

                for(Boat b: boats){
                    b.Render(0.05f,0.1f,1.5f);
                }
                duckBoat.Render(0.05f,0.1f,1.5f);

                mv.popMatrix();
            }
            break;

            case 1:{
                mv.translate(5*mv.width/6,mv.height/2,0);

                mv.rotateX(2 * PApplet.PI/6.0f);
                
                mv.translate(0,0,-50);

                mv.scale(60);
                vortex.Render();
            }
            break;

            case 2:{

                mv.noFill();
                mv.stroke(255,0,0);
                mv.strokeWeight(10);

                mv.translate(mv.width/2,mv.height/2,0);
                mv.rotateX(2 * PApplet.PI/6.0f);
                
                mv.translate(0,0,-50);

                mv.scale(60);
                duckCircle.Render();
            }
            break;

            default:
            break;
        }
    }
}
