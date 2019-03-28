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
mapSizeX, mapSizeY, scale, mapX, mapY, zone,
playerDirection;
  /*
  1 = [w] up
  2 = [a] left
  3 = [s] down
  4 = [d] left
  */
render r;
public void setup() {
  frameRate(144);
  
  background(30);
  scale=4;
  psymonSize=32;
  mapSizeX=640;
  mapSizeY=480;
  walkSpeed=15;
  playerX=width/2-((psymonSize*scale)/2);
  playerY=height/2-((psymonSize*scale)/2);
  mapX = width/2-(mapSizeX*scale/2);
  mapY =height/2-(mapSizeY*scale/2);
  r= new render(psymonSize, scale, mapSizeX, mapSizeY, mapX, mapY);
  zone=0;
}
public void draw() {
  if(keyPressed) {
    switch(key) {
      default:
      break; case 'w':
        mapY=mapY+walkSpeed;
        playerDirection = 1;
      break; case 'a':
        mapX=mapX+walkSpeed;
        playerDirection = 2;
      break; case 's':
        mapY=mapY-walkSpeed;
        playerDirection = 3;
      break; case 'd':
        mapX=mapX-walkSpeed;
        playerDirection = 4;
      break;
    }
  }
  r.updateDirection(playerDirection);
  r.updateXY(mapX,mapY);
  r.MAINRENDER(zone);
}
class render {
  PImage PsymonW,PsymonA,PsymonS,PsymonD,
  WhyattW,WhyattA,WhyattS,WhyattD,
  Map,
  PsymonOld
  ;
  int psymonSize, scale, mapSizeX, mapSizeY, mapX, mapY,direction;
  public render(int ps, int s, int msX, int msY, int mX, int mY) {
    //require input
    psymonSize = ps;
    scale = s;
    mapSizeX = msX;
    mapSizeY = msY;
    mapX = mX;
    mapY = mY;
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
  public void MAINRENDER(int renderZone) {
    switch (renderZone) {
      default:
        image(Map,mapX,mapY,mapSizeX*scale,mapSizeY*scale);
        Psymon();
      break; case 0:
        image(Map,mapX,mapY,mapSizeX*scale,mapSizeY*scale);
        Psymon();
      break;
    }
    image(Map,mapX,mapY,mapSizeX*scale,mapSizeY*scale);
    Psymon();
  }
  public void updateXY(int o, int p) {
    mapX=o;
    mapY=p;
  }
  public void updateDirection(int t) {
    direction=t;
  }
  public void Psymon() {
    switch (direction) {
      default:
        image(PsymonW,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break; case 1:
        image(PsymonW,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break; case 2:
        image(PsymonA,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break; case 3:
        image(PsymonS,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break; case 4:
        image(PsymonD,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break;
    }

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
