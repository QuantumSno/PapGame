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
PsymonWw1, PsymonAw1, PsymonSw1, PsymonDw1,
PsymonWw2, PsymonAw2, PsymonSw2, PsymonDw2;
int playerSize, scale,
mapSizeX, mapSizeY,
x, y, flip, flipFrames;
 /*
 1 = [w] up
 2 = [a] left
 3 = [s] down
 4 = [d] left
 */

public void setup() {
  flip=0;
  flipFrames=5;
  mapSizeX=840;
  mapSizeY=640;
  x=x-mapSizeX/2;
  y=y-mapSizeX/2;
  scale=4;
  playerSize=32;
  
  PsymonW = createGraphics(playerSize*scale,playerSize*scale);
  PsymonA = createGraphics(playerSize*scale,playerSize*scale);
  PsymonS = createGraphics(playerSize*scale,playerSize*scale);
  PsymonD = createGraphics(playerSize*scale,playerSize*scale);
  PsymonWw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonWw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonSw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonSw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw2 = createGraphics(playerSize*scale,playerSize*scale);
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
      break; case 'w': y++; image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonWw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonWw2,356,256);flip++;} else {image(PsymonW,356,256);flip=0;}
      break; case 'a': x++; image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonAw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonAw2,356,256);flip++;} else {image(PsymonA,356,256);flip=0;}
      break; case 's': y--; image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonSw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonSw2,356,256);flip++;} else {image(PsymonS,356,256);flip=0;}
      break; case 'd': x--; image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonDw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonDw2,356,256);flip++;} else {image(PsymonD,356,256);flip=0;}
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

  PsymonWw1.beginDraw();
  PsymonWw1.noStroke();
  PsymonWw1.image(loadImage("Psymon-behind-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonWw1.endDraw();
  PsymonWw2.beginDraw();
  PsymonWw2.noStroke();
  PsymonWw2.image(loadImage("Psymon-behind-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonWw2.endDraw();
  PsymonAw1.beginDraw();
  PsymonAw1.noStroke();
  PsymonAw1.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw1.endDraw();
  PsymonAw2.beginDraw();
  PsymonAw2.noStroke();
  PsymonAw2.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw2.endDraw();
  PsymonSw1.beginDraw();
  PsymonSw1.noStroke();
  PsymonSw1.image(loadImage("Psymon-front-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonSw1.endDraw();
  PsymonSw2.beginDraw();
  PsymonSw2.noStroke();
  PsymonSw2.image(loadImage("Psymon-front-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonSw2.endDraw();
  PsymonDw1.beginDraw();
  PsymonDw1.noStroke();
  PsymonDw1.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw1.endDraw();
  PsymonDw2.beginDraw();
  PsymonDw2.noStroke();
  PsymonDw2.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw2.endDraw();

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
