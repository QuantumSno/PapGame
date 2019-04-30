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

ArrayList<boarders> boarder = new ArrayList<boarders>();
int x, y, walkSpeed;
String keys="";
//impliment loading screens!
psymon psymon;
elements elements;
raccoon raccoon;
Whyatt whyatt;
boolean walking, wWalking;
int direction, wDirection;
int f=0;
int four, two;
char zone = 't';
int tab1=1;
int combatPsymon = 1;
boolean psymonTurn=true;
boolean psymonAttack=false;
int combatX=150;
int swing=1;
int whyWalk=0;
int whyTWalk=0;
int firstConvo=0;
public void setup() {
  frameRate(60);
  psymon = new psymon();
  elements = new elements();
  raccoon = new raccoon();
  whyatt = new Whyatt(0, 0);
  
  
  imageMode(CENTER);
  x=y=0;
  walkSpeed=5;
  loadBoarders();
  redraw();
  noLoop();
}
public void draw() {
  walking=false;
  if (keyPressed)
    walking=true;
  keys();
  if (zone=='m') {
    drawOrder();
  } else if (zone=='t') {
    elements.title();
  } else if (zone=='p') {
    drawOrder();
    elements.tab(tab1);
  } else if (zone=='c') {
    combat();
  } else if (zone=='f') {
    drawOrder();
    textAlign(CENTER, CENTER);
    textSize(32);
    stroke(153);
    if (firstConvo==1) {
      fill(255, 0, 0);
      text("Heya Whyatt! What’ve been you up to today?", x, y-100);
    } else if (firstConvo==2) {
      fill(0, 102, 153);
      text("Oh, hey Psymon, nothin much. Just lookin around for my cat, he’s been gone a bit. \nI don’t want him getting stuck in the rain later", x-whyatt.getX(), y-whyatt.getY()-100);
    } else if (firstConvo==3) {
      text("Oh… okay. I’m sure your cat will turn up eventually. \nI can help look for him if you’d like", width/2, height/2-100);
    } else if (firstConvo==4) {
      text("Nah it’s alright, he’ll come around soon. Besides we should \ndo some errands before the storm hits", x-whyatt.getX(), y-whyatt.getY()-100);
    } else if (firstConvo==5) {
      text("That sounds like a great idea let’s head down and get some snacks!", width/2, height/2-100);
    } else {
      zone='m';
      loop();
    }
  }
  //println("x " + x + " y " + y + " direction " + direction + " walking " + walking + " framerate " + frameRate + " f " + f + " zone " + zone + " keys " + keys);
  //psymon.sheettest();
  whyatt.printSheets();
  whyatt.walkLeft(1, x, y);
  whyatt.walkLeft(2, x+20, y);
  whyatt.walkLeft(3, x+40, y);
  whyatt.walkLeft(4, x+60, y);
  whyatt.walkRight(1, x, y);
  whyatt.walkRight(2, x+120, y);
  whyatt.walkRight(3, x+140, y);
  whyatt.walkRight(4, x+160, y);
}
public void drawOrder() {
  //frame data
  f++;
  if (f>=40)
    f=0;
  if (f>0 && f<=10) {
    two=1;
    four=1;
  } else if (f>10 && f<=20) {
    two=2;
    four=2;
  } else if (f>20 && f<=30) {
    two=2;
    four=3;
  } else if (f>30 && f<=40) {
    two=1;
    four=4;
  }
  background(30);
  elements.map(x, y);
  //psymon
  if (walking==true) {
    if (direction==1) {
      psymon.walkUp(four);
    } else if (direction==2) {
      psymon.walkLeft(four);
    } else if (direction==3) {
      psymon.walkDown(four);
    } else if (direction==4) {
      psymon.walkRight(four);
    } else {
      psymon.down();
    }
  } else {
    if (direction==1) {
      psymon.up();
    } else if (direction==2) {
      psymon.left();
    } else if (direction==3) {
      psymon.down();
    } else if (direction==4) {
      psymon.right();
    } else {
      psymon.down();
    }
  }
  //if (whyatt.gunnawalk())
  if(false)
  {
    whyWalk=whyatt.walk();
    whyTWalk=0;
    wDirection=whyatt.direction();
    wWalking=true;
  }
  if (wWalking)
  {
    if (wDirection==1)
    {
      whyatt.update(whyatt.getX(), whyatt.getY()-5);
      whyatt.walkDown(two, x, y);
    } else if (wDirection==2)
    {
      println("wx " + whyatt.getX() + " wy " + whyatt.getY() + " four " + four + " x " + x + " y " + y + " d " + wDirection);
      whyatt.update(whyatt.getX()-5, whyatt.getY());
      whyatt.walkRight(four, x, y);
    } else if (wDirection==3)
    {
      whyatt.update(whyatt.getX(), whyatt.getY()+5);
      whyatt.walkUp(two, x, y);
    } else if (wDirection==4)
    {
      println("wx " + whyatt.getX() + " wy " + whyatt.getY() + " four " + four + " x " + x + " y " + y + " d " + wDirection);
      whyatt.update(whyatt.getX()+5, whyatt.getY());
      whyatt.walkLeft(four, x, y);
    }
    whyTWalk++;
    if(whyTWalk==whyWalk)
      wWalking=false;
  } else
  {
    if (wDirection==1)
      whyatt.up(x, y);
    else if (wDirection==2)
      whyatt.left(x, y);
    else if (wDirection==3)
      whyatt.down(x, y);
    else if (wDirection==4)
      whyatt.right(x, y);
  }
}
public void combat() {
  f++;
  if (f>=0 && f< 10) {
    swing++;
  } else {
    f=0;
    swing++;
  }
  elements.combat();
  elements.combatMenu(combatPsymon);
  if (psymonAttack) {//psymon attacking!
    psymon.swing(swing);
    if (swing>22) {
      psymonAttack=false;
      psymonTurn=false;
      swing=1;
    }
  } else if (!psymonAttack && !psymonTurn) { //raccoon attacking!
    raccoon.hit(swing);
    if (swing>7) {
      psymonTurn=true;
      noLoop();
    }
  } else {
    swing=1;
    psymon.ready();
    raccoon.ready();
  }
  elements.hp(1);
}

public void keys() {
  if (zone=='m') {
    if (keys.contains("w") && !boarderUp()) {
      y+=walkSpeed;
      direction=1;
    } else if (keys.contains("s") && !boarderDown()) {
      y+=-walkSpeed;
      direction=3;
    }
    if (keys.contains("a") && !boarderLeft()) {
      x+=walkSpeed;
      direction=2;
    } else if (keys.contains("d") && !boarderRight()) {
      x+=-walkSpeed;
      direction=4;
    }
    if (keys.contains(""+TAB)) {
      noLoop();
      tab1=1;
      zone='p';
    } else if (keys.contains("c")) {
      noLoop();
      zone='c';
    } else if (keys.contains("e"))
    {
      if (whyatt.range(x, y))
      {
        noLoop();
        textAlign(CENTER, CENTER);
        textSize(42);
        stroke(153);
        fill(0, 102, 153);
        if (firstConvo==0) {
          zone='f';
          firstConvo=1;
        } else
        {
          zone='t';
          text(whyatt.voice(), x-whyatt.getX(), y-whyatt.getY()-100);
        }
      }
    }
  } else if (zone=='p') {
    if (tab1==2) {
      if (keys.contains("w")) {
        tab1=1;
      } else if (keys.contains("s")) {
        tab1=3;
      } else if (keys.contains(""+ENTER)) {
        tab1=4;
      }
    } else if (tab1==1) {
      if (keys.contains("s")) {
        tab1=2;
      } else if (keys.contains(""+ENTER)) {
        zone='m';
        loop();
      }
    } else if (tab1==3) {
      if (keys.contains("w")) {
        tab1=2;
      } else if (keys.contains(""+ENTER)) {
        exit();
      }
    } else if (tab1==4) {
      if (keys.contains(""+ENTER)) {
        tab1=2;
      }
    }
  } else if (zone=='c') {
    if (psymonTurn) {
      if (keys.contains("w")) {
        if (combatPsymon==1)
          combatPsymon=2;
        else if (combatPsymon==2)
          combatPsymon=1;
      } else if (keys.contains("s")) {
        if (combatPsymon==1)
          combatPsymon=2;
        else if (combatPsymon==2)
          combatPsymon=1;
      } else if (keys.contains(""+ENTER)) {
        if (combatPsymon==1) {
          psymonAttack=true;
          loop();
        }
      }
    }
  }
}

public void keyPressed()
{
  keys+=key;
}
public void keyReleased() {
  if (zone=='t') {
    zone='m';
    loop();
  }
  if (zone=='p') {
    keys();
    redraw();
  }
  if (zone=='c') {
    keys();
    redraw();
  }
  if (zone=='f') {
    firstConvo++;
    redraw();
  }
  keys=keys.replace(key+"", "");
}
public boolean boarderUp() {
  for (int t=0; t<boarder.size(); t++)
    if (boarder.get(t).getD()==1)
      if (boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
        return true;
  return false;
}
public boolean boarderLeft() {
  for (int t=0; t<boarder.size(); t++)
    if (boarder.get(t).getD()==2)
      if (boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
        return true;
  return false;
}
public boolean boarderDown() {
  for (int t=0; t<boarder.size(); t++)
    if (boarder.get(t).getD()==3)
      if (boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
        return true;
  return false;
}
public boolean boarderRight() {
  for (int t=0; t<boarder.size(); t++)
    if (boarder.get(t).getD()==4)
      if (boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
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
  boarder.add(new boarders(-3590, 3080, -3590, 2740, 4)); //125-124
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
class AI {
  int active=100;
  public boolean gunnawalk() {
    if (PApplet.parseInt(random(1, active))==1) {
      return true;
    } else
      return false;
  }
  public int walk() {
    return PApplet.parseInt(random(5, active/2));
  }
  public int direction() {
    return PApplet.parseInt(random(1, 5));
  }
  public String voice() {
    return "text";
  }
  public boolean range(int o, int p) {
    if (o>x+420-100 && o< x+420+100 && p>y+310-100 && p<y+310+100)
      return true;
    return false;
  }
}
class Whyatt extends AI {
  int x, y;
  int size;
  spritesheet up, down, left, right, walkUp, walkDown, walkLeft, walkRight;
  public Whyatt(int o, int p) {
    size=38*4;
    x=o;
    y=p;
    noStroke();
    noSmooth();
    up= new spritesheet(loadImage("whyatt up.png"), 1, 1);
    up.setW(size);
    up.setH(size);
    down= new spritesheet(loadImage("whyatt down.png"), 1, 1);
    down.setW(size);
    down.setH(size);
    left= new spritesheet(loadImage("whyatt left walk.png"), 1, 1);
    left.setW(size);
    left.setH(size);
    right= new spritesheet(loadImage("whyatt right walk.png"), 1, 1);
    right.setW(size);
    right.setH(size);
    walkUp= new spritesheet(loadImage("whyatt up walk.png"), 2, 2);
    walkUp.setW(size);
    walkUp.setH(size);
    walkDown= new spritesheet(loadImage("whyatt down walk.png"), 2, 2);
    walkDown.setW(size);
    walkDown.setH(size);
    walkLeft= new spritesheet(loadImage("whyatt left walk.png"), 2, 2);
    walkLeft.setW(size);
    walkLeft.setH(size);
    walkRight= new spritesheet(loadImage("whyatt right walk.png"), 2, 2);
    walkRight.setW(size);
    walkRight.setH(size);
  }
  public void printSheets() {
    walkLeft.printSheet(1);
  }
  public void update(int o, int p) {
    x=o;
    y=p;
  }
  public String voice(int voiceline) {
    if (voiceline==1)
      return "Hello!";
    else if (voiceline==2)
      return "Goodday Sir";
    else if (voiceline==3)
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
    if (o>x+420-100 && o< x+420+100 && p>y+310-100 && p<y+310+100)
      return true;
    return false;
  }
  public void up(int ix, int iy) {
    up.out(1, ix-x, iy-y);
  }
  public void down(int ix, int iy) {
    down.out(1, ix-x, iy-y);
  }
  public void left(int ix, int iy) {
    left.out(2, ix-x, iy-y);
  }
  public void right(int ix, int iy) {
    right.out(2, ix-x, iy-y);
  }
  public void walkUp(int f, int ix, int iy) {
    walkUp.out(f, ix-x, iy-y);
  }
  public void walkDown(int f, int ix, int iy) {
    walkDown.out(f, ix-x, iy-y);
  }
  public void walkLeft(int f, int ix, int iy) {
    walkLeft.out(f, ix-x, iy-y);
  }
  public void walkRight(int f, int ix, int iy) {
    walkRight.out(f, ix-x, iy-y);
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
  public int getD() { 
    return direction;
  }
  public int getX1() { 
    return x1;
  }
  public int getY1() { 
    return y1;
  }
  public int getX2() { 
    return x2;
  }
  public int getY2() { 
    return y2;
  }

  public void update(int x, int y) {
    x1+=x;
    y1+=y;
    x2+=x;
    y2+=y;
  }
}
class elements {
  PImage mapImage;
  spritesheet test, title, tab, templateMap, combatMap, combatSpin, map, hp;
  boolean once=false;
  public elements() {
    test = new spritesheet(loadImage("collider map.png"), 1, 1);
    test.setW(8320);
    test.setH(7040);
    mapImage=loadImage("foil map working.png");
    map = new spritesheet(mapImage, 1, 1);
    map.setW(8320);
    map.setH(7040);
    title = new spritesheet(loadImage("foil title.png"), 1, 1);
    tab = new spritesheet(loadImage("tab menu.png"), 2, 2);
    tab.setW(width);
    tab.setH(height);
    templateMap = new spritesheet(loadImage("template_map.png"), 1, 1);
    combatMap = new spritesheet(loadImage("stage.png"), 1, 2);
    combatMap.setW(width);
    combatMap.setH(height);
    combatSpin = new spritesheet(loadImage("combat menu.png"), 2, 2);
    combatSpin.setW(150);
    combatSpin.setH(150);
    hp = new spritesheet(loadImage("hp bar.png"), 4, 3);
    hp.setW(50*9);
    hp.setH(50);
  }
  public void mapBoarders(int x, int y) {
    test.out(1, x, y);
  }
  public void map(int x, int y) {
    map.out(1, x, y);
  }
  public void title() {
    title.out(1, width/2, height/2);
  }
  public void tab(int f) {
    tab.out(f, width/2, height/2);
  }
  public void templateMap(int x, int y) {
    title.out(1, x, y);
  }
  public void combat() {
    combatMap.out(1, width/2, height/2);
  }
  public void combatMenu(int f) {
    combatSpin.out(f, 0+150/2, height-150/2);
  }
  public void hp(int f) {
    hp.out(f, 0+(50*9)/2, 0+(50)/2);
  }
}
class psymon {
  spritesheet up, down, left, right, walkUp, walkDown, walkLeft, walkRight, bat, batcharge, ready, hurt;
  int size;
  public psymon() {
    size=32*4;
    noStroke();
    noSmooth();
    up= new spritesheet(loadImage("psymon up.png"), 1, 1);
    up.setW(size);
    up.setH(size);
    down= new spritesheet(loadImage("psymon down.png"), 1, 1);
    down.setW(size);
    down.setH(size);
    left= new spritesheet(loadImage("psymon left.png"), 1, 1);
    left.setW(size);
    left.setH(size);
    right= new spritesheet(loadImage("psymon right.png"), 1, 1);
    right.setW(size);
    right.setH(size);
    walkUp= new spritesheet(loadImage("psymon up walk.png"), 2, 2);
    walkUp.setW(size);
    walkUp.setH(size);
    walkDown= new spritesheet(loadImage("psymon down walk.png"), 2, 2);
    walkDown.setW(size);
    walkDown.setH(size);
    walkLeft= new spritesheet(loadImage("psymon left walk.png"), 2, 2);
    walkLeft.setW(size);
    walkLeft.setH(size);
    walkRight= new spritesheet(loadImage("psymon right walk.png"), 2, 2);
    walkRight.setW(size);
    walkRight.setH(size);
    bat = new spritesheet(loadImage("psymon bat charge.png"), 3, 3);
    bat.setW(size);
    bat.setH(size);
    batcharge = new spritesheet(loadImage("psymon bat.png"), 4, 5);
    batcharge.setW(size);
    batcharge.setH(size);
    ready = new spritesheet(loadImage("psymon ready.png"), 1, 1);
    ready.setW(size);
    ready.setH(size);
    hurt = new spritesheet(loadImage("psymon hurt.png"), 1, 1);
    hurt.setW(size);
    hurt.setH(size);
  }
  public void up() {
    up.out(1, width/2, height/2);
  }
  public void down() {
    down.out(1, width/2, height/2);
  }
  public void left() {
    left.out(1, width/2, height/2);
  }
  public void right() {
    right.out(1, width/2, height/2);
  }
  public void walkUp(int f) {
    walkUp.out(f, width/2, height/2);
  }
  public void walkDown(int f) {
    walkDown.out(f, width/2, height/2);
  }
  public void walkLeft(int f) {
    walkLeft.out(f, width/2, height/2);
  }
  public void walkRight(int f) {
    walkRight.out(f, width/2, height/2);
  }
  public void ready() {
    ready.out(1, 300, height-120);
  }
  public void hurt() {
    hurt.out(1, 300, height-120);
  }
  public void swing(int f) {
    println(f);
    if (f>=1 && f <= 4) {
      bat.out(f, 300, height-120);
    } else {
      batcharge.out(f-4, 300, height-120);
    }
  }

  public void sheettest() {
    //walkLeft.printSheet(1);
    //walkDown.printSheet(2);
    //walkUp.printSheet(3);
    bat.printSheet(1);
    batcharge.printSheet(2);
  }
}
class raccoon {
  spritesheet raccoon, raccoonHurt, raccoonHit;
  public raccoon() {
    raccoon = new spritesheet(loadImage("raccoon.png"), 1, 1);
    raccoonHurt = new spritesheet(loadImage("raccoon hurt.png"), 1, 1);
    raccoonHit = new spritesheet(loadImage("raccoon hit.png"), 3, 3);
  }

  public void ready() { 
    raccoon.out(1, width-300, height-140);
  }
  public void hurt() { 
    raccoonHurt.out(1, width-300, height-140);
  }
  public void hit(int f) { 
    raccoonHit.out(f, width-300, height-140);
  }
}
class spritesheet {
  PImage[] sprites;
  int wid, hei;
  PImage spritesheet;
  public spritesheet(PImage ispritesheet, int dX, int dY) {
    spritesheet = ispritesheet;
    noStroke();
    smooth(0);
    sprites = new PImage[dX*dY];
    int W = wid = spritesheet.width/dX;
    int H = hei = spritesheet.height/dY;
    for (int i=0; i<sprites.length; i++) {
      int x = i%dX*W;
      int y = i/dY*H;
      sprites[i] = spritesheet.get(x, y, W, H);
    }
  }
  public void out(int i, int x, int y) {
    noStroke();
    image(sprites[i-1], x, y, wid, hei);
  }
  public void printSheet(int lvl) {
    int tx=wid/2;
    int ty=hei/2;
    ty+=hei*(lvl-1);
    for (int t=0; t<sprites.length; t++) {
      image(sprites[t], tx, ty, wid, hei);
      tx+=wid;
    }
  }
  public void setW(int i) {
    wid=i;
  }
  public void setH(int i) {
    hei=i;
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
