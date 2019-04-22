class spritesheet {
  PImage[] sprites;
  public spritesheet(PImage spritesheet, int dX, int dY) {
    sprites = new PImage[dX*dY];
    int W = spritesheet.width/dX;
    int H = spritesheet.height/dY;
    for (int i=0; i<sprites.length; i++) {
      int x = i%dX*W;
      int y = i/dY*H;
      sprites[i] = spritesheet.get(x, y, W, H);
    }
  }
  void out(int i, int x, int y) {
    noStroke();
    image(sprites[i-1], x, y, 100, 100);
  }

}
