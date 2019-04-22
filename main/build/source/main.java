import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class main extends PApplet {

int x, y, walkSpeed;
String keys="";
spritesheet test;
psymon psymon;
boolean walking; int direction;
public void setup() {
  psymon = new psymon();
  
  
  imageMode(CENTER);
  x=y=0;
  walkSpeed=5;
}
public void draw() {
  keys();
  psymon.down(1);
  //println("x " + x + " y " + y);
}


public void keys() {
    if(keys.contains("w")) {
      y+=walkSpeed;
    } else if(keys.contains("s")) {
      y+=-walkSpeed;
    }

    if(keys.contains("a")) {
      x+=walkSpeed;
    } else if(keys.contains("d")) {
      x+=-walkSpeed;
    }
}
public void keyPressed()
{
  keys+=key;
}

public void keyReleased() {
  keys=keys.replace(key+"","");
}
class elements {
  public elements() {
    test = new spritesheet(loadImage("collider map.png"), 1, 1);
  }
}
class psymon {
  spritesheet up, down, left, right, walkUp, walkDown, walkLeft, walkRight, bat, batcharge, ready, hurt;
  int size;
  public psymon() { size=100;
    noStroke();
    noSmooth();
    up= new spritesheet(loadImage("psymon up.png"), 1, 1); up.setW(size); up.setH(size);
    down= new spritesheet(loadImage("psymon down.png"), 1, 1); down.setW(size); down.setH(size);
    left= new spritesheet(loadImage("psymon left.png"), 1, 1); left.setW(size); left.setH(size);
    right= new spritesheet(loadImage("psymon right.png"), 1, 1); right.setW(size); right.setH(size);
    walkUp= new spritesheet(loadImage("psymon down walk.png"), 1, 2); walkUp.setW(size); walkUp.setH(size);
    walkDown= new spritesheet(loadImage("psymon up walk.png"), 1, 2); walkDown.setW(size); walkDown.setH(size);
    walkLeft= new spritesheet(loadImage("psymon left walk.png"), 2, 2); walkLeft.setW(size); walkLeft.setH(size);
    walkRight= new spritesheet(loadImage("psymon right walk.png"), 2, 2); walkRight.setW(size); walkRight.setH(size);
    bat = new spritesheet(loadImage("psymon bat.png"), 3, 3); bat.setW(size); bat.setH(size);
    bat = new spritesheet(loadImage("psymon bat charge.png"), 4, 5); bat.setW(size); bat.setH(size);
    ready = new spritesheet(loadImage("psymon ready.png"), 1, 1); ready.setW(size); ready.setH(size);
    hurt = new spritesheet(loadImage("psymon hurt.png"), 1, 1); hurt.setW(size); hurt.setH(size);
  }
  public void up(int f) { up.out(f, width/2, height/2); }
  public void down(int f) { down.out(f, width/2, height/2); }
  public void left(int f) { left.out(f, width/2, height/2); }
  public void right(int f) { right.out(f, width/2, height/2); }
  public void walkUp(int f) { walkUp.out(f, width/2, height/2); }
  public void walkDown(int f) { walkDown.out(f, width/2, height/2); }
  public void walkLeft(int f) { walkLeft.out(f, width/2, height/2); }
  public void walkRight(int f) { walkRight.out(f, width/2, height/2); }
  public void bat(int f) { bat.out(f, width/2, height/2); }
  public void ready(int f) { ready.out(f, width/2, height/2); }
  public void hurt(int f) { hurt.out(f, width/2, height/2); }
}
class spritesheet {
  PImage[] sprites;
  ArrayList<PGraphics> rendered;
  int wid, hei;
  public spritesheet(PImage spritesheet, int dX, int dY) {
    sprites = new PImage[dX*dY];
    rendered = new ArrayList<PGraphics>();
    int W = spritesheet.width/dX;
    int H = spritesheet.height/dY;
    wid=hei=300;
    for (int i=0; i<sprites.length; i++) {
      int x = i%dX*W;
      int y = i/dY*H;
      sprites[i] = spritesheet.get(x, y, W, H);
    }
  }
  public void out(int i, int x, int y) {
    noStroke();
    image(sprites[i-1], x, y, wid, hei);
  }
  public void setW(int i) { wid=i; }
  public void setH(int i) { hei=i; }
}
  public void settings() {  size(840, 640, P2D);  noSmooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
