package c21344786;

import example.MyVisual;
import processing.core.PConstants;

public class Radar
{
    MyVisual mv;

    float shapeX;
    float shapeY;
    float shapeR;
    float shapeS;

    float lineX;
    float lineY;
    float lineA;

    float scanX;
    float scanY;

    public Radar(MyVisual mv)
    {
        this.mv = mv;
    }

    public void screen(float screenX, float screenY, float maxRad, float range, float sectors, int pos)
    {
        // Screen alignment on board
        switch(pos)
        {
            // Left-align radar screen
            case 0:
            {
                shapeX = screenX/4;
            }
            break;

            // Center-align radar screen
            case 1:
            {
                shapeX = screenX/2;
            }
            break;

            // Right-align radar screen
            case 2:
            {
                shapeX = (screenX/2)+(screenX/4);
            }
            break;
        }

        shapeY = screenY;
        shapeR = maxRad;
        shapeS = shapeY/range;

        for(int i = 0; i < range; i++)
        {
            if(i != 0)
            {
                mv.noFill();
                mv.stroke(200);
                mv.strokeWeight(1);
                mv.circle(shapeX, shapeY, maxRad);
            }
            else
            {
                mv.noFill();
                mv.stroke(255);
                mv.strokeWeight(4);
                mv.circle(shapeX, shapeY, maxRad);
            }

            maxRad -= shapeS;
        }

        for(int i = 0; i < sectors; i++)
        {
            lineA = PConstants.TWO_PI*i/sectors;
            lineX = shapeX+MyVisual.cos(lineA)*shapeR/2;
            lineY = shapeY+MyVisual.sin(lineA)*shapeR/2;

            mv.stroke(200);
            mv.strokeWeight(1);
            mv.line(shapeX, shapeY, lineX, lineY);

            float labelX = shapeX+MyVisual.cos(lineA)*(shapeR/2+30);
            float labelY = shapeY+MyVisual.sin(lineA)*(shapeR/2+30);

            mv.fill(255);
            mv.textSize(18);
            mv.textAlign(PConstants.CENTER, PConstants.CENTER);
            mv.text(MyVisual.round(MyVisual.degrees(lineA)) + "°", labelX, labelY);
        }
    }

    public void scan(float frame, float speed)
    {
        scanX = shapeX+(shapeR/2)*MyVisual.cos(MyVisual.radians(frame*speed));
        scanY = shapeY+(shapeR/2)*MyVisual.sin(MyVisual.radians(frame*speed));

        mv.stroke(255, 255, 0);
        mv.strokeWeight(4);
        mv.line(shapeX, shapeY, scanX, scanY);
    }
}
