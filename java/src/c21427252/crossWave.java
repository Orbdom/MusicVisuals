package c21427252;

import processing.core.*;

import example.MyVisual;

public class crossWave {
    private MyVisual vis;
    float cy = 0;
    float lerp;

    private float width;
    private float height;
    float halfH = height / 2;
    float halfW = width / 2;
    float quarterh = height / 4;
    float avg = 0;

    public crossWave(MyVisual vis) {
        this.vis = vis;
        cy = this.vis.height / 2;
        width = this.vis.width;
        height = vis.height;
        lerp = vis.getSmoothedAmplitude();
    }

    float off = 0;

    float lerpedBuffer[] = new float[1024];

    public void render() 
    {
        vis.colorMode(PApplet.HSB);
        for (int i = 0; i < vis.getAudioBuffer().size(); i++) {
            // setting the stroke to the rectangle using map
            vis.stroke(
                    PApplet.map(i, 0, vis.getAudioBuffer().size(), 0, 255), 255, 255);

            // Setting the lurp variables
            lerpedBuffer[i] = vis.lerp(lerpedBuffer[i], 350 * vis.getAudioBuffer().get(i), 0.12f);

            vis.fill(
                    PApplet.map(i, 0, vis.getAudioBuffer().size(), 0, 255), 215, 255

            );
            vis.rect(width * ((float) i / (float) vis.getAudioBuffer().size()), cy - lerpedBuffer[i],
                    90 * width / vis.getAudioBuffer().size(), lerpedBuffer[i]);
            

            // Comment out the below to get rif of 
            vis.rect(halfW - lerpedBuffer[i]/2, halfH, lerpedBuffer[i],height );

        }
    }
}