package c21344786;

import example.MyVisual;
import processing.core.PConstants;

public class Sonar
{
    MyVisual mv;

    float topX;
    float topY;
    float shapeW;
    float shapeH;
    float lineX;
    float lineY;
    float waveX;
    float waveY;

    public Sonar(MyVisual mv)
    {
        this.mv = mv;
    }

    public void screen(float screenX, float screenY, float width, float height, float cols, String title, int pos)
    {
        switch(pos)
        {
            case 0:
            {
                topX = (screenX/4)-(width/2);
            }
            break;

            case 1:
            {
                topX = (screenX/2)-(width/2);
            }
            break;

            case 2:
            {
                topX = (screenX*3/4)-(width/2);
            }
            break;
        }

        topY = screenY;
        shapeW = width;
        shapeH = height;

        for(int i = 1; i < cols; i++)
        {
            lineY = topX+i*shapeW/cols;

            mv.stroke(150);
            mv.strokeWeight(1);
            mv.line(lineY, topY, lineY, topY+shapeH);
        }

        mv.pushStyle();

        mv.noFill();
        mv.stroke(255);
        mv.strokeWeight(4);
        mv.rect(topX, topY, shapeW, shapeH);

        mv.popStyle();

        mv.textSize(28);
        mv.textAlign(PConstants.LEFT);
        mv.text(title, topX, topY-10);
    }

    public void rawWave()
    {}

    public void modWave()
    {}
}
