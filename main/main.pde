int playerX, playerY, psymonSize, walkSpeed,
mapSizeX, mapSizeY, scale,
playerDirection;
  /*
  1 = [w] up
  2 = [a] left
  3 = [s] down
  4 = [d] left
  */
render r;
void setup() {
  fullScreen();
  background(30);
  scale=4;
  psymonSize=32;
  mapSizeX=640;
  mapSizeY=480;
  walkSpeed=5;
  playerX=width/2-((psymonSize*scale)/2);
  playerY=height/2-((psymonSize*scale)/2);

  r= new render(psymonSize,scale,mapSizeX,mapSizeY);
}
void draw() {
  switch(key) {
    default:
    break; case 'w':
      playerY=playerY+walkSpeed;
      playerDirection = 1;
    break; case 'a':
      playerX=playerX-walkSpeed;
      playerDirection = 2;
    break; case 's':
      playerY=playerY+walkSpeed;
      playerDirection = 3;
    break; case 'd':
      playerX=playerX+walkSpeed;
      playerDirection = 4;
    break;
  }
  r.MAINRENDER();
}
