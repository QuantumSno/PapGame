  int scale, flipTime, flip, zone, x, y, walkSpeed, direction, hammer, time, dmg;
  boolean move, talking, doDmg;
  RenderOrder ro;
  Map map;
  ui ui;
  //map size 2080x1750
void setup() {
  //noCursor();
  map= new Map();
  ui= new ui();
  move = true;
  size(840, 640, P2D);
  //fullScreen(P2D);
  flipTime = 10;
  flip = 0;
  zone = 0;
  x = 0;
  y = 0;
  direction=0;
  walkSpeed = 5;
  imageMode(CENTER);
  noSmooth();
  clip(width/2, height/2, width, height);
  ro= new RenderOrder(x, y);
}
void draw() {
  if(flip >= flipTime * 4)
    flip = 0;
  keyPressed();
  if(zone==4)
    if(ro.shp()<=0) {
      zone=0;
      ro.shpr();
    }
  ro.render(zone, x, y, direction, flip, flipTime, hammer, dmg, doDmg);
  println("x: " + x + " y: " +  y);
  doDmg=false;
}
void keyPressed() {
  if(zone==0)
  if(keyPressed) {
    if(key=='w' && !map.boarderUp(x, y)) {
      y= y+walkSpeed;
      direction=5;
      flip++;
    } if(key=='a' && !map.boarderLeft(x, y)) {
      x= x+walkSpeed;
      direction=6;
      flip++;
    } if(key=='s' && !map.boarderDown(x, y)) {
      y= y-walkSpeed;
      direction=7;
      flip++;
    } if(key=='d' && !map.boarderRight(x, y)) {
      x= x-walkSpeed;
      direction=8;
      flip++;
    }
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
}
void keyReleased() {
  if(zone==0)
    if(key=='w') direction=1;
    else if(key=='a') direction=2;
    else if(key=='s') direction=3;
    else if(key=='d') direction=4;
    else if(key==TAB) {
      zone=1;
      noLoop();
      ui.tab1();
    } else if(key=='e') {
      textAlign(CENTER, CENTER);
      textSize(42);
      stroke(153);
      fill(0, 102, 153);
        if(ro.wrange(x,y)) {
        talking=true;
        noLoop();
        text(ro.wvoice(), x-ro.wgetX(), y-ro.wgetY()-100);
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
