/*
STILL NO FUCKING PGRAPHICS!
https://processing.org/tutorials/rendering/
*/

int playerX, playerY, psymonSize, walkSpeed,
mapSizeX, mapSizeY, scale, mapX, mapY, zone,
playerDirection;
  /*
  1 = [w] up
  2 = [a] left
  3 = [s] down
  4 = [d] left
  */
render r;
void setup() {
  frameRate(144);
  fullScreen();
  background(30);
  scale=4;
  psymonSize=32;
  mapSizeX=640;
  mapSizeY=480;
  walkSpeed=15;
  playerX=width/2-((psymonSize*scale)/2);
  playerY=height/2-((psymonSize*scale)/2);
  mapX = width/2-(mapSizeX*scale/2);
  mapY =height/2-(mapSizeY*scale/2);
  r= new render(psymonSize, scale, mapSizeX, mapSizeY, mapX, mapY);
  zone=0;
}
void draw() {
  if(keyPressed) {
    switch(key) {
      default:
      break; case 'w':
        mapY=mapY+(1*walkSpeed);
        playerDirection = 1;
      break; case 'a':
        mapX=mapX+(1*walkSpeed);
        playerDirection = 2;
      break; case 's':
        mapY=mapY-(1*walkSpeed);
        playerDirection = 3;
      break; case 'd':
        mapX=mapX-(1*walkSpeed);
        playerDirection = 4;
      break;
    }
  }
  r.updateDirection(playerDirection);
  r.updateXY(mapX,mapY);
  r.MAINRENDER(zone);
}
