package example;

import ie.tudublin.*;
import c21376161.*;
import c21344786.*;

public class MyVisual extends Visual
{
    float position;
    Dima dima;
    Shawn shawn;
    int i = 0;

    public void settings()
    {
        fullScreen(P3D, SPAN); 
        smooth();
    }

    public void setup()
    {
        
        colorMode(HSB);
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Moby Duck.mp3");   

        dima = new Dima(this);
        shawn = new Shawn(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0, 30);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 
        //
        //// Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        //wf.render();
        //abv.render();
        fill(0,255,255,255);
        rect(i + 10,10,10,10);
        position = map(getAudioPlayer().position(), 0, getAudioPlayer().length(), 0, 100);
        


        // Include this colorMode() for my section, all my colours are in RGB!
        colorMode(RGB);
        shawn.visual();


        
    }
}
