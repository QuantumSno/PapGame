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
        default: psymon.pS(); break;
        case 1: psymon.pW(); break;
        case 2: psymon.pA(); break;
        case 3: psymon.pS(); break;
        case 4: psymon.pD(); break;
        case 5: psymon.pW1(); break;
        case 6: psymon.pW2(); break;
        case 7: psymon.pA1(); break;
        case 8: psymon.pA2(); break;
        case 9: psymon.pA3(); break;
        case 10: psymon.pA4(); break;
        case 11: psymon.pS1(); break;
        case 12: psymon.pS2(); break;
        case 13: psymon.pS(); break;
        case 14: psymon.pA(); break;
        case 15: psymon.pA(); break;
      }
    }
  }
}
