int x, y, walkSpeed;
String keys="";
spritesheet test;
psymon psymon;
boolean walking; int direction;
void setup() {
  psymon = new psymon();
  size(840, 640, P2D);
  noSmooth();
  imageMode(CENTER);
  x=y=0;
  walkSpeed=5;
}
void draw() {
  keys();
  psymon.down(1);
  //println("x " + x + " y " + y);
}


void keys() {
    if(keys.contains("w")) {
      y+=walkSpeed;
    } else if(keys.contains("s")) {
      y+=-walkSpeed;
    }

    if(keys.contains("a")) {
      x+=walkSpeed;
    } else if(keys.contains("d")) {
      x+=-walkSpeed;
    }
}
void keyPressed()
{
  keys+=key;
}

void keyReleased() {
  keys=keys.replace(key+"","");
}
