package c21344786;

import example.MyVisual;
import processing.core.PConstants;

public class Sonar
{
    MyVisual mv;

    float topX;
    float topY;
    float shapeW;
    float shapeH;
    float lineX;
    float lineY;
    float waveX;
    float waveY;

    public Sonar(MyVisual mv)
    {
        this.mv = mv;
    }

    public void screen(float screenX, float screenY, float width, float height, float cols, String title, String unit, int pos)
    {
        switch(pos)
        {
            case 0:
            {
                topX = (screenX/4)-(width/2);
            }
            break;

            case 1:
            {
                topX = (screenX/2)-(width/2);
            }
            break;

            case 2:
            {
                topX = (screenX*3/4)-(width/2);
            }
            break;
        }

        topY = screenY;
        shapeW = width;
        shapeH = height;

        for(int i = 1; i < cols; i++)
        {
            lineY = topX+i*shapeW/cols;

            mv.stroke(150);
            mv.strokeWeight(1);
            mv.line(lineY, topY, lineY, topY+shapeH);

            mv.fill(255);
            mv.textSize(16);
            mv.textAlign(PConstants.CENTER);
            mv.text(title, lineY, topY+shapeH+20);
        }

        mv.pushStyle();

        mv.noFill();
        mv.stroke(255);
        mv.strokeWeight(4);
        mv.rect(topX, topY, shapeW, shapeH);

        mv.popStyle();

        mv.fill(255);
        mv.textSize(32);
        mv.textAlign(PConstants.LEFT);
        mv.text(title, topX, topY-10);
    }

    public void rawWave()
    {
        mv.pushStyle();
        mv.beginShape();

        for(int i = 0; i < mv.getAudioBuffer().size(); i++)
        {
            waveX = MyVisual.map(i, 0, mv.getAudioBuffer().size(), topX, topX+shapeW);
            waveY = MyVisual.map(mv.getAudioBuffer().get(i), -1, 1, topY, topY+shapeH);
            waveY = MyVisual.constrain(waveY, topY, topY+shapeH);

            mv.noFill();
            mv.stroke(0, 255, 0);
            mv.strokeWeight(2);
            mv.vertex(waveX, waveY);
        }

        mv.endShape();
        mv.popStyle();
    }

    public void modWave(float scale)
    {
        mv.pushStyle();
        mv.beginShape();

        for(int i = 0; i < mv.getAudioBuffer().size(); i++)
        {
            waveX = MyVisual.map(i, 0, mv.getAudioBuffer().size(), topX, topX+shapeW);
            waveY = MyVisual.map(mv.getAudioBuffer().get(i), -1, 1, -scale*shapeH, scale*shapeH);
            waveY = MyVisual.lerp(topY+shapeH/2, topY+shapeH/2+waveY, scale);
            waveY = MyVisual.constrain(waveY, topY, topY+shapeH);

            mv.smooth();
            mv.noFill();
            mv.stroke(255, 255, 0);
            mv.strokeWeight(4);
            mv.curveVertex(waveX, waveY);
        }

        mv.endShape();
        mv.popStyle();
    }
}
