package c21344786;

import example.MyVisual;

public class Shawn
{
    MyVisual mv;

    Board board1;
    Board board2;
    Sonar sonar1;
    Sonar sonar2;
    Radar radar1;

    float shapeW;
    float shapeH;

    public Shawn(MyVisual mv)
    {
        this.mv = mv;

        board1 = new Board(mv);
        board2 = new Board(mv);

        sonar1 = new Sonar(mv);
        sonar2 = new Sonar(mv);

        radar1 = new Radar(mv);
    }

    public void visual(int index)
    {
        switch(index)
        {
            case 0:
            {
                shapeW = board1.getWidth();
                shapeH = board1.getHeight();

                board1.screen(30, 20, "Info On The Duck?", 180);
                
                //sonar1.rawWave();
                sonar1.modWave(0.35f);
                sonar1.screen(shapeW, 270, 1000, 225, 7, "Broadband Sonar", "Hz", 0);

                sonar2.rawWave();
                sonar2.modWave(1.25f);
                sonar2.screen(shapeW, 655, 1000, 375, 13, "Narrowband Sonar", "KHz", 0);

                radar1.project(mv.frameCount, mv.getAmplitude());
                radar1.scan(mv.frameCount, 1.0f);
                radar1.screen(shapeW, (shapeH/2)+50, 950, 6, 24, "Long-Range Radar", 2);
            }
            break;

            case 1:
            {
                shapeW = board2.getWidth();
                shapeH = board2.getHeight();

                board2.screen(30, 30, "Personnel Files", 180);
            }
            break;
        }
    }
}
