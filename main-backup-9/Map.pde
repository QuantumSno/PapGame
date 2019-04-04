class Map {
  PGraphics map;
  int scale;
  public Map() {
    scale=4;
    //map size 2080x1750
    map = createGraphics(2080,1750);
    loadMap();
  }

  void m(int x, int y) { image(map, x, y); }

  void loadMap() {
    map.beginDraw();
    map.noStroke();
    map.image(loadImage("collider map.png"),0,0,2080,1750);
    map.endDraw();
  }
  boolean boarderUp() {
    if(false)
      return true;
    else
      return false;
  }
  boolean boarderLeft() {
    if(false)
      return true;
    else
      return false;
  }

  boolean boarderDown() {
    if(false)
      return true;
    else
      return false;
  }
  boolean boarderRight() {
    if(false)
      return true;
    else
      return false;
  }
}
