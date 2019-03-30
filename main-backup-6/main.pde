import java.util.*;
ArrayList<sprite> sprites;
int x, y,
playerSize, mapX, mapY, scale;
renderTests rt;
void setup() {
  rt= new renderTests();
  imageMode(CENTER);
  //fullScreen();
  size(840,640);
  setVariables();
  sprites = new ArrayList<sprite>();
  loadSprites();
}

void draw() {
  image(f("m"), width/2, height/2);
  switch(key) {
    default: image(f("pf"), width/2, height/2);
    break; case 'w': image(f("pf"), width/2, height/2);
    break; case 'a': image(f("pl"), width/2, height/2);
    break; case 's': image(f("pd"), width/2, height/2);
    break; case 'd': image(f("pr"), width/2, height/2);
    break;
  }
  if(keyPressed) {
    switch(key) {
      default: image(f("pf"), width/2, height/2);
      break; case 'w': image(f("pf"), width/2, height/2);
      break; case 'a': image(f("pl"), width/2, height/2);
      break; case 's': image(f("pd"), width/2, height/2);
      break; case 'd': image(f("pr"), width/2, height/2);
      break;
    }
  }
}

PImage f(String find) {
  for(int t=0; t<sprites.size(); t++)
    if(sprites.get(t).getName() == find)
      return sprites.get(t).out();
  return sprites.get(0).out();
}

void setVariables() {
  x=0;
  y=0;
  mapX=840;
  mapY=640;
  playerSize=32;
  scale=4;
}
void loadSprites() {
  //load menus
  sprites.add(new sprite(loadImage("menu-1.png"), width, height, "mu1"));
  sprites.add(new sprite(loadImage("menu-2.png"), width, height, "mu2"));
  sprites.add(new sprite(loadImage("menu-3.png"), width, height, "mu3"));

  //load Psymons
  sprites.add(new sprite(loadImage("Psymon-behind-walking-1.png"), playerSize*scale, playerSize*scale, "pbw1"));
  sprites.add(new sprite(loadImage("Psymon-behind-walking-2.png"), playerSize*scale, playerSize*scale, "pbw2"));
  sprites.add(new sprite(loadImage("Psymon-behind.png"), playerSize*scale, playerSize*scale, "pb"));

  sprites.add(new sprite(loadImage("Psymon-front-walking-1.png"), playerSize*scale, playerSize*scale, "pfw1"));
  sprites.add(new sprite(loadImage("Psymon-front-walking-2.png"), playerSize*scale, playerSize*scale, "pfw2"));
  sprites.add(new sprite(loadImage("Psymon-front.png"), playerSize*scale, playerSize*scale, "pf"));

  sprites.add(new sprite(loadImage("Psymon-side-left-walking-1.png"), playerSize*scale, playerSize*scale, "pslw1"));
  sprites.add(new sprite(loadImage("Psymon-side-left-walking-2.png"), playerSize*scale, playerSize*scale, "pslw2"));
  sprites.add(new sprite(loadImage("Psymon-side-left-walking-3.png"), playerSize*scale, playerSize*scale, "pslw3"));
  sprites.add(new sprite(loadImage("Psymon-side-left-walking-4.png"), playerSize*scale, playerSize*scale, "pslw4"));
  sprites.add(new sprite(loadImage("Psymon-side-left.png"), playerSize*scale, playerSize*scale, "psl"));

  sprites.add(new sprite(loadImage("Psymon-side-right-walking-1.png"), playerSize*scale, playerSize*scale, "psrw1"));
  sprites.add(new sprite(loadImage("Psymon-side-right-walking-2.png"), playerSize*scale, playerSize*scale, "psrw2"));
  sprites.add(new sprite(loadImage("Psymon-side-right-walking-3.png"), playerSize*scale, playerSize*scale, "psrw3"));
  sprites.add(new sprite(loadImage("Psymon-side-right-walking-4.png"), playerSize*scale, playerSize*scale, "psrw4"));
  sprites.add(new sprite(loadImage("Psymon-side-right.png"), playerSize*scale, playerSize*scale, "psr"));

  sprites.add(new sprite(loadImage("template_map.png"), mapX*scale, mapY*scale, "m"));
}
