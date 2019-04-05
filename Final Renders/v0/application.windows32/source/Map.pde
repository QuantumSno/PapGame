class Map {
  PGraphics map;
  int scale;
  boarders b;
  public Map() {
    b= new boarders();
    scale=4;
    //map size 2080x1750
    map = createGraphics(2080*scale,1750*scale);
    loadMap();
  }

  void m(int x, int y) { image(map, x, y); }
  void translate(int x, int y) {
    translate(x, y);
  }

  void loadMap() {
    map.beginDraw();
    map.noStroke();
    map.image(loadImage("collider map.png"),0,0,2080*scale,1750*scale);
    map.endDraw();
  }
  boolean boarderUp() {
    if(b.up(x,y))
      return true;
    return false;
  }
  boolean boarderLeft() {
    if(b.left(x,y))
      return true;
    return false;
  }

  boolean boarderDown() {
    if(b.down(x,y))
      return true;
    return false;
  }
  boolean boarderRight() {
    if(b.right(x,y))
      return true;
    return false;
  }
}
