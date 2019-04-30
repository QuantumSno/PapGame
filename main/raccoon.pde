class raccoon {
  spritesheet raccoon, raccoonHurt, raccoonHit;
  public raccoon() {
    raccoon = new spritesheet(loadImage("raccoon.png"), 1, 1);
    raccoonHurt = new spritesheet(loadImage("raccoon hurt.png"), 1, 1);
    raccoonHit = new spritesheet(loadImage("raccoon hit.png"), 3, 3);
  }

  void ready() { 
    raccoon.out(1, width-300, height-140);
  }
  void hurt() { 
    raccoonHurt.out(1, width-300, height-140);
  }
  void hit(int f) { 
    raccoonHit.out(f, width-300, height-140);
  }
}
