class Whyatt extends AI {
  int x, y;
  int size;
  spritesheet up, down, left, right, walkUp, walkDown, walkLeft, walkRight;
  public Whyatt(int o, int p) {
    size=38*4;
    x=o;
    y=p;
    noStroke();
    noSmooth();
    up= new spritesheet(loadImage("whyatt up.png"), 1, 1);
    up.setW(size);
    up.setH(size);
    down= new spritesheet(loadImage("whyatt down.png"), 1, 1);
    down.setW(size);
    down.setH(size);
    left= new spritesheet(loadImage("whyatt left walk.png"), 1, 1);
    left.setW(size);
    left.setH(size);
    right= new spritesheet(loadImage("whyatt right walk.png"), 1, 1);
    right.setW(size);
    right.setH(size);
    walkUp= new spritesheet(loadImage("whyatt up walk.png"), 2, 2);
    walkUp.setW(size);
    walkUp.setH(size);
    walkDown= new spritesheet(loadImage("whyatt down walk.png"), 2, 2);
    walkDown.setW(size);
    walkDown.setH(size);
    walkLeft= new spritesheet(loadImage("whyatt left walk.png"), 2, 2);
    walkLeft.setW(size);
    walkLeft.setH(size);
    walkRight= new spritesheet(loadImage("whyatt right walk.png"), 2, 2);
    walkRight.setW(size);
    walkRight.setH(size);
  }
  void update(int o, int p) {
    x=o;
    y=p;
  }
  String voice(int voiceline) {
    if(voiceline==1)
      return "Hello!";
    else if(voiceline==2)
      return "Goodday Sir";
    else if(voiceline==3)
      return "The whether is nice today";
    else
      return "error";
  }
  int getX() {
    return x;
  }
  int getY() {
    return y;
  }
  boolean range(int o, int p) {
    if(o>x+420-100 && o< x+420+100 && p>y+310-100 && p<y+310+100)
      return true;
    return false;
  }
  void up(int ix, int iy) {
    up.out(1, ix-x, iy-y);
  }
  void down(int ix, int iy) {
    down.out(1, ix-x, iy-y);
  }
  void left(int ix, int iy) {
    left.out(2, ix-x, iy-y);
  }
  void right(int ix, int iy) {
    right.out(2, ix-x, iy-y);
  }
  void walkUp(int f, int ix, int iy) {
    walkUp.out(f, ix-x, iy-y);
  }
  void walkDown(int f, int ix, int iy) {
    walkDown.out(f, ix-x, iy-y);
  }
  void walkLeft(int f, int ix, int iy) {
    walkLeft.out(f, ix-x, iy-y);
  }
  void walkRight(int f, int ix, int iy) {
    walkRight.out(f, ix-x, iy-y);
  }
}
