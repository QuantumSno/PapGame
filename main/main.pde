//PImage Psymon,Whyatt,Map;
//int playerX , playerY , walkSpeed , psymonSize , mapSizeX , mapSizeY , scale;
setup() {
  scale=4;
  psymonSize=32;
  mapSizeX=640;
  mapSizeY=480;
  walkSpeed=5;
  playerX=width/2-((psymonSize*scale)/2);
  playerY=height/2-((psymonSize*scale)/2);
  Psymon = loadImage("Psymon-1.png.png");
  Whyatt = loadImage("Whyatt.png");
  Map = loadImage("template_map.png");
}
draw() {
  switch(key) {
    case 'w': y=y+walkSpeed break;
    case 'a': x=x-walkSpeed break;
    case 's': y=y+walkSpeed break;
    case 'd': x=x+walkSpeed break;
  }
}
