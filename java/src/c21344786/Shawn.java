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

                board1.screen(30, 30, "Info On The Duck?", 180);
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
