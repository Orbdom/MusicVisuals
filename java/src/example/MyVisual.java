package example;

import ie.tudublin.*;
import c21376161.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;

    float position;
    Dima dima;
    int i = 0;

    public void settings()
    {
        //size(1024, 500,P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, SPAN); 
        smooth();
    }

    public void setup()
    {
        
        colorMode(HSB);
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Moby Duck.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 

        dima = new Dima(this);
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

        position = map(getAudioPlayer().position(), 0, getAudioPlayer().length(), 0, 100);

        if(position < 0){
            dima.Visual(2);
        }
        else{
            dima.Visual(0);
        }
    }
}
