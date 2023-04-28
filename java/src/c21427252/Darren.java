package c21427252;

import c21376161.Wave;
import example.MyVisual;

public class Darren 
{
    private MyVisual mv;
    private bubbles b;
    private crossWave wave;
    
    public Darren(MyVisual myVisual )
    {
        this.mv = myVisual;
        b = new bubbles(myVisual.width,myVisual.height, myVisual);
        wave = new crossWave(myVisual);
    }

    public void render()
    {
        b.render();
        wave.render();
    }

    
}
