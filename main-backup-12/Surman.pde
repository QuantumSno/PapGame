class Surman extends AI {
  int size, scale, hp, dmg, hitChance;
  PGraphics surman;
  public Surman() {
    scale=4;
    size=32*scale;
    surman = createGraphics(size*2,size*2);
    hp=20;
    hitChance=5; // 1/5 chance
    dmg=5;
    loadsurman();
  }
  void s() { image(surman, width-width/4, height/2); }
  int dmg() {
    if(int(random(1,3))==1)
      return dmg;
    return 0;
  }
  void hit(int d) { hp-=d; }
  int hp() { return hp; }
  void reset() { hp=20; }
  void loadsurman() {
    surman.beginDraw();
    surman.noStroke();
    surman.image(loadImage("surman.png"),0,0,size*2,size*2);
    surman.endDraw();
  }
}
