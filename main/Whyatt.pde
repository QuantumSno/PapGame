class Whyatt extends AI {
  PGraphics
  WhyattW, WhyattA, WhyattS, WhyattD,
  WhyattWw1, WhyattAw1, WhyattSw1, WhyattDw1,
  WhyattWw2, WhyattAw2, WhyattSw2, WhyattDw2,
  WhyattAw3, WhyattAw4, WhyattDw3, WhyattDw4;
  int scale, size, x, y;
public Whyatt(int o, int p) {
  x=o;
  y=p;
  scale=4;
  size=38*scale;
  WhyattW = createGraphics(size,size);
  WhyattWw1 = createGraphics(size,size);
  WhyattWw2 = createGraphics(size,size);
  WhyattA = createGraphics(size,size);
  WhyattAw1 = createGraphics(size,size);
  WhyattAw2 = createGraphics(size,size);
  WhyattAw3 = createGraphics(size,size);
  WhyattAw4 = createGraphics(size,size);
  WhyattS = createGraphics(size,size);
  WhyattSw1 = createGraphics(size,size);
  WhyattSw2 = createGraphics(size,size);
  WhyattD = createGraphics(size,size);
  WhyattDw1 = createGraphics(size,size);
  WhyattDw2 = createGraphics(size,size);
  WhyattDw3 = createGraphics(size,size);
  WhyattDw4 = createGraphics(size,size);
  loadWhyatt();
}
void update(int o, int p) {
  x=o;
  y=p;
}

void wW(int o, int p) { image(WhyattW, o-x, p-y); }
void wA(int o, int p) { image(WhyattA, o-x, p-y); }
void wS(int o, int p) { image(WhyattS, o-x, p-y); }
void wD(int o, int p) { image(WhyattD, o-x, p-y); }

void wW1(int o, int p) { image(WhyattWw1, o-x, p-y); }
void wW2(int o, int p) { image(WhyattWw2, o-x, p-y); }

void wA1(int o, int p) { image(WhyattAw1, o-x, p-y); }
void wA2(int o, int p) { image(WhyattAw2, o-x, p-y); }
void wA3(int o, int p) { image(WhyattAw3, o-x, p-y); }
void wA4(int o, int p) { image(WhyattAw4, o-x, p-y); }

void wS1(int o, int p) { image(WhyattSw1, o-x, p-y); }
void wS2(int o, int p) { image(WhyattSw2, o-x, p-y); }

void wD1(int o, int p) { image(WhyattDw1, o-x, p-y); }
void wD2(int o, int p) { image(WhyattDw2, o-x, p-y); }
void wD3(int o, int p) { image(WhyattDw3, o-x, p-y); }
void wD4(int o, int p) { image(WhyattDw4, o-x, p-y); }

void loadWhyatt() {
  WhyattW.beginDraw();
  WhyattW.noStroke();
  //WhyattW.image(loadImage("Whyatt-behind.png"),0,0,size,size);
  WhyattW.endDraw();
  WhyattWw1.beginDraw();
  WhyattWw1.noStroke();
  //WhyattWw1.image(loadImage("Whyatt-behind-walking-1.png"),0,0,size,size);
  WhyattWw1.endDraw();
  WhyattWw2.beginDraw();
  WhyattWw2.noStroke();
  //WhyattWw2.image(loadImage("Whyatt-behind-walking-2.png"),0,0,size,size);
  WhyattWw2.endDraw();

  WhyattA.beginDraw();
  WhyattA.noStroke();
  //WhyattA.image(loadImage("Whyatt-side-left.png"),0,0,size,size);
  WhyattA.endDraw();
  WhyattAw1.beginDraw();
  WhyattAw1.noStroke();
  //WhyattAw1.image(loadImage("Whyatt-side-left-walking-1.png"),0,0,size,size);
  WhyattAw1.endDraw();
  WhyattAw2.beginDraw();
  WhyattAw2.noStroke();
  //WhyattAw2.image(loadImage("Whyatt-side-left-walking-2.png"),0,0,size,size);
  WhyattAw2.endDraw();
  WhyattAw3.beginDraw();
  WhyattAw3.noStroke();
  //WhyattAw3.image(loadImage("Whyatt-side-left-walking-3.png"),0,0,size,size);
  WhyattAw3.endDraw();
  WhyattAw4.beginDraw();
  WhyattAw4.noStroke();
  //WhyattAw4.image(loadImage("Whyatt-side-left-walking-4.png"),0,0,size,size);
  WhyattAw4.endDraw();

  WhyattS.beginDraw();
  WhyattS.noStroke();
  WhyattS.image(loadImage("Whyatt-front.png"),0,0,size,size);
  WhyattS.endDraw();
  WhyattSw1.beginDraw();
  WhyattSw1.noStroke();
  WhyattSw1.image(loadImage("Whyatt-front-walking-1.png"),0,0,size,size);
  WhyattSw1.endDraw();
  WhyattSw2.beginDraw();
  WhyattSw2.noStroke();
  WhyattSw2.image(loadImage("Whyatt-front-walking-2.png"),0,0,size,size);
  WhyattSw2.endDraw();

  WhyattD.beginDraw();
  WhyattD.noStroke();
  //WhyattD.image(loadImage("Whyatt-side-right.png"),0,0,size,size);
  WhyattD.endDraw();
  WhyattDw1.beginDraw();
  WhyattDw1.noStroke();
  //WhyattDw1.image(loadImage("Whyatt-side-right-walking-1.png"),0,0,size,size);
  WhyattDw1.endDraw();
  WhyattDw2.beginDraw();
  WhyattDw2.noStroke();
  //WhyattDw2.image(loadImage("Whyatt-side-right-walking-2.png"),0,0,size,size);
  WhyattDw2.endDraw();
  WhyattDw3.beginDraw();
  WhyattDw3.noStroke();
  //WhyattDw3.image(loadImage("Whyatt-side-right-walking-3.png"),0,0,size,size);
  WhyattDw3.endDraw();
  WhyattDw4.beginDraw();
  WhyattDw4.noStroke();
  //WhyattDw4.image(loadImage("Whyatt-side-right-walking-4.png"),0,0,size,size);
  WhyattDw4.endDraw();
}
}
