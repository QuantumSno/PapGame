  int scale, flipTime, flip, zone, x, y, walkSpeed, direction;
  boolean move;
  RenderOrder ro;
  Map map;
  //CREATE RENDER ORDER
void setup() {
  map= new Map();
  move = true;
  size(840, 640);
  flipTime = 10;
  flip = 0;
  zone = 0;
  x = 0;
  y = 0;
  direction=0;
  walkSpeed = 5;
  imageMode(CENTER);
  noSmooth();
  ro= new RenderOrder(x, y);
}
void draw() {
  if(flip >= flipTime * 4)
  flip = 0;
  keyPressed();
  ro.render(zone, x, y, direction, flip);
}
void keyPressed() {
  if(zone==0)
  if(keyPressed) {
    if(key=='w' && !map.boarderUp()) {
      y= y+walkSpeed;
      direction=1;
    } else if(key=='a' && !map.boarderRight()) {
      x= x+walkSpeed;
      direction=2;
    } else if(key=='s' && !map.boarderDown()) {
      y= y-walkSpeed;
      direction=3;
    } else if(key=='d' && !map.boarderLeft()) {
      x= x-walkSpeed;
      direction=4;
    }
    else if(key==TAB);
  }
}
void keyReleased() {
  if(zone==0)
  if(key=='w') direction=1;
  if(key=='a') direction=2;
  if(key=='s') direction=3;
  if(key=='d') direction=4;
}
