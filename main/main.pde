int scale, flipTime, flip, zone;
Psymon psymon;
Map map;
void setup() {
  size(840,640);
  flipTime=5;
  flip=0;
  zone=0;
  imageMode(CENTER);
  psymon= new Psymon();
  map= new Map();
}
void draw() {
  if(zone=1) {

  } else {
    image(map.m(), width/2, height/2);
    standing();
    moving();
    flip++;
  }
}

void standing() {
  switch(key) {
    default: image(psymon.pS(), width/2, height/2);
    break; case 'w': image(psymon.pW(), width/2, height/2);
    break; case 'a': image(psymon.pA(), width/2, height/2);
    break; case 's': image(psymon.pS(), width/2, height/2);
    break; case 'd': image(psymon.pD(), width/2, height/2);
  }
}
void walking() {
  if(keyPressed) {

  }
}
