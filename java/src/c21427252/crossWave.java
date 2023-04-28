package c21427252;
import processing.core.*;

import example.MyVisual;

public class crossWave 
{
    private MyVisual vis;
    float cy = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    private float width;
    private float height;
    float quarterh= height /4;
    float avg = 0;


    public crossWave(MyVisual vis) 
    {
        this.vis = vis;
        cy = this.vis.height / 2;
    }

    float off = 0;

    float lerpedBuffer[] = new float[1024];

    public void render() 
    {
        vis.colorMode(PApplet.HSB);
        for(int i = 0 ; i < vis.getAudioBuffer().size() ; i ++)
        {
            vis.stroke(
                PApplet.map(i, 0, vis.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );
            
            //vis.rect(width/2 * vis.getAudioBuffer().get(i), i, 600 * vis.getAudioBuffer().get(i),i);
            //vis.rect(i, (600  * vis.getAudioBuffer().get(i)) , i, (quarterh ) * ( vis.getAudioBuffer().get(i)));
            //vis.rect(width/2,cy,width,cy);
            //vis.rect(i,600 ,i,  height/4);
            float rectWidth = 1080;  // set the desired width of the rectangle
            float rectX = (width - rectWidth) / 2;  // calculate the x-coordinate for the rectangle
            vis.rect(rectX, cy, rectWidth, cy);  
            
        }
    }
}