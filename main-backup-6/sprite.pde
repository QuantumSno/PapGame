class sprite {
  PImage sprite;
  PGraphics render;
  String name;
  int x,y, sizeX, sizeY;
  public sprite(PImage s, int o, int p, String n) {
    sprite=s;
    sizeX=o;
    sizeY=p;
    name=n;
    Gload();
  }
  //set name from file name
  void setCords(int o, int p) {
    x=o;
    y=p;
  }
  void Gload() {
    render = createGraphics(sizeX,sizeY);
    render.beginDraw();
    render.noStroke();
    render.image(sprite, 0, 0, sizeX, sizeY);
    render.endDraw();
  }
  String getName() {
    return name;
  }
  PGraphics out() {
    return render;
  }
}
