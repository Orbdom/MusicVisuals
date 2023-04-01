package c21376161;

import example.MyVisual;
import processing.core.PApplet;

public class Wave{
    MyVisual mv;

    float points[];
    float WaveOffset = 0;
    int WaveDelay = 0;
    int AmtPoints;
    int WaveWidth, WaveHeight;
    float ToLerp;
    float DIST = 30;

    public Wave(MyVisual mv, int AmtPoints){
        this.mv = mv;
        this.WaveWidth = mv.width+20;
        this.WaveHeight = mv.height/2;

        this.points = new float[AmtPoints];
        this.AmtPoints = AmtPoints;
        points[0] = 0;
        for(int i = 1; i < AmtPoints-1; i++){
            //points[i] = points[i-1] + mv.random(-DIST,DIST);
            points[i] = BufferAvg();//(float)PApplet.lerp(points[i-1], mv.random(-DIST,DIST), 0.1f);
        }
    }

    public void RenderWave(float Move){
        float offset = WaveOffset + WaveWidth;

        for(int i = 0; i < AmtPoints; i++){
            float p1 = (offset + ((float)i/AmtPoints)*WaveWidth) % WaveWidth;
            float p2 = (offset + ((float)((i+1)%AmtPoints)/AmtPoints)*WaveWidth) % WaveWidth;
            if(p2 < p1){
                points[(i + ((Move < 0)?0:1))%AmtPoints] = PApplet.lerp(points[(i + ((Move < 0)?1:0))%AmtPoints],(float)Math.sin(i*0.1)*ToLerp,0.5f);
                continue;
            }

            //mv.point(p1,points[i] + WaveHeight);
            points[i] = PApplet.lerp(points[i], points[(i + ((Move < 0)?1:0))%AmtPoints],0.008f);
            mv.line(p1, points[i] + WaveHeight, p2, points[(i+1)%AmtPoints] + WaveHeight);
        }
        WaveMove(Move);
    }

    public void SetWave(float value){
        this.ToLerp = value;
    }
    public void SetWave(){
        this.ToLerp = BufferAvg();
    }

    void WaveMove(float offset){
        WaveOffset += offset;
        WaveOffset += WaveWidth;
        WaveOffset %= WaveWidth;
    }

    public float GrabWavePoint(float pos){
        //WaveWidth * (WaveOffset/(float)WaveWidth) + WaveWidth;
        //p1 = (offset + (i/AmtPoints)*WaveWidth) % WaveWidth
        return points[((int)PApplet.round((float) AmtPoints * ( ((pos - WaveOffset + WaveWidth))%WaveWidth / WaveWidth))) % AmtPoints] + WaveHeight;
    }

    float BufferAvg(){
        float Avg;
        Avg = 0;
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            Avg += mv.getSmoothedBands()[i];
        }

        return (Avg/mv.getBands().length) *  0.3f;
        
    }
}