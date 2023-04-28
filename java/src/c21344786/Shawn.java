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
        shapeW = board1.getWidth();
        shapeH = board1.getHeight();

        board1.screen(30, 20, "Info On The Duck?", 180);
        
        //sonar1.rawWave();
        sonar1.modWave(0.35f);
        sonar1.screen(shapeW, 270, 1000, 225, 7, "Broadband Sonar", "Hz", 0);

        sonar2.rawWave();
        sonar2.modWave(1.25f);
        sonar2.screen(shapeW, 1040, 1000, 375, 13, "Narrowband Sonar", "KHz", 0);

        radar1.project(mv.frameCount, mv.getSmoothedAmplitude()/4);
        radar1.scan(mv.frameCount, 1.5f);
        radar1.screen(shapeW, (shapeH/2)+75, 950, 6, 24, "Long-Range Radar", 2);

        gauge1.screen(shapeW, 655, 1000, 225, "Radio Transmissions", 0);
        gauge1.scan(mv.frameCount, mv.getSmoothedAmplitude()/10, 0);
        gauge1.scanScreen("\"To The Ol' Rust Bucket!\"", 180, 0);
        gauge1.scan(mv.frameCount, mv.getSmoothedAmplitude()/8, 1);
        gauge1.scanScreen("\"To Me Hearties!\"", 180, 1);
    }
}
