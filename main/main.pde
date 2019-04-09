  int scale, flipTime, flip, zone, x, y, walkSpeed, direction, hammer, time;
  boolean move, talking;
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
  ro.render(zone, x, y, direction, flip, flipTime, hammer);
  //System.out.println("x: " + x + " y: " +  y);
  println(hammer+" "+time);
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
  if(zone==4)
    if(keyPressed)
      if(key=='e')
        if(time>=0 && time<=100/4) {
          hammer=1;
          time+=1;
        } else if(time>=100/4 && time<=100/2) {
          hammer=2;
          time+=1;
        } else if(time>=100/2 && time<=100-100/4) {
          hammer=3;
          time+=1;
        } else {
          hammer=4;
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
    if(key=='e') {
      time=0;
      hammer=0;
    }
}
