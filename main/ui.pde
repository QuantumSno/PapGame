class ui {
  PGraphics tab1, tab2, tab3;
  int scale;
  public ui() {
    scale=4;
    tab1 = createGraphics(width,height);
    tab2 = createGraphics(width,height);
    tab3 = createGraphics(width,height);
    loadUi();
  }

  PImage tab1() { return tab1; }
  PImage tab2() { return tab2; }
  PImage tab3() { return tab3; }


  void loadUi() {
    tab1.beginDraw();
    tab1.noStroke();
    tab1.image(loadImage("tab1.png"),0,0,width,height);
    tab1.endDraw();

    tab2.beginDraw();
    tab2.noStroke();
    tab2.image(loadImage("tab2.png"),0,0,width,height);
    tab2.endDraw();

    tab3.beginDraw();
    tab3.noStroke();
    tab3.image(loadImage("tab3.png"),0,0,width,height);
    tab3.endDraw();
  }
}
