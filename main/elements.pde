class elements {
  spritesheet test, title, tab, templateMap, combatMap, combatSpin, map;
  public elements() {
    test = new spritesheet(loadImage("collider map.png"), 1, 1);
      test.setW(8320);
      test.setH(7040);
    map = new spritesheet(loadImage("foil map working.png"), 1, 1);
      map.setW(8320);
      map.setH(7040);
    title = new spritesheet(loadImage("foil title.png"), 1, 1);
    tab = new spritesheet(loadImage("tab menu.png"), 2, 2);
      tab.setW(width); tab.setH(height);
    templateMap = new spritesheet(loadImage("template_map.png"), 1, 1);
    combatMap = new spritesheet(loadImage("stage.png"), 1, 2);
      combatMap.setW(width); combatMap.setH(height);
    combatSpin = new spritesheet(loadImage("combat menu.png"), 2, 2);
      combatSpin.setW(150); combatSpin.setH(150);
  }
  void mapBoarders(int x, int y) { test.out(1, x, y); }
  void map(int x, int y) { map.out(1, x, y); }
  void title() { title.out(1, width/2, height/2); }
  void tab(int f) { tab.out(f, width/2, height/2); }
  void templateMap(int x, int y) { title.out(1, x, y); }
  void combat() { combatMap.out(1, width/2, height/2); }
  void combatMenu(int f) { combatSpin.out(f, 0+50, height-50); }
}
