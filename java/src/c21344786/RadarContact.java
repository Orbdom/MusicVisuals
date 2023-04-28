package c21344786;

import example.MyVisual;

public class RadarContact
{
    MyVisual mv;

    float shapeX;
    float shapeY;
    float shapeR;

    public RadarContact(float shapeX, float shapeY, float shapeR, MyVisual mv)
    {
        this.mv = mv;

        this.shapeX = shapeX;
        this.shapeY = shapeY;
        this.shapeR = shapeR;

    }

    public void display()
    {
        mv.fill(255, 0, 0); // Red circle
        mv.noStroke();
        mv.ellipse(shapeX, shapeY, shapeR, shapeR);
    }

    public void update(float scanX, float scanY)
    {
        float dist = MyVisual.dist(scanX, scanY, shapeX, shapeY);

        if(dist < shapeR/2)
        {
            shapeX = mv.random(mv.width - shapeR);
            shapeY = mv.random(mv.height - shapeR);
        }
    }
}
