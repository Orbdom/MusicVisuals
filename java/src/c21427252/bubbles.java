package c21427252;

// import hireracy 
import processing.core.PApplet;
import processing.core.PVector;

public class bubbles 
{
    //creates an array
    bubble bob[];
    private PApplet p;
    private PVector pos;

    private float width;
    private float height;
    
    // This decides how many balls will spawn 
    private int size = 1000;
    
    public bubbles(float width, float height, PApplet p)
    {
        //this exact classes width = 
        this.width = width;
        this.height = height;
        this.p = p;
        

        // Initalsing bubble array
        bob = new bubble[size];
        
        // This for loop deides on which side of the screen the bubble will spawn by dividing the array size by modulos of 4 
        for(int i = 0; i < size; i++)
        {
            float x = 0, y = 0; 
            switch (i%4) 
            {
                case 0:
                //left
                    x = p.random(0,width);
                    y = p.random(0, height);
                    break;
                case 1:
                //right
                    x = p.random(0,width);
                    y = p.random(0, height);

                    break;
                case 2:
                //bottom
                    x = p.random(0, width);
                    y = p.random(0,height);
                    break;
                case 3:
                //top
                    x = p.random(0, width);
                    y = p.random(0, height);

                    break;
                      
            
                default:
                    break;
            }
             
            pos = new PVector(x,y);
            bob[i] = new bubble(pos,p);
            

        }
    }

    // creates the bubbles and stuff
    public void render()
    {
        for (int i = 0; i < size; i++)
        {
            
            bob[i].render();
            bob[i].update();
            
        }
    }

    public void update()
    {
        for (int i = 0; i < size; i++)
        {
            
            bob[i].update();
            
        }
    }
}
