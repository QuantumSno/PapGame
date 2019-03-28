PGraphics Psymon;
PImage PsymonI;
int playerSize, x, y, scale;
void setup() {
  scale=4;
  playerSize=32;
  size(840,640);
  Psymon = createGraphics(playerSize*scale,playerSize*scale);
  PsymonI=loadImage("Psymon-front.png");
}
void draw() {
  render();
  image(Psymon,width/2,height/2);
}
void render() {
  Psymon.beginDraw();
  Psymon.noStroke();
  Psymon.image(PsymonI,0,0,playerSize*scale,playerSize*scale);
  //Psymon.background(30);
  Psymon.endDraw();
}
