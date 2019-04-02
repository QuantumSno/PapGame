class Whyatt {
  PGraphics
  WhyattW, WhyattA, WhyattS, WhyattD,
  WhyattWw1, WhyattAw1, WhyattSw1, WhyattDw1,
  WhyattWw2, WhyattAw2, WhyattSw2, WhyattDw2,
  WhyattAw3, WhyattAw4, WhyattDw3, WhyattDw4;
  int scale, size;
  public Whyatt() {
    scale=4;
    size=32*scale;
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

  void wW() { image(WhyattW, width/2, height/2); }
  void wA() { image(WhyattA, width/2, height/2); }
  void wS() { image(WhyattS, width/2, height/2); }
  void wD() { image(WhyattD, width/2, height/2); }

  void wW1() { image(WhyattWw1, width/2, height/2); }
  void wW2() { image(WhyattWw2, width/2, height/2); }

  void wA1() { image(WhyattAw1, width/2, height/2); }
  void wA2() { image(WhyattAw2, width/2, height/2); }
  void wA3() { image(WhyattAw3, width/2, height/2); }
  void wA4() { image(WhyattAw4, width/2, height/2); }

  void wS1() { image(WhyattSw1, width/2, height/2); }
  void wS2() { image(WhyattSw2, width/2, height/2); }

  void wD1() { image(WhyattDw1, width/2, height/2); }
  void wD2() { image(WhyattDw2, width/2, height/2); }
  void wD3() { image(WhyattDw3, width/2, height/2); }
  void wD4() { image(WhyattDw4, width/2, height/2); }

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
  //  WhyattAw1.image(loadImage("Whyatt-side-left-walking-1.png"),0,0,size,size);
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
