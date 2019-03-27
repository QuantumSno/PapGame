PImage PsymonW,PsymonA,PsymonS,PsymonD
WhyattW,WhyattA,WhyattS,WhyattD
Map;
int playerX , playerY , walkSpeed , psymonSize , mapSizeX , mapSizeY , scale;
void setup() {
  fullScreen();
  scale=4;
  psymonSize=32;
  mapSizeX=640;
  mapSizeY=480;
  walkSpeed=5;
  playerX=width/2-((psymonSize*scale)/2);
  playerY=height/2-((psymonSize*scale)/2);
  PsymonW = loadImage("Psymon-front.png");
  PsymonA = loadImage("Psymon-side-left.png");
  PsymonS = loadImage("Psymon-behind.png");
  PsymonD = loadImage("Psymon-side-right.png");
  WhyattW = loadImage("Whyatt.png");
  /*
  WhyattA = loadImage("Whyatt-
  WhyattS = loadImage("Whyatt-
  WhyattD = loadImage("Whyatt-
  */
  Map = loadImage("template_map.png");
}
void draw() {
  switch(key) {
    case 'w': playerY=playerY+walkSpeed; break;
    case 'a': playerX=playerX-walkSpeed; break;
    case 's': playerY=playerY+walkSpeed; break;
    case 'd': playerX=playerX+walkSpeed; break;
    default: break;
  }
  
}
