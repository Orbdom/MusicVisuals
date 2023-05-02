package c21376161;

import processing.core.PApplet;

public class Bobber {
    private Wave wave;
    private float Angle = 0;
    protected float LerpedAngle = 0;
    private float LowHeight, MidHeight, HighHeight;
    private float LerpedLowHeight = 0;
    protected float LerpedMidHeight = 0;
    private float LerpedHighHeight = 0;
    protected float posX;
    protected float length;

    public boolean Debug = false;

    PApplet p;

    public Bobber(Wave wave, float posX, float length){
        this.wave = wave;
        this.posX = posX;
        this.length = length;
        this.p = wave.mv;
    }

    public void GetAngle(float AngleRate, float HeightRate){
        Angle = (float)PApplet.atan((wave.GrabWavePoint(posX + length) - wave.GrabWavePoint(posX))/(length));
        LerpedAngle = PApplet.lerp(LerpedAngle, Angle, AngleRate);
        MidHeight = (wave.GrabWavePoint(posX + length)+wave.GrabWavePoint(posX))/2;


        LerpedMidHeight = PApplet.lerp(LerpedMidHeight, MidHeight, HeightRate);

        if(wave.GrabWavePoint(posX + length) > wave.GrabWavePoint(posX)){
            HighHeight = wave.GrabWavePoint(posX + length);
            LowHeight = wave.GrabWavePoint(posX);
        }
        else{
            HighHeight = wave.GrabWavePoint(posX);
            LowHeight = wave.GrabWavePoint(posX + length);
        }

        LerpedHighHeight = PApplet.lerp(LerpedHighHeight, HighHeight, HeightRate);
        LerpedLowHeight = PApplet.lerp(LerpedLowHeight, LowHeight, HeightRate);

        if(!Debug){
            return;
        }

        int preCol = p.g.strokeColor;
        float preWeight = p.g.strokeWeight;

        p.stroke(0,0,255);
        p.strokeWeight(1);
        p.translate(posX + length/2, wave.WaveHeight + 100);

        p.line(-length/2, -20, -length/2, 20);

        p.line(-length/2,0, length/2, 0);
        
        p.line(length/2, -20, length/2, 20);

        p.rotate(LerpedAngle);
        p.stroke(255,255,255);
        p.strokeWeight(3);
        p.line(0.9f*(-length/2), -0, 0.9f*(length/2), 0);
        p.rotate(-LerpedAngle);
        
        p.translate(-posX - length/2, -wave.WaveHeight - 100);

        p.stroke(preCol);
        p.strokeWeight(preWeight);
    }

    public void ChangeX(float posX){
        this.posX += posX;
    }
}