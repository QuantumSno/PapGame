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

int x, y;
String keys="";
psymon psymon;
public void setup() {
  psymon = new psymon();
  
  
  imageMode(CENTER);
  x=y=0;
}
public void draw() {
  psymon.down(1);
  keys();
}


public void keys() {
    if(keys.contains("w")) {
      y+=-1;
    } else if(keys.contains("s")) {
      y+=1;
    }

    if(keys.contains("a")) {
      x+=-1;
    } else if(keys.contains("d")) {
      x+=1;
    }
}
public void keyPressed()
{
  keys+=key;
}

public void keyReleased() {
  keys=keys.replace(key+"","");
}
class psymon {
  spritesheet up, down, left, right, walkUp, walkDown, walkLeft, walkRight, bat, ready, hurt;
  public psymon() {
    up= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20behind.png"), 1, 1);
    down= new spritesheet(loadImage("psymon front.png"), 1, 1);
    left= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20left.png"), 1, 1);
    right= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20right.png"), 1, 1);
    walkUp= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20behind%20walk.png"), 1, 2);
    walkDown= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20front%20walk.png"), 1, 2);
    walkLeft= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20left%20walk.png"), 2, 2);
    walkRight= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20right%20walk.png"), 2, 2);
  }
  public void up(int f) { up.out(f, width/2, height/2); }
  public void down(int f) { down.out(f, width/2, height/2); }
  public void left(int f) { left.out(f, width/2, height/2); }
  public void right(int f) { right.out(f, width/2, height/2); }
  public void walkUp(int f) { walkUp.out(f, width/2, height/2); }
  public void walkDown(int f) { walkDown.out(f, width/2, height/2); }
  public void walkLeft(int f) { walkLeft.out(f, width/2, height/2); }
  public void walkRight(int f) { walkRight.out(f, width/2, height/2); }

}
class spritesheet {
  PImage[] sprites;
  public spritesheet(PImage spritesheet, int dX, int dY) {
    sprites = new PImage[dX*dY];
    int W = spritesheet.width/dX;
    int H = spritesheet.height/dY;
    for (int i=0; i<sprites.length; i++) {
      int x = i%dX*W;
      int y = i/dY*H;
      sprites[i] = spritesheet.get(x, y, W, H);
    }
  }
  public void out(int i, int x, int y) {
    noStroke();
    image(sprites[i-1], x, y, 100, 100);
  }

}
  public void settings() {  size(840, 640, P2D);  noSmooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
