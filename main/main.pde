  int scale, flipTime, flip, zone, x, y, walkSpeed, direction;
  boolean move;
  RenderOrder ro;
  //CREATE RENDER ORDER
void setup() {
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
  ro.render(zone, x, y, direction, flip);
}
void keyPressed() {
  if(zone==0)
  if(keyPressed) {
    if(key=='w') {
      y= y+walkSpeed;
      direction=1;
    } else if(key=='w' && key== 'd') {
      y= y+walkSpeed;
      x= x+walkSpeed;
      direction=2;
    } else if(key=='d') {
      x= x+walkSpeed;
      direction=3;
    } else if(key=='d' && key=='s') {
      x= x+walkSpeed;
      y= y-walkSpeed;
      direction=4;
    } else if(key=='s') {
      y= y-walkSpeed;
      direction=5;
    } else if(key=='s' && key=='a') {
      y= y-walkSpeed;
      x= x-walkSpeed;
      direction=6;
    } else if(key=='a') {
      x= x-walkSpeed;
      direction=7;
    } else if(key=='a' && key=='w') {
      x= x-walkSpeed;
      y= y+walkSpeed;
      direction=8;
    }
    else if(key==TAB);
    else;
  }
}
void keyReleased() {

  }
}
