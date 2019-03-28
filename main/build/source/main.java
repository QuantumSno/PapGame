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

PGraphics Map,
PsymonW, PsymonA, PsymonS, PsymonD,
PsymonWw, PsymonAw, PsymonSw, PsymonDw
;
int playerSize, scale,
mapSizeX, mapSizeY,
x, y;
 /*
 1 = [w] up
 2 = [a] left
 3 = [s] down
 4 = [d] left
 */

public void setup() {
  mapSizeX=840;
  mapSizeY=640;
  scale=4;
  playerSize=32;
  
  PsymonW = createGraphics(playerSize*scale,playerSize*scale);
  PsymonA = createGraphics(playerSize*scale,playerSize*scale);
  PsymonS = createGraphics(playerSize*scale,playerSize*scale);
  PsymonD = createGraphics(playerSize*scale,playerSize*scale);
  PsymonWw = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw = createGraphics(playerSize*scale,playerSize*scale);
  PsymonSw = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw = createGraphics(playerSize*scale,playerSize*scale);
  Map = createGraphics(mapSizeX*scale,mapSizeY*scale);
  render();
}
public void draw() {
  image(Map,x,y);
  switch(key) {
    default: image(PsymonW,356,256);
    break; case 'w': image(PsymonW,356,256);
    break; case 'a': image(PsymonA,356,256);
    break; case 's': image(PsymonS,356,256);
    break; case 'd': image(PsymonD,356,256);
    break;
  }
  if(keyPressed) {
    switch(key) {
      default: image(PsymonW,356,256);
      break; case 'w': y++; image(Map,x,y); image(PsymonWw,356,256);
      break; case 'a': x++; image(Map,x,y); image(PsymonAw,356,256);
      break; case 's': y--; image(Map,x,y); image(PsymonSw,356,256);
      break; case 'd': x--; image(Map,x,y); image(PsymonDw,356,256);

      break;
    }
  }
}
public void render() {
  PsymonW.beginDraw();
  PsymonW.noStroke();
  PsymonW.image(loadImage("Psymon-behind.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonW.endDraw();
  PsymonA.beginDraw();
  PsymonA.noStroke();
  PsymonA.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonA.endDraw();
  PsymonS.beginDraw();
  PsymonS.noStroke();
  PsymonS.image(loadImage("Psymon-front.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonS.endDraw();
  PsymonD.beginDraw();
  PsymonD.noStroke();
  PsymonD.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonD.endDraw();

  PsymonWw.beginDraw();
  PsymonWw.noStroke();
  PsymonWw.image(loadImage("Psymon-behind-walking.gif"),0,0,playerSize*scale,playerSize*scale);
  PsymonWw.endDraw();
  PsymonAw.beginDraw();
  PsymonAw.noStroke();
  PsymonAw.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw.endDraw();
  PsymonSw.beginDraw();
  PsymonSw.noStroke();
  PsymonSw.image(loadImage("Psymon-front-walking.gif"),0,0,playerSize*scale,playerSize*scale);
  PsymonSw.endDraw();
  PsymonDw.beginDraw();
  PsymonDw.noStroke();
  PsymonDw.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw.endDraw();

  Map.beginDraw();
  Map.noStroke();
  Map.image(loadImage("template_map.png"),x,y,mapSizeX*scale,mapSizeY*scale);
  Map.endDraw();
}
  public void settings() {  size(840,640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
