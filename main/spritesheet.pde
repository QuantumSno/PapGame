class spritesheet {
  PImage[] sprites;
  ArrayList<PGraphics> rendered;
  int wid, hei;
  public spritesheet(PImage spritesheet, int dX, int dY) {
    sprites = new PImage[dX*dY];
    rendered = new ArrayList<PGraphics>();
    int W = spritesheet.width/dX;
    int H = spritesheet.height/dY;
    wid=hei=300;
    for (int i=0; i<sprites.length; i++) {
      int x = i%dX*W;
      int y = i/dY*H;
      sprites[i] = spritesheet.get(x, y, W, H);
    }
  }
  void out(int i, int x, int y) {
    noStroke();
    image(sprites[i-1], x, y, wid, hei);
  }
  void setW(int i) { wid=i; }
  void setH(int i) { hei=i; }
}
