class psymon {
  spritesheet up, down, left, right, walkUp, walkDown, walkLeft, walkRight, bat, batcharge, ready, hurt;
  int size;
  public psymon() { size=32*4;
    noStroke();
    noSmooth();
    up= new spritesheet(loadImage("psymon up.png"), 1, 1); up.setW(size); up.setH(size);
    down= new spritesheet(loadImage("psymon down.png"), 1, 1); down.setW(size); down.setH(size);
    left= new spritesheet(loadImage("psymon left.png"), 1, 1); left.setW(size); left.setH(size);
    right= new spritesheet(loadImage("psymon right.png"), 1, 1); right.setW(size); right.setH(size);
    walkUp= new spritesheet(loadImage("psymon up walk.png"), 2, 2); walkUp.setW(size); walkUp.setH(size);
    walkDown= new spritesheet(loadImage("psymon down walk.png"), 2, 2); walkDown.setW(size); walkDown.setH(size);
    walkLeft= new spritesheet(loadImage("psymon left walk.png"), 2, 2); walkLeft.setW(size); walkLeft.setH(size);
    walkRight= new spritesheet(loadImage("psymon right walk.png"), 2, 2); walkRight.setW(size); walkRight.setH(size);
    bat = new spritesheet(loadImage("psymon bat.png"), 3, 3); bat.setW(size); bat.setH(size);
    bat = new spritesheet(loadImage("psymon bat charge.png"), 4, 5); bat.setW(size); bat.setH(size);
    ready = new spritesheet(loadImage("psymon ready.png"), 1, 1); ready.setW(size); ready.setH(size);
    hurt = new spritesheet(loadImage("psymon hurt.png"), 1, 1); hurt.setW(size); hurt.setH(size);
  }
  void up() { up.out(1, width/2, height/2); }
  void down() { down.out(1, width/2, height/2); }
  void left() { left.out(1, width/2, height/2); }
  void right() { right.out(1, width/2, height/2); }
  void walkUp(int f) { walkUp.out(f, width/2, height/2); }
  void walkDown(int f) { walkDown.out(f, width/2, height/2); }
  void walkLeft(int f) { walkLeft.out(f, width/2, height/2); }
  void walkRight(int f) { walkRight.out(f, width/2, height/2); }
  void bat(int f) { bat.out(f, width/2, height/2); }
  void ready(int f) { ready.out(f, width/2, height/2); }
  void hurt(int f) { hurt.out(f, width/2, height/2); }

  void sheettest() {
    walkLeft.printSheet(1);
    walkDown.printSheet(2);
    walkUp.printSheet(3);
  }
}
