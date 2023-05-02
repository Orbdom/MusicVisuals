package c21344786;

import example.MyVisual;

public class Shawn
{
    MyVisual mv;

    Board board1;
    Sonar sonar1;
    Sonar sonar2;
    Radar radar1;
    Gauge gauge1;

    float shapeW;
    float shapeH;
    float shapeG;

    public Shawn(MyVisual mv)
    {
        this.mv = mv;

        board1 = new Board(mv);
        sonar1 = new Sonar(mv);
        sonar2 = new Sonar(mv);
        radar1 = new Radar(mv);
        gauge1 = new Gauge(mv);
    }

    public void visual()
    {
        shapeG = 30;

        shapeW = board1.getWidth()-shapeG;
        shapeH = board1.getHeight()-shapeG;

        board1.screen(shapeG, 20, "Info On The Duck?", shapeH/16);
        
        //sonar1.rawWave();
        sonar1.modWave(0.35f);
        sonar1.screen(shapeW, (shapeH/2)-(shapeH/3), shapeW/2.5f, shapeH/6, 7, "Broadband Sonar", shapeH/42, "Hz", 0);

        sonar2.rawWave();
        sonar2.modWave(1.25f);
        sonar2.screen(shapeW, (shapeH/2)+(shapeH/5), shapeW/2.5f, shapeH/6, 13, "Narrowband Sonar", shapeH/42, "KHz", 0);

        gauge1.screen(shapeW, (shapeH/2)-(shapeH/16), shapeW/2.5f, shapeH/6, "Radio Transmissions", shapeH/42, 0);
        gauge1.scan(mv.frameCount, mv.getAmplitude()/16, 0);
        gauge1.scanScreen("\"To The Ol' Rust Bucket!\"", shapeH/8, 0);
        gauge1.scan(mv.frameCount, mv.getSmoothedAmplitude()/10, 1);
        gauge1.scanScreen("\"To Me Hearties!\"", shapeH/8, 1);

        radar1.project(mv.frameCount, mv.getSmoothedAmplitude()/4);
        radar1.scan(mv.frameCount, 1.5f);
        radar1.screen(shapeW, shapeH*11/20, shapeH/1.55f, 6, 24, "Long-Range Radar", shapeH/36, 2);
    }
}
