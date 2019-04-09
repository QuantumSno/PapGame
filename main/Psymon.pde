class Psymon {
  PGraphics
  PsymonW, PsymonA, PsymonS, PsymonD,
  PsymonWw1, PsymonAw1, PsymonSw1, PsymonDw1,
  PsymonWw2, PsymonAw2, PsymonSw2, PsymonDw2,
  PsymonAw3, PsymonAw4, PsymonDw3, PsymonDw4,
  PsymonB1, PsymonB2, PsymonB3, PsymonB4, PsymonB5, PsymonB6;
  int scale, size;
  public Psymon() {
    scale=4;
    size=32*scale;
    PsymonW = createGraphics(size,size);
    PsymonWw1 = createGraphics(size,size);
    PsymonWw2 = createGraphics(size,size);
    PsymonA = createGraphics(size,size);
    PsymonAw1 = createGraphics(size,size);
    PsymonAw2 = createGraphics(size,size);
    PsymonAw3 = createGraphics(size,size);
    PsymonAw4 = createGraphics(size,size);
    PsymonS = createGraphics(size,size);
    PsymonSw1 = createGraphics(size,size);
    PsymonSw2 = createGraphics(size,size);
    PsymonD = createGraphics(size,size);
    PsymonDw1 = createGraphics(size,size);
    PsymonDw2 = createGraphics(size,size);
    PsymonDw3 = createGraphics(size,size);
    PsymonDw4 = createGraphics(size,size);
    PsymonB1 = createGraphics(size*2,size*2);
    PsymonB2 = createGraphics(size*2,size*2);
    PsymonB3 = createGraphics(size*2,size*2);
    PsymonB4 = createGraphics(size*2,size*2);
    PsymonB5 = createGraphics(size*2,size*2);
    PsymonB6 = createGraphics(size*2,size*2);

    loadPsymon();
  }

  void pW() { image(PsymonW, width/2, height/2); }
  void pA() { image(PsymonA, width/2, height/2); }
  void pS() { image(PsymonS, width/2, height/2); }
  void pD() { image(PsymonD, width/2, height/2); }

  void pW1() { image(PsymonWw1, width/2, height/2); }
  void pW2() { image(PsymonWw2, width/2, height/2); }

  void pA1() { image(PsymonAw1, width/2, height/2); }
  void pA2() { image(PsymonAw2, width/2, height/2); }
  void pA3() { image(PsymonAw3, width/2, height/2); }
  void pA4() { image(PsymonAw4, width/2, height/2); }

  void pS1() { image(PsymonSw1, width/2, height/2); }
  void pS2() { image(PsymonSw2, width/2, height/2); }

  void pD1() { image(PsymonDw1, width/2, height/2); }
  void pD2() { image(PsymonDw2, width/2, height/2); }
  void pD3() { image(PsymonDw3, width/2, height/2); }
  void pD4() { image(PsymonDw4, width/2, height/2); }

  void pB1() { image(PsymonB1, width/4, height/2); }
  void pB2() { image(PsymonB2, width/4, height/2); }
  void pB3() { image(PsymonB3, width/4, height/2); }
  void pB4() { image(PsymonB4, width/4, height/2); }
  void pB5() { image(PsymonB5, width/4, height/2); }
  void pB6() { image(PsymonB6, width/4, height/2); }

  void loadPsymon() {
    PsymonW.beginDraw();
    PsymonW.noStroke();
    PsymonW.image(loadImage("Psymon-behind.png"),0,0,size,size);
    PsymonW.endDraw();
    PsymonWw1.beginDraw();
    PsymonWw1.noStroke();
    PsymonWw1.image(loadImage("Psymon-behind-walking-1.png"),0,0,size,size);
    PsymonWw1.endDraw();
    PsymonWw2.beginDraw();
    PsymonWw2.noStroke();
    PsymonWw2.image(loadImage("Psymon-behind-walking-2.png"),0,0,size,size);
    PsymonWw2.endDraw();

    PsymonA.beginDraw();
    PsymonA.noStroke();
    PsymonA.image(loadImage("Psymon-side-left.png"),0,0,size,size);
    PsymonA.endDraw();
    PsymonAw1.beginDraw();
    PsymonAw1.noStroke();
    PsymonAw1.image(loadImage("Psymon-side-left-walking-1.png"),0,0,size,size);
    PsymonAw1.endDraw();
    PsymonAw2.beginDraw();
    PsymonAw2.noStroke();
    PsymonAw2.image(loadImage("Psymon-side-left-walking-2.png"),0,0,size,size);
    PsymonAw2.endDraw();
    PsymonAw3.beginDraw();
    PsymonAw3.noStroke();
    PsymonAw3.image(loadImage("Psymon-side-left-walking-3.png"),0,0,size,size);
    PsymonAw3.endDraw();
    PsymonAw4.beginDraw();
    PsymonAw4.noStroke();
    PsymonAw4.image(loadImage("Psymon-side-left-walking-4.png"),0,0,size,size);
    PsymonAw4.endDraw();

    PsymonS.beginDraw();
    PsymonS.noStroke();
    PsymonS.image(loadImage("Psymon-front.png"),0,0,size,size);
    PsymonS.endDraw();
    PsymonSw1.beginDraw();
    PsymonSw1.noStroke();
    PsymonSw1.image(loadImage("Psymon-front-walking-1.png"),0,0,size,size);
    PsymonSw1.endDraw();
    PsymonSw2.beginDraw();
    PsymonSw2.noStroke();
    PsymonSw2.image(loadImage("Psymon-front-walking-2.png"),0,0,size,size);
    PsymonSw2.endDraw();

    PsymonD.beginDraw();
    PsymonD.noStroke();
    PsymonD.image(loadImage("Psymon-side-right.png"),0,0,size,size);
    PsymonD.endDraw();
    PsymonDw1.beginDraw();
    PsymonDw1.noStroke();
    PsymonDw1.image(loadImage("Psymon-side-right-walking-1.png"),0,0,size,size);
    PsymonDw1.endDraw();
    PsymonDw2.beginDraw();
    PsymonDw2.noStroke();
    PsymonDw2.image(loadImage("Psymon-side-right-walking-2.png"),0,0,size,size);
    PsymonDw2.endDraw();
    PsymonDw3.beginDraw();
    PsymonDw3.noStroke();
    PsymonDw3.image(loadImage("Psymon-side-right-walking-3.png"),0,0,size,size);
    PsymonDw3.endDraw();
    PsymonDw4.beginDraw();
    PsymonDw4.noStroke();
    PsymonDw4.image(loadImage("Psymon-side-right-walking-4.png"),0,0,size,size);
    PsymonDw4.endDraw();

    PsymonB1.beginDraw();
    PsymonB1.noStroke();
    PsymonB1.image(loadImage("psymon-bat-1.png"),0,0,size*2,size*2);
    PsymonB1.endDraw();
    PsymonB2.beginDraw();
    PsymonB2.noStroke();
    PsymonB2.image(loadImage("psymon-bat-2.png"),0,0,size*2,size*2);
    PsymonB2.endDraw();
    PsymonB3.beginDraw();
    PsymonB3.noStroke();
    PsymonB3.image(loadImage("psymon-bat-3.png"),0,0,size*2,size*2);
    PsymonB3.endDraw();
    PsymonB4.beginDraw();
    PsymonB4.noStroke();
    PsymonB4.image(loadImage("psymon-bat-4.png"),0,0,size*2,size*2);
    PsymonB4.endDraw();
    PsymonB5.beginDraw();
    PsymonB5.noStroke();
    PsymonB5.image(loadImage("Psymon-side-right.png"),0,0,size*2,size*2);
    PsymonB5.endDraw();
    PsymonB6.beginDraw();
    PsymonB6.noStroke();
    PsymonB6.image(loadImage("Psymon-side-right.png"),0,0,size*2,size*2);
    PsymonB6.endDraw();
  }
}
