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

PGraphics Psymon;
PImage PsymonI;
int playerSize, x, y, scale;
public void setup() {
  scale=4;
  playerSize=32;
  
  Psymon = createGraphics(playerSize*scale,playerSize*scale);
  PsymonI=loadImage("Psymon-front.png");
}
public void draw() {
  render();
  image(Psymon,width/2,height/2);
}
public void render() {
  Psymon.beginDraw();
  Psymon.noStroke();
  Psymon.image(PsymonI,0,0,playerSize*scale,playerSize*scale);
  //Psymon.background(30);
  Psymon.endDraw();
}
  public void settings() {  size(840,640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
