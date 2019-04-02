class RenderOrder {
    Psymon psymon;
    Map map;
    ui ui;
    Whyatt whyatt;
  public RenderOrder(int x, int y) {
    psymon = new Psymon();
    map = new Map();
    ui = new ui();
    whyatt = new Whyatt(500,500);
    map.m(x,y);
    psymon.pS();
  }
  void render(int zone, int x, int y, int direction, int flip) {
    if(zone==0) {
      map.m(x, y);
      switch(direction) {
        default: psymon.pS();
        case 1: psymon.pW1;
        break; 
      }
    }
  }
}
