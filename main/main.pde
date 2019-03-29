PGraphics Map,
PsymonW, PsymonA, PsymonS, PsymonD,
PsymonWw1, PsymonAw1, PsymonSw1, PsymonDw1,
PsymonWw2, PsymonAw2, PsymonSw2, PsymonDw2,
WhyattW, WhyattA, WhyattS, WhyattD,
WhyattWw1, WhyattAw1, WhyattSw1, WhyattDw1,
WhyattWw2, WhyattAw2, WhyattSw2, WhyattDw2;
int playerSize, scale, walkSpeed,
mapSizeX, mapSizeY,
x, y, flip, flipFrames;
 /*
 1 = [w] up
 2 = [a] left
 3 = [s] down
 4 = [d] left
 */

void setup() {
  walkSpeed=5;
  flip=0;
  flipFrames=5;
  mapSizeX=840;
  mapSizeY=640;
  x=x-mapSizeX/2;
  y=y-mapSizeX/2;
  scale=4;
  playerSize=32;
  size(840,640);
  PsymonW = createGraphics(playerSize*scale,playerSize*scale);
  PsymonA = createGraphics(playerSize*scale,playerSize*scale);
  PsymonS = createGraphics(playerSize*scale,playerSize*scale);
  PsymonD = createGraphics(playerSize*scale,playerSize*scale);
  PsymonWw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonWw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonSw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonSw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw2 = createGraphics(playerSize*scale,playerSize*scale);
  WhyattW = createGraphics(playerSize*scale,playerSize*scale);
  WhyattA = createGraphics(playerSize*scale,playerSize*scale);
  WhyattS = createGraphics(playerSize*scale,playerSize*scale);
  WhyattD = createGraphics(playerSize*scale,playerSize*scale);
  WhyattWw1 = createGraphics(playerSize*scale,playerSize*scale);
  WhyattWw2 = createGraphics(playerSize*scale,playerSize*scale);
  WhyattAw1 = createGraphics(playerSize*scale,playerSize*scale);
  WhyattAw2 = createGraphics(playerSize*scale,playerSize*scale);
  WhyattSw1 = createGraphics(playerSize*scale,playerSize*scale);
  WhyattSw2 = createGraphics(playerSize*scale,playerSize*scale);
  WhyattDw1 = createGraphics(playerSize*scale,playerSize*scale);
  WhyattDw2 = createGraphics(playerSize*scale,playerSize*scale);
  Map = createGraphics(mapSizeX*scale,mapSizeY*scale);
  render();
}
void draw() {
  image(Map,x,y);
  switch(key) {
    default: image(PsymonW,356,256);
    break; case 'w': image(PsymonW,356,256);
    break; case 'a': image(PsymonA,356,256);
    break; case 's': image(PsymonS,356,256);
    break; case 'd': image(PsymonD,356,256);
    break;
  }
  if(keyPressed) {
    switch(key) {
      default: image(PsymonW,356,256);
      break; case 'w': y=y+walkSpeed; image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonWw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonWw2,356,256);flip++;} else {image(PsymonW,356,256);flip=0;}
      break; case 'a': x=x+walkSpeed; image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonAw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonAw2,356,256);flip++;} else {image(PsymonA,356,256);flip=0;}
      break; case 's': y=y-walkSpeed; image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonSw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonSw2,356,256);flip++;} else {image(PsymonS,356,256);flip=0;}
      break; case 'd': x=x-walkSpeed; image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonDw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonDw2,356,256);flip++;} else {image(PsymonD,356,256);flip=0;}
      break;
    }
  }
}
void render() {
  PsymonW.beginDraw();
  PsymonW.noStroke();
  PsymonW.image(loadImage("Psymon-behind.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonW.endDraw();
  PsymonA.beginDraw();
  PsymonA.noStroke();
  PsymonA.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonA.endDraw();
  PsymonS.beginDraw();
  PsymonS.noStroke();
  PsymonS.image(loadImage("Psymon-front.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonS.endDraw();
  PsymonD.beginDraw();
  PsymonD.noStroke();
  PsymonD.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonD.endDraw();

  PsymonWw1.beginDraw();
  PsymonWw1.noStroke();
  PsymonWw1.image(loadImage("Psymon-behind-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonWw1.endDraw();
  PsymonWw2.beginDraw();
  PsymonWw2.noStroke();
  PsymonWw2.image(loadImage("Psymon-behind-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonWw2.endDraw();
  PsymonAw1.beginDraw();
  PsymonAw1.noStroke();
  PsymonAw1.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw1.endDraw();
  PsymonAw2.beginDraw();
  PsymonAw2.noStroke();
  PsymonAw2.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw2.endDraw();
  PsymonSw1.beginDraw();
  PsymonSw1.noStroke();
  PsymonSw1.image(loadImage("Psymon-front-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonSw1.endDraw();
  PsymonSw2.beginDraw();
  PsymonSw2.noStroke();
  PsymonSw2.image(loadImage("Psymon-front-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonSw2.endDraw();
  PsymonDw1.beginDraw();
  PsymonDw1.noStroke();
  PsymonDw1.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw1.endDraw();
  PsymonDw2.beginDraw();
  PsymonDw2.noStroke();
  PsymonDw2.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw2.endDraw();

/* Cut off render for Whyatt while sprites are in development
  WhyattW.beginDraw();
  WhyattW.noStroke();
  WhyattW.image(loadImage("Whyatt-behind.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattW.endDraw();
  WhyattA.beginDraw();
  WhyattA.noStroke();
  WhyattA.image(loadImage("Whyatt-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattA.endDraw();
  WhyattS.beginDraw();
  WhyattS.noStroke();
  WhyattS.image(loadImage("Whyatt-front.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattS.endDraw();
  WhyattD.beginDraw();
  WhyattD.noStroke();
  WhyattD.image(loadImage("Whyatt-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattD.endDraw();

  WhyattWw1.beginDraw();
  WhyattWw1.noStroke();
  WhyattWw1.image(loadImage("Whyatt-behind-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattWw1.endDraw();
  WhyattWw2.beginDraw();
  WhyattWw2.noStroke();
  WhyattWw2.image(loadImage("Whyatt-behind-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattWw2.endDraw();
  WhyattAw1.beginDraw();
  WhyattAw1.noStroke();
  WhyattAw1.image(loadImage("Whyatt-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattAw1.endDraw();
  WhyattAw2.beginDraw();
  WhyattAw2.noStroke();
  WhyattAw2.image(loadImage("Whyatt-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattAw2.endDraw();
  WhyattSw1.beginDraw();
  WhyattSw1.noStroke();
  WhyattSw1.image(loadImage("Whyatt-front-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattSw1.endDraw();
  WhyattSw2.beginDraw();
  WhyattSw2.noStroke();
  WhyattSw2.image(loadImage("Whyatt-front-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattSw2.endDraw();
  WhyattDw1.beginDraw();
  WhyattDw1.noStroke();
  WhyattDw1.image(loadImage("Whyatt-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattDw1.endDraw();
  WhyattDw2.beginDraw();
  WhyattDw2.noStroke();
  WhyattDw2.image(loadImage("Whyatt-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattDw2.endDraw();
  */

  Map.beginDraw();
  Map.noStroke();
  Map.image(loadImage("template_map.png"),x,y,mapSizeX*scale,mapSizeY*scale);
  Map.endDraw();
}
