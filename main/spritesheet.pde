class spritesheet {
  PImage[] sprites;
  int wid, hei;
  public spritesheet(PImage spritesheet, int dX, int dY) {
    noStroke();
    smooth(0);
    sprites = new PImage[dX*dY];
    int W = wid = spritesheet.width/dX;
    int H = hei = spritesheet.height/dY;
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
  void printSheet(int lvl) {
    int tx=wid/2;
    int ty=hei/2;
    ty+=hei*(lvl-1);
    for(int t=0; t<sprites.length; t++) {
      image(sprites[t], tx, ty, wid, hei);
      tx+=wid;
    }
  }
  void setW(int i) { wid=i; }
  void setH(int i) { hei=i; }
}
