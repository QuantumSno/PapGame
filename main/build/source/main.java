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

int playerX, playerY, psymonSize, walkSpeed,
mapSizeX, mapSizeY, scale,
playerDirection;
  /*
  1 = [w] up
  2 = [a] left
  3 = [s] down
  4 = [d] left
  */
render r;
public void setup() {
  
  background(30);
  scale=4;
  psymonSize=32;
  mapSizeX=640;
  mapSizeY=480;
  walkSpeed=5;
  playerX=width/2-((psymonSize*scale)/2);
  playerY=height/2-((psymonSize*scale)/2);

  r= new render(psymonSize,scale,mapSizeX,mapSizeY);
}
public void draw() {
  switch(key) {
    default:
    break; case 'w':
      playerY=playerY+walkSpeed;
      playerDirection = 1;
    break; case 'a':
      playerX=playerX-walkSpeed;
      playerDirection = 2;
    break; case 's':
      playerY=playerY+walkSpeed;
      playerDirection = 3;
    break; case 'd':
      playerX=playerX+walkSpeed;
      playerDirection = 4;
    break;
  }
  r.MAINRENDER();
}
class render {
  PImage PsymonW,PsymonA,PsymonS,PsymonD,
  WhyattW,WhyattA,WhyattS,WhyattD,
  Map,
  PsymonOld
  ;
  int psymonSize, scale, mapSizeX, mapSizeY;
  public render(int ps, int s, int mX, int mY) {
    //require input
    psymonSize = ps;
    scale = s;
    mapSizeX = mX;
    mapSizeY = mY;
    //just set up
    PsymonW = loadImage("Psymon-front.png");
    PsymonA = loadImage("Psymon-side-left.png");
    PsymonS = loadImage("Psymon-behind.png");
    PsymonD = loadImage("Psymon-side-right.png");
    PsymonOld = loadImage("Psymon-old.png");
    WhyattW = loadImage("Whyatt.png");
    /*
    WhyattA = loadImage("Whyatt-
    WhyattS = loadImage("Whyatt-
    WhyattD = loadImage("Whyatt-
    */
    Map = loadImage("template_map.png");
  }
  public void MAINRENDER() {
    image(Map,width/2-(mapSizeX*scale/2),height/2-(mapSizeY*scale/2),mapSizeX*scale,mapSizeY*scale);
    Psymon();
  }
  public void Psymon() {
    image(PsymonW,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);

  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
