class Map {
  PGraphics map;
  int scale;
  ArrayList<boarders> boarder = new ArrayList<boarders>();
  public Map() {
    scale=4;
    //map size 2080x1750
    map = createGraphics(2080*scale,1750*scale);
    //map=createGraphics(1000,1000);
    loadMap();
    loadBoarders();
  }

  void m(int x, int y) { image(map, x, y); }
  void translate(int x, int y) {
    translate(x, y);
  }
  void loadMap() {
    map.beginDraw();
    map.noStroke();
    //map.background(30);
    map.image(loadImage("collider map.png"),0,0,2080*scale,1750*scale);
    map.endDraw();
  }
  boolean boarderUp(int x, int y) {
    for(int t=0; t<boarder.size(); t++)
      if(boarder.get(t).getD()==1)
        if(boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
          return true;
    return false;
  }
  boolean boarderLeft(int x, int y) {
    for(int t=0; t<boarder.size(); t++)
      if(boarder.get(t).getD()==2)
        if(boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
          return true;
    return false;
  }
  boolean boarderDown(int x, int y) {
    for(int t=0; t<boarder.size(); t++)
      if(boarder.get(t).getD()==3)
        if(boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
          return true;
    return false;
  }
  boolean boarderRight(int x, int y) {
    for(int t=0; t<boarder.size(); t++)
      if(boarder.get(t).getD()==4)
        if(boarder.get(t).getX1() > x-5 && boarder.get(t).getX2() < x+5 &&
        boarder.get(t).getY1() > y-5 && boarder.get(t).getY2() < y+5)
          return true;
    return false;
  }
  void loadBoarders() {
    //boarder.add(new boarders(, , , , )); //
    boarder.add(new boarders(4305, -1880, 4305, -2095, 2)); //1-2
    boarder.add(new boarders(4305, -1880, 4185, -1880, 1)); //2-3
    boarder.add(new boarders(4185, -1755, 4185, -1880, 2)); //3-4
    boarder.add(new boarders(4180, -1755, 4050, -1755, 1)); //4-5
    boarder.add(new boarders(4050, -1335, 4050, -1755, 2)); //5-6
    boarder.add(new boarders(4305, -1335, 4050, -1335, 3)); //6-7
    boarder.add(new boarders(4305, -1254, 4305, -1335, 2)); //7-8
    boarder.add(new boarders(4305, -1245, 4180, -1245, 1)); //8-9
    boarder.add(new boarders(4180, -1080, 4180, -1245, 2)); //9-10
    boarder.add(new boarders(4305, -1080, 4180, -1080, 3)); //10-11
    boarder.add(new boarders(4305, 920, 4305, -1080, 2)); //11-24
    boarder.add(new boarders(4305, 920, 2765, 915, 1)); //24-25
    boarder.add(new boarders(2765, 915, 2765, 1215, 2)); //25-26
    boarder.add(new boarders(2765, 1215, 2935, 1215, 3)); //26-27
    boarder.add(new boarders(2935, 1215, 2935, 1085, 4)); //27-28
    boarder.add(new boarders(2935, 1085, 4305, 1085, 3)); //28-29
    boarder.add(new boarders(4305, 1085, 4305, 2570, 2)); //29-34
    boarder.add(new boarders(4305, 2570, 2935, 2570, 1)); //34-35
    boarder.add(new boarders(2935, 2570, 2935, 1555, 4)); //35-36
    boarder.add(new boarders(2935, 1555, 2765, 1555, 1)); //36-37
    boarder.add(new boarders(2765, 1555, 2765, 2570, 2)); //37-38
    boarder.add(new boarders(2765, 2570, 2645, 2570, 1)); //38-39
    boarder.add(new boarders(2645, 2570, 2645, 2740, 2)); //39-40
  }
}
