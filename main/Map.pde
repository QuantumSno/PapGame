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
    map.background(30);
    map.image(loadImage("collider map.png"),0,0,2080*scale,1750*scale);
    //map.image(loadImage("template_map.png"),0,0,1000,1000);
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
    boarder.add(new boarders(2765, 1215, 2765, 915, 2)); //25-26
    boarder.add(new boarders(2935, 1215, 2765, 1215, 3)); //26-27
    boarder.add(new boarders(2935, 1215, 2935, 1085, 4)); //27-28
    boarder.add(new boarders(4305, 1085, 2935, 1085, 3)); //28-29
    boarder.add(new boarders(4305, 2570, 4305, 1085, 2)); //29-34
    boarder.add(new boarders(4305, 2570, 2935, 2570, 1)); //34-35
    boarder.add(new boarders(2935, 2570, 2935, 1555, 4)); //35-36
    boarder.add(new boarders(2935, 1555, 2765, 1555, 1)); //36-37
    boarder.add(new boarders(2765, 2570, 2765, 1555, 2)); //37-38
    boarder.add(new boarders(2765, 2570, 2645, 2570, 1)); //38-39
    boarder.add(new boarders(2645, 2740, 2645, 2570, 2)); //39-40
    boarder.add(new boarders(4525, 2740, 2645, 2570, 3)); //40-41
    boarder.add(new boarders(4525, 3080, 4525, 2740, 2)); //41-42
    boarder.add(new boarders(-3590, 3080, 4525, 3080, 1)); //41-125
    boarder.add(new boarders(-3590, 3080, -3590, 2740 , 4)); //125-124
    boarder.add(new boarders(-1930, 2740, -3590, 2740, 3)); //124-123
    boarder.add(new boarders(-1930, 2740, -1930, 2570, 4)); //123-122
    boarder.add(new boarders(-1930, 2570, -2315, 2570, 1)); //122-121
    boarder.add(new boarders(-2315, 2570, -2315, 70, 4)); //121-120
    boarder.add(new boarders(-1460, 70, -2315, 70, 3)); //120-119
    boarder.add(new boarders(-1460, 830, -1460, 70, 2)); //119-118
    boarder.add(new boarders(-1160, 830, -1460, 830, 3)); //117-118
    boarder.add(new boarders(-1160, 830, -1160, 320, 4)); //117-116
    boarder.add(new boarders(-650, 320, -1160, 320, 3)); //116-115
    boarder.add(new boarders(-650, 320, -650, -2010, 4)); //115-114
    boarder.add(new boarders(-650, -2010, -1970, -2010, 1)); //114-113
    boarder.add(new boarders(-1970, -1240, -1970, -2010, 2)); //113-112
    boarder.add(new boarders(-1970, -1240, -2315, -1245, 1)); //112-111
    boarder.add(new boarders(-2315, -1245, -2315, -2605, 4)); //111-110
    boarder.add(new boarders(460, -2905, -2315, -2605, 3)); //110-109
    boarder.add(new boarders(460, 1170, 460, -2905, 2)); //109-108
    boarder.add(new boarders(460, 1170, -1455, 1170, 1)); //108-107
    boarder.add(new boarders(-1455, 2570, -1455, 1170, 2)); //107-106
    boarder.add(new boarders(-1455, 2570, -1835, 2570, 1)); //106-105
    boarder.add(new boarders(-1840, 2740, -1835, 2570, 2)); //105-104///
    boarder.add(new boarders(2290, 2740, -1840, 2740, 3)); //104-43
    boarder.add(new boarders(2290, 2740, 2290, 2570, 4)); //43-44
    boarder.add(new boarders(2290, 2570, 2165, 2570, 1)); //44-45
    boarder.add(new boarders(2165, 2570, 2165, 1300, 4)); //45-46
    boarder.add(new boarders(2165, 1300, 1235, 1300, 1)); //46-55
    boarder.add(new boarders(1235, 1465, 1235, 1300, 2)); //55-56
    boarder.add(new boarders(1995, 1465, 1235, 1465, 3)); //56-57
    boarder.add(new boarders(1995, 2570, 1995, 1465, 2)); //57-62
    boarder.add(new boarders(1995, 2570, 630, 2570, 1)); //62-63
    boarder.add(new boarders(630, 2570, 630, 1470, 4)); //63-68
    boarder.add(new boarders(885, 1470, 630, 1470, 3)); //68-69
    boarder.add(new boarders(885, 1470, 885, 1300, 4)); //69-70
    boarder.add(new boarders(885, 1300, 630, 1300, 1)); //70-71
    boarder.add(new boarders(630, 1300, 630, 195, 4)); //71-72
    boarder.add(new boarders(890, 195, 195, 630, 3)); //72-73
    boarder.add(new boarders(890, 195, 890, 25, 4)); //73-74
    boarder.add(new boarders(890, 25, 630, 25, 1)); //74-75
    boarder.add(new boarders(630, 25, 630, -1330, 4)); //75-88
    boarder.add(new boarders(2000, -1330, 630, -1330, 3)); //88-89
    boarder.add(new boarders(2000, -955, 2000, -1330, 2)); //89-90
    boarder.add(new boarders(2165, -955, 2000, -955, 3)); //90-91
    boarder.add(new boarders(2165, -955, 2165, -1500, 4)); //91-101
    boarder.add(new boarders(2165, -1500, 630, -1500, 1)); //101-102
    boarder.add(new boarders(630, -1500, 630, -2095, 4)); //102-103
    boarder.add(new boarders(4305, -2095, 630, -2095, 3)); //103-1
  }
}
