  int scale, flipTime, flip, zone, x, y, walkSpeed, direction;
  boolean move;
  RenderOrder ro;
  Map map;
  ui ui;
  //CREATE RENDER ORDER
  //map size 2080x1750
void setup() {
  noCursor();
  map= new Map();
  ui= new ui();
  move = true;
  //size(840, 640, P2D);
  fullScreen(P2D);
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
  ro.render(zone, x, y, direction, flip, flipTime);
  System.out.println("x: " + x + " y: " +  y);
}
void keyPressed() {
  if(zone==0)
  if(keyPressed) {
    if(key=='w' && !map.boarderUp()) {
      y= y+walkSpeed;
      direction=5;
      flip++;
    } else if(key=='a' && !map.boarderRight()) {
      x= x+walkSpeed;
      direction=6;
      flip++;
    } else if(key=='s' && !map.boarderDown()) {
      y= y-walkSpeed;
      direction=7;
      flip++;
    } else if(key=='d' && !map.boarderLeft()) {
      x= x-walkSpeed;
      direction=8;
      flip++;
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
    }
  if(zone==1)
    if(key=='s') {
      redraw();
      zone=2;
    } else if(key==ENTER) {
      zone=0;
      loop();
    }
}
