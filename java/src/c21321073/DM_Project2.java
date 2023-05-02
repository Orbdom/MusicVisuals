package c21321073;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import processing.core.PApplet;
import processing.core.PImage;
import example.MyVisual;

public class DM_Project2 {

    MyVisual mv;
    AudioPlayer ap;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    float off = 0;

    int squareSize;
    int verticalGapSize;
    int horizontalGapSize;
    int numColumns;
    float amplitude;

    float[] lerpedBuffer = new float[1920];

    public DM_Project2(MyVisual mv) {
        this.mv = mv;
        ab = mv.getAudioBuffer();
        squareSize = 50;
        verticalGapSize = 10;
        horizontalGapSize = 50;
        numColumns = 15;
        amplitude = 0;
        amplitude = mv.getSmoothedAmplitude();
    }

    public void visual() {
        mv.background(0); // Set background color to black

        // Calculate the number of squares that can fit in the window
        int numSquares = PApplet.floor((mv.height - verticalGapSize) / (squareSize + verticalGapSize));

        // Calculate the width of each column
        int columnWidth = PApplet.floor((mv.width - (numColumns + 1) * horizontalGapSize) / numColumns);

        // Get the current sound data
        float[] samples = ab.toArray();

        // Calculate the amplitude of the current buffer
        amplitude = 0;
        for (int i = 0; i < samples.length; i++) {
            amplitude += samples[i] * samples[i];
        }
        amplitude = PApplet.sqrt(amplitude / samples.length);

        // Interpolate between the previous amplitude and the current amplitude
        smoothedAmplitude = PApplet.lerp(smoothedAmplitude, amplitude, 0.6f);

        // Draw the columns
        mv.noStroke();
        float x = horizontalGapSize;
        for (int i = 0; i < numColumns; i++) {
            // Calculate the number of squares in the column
            int squaresInColumn = PApplet.floor(numSquares * (smoothedAmplitude * 2 + mv.random(-0.02f, 0.02f)));

            // Draw the squares
            float y = mv.height - verticalGapSize;
            int squareCounter = 0;
            while (squareCounter < squaresInColumn) {
                // Calculate the color based on the height
                float c = PApplet.map(y, 0, mv.height, 0, 255);
                mv.fill(c, 200, 200);
                mv.rect(x, y - squareSize, columnWidth, squareSize);
                squareCounter++;
                y -= (squareSize + verticalGapSize);
            }

            // Move to the next column
            x += columnWidth + horizontalGapSize;
        }
    }
}