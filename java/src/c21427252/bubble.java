package c21427252;

import processing.core.PApplet;
import processing.core.PVector;

public class bubble
{
    private PVector velocity;
    private PVector pos;
    private PApplet p;
    private int lives = 10;
    
    public bubble(PVector pos, PApplet p)
    {
        this.pos = pos;
        velocity = new PVector(0, 0);
        this.p = p;
    }

    public void render()
    {
        p.noStroke();
        //p.println(p.millis());
        p.fill((p.millis()/250)%256 ,255,255);
        p.circle(pos.x, pos.y, 15);

    }
    
    float DirY = 3;
    float DirX = 2;
    

    public void update()
    {
        
        //p.circle(pos.x += DirX, pos.y += DirY, 11);
        
        if(pos.x > p.width)
        {
            DirX *= -1.25;
            lives--; 
        }
        
        if(pos.x < 0) 
        {
            DirX *= -1.25;
            lives--;
        }

        if(pos.y > p.height)
        {
            DirY *= -1.25;
            lives--;
        }
        
        if(pos.y < 0) 
        {
            DirY *= -1.25;
            lives--;
        }
        //c = 
        pos.x += DirX;
        pos.y += DirY;
        

        
        if (lives > 0)
        {
            explosion();
            
        }
        lives = 10;
        //p.circle(, 11);
        //DirX=PApplet.constrain(DirX, 0, p.width);
        //DirY=PApplet.constrain(DirY, 0, p.height);
    }


    public void explosion() 
    {
        //if a bubbles life = > 3 leave an explosion at current location
        p.rect(pos.x, pos.y, DirX, DirY);
        lives = 10;
    }
    
    
    
}
