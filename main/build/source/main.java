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

int scale, flipTime, flip, zone, x, y, walkSpeed;
Psymon psymon;
Map map;
boolean move;
public void setup() {
  move=true;
  
  flipTime=5;
  flip=0;
  zone=0;
  x=0;
  y=0;
  walkSpeed=5;
  imageMode(CENTER);
  psymon= new Psymon();
  map= new Map();
  //image(map.m(), x, y);
  //image(psymon.pW(), width/2, height/2);
}
public void draw() {
  if(flip>=flipTime*4)
    flip=0;
    if(move)
    keyPressed();
}

public void keyPressed() {
  move=true;
  image(map.m(), x, y);
  flip++;
  switch(key) {
    default: image(psymon.pS(),width/2,height/2);
    break; case 'w':
      y=y+walkSpeed;
      if(!map.boarderUp())
        if(flip>=0 && flip<flipTime)
          image(psymon.pW1(), width/2, height/2);
        else if(flip>=flipTime && flip<flipTime*2)
          image(psymon.pW2(), width/2, height/2);
        else if(flip>=flipTime*2 && flip<flipTime*3)
          image(psymon.pW1(), width/2, height/2);
        else
          image(psymon.pW2(), width/2, height/2);
    break; case 'a':
      x=x+walkSpeed;
      if(!map.boarderLeft())
        if(flip>=0 && flip<flipTime)
          image(psymon.pA1(), width/2, height/2);
        else if(flip>=flipTime && flip<flipTime*2)
          image(psymon.pA2(), width/2, height/2);
        else if(flip>=flipTime*2 && flip<flipTime*3)
          image(psymon.pA3(), width/2, height/2);
        else
          image(psymon.pA4(), width/2, height/2);
    break; case 's':
    y=y-walkSpeed;
    if(!map.boarderDown())
      if(flip>=0 && flip<flipTime)
        image(psymon.pS1(), width/2, height/2);
      else if(flip>=flipTime && flip<flipTime*2)
        image(psymon.pS2(), width/2, height/2);
      else if(flip>=flipTime*2 && flip<flipTime*3)
        image(psymon.pS1(), width/2, height/2);
      else
        image(psymon.pS2(), width/2, height/2);
    break; case 'd':
    x=x-walkSpeed;
      if(!map.boarderRight())
        if(flip>=0 && flip<flipTime)
          image(psymon.pD1(), width/2, height/2);
        else if(flip>=flipTime && flip<flipTime*2)
          image(psymon.pD2(), width/2, height/2);
        else if(flip>=flipTime*2 && flip<flipTime*3)
          image(psymon.pD3(), width/2, height/2);
        else
          image(psymon.pD4(), width/2, height/2);
    break;
  }
}
public void keyReleased() {
  move=false;
  image(map.m(), x, y);
  switch(key) {
    default: image(psymon.pS(),width/2,height/2);
    break; case 'w': image(psymon.pW(), width/2, height/2);
    break; case 'a': image(psymon.pA(), width/2, height/2);
    break; case 's': image(psymon.pS(), width/2, height/2);
    break; case 'd': image(psymon.pD(), width/2, height/2);
    break;
  }
}
class Map {
  PGraphics map;
  int scale;
  public Map() {
    scale=4;
    map = createGraphics(840*scale,640*scale);
    loadMap();
  }

  public PImage m() { return map; }

  public void loadMap() {
    map.beginDraw();
    map.noStroke();
    map.image(loadImage("template_map.png"),0,0,840*scale,640*scale);
    map.endDraw();
  }
  public boolean boarderUp() {
    if(false)
      return true;
    else
      return false;
  }
  public boolean boarderLeft() {
    if(false)
      return true;
    else
      return false;
  }

  public boolean boarderDown() {
    if(false)
      return true;
    else
      return false;
  }
  public boolean boarderRight() {
    if(false)
      return true;
    else
      return false;
  }
}
class Psymon {
  PGraphics
  PsymonW, PsymonA, PsymonS, PsymonD,
  PsymonWw1, PsymonAw1, PsymonSw1, PsymonDw1,
  PsymonWw2, PsymonAw2, PsymonSw2, PsymonDw2,
  PsymonAw3, PsymonAw4, PsymonDw3, PsymonDw4;
  int scale, size;
  public Psymon() {
    scale=4;
    size=32*scale;
    PsymonW = createGraphics(size,size);
    PsymonWw1 = createGraphics(size,size);
    PsymonWw2 = createGraphics(size,size);
    PsymonA = createGraphics(size,size);
    PsymonAw1 = createGraphics(size,size);
    PsymonAw2 = createGraphics(size,size);
    PsymonAw3 = createGraphics(size,size);
    PsymonAw4 = createGraphics(size,size);
    PsymonS = createGraphics(size,size);
    PsymonSw1 = createGraphics(size,size);
    PsymonSw2 = createGraphics(size,size);
    PsymonD = createGraphics(size,size);
    PsymonDw1 = createGraphics(size,size);
    PsymonDw2 = createGraphics(size,size);
    PsymonDw3 = createGraphics(size,size);
    PsymonDw4 = createGraphics(size,size);

    loadPsymon();
  }

  public PImage pW() { return PsymonW; }
  public PImage pA() { return PsymonA; }
  public PImage pS() { return PsymonS; }
  public PImage pD() { return PsymonD; }

  public PImage pW1() { return PsymonWw1; }
  public PImage pW2() { return PsymonWw2; }

  public PImage pA1() { return PsymonAw1; }
  public PImage pA2() { return PsymonAw2; }
  public PImage pA3() { return PsymonAw3; }
  public PImage pA4() { return PsymonAw4; }

  public PImage pS1() { return PsymonSw1; }
  public PImage pS2() { return PsymonSw2; }

  public PImage pD1() { return PsymonDw1; }
  public PImage pD2() { return PsymonDw2; }
  public PImage pD3() { return PsymonDw3; }
  public PImage pD4() { return PsymonDw4; }

  public void loadPsymon() {
    PsymonW.beginDraw();
    PsymonW.noStroke();
    PsymonW.image(loadImage("Psymon-behind.png"),0,0,size,size);
    PsymonW.endDraw();
    PsymonWw1.beginDraw();
    PsymonWw1.noStroke();
    PsymonWw1.image(loadImage("Psymon-behind-walking-1.png"),0,0,size,size);
    PsymonWw1.endDraw();
    PsymonWw2.beginDraw();
    PsymonWw2.noStroke();
    PsymonWw2.image(loadImage("Psymon-behind-walking-2.png"),0,0,size,size);
    PsymonWw2.endDraw();

    PsymonA.beginDraw();
    PsymonA.noStroke();
    PsymonA.image(loadImage("Psymon-side-left.png"),0,0,size,size);
    PsymonA.endDraw();
    PsymonAw1.beginDraw();
    PsymonAw1.noStroke();
    PsymonAw1.image(loadImage("Psymon-side-left-walking-1.png"),0,0,size,size);
    PsymonAw1.endDraw();
    PsymonAw2.beginDraw();
    PsymonAw2.noStroke();
    PsymonAw2.image(loadImage("Psymon-side-left-walking-2.png"),0,0,size,size);
    PsymonAw2.endDraw();
    PsymonAw3.beginDraw();
    PsymonAw3.noStroke();
    PsymonAw3.image(loadImage("Psymon-side-left-walking-3.png"),0,0,size,size);
    PsymonAw3.endDraw();
    PsymonAw4.beginDraw();
    PsymonAw4.noStroke();
    PsymonAw4.image(loadImage("Psymon-side-left-walking-4.png"),0,0,size,size);
    PsymonAw4.endDraw();

    PsymonS.beginDraw();
    PsymonS.noStroke();
    PsymonS.image(loadImage("Psymon-front.png"),0,0,size,size);
    PsymonS.endDraw();
    PsymonSw1.beginDraw();
    PsymonSw1.noStroke();
    PsymonSw1.image(loadImage("Psymon-front-walking-1.png"),0,0,size,size);
    PsymonSw1.endDraw();
    PsymonSw2.beginDraw();
    PsymonSw2.noStroke();
    PsymonSw2.image(loadImage("Psymon-front-walking-2.png"),0,0,size,size);
    PsymonSw2.endDraw();

    PsymonD.beginDraw();
    PsymonD.noStroke();
    PsymonD.image(loadImage("Psymon-side-right.png"),0,0,size,size);
    PsymonD.endDraw();
    PsymonDw1.beginDraw();
    PsymonDw1.noStroke();
    PsymonDw1.image(loadImage("Psymon-side-right-walking-1.png"),0,0,size,size);
    PsymonDw1.endDraw();
    PsymonDw2.beginDraw();
    PsymonDw2.noStroke();
    PsymonDw2.image(loadImage("Psymon-side-right-walking-2.png"),0,0,size,size);
    PsymonDw2.endDraw();
    PsymonDw3.beginDraw();
    PsymonDw3.noStroke();
    PsymonDw3.image(loadImage("Psymon-side-right-walking-3.png"),0,0,size,size);
    PsymonDw3.endDraw();
    PsymonDw4.beginDraw();
    PsymonDw4.noStroke();
    PsymonDw4.image(loadImage("Psymon-side-right-walking-4.png"),0,0,size,size);
    PsymonDw4.endDraw();
  }
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
