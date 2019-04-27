class raccoon {
  spritesheet raccoon, raccoonHurt, raccoonHit;
  public raccoon() {
    raccoon = new spritesheet(loadImage("raccoon.png"), 1, 1);
    raccoonHurt = new spritesheet(loadImage("raccoon hurt.png"), 1, 1);
    raccoonHit = new spritesheet(loadImage("raccoon hit.png"), 3, 3);
  }

  void ready() { raccoon.out(1, width-150, height-140); }
  void hurt() { raccoonHurt.out(1, width-150, height-140); }
  void hit(int f, int x, int y) { raccoonHit.out(f, x, y); }

}
