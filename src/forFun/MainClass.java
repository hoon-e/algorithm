package forFun;

import processing.core.PApplet;
import java.util.Scanner;

// Triangle Strip
// Connect all triangles together.

// Perlin Noise
// A way of getting smooth random number

public class MainClass extends PApplet {
    int cols, rows;
    int scale = 20;
    static int w;
    static int h;

    float[][] terrain;
    float flying = 0;

    public void draw(){
        background(0);
        stroke(255);
        noFill();

        translate(width/2, height/2);
        rotateX(PI/3);
        translate(-w/2, -h/2);

        flying -= 0.1;

        float yoff = flying;
        // draw rectangle
        for(int y=0; y<rows; y++){
            float xoff = 0;
            for(int x=0; x<cols; x++){
                terrain[x][y] = map(noise(xoff, yoff), 0, 1, -100, 100);
                xoff += 0.2;
            }
            yoff += 0.2;
        }

        // draw rectangle
        for(int y=0; y<rows-1; y++){
            beginShape(TRIANGLE_STRIP);
            for(int x=0; x<cols; x++){
                // use 2D array to store z-value
                vertex(x*scale, y*scale, terrain[x][y]);
                vertex(x*scale, (y+1)*scale,terrain[x][y+1]);
                // rect(x*scale, y*scale, scale, scale);
            }
            endShape();
        }
    }

    public void settings(){
        size(600, 600, P3D);

        cols = w / scale;
        rows = h / scale;

        terrain = new float[cols][rows];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        w = scn.nextInt();
        h = scn.nextInt();

        PApplet.main("forFun.MainClass", args);
    }
}
