class psymon {
  spritesheet up, down, left, right, walkUp, walkDown, walkLeft, walkRight, bat, ready, hurt;
  public psymon() {
    up= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20behind.png"), 1, 1);
    down= new spritesheet(loadImage("psymon front.png"), 1, 1);
    left= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20left.png"), 1, 1);
    right= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20right.png"), 1, 1);
    walkUp= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20behind%20walk.png"), 1, 2);
    walkDown= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20front%20walk.png"), 1, 2);
    walkLeft= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20left%20walk.png"), 2, 2);
    walkRight= new spritesheet(loadImage("https://raw.githubusercontent.com/QuantumSno/PapGame/master/main/data/psymon%20right%20walk.png"), 2, 2);
  }
  void up(int f) { up.out(f, width/2, height/2); }
  void down(int f) { down.out(f, width/2, height/2); }
  void left(int f) { left.out(f, width/2, height/2); }
  void right(int f) { right.out(f, width/2, height/2); }
  void walkUp(int f) { walkUp.out(f, width/2, height/2); }
  void walkDown(int f) { walkDown.out(f, width/2, height/2); }
  void walkLeft(int f) { walkLeft.out(f, width/2, height/2); }
  void walkRight(int f) { walkRight.out(f, width/2, height/2); }

}
