int x, y;
String keys="";
psymon psymon;
void setup() {
  psymon = new psymon();
  size(840, 640, P2D);
  noSmooth();
  imageMode(CENTER);
  x=y=0;
}
void draw() {
  psymon.down(1);
  keys();
}


void keys() {
    if(keys.contains("w")) {
      y+=-1;
    } else if(keys.contains("s")) {
      y+=1;
    }

    if(keys.contains("a")) {
      x+=-1;
    } else if(keys.contains("d")) {
      x+=1;
    }
}
void keyPressed()
{
  keys+=key;
}

void keyReleased() {
  keys=keys.replace(key+"","");
}
