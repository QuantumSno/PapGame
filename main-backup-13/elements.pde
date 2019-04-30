class elements {
  PImage mapImage;
  spritesheet test, title, tab, templateMap, combatMap, combatSpin, map, hp;
  boolean once=false;
  public elements() {
    test = new spritesheet(loadImage("collider map.png"), 1, 1);
    test.setW(8320);
    test.setH(7040);
    mapImage=loadImage("foil map working.png");
    map = new spritesheet(mapImage, 1, 1);
    map.setW(8320);
    map.setH(7040);
    title = new spritesheet(loadImage("foil title.png"), 1, 1);
    tab = new spritesheet(loadImage("tab menu.png"), 2, 2);
    tab.setW(width);
    tab.setH(height);
    templateMap = new spritesheet(loadImage("template_map.png"), 1, 1);
    combatMap = new spritesheet(loadImage("stage.png"), 1, 2);
    combatMap.setW(width);
    combatMap.setH(height);
    combatSpin = new spritesheet(loadImage("combat menu.png"), 2, 2);
    combatSpin.setW(150);
    combatSpin.setH(150);
    hp = new spritesheet(loadImage("hp bar.png"), 4, 3);
    hp.setW(50*9);
    hp.setH(50);
  }
  void mapBoarders(int x, int y) {
    test.out(1, x, y);
  }
  void map(int x, int y) {
    map.out(1, x, y);
  }
  void title() {
    title.out(1, width/2, height/2);
  }
  void tab(int f) {
    tab.out(f, width/2, height/2);
  }
  void templateMap(int x, int y) {
    title.out(1, x, y);
  }
  void combat() {
    combatMap.out(1, width/2, height/2);
  }
  void combatMenu(int f) {
    combatSpin.out(f, 0+150/2, height-150/2);
  }
  void hp(int f) {
    hp.out(f, 0+(50*9)/2, 0+(50)/2);
  }
}
