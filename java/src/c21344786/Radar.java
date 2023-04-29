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

    // Constructor method
    public Radar(MyVisual mv)
    {
        this.mv = mv;
    }

    // Radar screen creation method
    public void screen(float screenX, float screenY, float maxRad, float range, float sectors, String title, int pos)
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

        // Set method variables from the switch() operation
        shapeY = screenY;
        shapeR = maxRad;
        shapeS = shapeY/range;

        // Radar screen border/range lines (concentric circles)
        for(int i = 0; i < range; i++)
        {
            if(i != 0)
            {
                mv.noFill();
                mv.stroke(2, 100, 32); // Change colour here
                mv.strokeWeight(1);
                mv.circle(shapeX, shapeY, maxRad);
            }
            else
            {
                mv.fill(0);
                mv.stroke(6, 150, 64); // Change colour here
                mv.strokeWeight(6);
                mv.circle(shapeX, shapeY, maxRad);
            }

            maxRad -= shapeS;
        }

        // Radar screen sector lines/course headings
        for(int i = 0; i < sectors; i++)
        {
            lineA = PConstants.TWO_PI*i/sectors;
            lineX = shapeX+MyVisual.cos(lineA)*shapeR/2;
            lineY = shapeY+MyVisual.sin(lineA)*shapeR/2;

            mv.stroke(2, 100, 64); // Change colour here
            mv.strokeWeight(1);
            mv.line(shapeX, shapeY, lineX, lineY);

            float headingX = shapeX+MyVisual.cos(lineA)*(shapeR/2+35);
            float headingY = shapeY+MyVisual.sin(lineA)*(shapeR/2+35);

            mv.fill(255);
            mv.textSize(20); // Hard-coded
            mv.textAlign(PConstants.CENTER, PConstants.CENTER);
            mv.text(MyVisual.round(MyVisual.degrees(lineA)) + "°", headingX, headingY);
        }

        // Radar title
        mv.fill(255);
        mv.textSize(48); // Hard-coded
        mv.textAlign(PConstants.CENTER, PConstants.CENTER);
        mv.text(title, shapeX, shapeY-(shapeR/2)-100);
    }

    // Radar scanning method
    public void scan(float frame, float speed)
    {
        scanX = shapeX+(shapeR/2)*MyVisual.cos(MyVisual.radians(frame*speed));
        scanY = shapeY+(shapeR/2)*MyVisual.sin(MyVisual.radians(frame*speed));

        mv.stroke(0, 255, 0); // Change colour here
        mv.strokeWeight(6);
        mv.line(shapeX, shapeY, scanX, scanY);
    }

    // Radar projection method (in place of a radar contact)
    public void project(float frame, float speed)
    {
        scanX = shapeX+(shapeR/2)*MyVisual.cos(MyVisual.radians(frame*speed));
        scanY = shapeY+(shapeR/2)*MyVisual.sin(MyVisual.radians(frame*speed));

        float angle = MyVisual.atan2(scanY-shapeY, scanX-shapeX);

        mv.stroke(255, 255, 0); // Change colour here
        mv.strokeWeight(2);
        mv.line(shapeX, shapeY, scanX, scanY);

        mv.pushMatrix();

        // Contact direction arrow
        mv.translate(scanX, scanY);
        mv.rotate(angle);

        mv.stroke(255, 255, 0); // Change colour here
        mv.strokeWeight(2);
        mv.line(0, 0, -10, 0);
        mv.line(0, 0, -20, -5);
        mv.line(0, 0, -20, 5);

        mv.popMatrix();
    }
}
