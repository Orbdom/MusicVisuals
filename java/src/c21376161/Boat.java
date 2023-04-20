package c21376161;

import processing.core.PApplet;
import processing.core.PShape;

public class Boat extends Bobber {
    private PShape Parent, BoatShape, Sail, Mast;
    private float drop = 0;

    public Boat(Wave wave, float posX, float length, float drop){
        super(wave, posX, length);
        this.drop = drop;

        Parent = p.createShape(PShape.GROUP);
        //Parent.beginShape();
        //Parent.endShape();

        BoatShape = p.createShape(PShape.GEOMETRY);
        BoatShape.beginShape();
        BoatShape.stroke(0,0,255);
        BoatShape.vertex(-50,-10);
        BoatShape.vertex(-48,-20);
        BoatShape.vertex(-20, -20);
        BoatShape.vertex(-20, -10);
        BoatShape.vertex(15, -10);
        BoatShape.vertex(30, -20);
        BoatShape.vertex(55, -20);

        BoatShape.vertex(69, -23);
        BoatShape.vertex(70, -22);

        BoatShape.vertex(55, -15);
        BoatShape.bezierVertex( 40,20, -20,10, -45, 7);

        BoatShape.endShape(PApplet.CLOSE);
        BoatShape.setFill(true);
        BoatShape.setFill(wave.mv.color(0,0,0));

        //Sail
        Sail = p.createShape(PShape.GEOMETRY);
        Sail.beginShape();
        Sail.stroke(0,0,255);

        Sail.vertex(-10,-80);
        Sail.bezierVertex(20,-70, 20,-25,-10,-15);

        Sail.endShape();
        Sail.setFill(true);
        Sail.setFill(wave.mv.color(0,0,0));

        //Mast rect(-1.5f,-10,3,-70);

        Mast = p.createShape(PShape.GEOMETRY);
        Mast.beginShape();
        Mast.stroke(0,0,255);

        Mast.vertex(-5f,-10);
        Mast.vertex(-1.5f,-10);
        Mast.vertex(-1.5f,-80);
        Mast.vertex(-5f,-80);
        
        Mast.endShape(PShape.CLOSE);
        Mast.setFill(true);
        Mast.setFill(wave.mv.color(0,0,0));

        Parent.addChild(BoatShape);
        Parent.addChild(Sail);
        Parent.addChild(Mast);

    }

    public Boat(Wave wave, float posX, float length, float drop, PShape Parent){
        super(wave, posX, length);
        this.drop = drop;
        this.Parent = Parent;
    }

    public void Render(float AngleRate, float HeightRate,float scale){
        GetAngle(AngleRate, HeightRate);
        p.pushMatrix();
        p.translate(posX + length/2, LerpedMidHeight + drop);
        p.rotate(LerpedAngle);
        p.scale(scale);

        //drawing
        p.stroke(0,0,255);
        p.strokeWeight(1);
        p.noFill();

        p.shape(Parent);
        p.popMatrix();
    }

    public PShape GetPShape(){
        return Parent;
    }
}
