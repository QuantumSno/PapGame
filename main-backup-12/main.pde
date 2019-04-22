  int scale, flip, zone, x, y, walkSpeed, direction, hammer, time, dmg;
  boolean move, talking, doDmg;
  RenderOrder ro;
  Map map;
  ui ui;
  PVector cords;
  String keys="";
  int s, frame, count;
  //map size 2080x1750
void setup() {
  //noCursor();
  map= new Map();
  ui= new ui();
  move = true;
  size(840, 640, P2D);
  //fullScreen(P2D);
  flip = 0;
  zone = 0;
  cords = new PVector(0,0);
  direction=0;
  walkSpeed = 5;
  imageMode(CENTER);
  noSmooth();
  clip(width/2, height/2, width, height);
  ro= new RenderOrder(int(cords.x), int(cords.y));
}
void draw() {
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
  ro.render(zone, int(cords.x), int(cords.y), direction, hammer, dmg, doDmg, frame);
  //println("cords.x: " + cords.x + " cords.y: " +  cords.y);
  doDmg=false;
  //println(flip);
}

void keys() {
  if(zone==0)
    if(keys.contains("w") && !map.boarderUp(int(cords.x), int(cords.y))) {
      cords.y= cords.y+walkSpeed;
      direction=5;
    } if(keys.contains("a") && !map.boarderLeft(int(cords.x), int(cords.y))) {
      cords.x= cords.x+walkSpeed;
      direction=6;
    } if(keys.contains("s") && !map.boarderDown(int(cords.x), int(cords.y))) {
      cords.y= cords.y-walkSpeed;
      direction=7;
    } if(keys.contains("d") && !map.boarderRight(int(cords.x), int(cords.y))) {
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
        if(ro.wrange(int(cords.x), int(cords.y))) {
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

void keyPressed() {
  keys+=key;
}
void keyReleased() {
  keys=keys.replace(key+"","");
}
