class Map {
  PGraphics map;
  int scale;
  boarder b;
  public Map() {
    b= new boarder();
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
    b.up(x,y);
  }
  boolean boarderLeft() {
    b.left(x,y);
  }

  boolean boarderDown() {
    b.down(x,y);
  }
  boolean boarderRight() {
    b.right(x,y);
  }
}
