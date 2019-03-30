class Map {
  PGraphics map;
  int scale;
  public Map() {
    scale=4;
    map = createGraphics(840*scale,640*scale);
    loadMap();
  }

  PImage m() { return map; }

  void loadMap() {
    map.beginDraw();
    map.noStroke();
    map.image(loadImage("template_map.png"),0,0,840*scale,640*scale);
    map.endDraw();
  }
}
