package c21344786;

import example.MyVisual;

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
    public void screen(float gap, float row, String title)
    {
        // Calculations to determine max screen
        shapeW = screenW-(gap*2);
        shapeH = screenH-(gap*2);
        lineH = shapeH/row;
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
