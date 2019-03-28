PGraphics Psymon;
int playerSize, scale,
 x, y, direction;
 /*
 1 = [w] up
 2 = [a] left
 3 = [s] down
 4 = [d] left
 */

void setup() {
  scale=4;
  playerSize=32;
  size(840,640);
  Psymon = createGraphics(playerSize*scale,playerSize*scale);
}
void draw() {
  if(keyPressed) {
    switch(key) {
      default:
      break; case 'w': y++; direction=1;
      break; case 'a': x++; direction=2;
      break; case 's': y--; direction=3;
      break; case 'd': x--; direction=4;
      break;
    }
  }
  render();
  image(Psymon,356,256);
}
void render() {
  Psymon.beginDraw();
  Psymon.noStroke();
  switch(direction) {
    default: Psymon.image(loadImage("Psymon-front.png"),0,0,playerSize*scale,playerSize*scale);
    break; case 1: Psymon.image(loadImage("Psymon-behind.png"),0,0,playerSize*scale,playerSize*scale);
    break; case 2: Psymon.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
    break; case 3: Psymon.image(loadImage("Psymon-front.png"),0,0,playerSize*scale,playerSize*scale);
    break; case 4: Psymon.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
    break;
  }
  Psymon.endDraw();
}
