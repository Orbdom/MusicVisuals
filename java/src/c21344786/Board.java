package c21344786;

import example.MyVisual;
import processing.core.PConstants;

public class Board
{
    MyVisual mv;

    float screenW;
    float screenH;
    float shapeW;
    float shapeH;
    float lineX;
    float lineH;

    // Constructor method
    public Board(MyVisual mv)
    {
        this.mv = mv;

        screenW = mv.width;
        screenH = mv.height;
    }
    
    // Background creation method
    public void screen(float gap, float row, String title, float titleY)
    {
        // Calculations to determine max screen
        shapeW = screenW-(gap*2);
        shapeH = screenH-(gap*2);
        lineH = shapeH/row;

        // Board border colour
        mv.background(209, 175, 132);

        mv.pushStyle();

        // Board surface
        mv.noStroke();
        mv.fill(39, 76, 67);
        mv.rect(gap, gap, shapeW, shapeH);

        // Board chalk lines
        for(int i = 1; i < row; i++)
        {
            lineX = gap+(i*lineH);

            mv.stroke(100);
            mv.strokeWeight(1);
            mv.line(gap, lineX, shapeW+gap, lineX);
        }

        mv.popStyle();

        // Board title
        mv.fill(255);
        mv.textSize(100);
        mv.textAlign(PConstants.CENTER);
        mv.text(title, shapeW/2+gap, titleY);
    }

    // Get method for setting object max width
    public float getWidth()
    {
        return screenW;
    }

    // Get method for setting object max height
    public float getHeight()
    {
        return screenH;
    }
}
