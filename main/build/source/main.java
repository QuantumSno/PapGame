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

  int scale, flip, zone, x, y, walkSpeed, direction, hammer, time, dmg;
  boolean move, talking, doDmg;
  RenderOrder ro;
  Map map;
  ui ui;
  PVector cords;
  String keys="";
  int s, frame, count;
  //map size 2080x1750
public void setup() {
  //noCursor();
  map= new Map();
  ui= new ui();
  move = true;
  
  //fullScreen(P2D);
  flip = 0;
  zone = 0;
  cords = new PVector(0,0);
  direction=0;
  walkSpeed = 5;
  imageMode(CENTER);
  
  clip(width/2, height/2, width, height);
  ro= new RenderOrder(PApplet.parseInt(cords.x), PApplet.parseInt(cords.y));
}
public void draw() {
  if(millis()!=s){
    count++;
    if(count==10) {
      count=0;
      frame++;
    }
  }
  if(frame>4)
    frame=1;
    keys();
  if(zone==4)
    if(ro.shp()<=0) {
      zone=0;
      ro.shpr();
    }
  ro.render(zone, PApplet.parseInt(cords.x), PApplet.parseInt(cords.y), direction, hammer, dmg, doDmg, frame);
  //println("cords.x: " + cords.x + " cords.y: " +  cords.y);
  doDmg=false;
  //println(flip);
}

public void keys() {
  if(zone==0)
    if(keys.contains("w") && !map.boarderUp(PApplet.parseInt(cords.x), PApplet.parseInt(cords.y))) {
      cords.y= cords.y+walkSpeed;
      direction=5;
    } if(keys.contains("a") && !map.boarderLeft(PApplet.parseInt(cords.x), PApplet.parseInt(cords.y))) {
      cords.x= cords.x+walkSpeed;
      direction=6;
    } if(keys.contains("s") && !map.boarderDown(PApplet.parseInt(cords.x), PApplet.parseInt(cords.y))) {
      cords.y= cords.y-walkSpeed;
      direction=7;
    } if(keys.contains("d") && !map.boarderRight(PApplet.parseInt(cords.x), PApplet.parseInt(cords.y))) {
      cords.x= cords.x-walkSpeed;
      direction=8;
    }
  if(zone==4) {
    if(keyPressed) {
      if(key=='e') {
        if(time>=0 && time<=100/4) {
          hammer=1;
          time+=1;
          dmg=1;
        } else if(time>=100/4 && time<=100/2) {
          hammer=2;
          time+=1;
          dmg=2;
        } else if(time>=100/2 && time<100-100/4) {
          hammer=3;
          time+=1;
          dmg=3;
        } else {
          hammer=4;
          dmg=5;
        }
      }
    } else {
      if(time>0)
        time-=1;
      if(time<100-100/4 && time>100/2)
        hammer=5;
      else if(time<=100/2 && time>time/4)
        hammer=6;
      else hammer=1;
    }
  }
  if(zone==0)
    if(keys.contains("w")) direction=1;
    else if(keys.contains("a")) direction=2;
    else if(keys.contains("s")) direction=3;
    else if(keys.contains("d")) direction=4;
    else if(key==TAB) {
      zone=1;
      noLoop();
      ui.tab1();
    } else if(key=='e') {
      textAlign(CENTER, CENTER);
      textSize(42);
      stroke(153);
      fill(0, 102, 153);
        if(ro.wrange(PApplet.parseInt(cords.x), PApplet.parseInt(cords.y))) {
        talking=true;
        noLoop();
        text(ro.wvoice(), cords.x-ro.wgetX(), cords.y-ro.wgetY()-100);
      }
    } else if(key==ENTER && talking) {
      loop();
      talking=false;
    } else if(key=='c') {
      zone=4;
    }
  if(zone==2)
    if(key=='w') {
      zone=1;
      redraw();
    } else if(key=='s') {
      zone=3;
      redraw();
    }
  if(zone==3)
    if(key=='w') {
      zone=2;
      redraw();
    } else if(key==ENTER) {
      exit();
    }
  if(zone==1)
    if(key=='s') {
      redraw();
      zone=2;
    } else if(key==ENTER) {
      zone=0;
      loop();
    }
  if(zone==4)
    if(key=='e')
      doDmg=true;
}

public void keyPressed() {
  keys+=key;
}
public void keyReleased() {
  keys=keys.replace(key+"","");
}
class AI {
  int active=100;
  public boolean gunnawalk() {
    if(PApplet.parseInt(random(1, active))==1) {
      return true;
    }
    else
      return false;
  }
  public int walk() {
    return PApplet.parseInt(random(5, active/2));
  }
  public int direction() {
    return PApplet.parseInt(random(1,5));
  }
  public String voice() {
    return "text";
  }
  public boolean range(int o, int p) {
    if(o>x+420-100 && o< x+420+100 && p>y+310-100 && p<y+310+100)
      return true;
    return false;
  }
}
class Map {
  PGraphics map;
  int scale;
  ArrayList<boarders> boarder = new ArrayList<boarders>();
  public Map() {
    scale=4;
    //map size 2080x1750
    map = createGraphics(2080*scale,1750*scale);
    //map=createGraphics(1000,1000);
    loadMap();
    loadBoarders();
  }

  public void m(int x, int y) { image(map, x, y); }
  public void translate(int x, int y) {
    translate(x, y);
  }
  public void loadMap() {
    map.beginDraw();
    map.noStroke();
    map.background(30);
    map.image(requestImage("collider map.png"),0,0,2080*scale,1750*scale);
    //map.image(requestImage("template_map.png"),0,0,1000,1000);
    map.endDraw();
  }
  public boolean boarderUp(int x, int y) {
    for(int t=0; t<boarder.size(); t++)
      if(boarder.get(t).getD()==1)
        if(boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
          return true;
    return false;
  }
  public boolean boarderLeft(int x, int y) {
    for(int t=0; t<boarder.size(); t++)
    if(boarder.get(t).getD()==2)
        if(boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
          return true;
    return false;
  }
  public boolean boarderDown(int x, int y) {
    for(int t=0; t<boarder.size(); t++)
      if(boarder.get(t).getD()==3)
        if(boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
          return true;
    return false;
  }
  public boolean boarderRight(int x, int y) {
    for(int t=0; t<boarder.size(); t++)
      if(boarder.get(t).getD()==4)
        if(boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
          return true;
    return false;
  }
  public void loadBoarders() {
    //boarder.add(new boarders(, , , , )); //
    boarder.add(new boarders(4305, -1880, 4305, -2095, 2)); //1-2
    boarder.add(new boarders(4305, -1880, 4185, -1880, 1)); //2-3
    boarder.add(new boarders(4185, -1755, 4185, -1880, 2)); //3-4
    boarder.add(new boarders(4180, -1755, 4050, -1755, 1)); //4-5
    boarder.add(new boarders(4050, -1335, 4050, -1755, 2)); //5-6
    boarder.add(new boarders(4305, -1335, 4050, -1335, 3)); //6-7
    boarder.add(new boarders(4305, -1254, 4305, -1335, 2)); //7-8
    boarder.add(new boarders(4305, -1245, 4180, -1245, 1)); //8-9
    boarder.add(new boarders(4180, -1080, 4180, -1245, 2)); //9-10
    boarder.add(new boarders(4305, -1080, 4180, -1080, 3)); //10-11
    boarder.add(new boarders(4305, 920, 4305, -1080, 2)); //11-24
    boarder.add(new boarders(4305, 920, 2765, 915, 1)); //24-25
    boarder.add(new boarders(2765, 1215, 2765, 915, 2)); //25-26
    boarder.add(new boarders(2935, 1215, 2765, 1215, 3)); //26-27
    boarder.add(new boarders(2935, 1215, 2935, 1085, 4)); //27-28
    boarder.add(new boarders(4305, 1085, 2935, 1085, 3)); //28-29
    boarder.add(new boarders(4305, 2570, 4305, 1085, 2)); //29-34
    boarder.add(new boarders(4305, 2570, 2935, 2570, 1)); //34-35
    boarder.add(new boarders(2935, 2570, 2935, 1555, 4)); //35-36
    boarder.add(new boarders(2935, 1555, 2765, 1555, 1)); //36-37
    boarder.add(new boarders(2765, 2570, 2765, 1555, 2)); //37-38
    boarder.add(new boarders(2765, 2570, 2645, 2570, 1)); //38-39
    boarder.add(new boarders(2645, 2740, 2645, 2570, 2)); //39-40
    boarder.add(new boarders(4525, 2740, 2645, 2570, 3)); //40-41
    boarder.add(new boarders(4525, 3080, 4525, 2740, 2)); //41-42
    boarder.add(new boarders(-3590, 3080, 4525, 3080, 1)); //41-125
    boarder.add(new boarders(-3590, 3080, -3590, 2740 , 4)); //125-124
    boarder.add(new boarders(-1930, 2740, -3590, 2740, 3)); //124-123
    boarder.add(new boarders(-1930, 2740, -1930, 2570, 4)); //123-122
    boarder.add(new boarders(-1930, 2570, -2315, 2570, 1)); //122-121
    boarder.add(new boarders(-2315, 2570, -2315, 70, 4)); //121-120
    boarder.add(new boarders(-1460, 70, -2315, 70, 3)); //120-119
    boarder.add(new boarders(-1460, 830, -1460, 70, 2)); //119-118
    boarder.add(new boarders(-1160, 830, -1460, 830, 3)); //117-118
    boarder.add(new boarders(-1160, 830, -1160, 320, 4)); //117-116
    boarder.add(new boarders(-650, 320, -1160, 320, 3)); //116-115
    boarder.add(new boarders(-650, 320, -650, -2010, 4)); //115-114
    boarder.add(new boarders(-650, -2010, -1970, -2010, 1)); //114-113
    boarder.add(new boarders(-1970, -1240, -1970, -2010, 2)); //113-112
    boarder.add(new boarders(-1970, -1240, -2315, -1245, 1)); //112-111
    boarder.add(new boarders(-2315, -1245, -2315, -2605, 4)); //111-110
    boarder.add(new boarders(460, -2905, -2315, -2605, 3)); //110-109
    boarder.add(new boarders(460, 1170, 460, -2905, 2)); //109-108
    boarder.add(new boarders(460, 1170, -1455, 1170, 1)); //108-107
    boarder.add(new boarders(-1455, 2570, -1455, 1170, 2)); //107-106
    boarder.add(new boarders(-1455, 2570, -1835, 2570, 1)); //106-105
    boarder.add(new boarders(-1840, 2740, -1835, 2570, 2)); //105-104///
    boarder.add(new boarders(2290, 2740, -1840, 2740, 3)); //104-43
    boarder.add(new boarders(2290, 2740, 2290, 2570, 4)); //43-44
    boarder.add(new boarders(2290, 2570, 2165, 2570, 1)); //44-45
    boarder.add(new boarders(2165, 2570, 2165, 1300, 4)); //45-46
    boarder.add(new boarders(2165, 1300, 1235, 1300, 1)); //46-55
    boarder.add(new boarders(1235, 1465, 1235, 1300, 2)); //55-56
    boarder.add(new boarders(1995, 1465, 1235, 1465, 3)); //56-57
    boarder.add(new boarders(1995, 2570, 1995, 1465, 2)); //57-62
    boarder.add(new boarders(1995, 2570, 630, 2570, 1)); //62-63
    boarder.add(new boarders(630, 2570, 630, 1470, 4)); //63-68
    boarder.add(new boarders(885, 1470, 630, 1470, 3)); //68-69
    boarder.add(new boarders(885, 1470, 885, 1300, 4)); //69-70
    boarder.add(new boarders(885, 1300, 630, 1300, 1)); //70-71
    boarder.add(new boarders(630, 1300, 630, 195, 4)); //71-72
    boarder.add(new boarders(890, 195, 195, 630, 3)); //72-73
    boarder.add(new boarders(890, 195, 890, 25, 4)); //73-74
    boarder.add(new boarders(890, 25, 630, 25, 1)); //74-75
    boarder.add(new boarders(630, 25, 630, -1330, 4)); //75-88
    boarder.add(new boarders(2000, -1330, 630, -1330, 3)); //88-89
    boarder.add(new boarders(2000, -955, 2000, -1330, 2)); //89-90
    boarder.add(new boarders(2165, -955, 2000, -955, 3)); //90-91
    boarder.add(new boarders(2165, -955, 2165, -1500, 4)); //91-101
    boarder.add(new boarders(2165, -1500, 630, -1500, 1)); //101-102
    boarder.add(new boarders(630, -1500, 630, -2095, 4)); //102-103
    boarder.add(new boarders(4305, -2095, 630, -2095, 3)); //103-1
  }
}
class Psymon {
  PGraphics
  PsymonW, PsymonA, PsymonS, PsymonD,
  PsymonWw1, PsymonAw1, PsymonSw1, PsymonDw1,
  PsymonWw2, PsymonAw2, PsymonSw2, PsymonDw2,
  PsymonAw3, PsymonAw4, PsymonDw3, PsymonDw4,
  PsymonB1, PsymonB2, PsymonB3, PsymonB4, PsymonB5, PsymonB6;
  int scale, size, hp;
  public Psymon() {
    hp=20;
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
    PsymonB1 = createGraphics(size*2,size*2);
    PsymonB2 = createGraphics(size*2,size*2);
    PsymonB3 = createGraphics(size*2,size*2);
    PsymonB4 = createGraphics(size*2,size*2);
    PsymonB5 = createGraphics(size*2,size*2);
    PsymonB6 = createGraphics(size*2,size*2);

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

  public void pB1() { image(PsymonB1, width/4, height/2); }
  public void pB2() { image(PsymonB2, width/4, height/2); }
  public void pB3() { image(PsymonB3, width/4, height/2); }
  public void pB4() { image(PsymonB4, width/4, height/2); }
  public void pB5() { image(PsymonB5, width/4, height/2); }
  public void pB6() { image(PsymonB6, width/4, height/2); }

  public int hp() { return hp; }
  public void dmg(int d) { hp-=d; }

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

    PsymonB1.beginDraw();
    PsymonB1.noStroke();
    PsymonB1.image(loadImage("psymon-bat-1.png"),0,0,size*2,size*2);
    PsymonB1.endDraw();
    PsymonB2.beginDraw();
    PsymonB2.noStroke();
    PsymonB2.image(loadImage("psymon-bat-2.png"),0,0,size*2,size*2);
    PsymonB2.endDraw();
    PsymonB3.beginDraw();
    PsymonB3.noStroke();
    PsymonB3.image(loadImage("psymon-bat-3.png"),0,0,size*2,size*2);
    PsymonB3.endDraw();
    PsymonB4.beginDraw();
    PsymonB4.noStroke();
    PsymonB4.image(loadImage("psymon-bat-4.png"),0,0,size*2,size*2);
    PsymonB4.endDraw();
    PsymonB5.beginDraw();
    PsymonB5.noStroke();
    PsymonB5.image(loadImage("Psymon-side-right.png"),0,0,size*2,size*2);
    PsymonB5.endDraw();
    PsymonB6.beginDraw();
    PsymonB6.noStroke();
    PsymonB6.image(loadImage("Psymon-side-right.png"),0,0,size*2,size*2);
    PsymonB6.endDraw();
  }
}
class RenderOrder {
    float s;
    Psymon psymon;
    Map map;
    ui ui;
    Whyatt whyatt;
    Surman surman;
    int wd, wdt, wdd, ws;
  public RenderOrder(int x, int y) {
    ws=3;
    psymon = new Psymon();
    map = new Map();
    ui = new ui();
    whyatt = new Whyatt(0,0);
    surman= new Surman();
    map.m(x,y);
    psymon.pS();
  }

  public void render(int zone, int x, int y, int direction, int hammer, int dmg, boolean doDmg, int frame) {
    map.m(x,y);
    if(zone==0) {
      aiTests();
      whyatt();
      psymon();
    } else if(zone==1) {
      map.m(x, y);
      whyatt();
      psymon();
      ui.tab1();
    } else if(zone==2) {
      map.m(x, y);
      whyatt();
      psymon();
      ui.tab2();
    } else if(zone==3) {
      map.m(x, y);
      whyatt();
      psymon();
      ui.tab3();
    } else if(zone==4) {
      background(40);
      if(doDmg) {
        surman.hit(dmg);
        delay(100);
        psymon.dmg(surman.dmg());
      }
      switch(hammer) {
        default: psymon.pB1();
        break; case 1: psymon.pB1();
        break; case 2: psymon.pB2();
        break; case 3: psymon.pB3();
        break; case 4: psymon.pB4();
        break; case 5: psymon.pB5();
        break; case 6: psymon.pB6();
        break;
      }
      surman.s();
      textAlign(CENTER, CENTER);
      textSize(32);
      fill(255,0,0);
      text(psymon.hp(), width/4, height-height/4);
      text(surman.hp(), width-width/4, height-height/4);
    }
  }
  public void aiTests() {
    whyatt();
  }
  public int shp() { return surman.hp(); }
  public void shpr() { surman.reset(); }
  public String wvoice() {
    return whyatt.voice(PApplet.parseInt(random(1,4)));
  }
  public boolean wrange(int x, int y) {
    return whyatt.range(x,y);
  }
  public int wgetX() {
    return whyatt.getX();
  }
  public int wgetY() {
    return whyatt.getY();
  }
  public void whyatt() {
    if(whyatt.gunnawalk()) {
      wd=whyatt.walk();
      wdd=whyatt.direction();
      wdt=0;
    }
    if(wdt<wd) {
      switch(wdd) {
        case 1:
          whyatt.update(whyatt.getX(),whyatt.getY()+ws);
          if(frame==1)
            whyatt.wS1(x, y);
          else if(frame==2)
            whyatt.wS2(x, y);
          else if(frame==3)
            whyatt.wS1(x, y);
          else
            whyatt.wS2(x, y);
          flip++;
          break;
        case 2:
          whyatt.update(whyatt.getX()-ws,whyatt.getY());
          if(frame==1)
            whyatt.wS1(x, y);
          else if(frame==2)
            whyatt.wS2(x, y);
          else if(frame==3)
            whyatt.wS1(x, y);
          else
            whyatt.wS2(x, y);
          flip++;
          break;
        case 3:
          whyatt.update(whyatt.getX(),whyatt.getY()-ws);
          if(frame==1)
            whyatt.wS1(x, y);
          else if(frame==2)
            whyatt.wS2(x, y);
          else if(frame==3)
            whyatt.wS1(x, y);
          else
            whyatt.wS2(x, y);
          flip++;
          break;
        case 4:
          whyatt.update(whyatt.getX()+ws,whyatt.getY());
          if(frame==1)
            whyatt.wS1(x, y);
          else if(frame==2)
            whyatt.wS2(x, y);
          else if(frame==3)
            whyatt.wS1(x, y);
          else
            whyatt.wS2(x, y);
          flip++;
          break;
      }
      wdt++;
    } else {
      switch(wdd) {
        default: whyatt.wS(x, y); break;
        case 1: whyatt.wS(x, y); break;
        case 2: whyatt.wS(x, y); break;
        case 3: whyatt.wS(x, y); break;
        case 4: whyatt.wS(x, y); break;
      }
    }
  }
  public void psymon() {
    switch(direction) {
      default: psymon.pS(); break;
      case 1: psymon.pW(); break;
      case 2: psymon.pA(); break;
      case 3: psymon.pS(); break;
      case 4: psymon.pD(); break;
      case 5:
        if(frame==1)
          psymon.pW1();
        else if(frame==2)
          psymon.pW2();
        else if(frame==3)
          psymon.pW1();
        else
          psymon.pW2();
        break;
      case 6:
        if(frame==1)
          psymon.pA1();
        else if(frame==2)
          psymon.pA2();
        else if(frame==3)
          psymon.pA3();
        else
          psymon.pA4();
        break;
      case 7:
        if(frame==1)
          psymon.pS1();
        else if(frame==2)
          psymon.pS2();
        else if(frame==3)
          psymon.pS1();
        else
          psymon.pS2();
        break;
      case 8:
        if(frame==1)
          psymon.pD1();
        else if(frame==2)
          psymon.pD2();
        else if(frame==3)
          psymon.pD3();
        else
          psymon.pD4();
        break;
    }
  }
}
class Surman extends AI {
  int size, scale, hp, dmg, hitChance;
  PGraphics surman;
  public Surman() {
    scale=4;
    size=32*scale;
    surman = createGraphics(size*2,size*2);
    hp=20;
    hitChance=5; // 1/5 chance
    dmg=5;
    loadsurman();
  }
  public void s() { image(surman, width-width/4, height/2); }
  public int dmg() {
    if(PApplet.parseInt(random(1,3))==1)
      return dmg;
    return 0;
  }
  public void hit(int d) { hp-=d; }
  public int hp() { return hp; }
  public void reset() { hp=20; }
  public void loadsurman() {
    surman.beginDraw();
    surman.noStroke();
    surman.image(loadImage("surman.png"),0,0,size*2,size*2);
    surman.endDraw();
  }
}
class Whyatt extends AI {
  PGraphics
  WhyattW, WhyattA, WhyattS, WhyattD,
  WhyattWw1, WhyattAw1, WhyattSw1, WhyattDw1,
  WhyattWw2, WhyattAw2, WhyattSw2, WhyattDw2,
  WhyattAw3, WhyattAw4, WhyattDw3, WhyattDw4;
  int scale, size, x, y;
public Whyatt(int o, int p) {
  x=o;
  y=p;
  scale=4;
  size=38*scale;
  WhyattW = createGraphics(size,size);
  WhyattWw1 = createGraphics(size,size);
  WhyattWw2 = createGraphics(size,size);
  WhyattA = createGraphics(size,size);
  WhyattAw1 = createGraphics(size,size);
  WhyattAw2 = createGraphics(size,size);
  WhyattAw3 = createGraphics(size,size);
  WhyattAw4 = createGraphics(size,size);
  WhyattS = createGraphics(size,size);
  WhyattSw1 = createGraphics(size,size);
  WhyattSw2 = createGraphics(size,size);
  WhyattD = createGraphics(size,size);
  WhyattDw1 = createGraphics(size,size);
  WhyattDw2 = createGraphics(size,size);
  WhyattDw3 = createGraphics(size,size);
  WhyattDw4 = createGraphics(size,size);
  loadWhyatt();
}
public void update(int o, int p) {
  x=o;
  y=p;
}
public String voice(int voiceline) {
  if(voiceline==1)
    return "Hello!";
  else if(voiceline==2)
    return "Goodday Sir";
  else if(voiceline==3)
    return "The whether is nice today";
  else
    return "error";
}
public int getX() {
  return x;
}
public int getY() {
  return y;
}
public boolean range(int o, int p) {
  if(o>x+420-100 && o< x+420+100 && p>y+310-100 && p<y+310+100)
    return true;
  return false;
}

public void wW(int o, int p) { image(WhyattW, o-x, p-y); }
public void wA(int o, int p) { image(WhyattA, o-x, p-y); }
public void wS(int o, int p) { image(WhyattS, o-x, p-y); }
public void wD(int o, int p) { image(WhyattD, o-x, p-y); }

public void wW1(int o, int p) { image(WhyattWw1, o-x, p-y); }
public void wW2(int o, int p) { image(WhyattWw2, o-x, p-y); }

public void wA1(int o, int p) { image(WhyattAw1, o-x, p-y); }
public void wA2(int o, int p) { image(WhyattAw2, o-x, p-y); }
public void wA3(int o, int p) { image(WhyattAw3, o-x, p-y); }
public void wA4(int o, int p) { image(WhyattAw4, o-x, p-y); }

public void wS1(int o, int p) { image(WhyattSw1, o-x, p-y); }
public void wS2(int o, int p) { image(WhyattSw2, o-x, p-y); }

public void wD1(int o, int p) { image(WhyattDw1, o-x, p-y); }
public void wD2(int o, int p) { image(WhyattDw2, o-x, p-y); }
public void wD3(int o, int p) { image(WhyattDw3, o-x, p-y); }
public void wD4(int o, int p) { image(WhyattDw4, o-x, p-y); }

public void loadWhyatt() {
  WhyattW.beginDraw();
  WhyattW.noStroke();
  //WhyattW.image(loadImage("Whyatt-behind.png"),0,0,size,size);
  WhyattW.endDraw();
  WhyattWw1.beginDraw();
  WhyattWw1.noStroke();
  //WhyattWw1.image(loadImage("Whyatt-behind-walking-1.png"),0,0,size,size);
  WhyattWw1.endDraw();
  WhyattWw2.beginDraw();
  WhyattWw2.noStroke();
  //WhyattWw2.image(loadImage("Whyatt-behind-walking-2.png"),0,0,size,size);
  WhyattWw2.endDraw();

  WhyattA.beginDraw();
  WhyattA.noStroke();
  //WhyattA.image(loadImage("Whyatt-side-left.png"),0,0,size,size);
  WhyattA.endDraw();
  WhyattAw1.beginDraw();
  WhyattAw1.noStroke();
  //WhyattAw1.image(loadImage("Whyatt-side-left-walking-1.png"),0,0,size,size);
  WhyattAw1.endDraw();
  WhyattAw2.beginDraw();
  WhyattAw2.noStroke();
  //WhyattAw2.image(loadImage("Whyatt-side-left-walking-2.png"),0,0,size,size);
  WhyattAw2.endDraw();
  WhyattAw3.beginDraw();
  WhyattAw3.noStroke();
  //WhyattAw3.image(loadImage("Whyatt-side-left-walking-3.png"),0,0,size,size);
  WhyattAw3.endDraw();
  WhyattAw4.beginDraw();
  WhyattAw4.noStroke();
  //WhyattAw4.image(loadImage("Whyatt-side-left-walking-4.png"),0,0,size,size);
  WhyattAw4.endDraw();

  WhyattS.beginDraw();
  WhyattS.noStroke();
  WhyattS.image(loadImage("Whyatt-front.png"),0,0,size,size);
  WhyattS.endDraw();
  WhyattSw1.beginDraw();
  WhyattSw1.noStroke();
  WhyattSw1.image(loadImage("Whyatt-front-walking-1.png"),0,0,size,size);
  WhyattSw1.endDraw();
  WhyattSw2.beginDraw();
  WhyattSw2.noStroke();
  WhyattSw2.image(loadImage("Whyatt-front-walking-2.png"),0,0,size,size);
  WhyattSw2.endDraw();

  WhyattD.beginDraw();
  WhyattD.noStroke();
  //WhyattD.image(loadImage("Whyatt-side-right.png"),0,0,size,size);
  WhyattD.endDraw();
  WhyattDw1.beginDraw();
  WhyattDw1.noStroke();
  //WhyattDw1.image(loadImage("Whyatt-side-right-walking-1.png"),0,0,size,size);
  WhyattDw1.endDraw();
  WhyattDw2.beginDraw();
  WhyattDw2.noStroke();
  //WhyattDw2.image(loadImage("Whyatt-side-right-walking-2.png"),0,0,size,size);
  WhyattDw2.endDraw();
  WhyattDw3.beginDraw();
  WhyattDw3.noStroke();
  //WhyattDw3.image(loadImage("Whyatt-side-right-walking-3.png"),0,0,size,size);
  WhyattDw3.endDraw();
  WhyattDw4.beginDraw();
  WhyattDw4.noStroke();
  //WhyattDw4.image(loadImage("Whyatt-side-right-walking-4.png"),0,0,size,size);
  WhyattDw4.endDraw();
}
}
class boarders {
  int x1, y1, x2, y2, direction;
  /*
  1= up
  2= left
  3= down
  4= right
  */
  public boarders(int ix1, int iy1, int ix2, int iy2, int idirection) {
    x1=ix1;
    y1=iy1;
    x2=ix2;
    y2=iy2;
    direction=idirection;
  }
  public int getD() { return direction; }
  public int getX1() { return x1; }
  public int getY1() { return y1; }
  public int getX2() { return x2; }
  public int getY2() { return y2; }
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
