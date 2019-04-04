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

  void tab1() { image(tab1, width/2, height/2); }
  void tab2() { image(tab2, width/2, height/2); }
  void tab3() { image(tab3, width/2, height/2); }


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
