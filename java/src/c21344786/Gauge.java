package c21344786;

import example.MyVisual;
import processing.core.PConstants;

public class Gauge
{
    MyVisual mv;

    float shapeW;
    float shapeH;
    float topX;
    float topY;
    float lineX;
    float lineY;
    float lineA;
    float arcX;
    float arcY;
    float arcR;

    // Constructor method
    public Gauge(MyVisual mv)
    {
        this.mv = mv;
    }

    // Gauge screen creation method
    public void screen(float screenX, float screenY, float width, float height, String title, int pos)
    {
        // Screen alignment on board
        switch(pos)
        {
            // Left-align gauge screen
            case 0:
            {
                topX = (screenX/4)-(width/2);
            }
            break;

            // Center-align gauge screen
            case 1:
            {
                topX = (screenX/2)-(width/2);
            }
            break;

            // Right-align gauge screen
            case 2:
            {
                topX = (screenX*3/4)-(width/2);
            }
            break;
        }

        // Set method variables based from switch() operation
        topY = screenY;
        shapeW = width;
        shapeH = height;

        mv.pushStyle();

        // Gauge screen border
        mv.fill(8, 0, 0); // Change colour here
        mv.stroke(255, 0, 0); // Change colour here
        mv.strokeWeight(6);
        mv.rect(topX, topY, shapeW, shapeH);

        mv.popStyle();

        // Gauge title
        mv.fill(255);
        mv.textSize(34);
        mv.textAlign(PConstants.LEFT);
        mv.text(title, topX, topY-10);
    }

    // Dial screen creation method
    public void scanScreen(String title, float maxRad, int pos)
    {
        // Dial alignment on screen
        switch(pos)
        {
            // Left-align dial screen
            case 0:
            {
                arcX = topX+shapeW/4;
            }
            break;

            // Center-align dial screen
            case 1:
            {
                arcX = topX+shapeW*3/4;
            }
            break;
        }

        arcY = topY+shapeH;
        arcR = maxRad;

        mv.pushStyle();

        // Needle holder
        mv.fill(255, 0, 0); // Change colour here
        mv.noStroke();
        mv.arc(arcX, arcY, arcR/2, arcR/2, PConstants.PI, PConstants.TWO_PI);

        mv.popStyle();

        mv.noFill(); // Change colour here
        mv.stroke(255, 0 ,0); // Change colour here
        mv.strokeWeight(4);
        mv.arc(arcX, arcY, arcR*2, arcR*2, PConstants.PI, PConstants.TWO_PI);

        mv.pushStyle();

        // Dial title
        mv.fill(255);
        mv.textSize(18);
        mv.textAlign(PConstants.CENTER);
        mv.text(title, arcX, arcY+25);

        mv.popStyle();
    }

    // Gauge dial method
    public void scan(float frame, float speed, int pos)
    {
        lineA = MyVisual.radians(frame*speed);
        lineA = MyVisual.min(lineA, MyVisual.radians(180));

        // Dial alignment on board
        switch(pos)
        {
            // Center-align dial to left dial
            case 0:
            {
                arcX = topX+shapeW/4;
            }
            break;

            // Center-align dial to right dial
            case 1:
            {
                arcX = topX+shapeW*3/4;
            }
            break;
        }

        lineX = arcX-arcR*MyVisual.cos(lineA);
        lineY = arcY+arcR*(-MyVisual.sin(lineA));

        mv.stroke(255, 0, 0); // Change colour here
        mv.strokeWeight(4);
        mv.line(arcX, arcY, lineX, lineY);
    }
}
