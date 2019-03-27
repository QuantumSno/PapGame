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

PImage Psymon,Whyatt,Map;
int playerX , playerY , walkSpeed , psymonSize , mapSizeX , mapSizeY , scale;
public void setup() {
  
  scale=4;
  psymonSize=32;
  mapSizeX=640;
  mapSizeY=480;
  walkSpeed=5;
  playerX=width/2-((psymonSize*scale)/2);
  playerY=height/2-((psymonSize*scale)/2);
  Psymon = loadImage("Psymon.png");
  Whyatt = loadImage("Whyatt.png");
  Map = loadImage("template_map.png");
}
public void draw() {
  switch(key) {
    case 'w': playerY=playerY+walkSpeed; break;
    case 'a': playerX=playerX-walkSpeed; break;
    case 's': playerY=playerY+walkSpeed; break;
    case 'd': playerX=playerX+walkSpeed; break;
    default: break;
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
