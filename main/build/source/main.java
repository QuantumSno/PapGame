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
ui ui;
boolean move;
public void setup() {
  move = true;
  
  flipTime = 10;
  flip = 0;
  zone = 0;
  x = 0;
  y = 0;
  walkSpeed = 5;
  imageMode(CENTER);
  psymon = new Psymon();
  map = new Map();
  ui = new ui();
  map.m(x,y);
  psymon.pS();
}
public void draw() {
  if (flip >= flipTime * 4)
  flip = 0;
  if (keyPressed)
    if (move)
        keyPressed();
  if (zone == 1) {
    map.m(x,y);
    psymon.pS();
    ui.tab1();
  } else if (zone == 2) {
    map.m(x,y);
    psymon.pS();
    ui.tab2();
  } else if (zone == 3) {
    map.m(x,y);
    psymon.pS();
    ui.tab3();
  }
}

  public void keyPressed() {
  if (keyPressed)
    map.m(x,y);
  flip++;
  switch (key) {
    default: psymon.pS();
    break;
    case 'w':
      if (move) {
        y = y + walkSpeed;
        if (!map.boarderUp())
          if (flip >= 0 && flip < flipTime)
            psymon.pW1();
          else if (flip >= flipTime && flip < flipTime * 2)
            psymon.pW2();
          else if (flip >= flipTime * 2 && flip < flipTime * 3)
            psymon.pW1();
          else
            psymon.pW2();
      }
    break;
    case 'a':
      if (move) {
        x = x + walkSpeed;
        if (!map.boarderLeft())
          if (flip >= 0 && flip < flipTime)
            psymon.pA1();
          else if (flip >= flipTime && flip < flipTime * 2)
            psymon.pA2();
          else if (flip >= flipTime * 2 && flip < flipTime * 3)
            psymon.pA3();
          else
            psymon.pA4();
      }
    break;
    case 's':
      if (move) {
        y = y - walkSpeed;
        if (!map.boarderDown())
          if (flip >= 0 && flip < flipTime)
            psymon.pS1();
          else if (flip >= flipTime && flip < flipTime * 2)
            psymon.pS2();
          else if (flip >= flipTime * 2 && flip < flipTime * 3)
            psymon.pS1();
          else
            psymon.pS2();
      }
    break;
    case 'd':
      if (move) {
        x = x - walkSpeed;
        if (!map.boarderRight())
          if (flip >= 0 && flip < flipTime)
            psymon.pD1();
          else if (flip >= flipTime && flip < flipTime * 2)
            psymon.pD2();
          else if (flip >= flipTime * 2 && flip < flipTime * 3)
            psymon.pD3();
          else
          psymon.pD4();
      }
    break;
    case TAB:
      zone = 1;
      delay(100);
      move = false;
    break;
  }
}
public void keyReleased() {
  map.m(x,y);
  switch (key) {
    default: psymon.pS();
    break;
    case 'w':
      psymon.pW();
      if (zone == 2)
        zone = 1;
      if (zone == 3)
        zone = 2;
    break;
    case 'a':
      psymon.pA();
    break;
    case 's':
      psymon.pS();
      if (zone == 1)
        zone = 2;
      if (zone == 2)
        zone = 3;
    break;
    case 'd':
      psymon.pD();
    break;
    case ENTER:
      if (zone == 1)
      zone = 0;
      move=true;
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

  public void m(int x, int y) { image(map, x, y); }

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

  public void pW() { image(PsymonW, width/2, height/2); }
  public void pA() { image(PsymonA, width/2, height/2); }
  public void pS() { image(PsymonS, width/2, height/2); }
  public void pD() { image(PsymonD, width/2, height/2); }

  public void pW1() { image(PsymonWw1, width/2, height/2); }
  public void pW2() { image(PsymonWw2, width/2, height/2); }

  public void pA1() { image(PsymonAw1, width/2, height/2); }
  public void pA2() { image(PsymonAw2, width/2, height/2); }
  public void pA3() { image(PsymonAw3, width/2, height/2); }
  public void pA4() { image(PsymonAw4, width/2, height/2); }

  public void pS1() { image(PsymonSw1, width/2, height/2); }
  public void pS2() { image(PsymonSw2, width/2, height/2); }

  public void pD1() { image(PsymonDw1, width/2, height/2); }
  public void pD2() { image(PsymonDw2, width/2, height/2); }
  public void pD3() { image(PsymonDw3, width/2, height/2); }
  public void pD4() { image(PsymonDw4, width/2, height/2); }

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
class ui {
  PGraphics tab1, tab2, tab3;
  int scale;
  public ui() {
    scale=4;
    tab1 = createGraphics(width,height);
    tab2 = createGraphics(width,height);
    tab3 = createGraphics(width,height);
    loadUi();
  }

  public void tab1() { image(tab1, width/2, height/2); }
  public void tab2() { image(tab2, width/2, height/2); }
  public void tab3() { image(tab3, width/2, height/2); }


  public void loadUi() {
    tab1.beginDraw();
    tab1.noStroke();
    tab1.image(loadImage("tab1.png"),0,0,width,height);
    tab1.endDraw();

    tab2.beginDraw();
    tab2.noStroke();
    tab2.image(loadImage("tab2.png"),0,0,width,height);
    tab2.endDraw();

    tab3.beginDraw();
    tab3.noStroke();
    tab3.image(loadImage("tab3.png"),0,0,width,height);
    tab3.endDraw();
  }
}
  public void settings() {  size(840, 640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
