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
  void render(int zone, int x, int y, int direction, int flip, int flipTime) {
    if(zone==0) {
      map.m(x, y);
      psymon();
    } else if(zone==1) {
      map.m(x, y);
      psymon();
      ui.tab1();
    } else if(zone==2) {
      map.m(x, y);
      psymon();
      ui.tab2();
    } else if(zone==3) {
      map.m(x, y);
      psymon();
      ui.tab3();
    }
  }
  void psymon() {
    switch(direction) {
      default: psymon.pS(); break;
      case 1: psymon.pW(); break;
      case 2: psymon.pA(); break;
      case 3: psymon.pS(); break;
      case 4: psymon.pD(); break;
      case 5:
        if(flip >= 0 && flip < flipTime)
          psymon.pW1();
        else if(flip >= flipTime && flip < flipTime * 2)
          psymon.pW2();
        else if(flip >= flipTime * 2 && flip < flipTime * 3)
          psymon.pW1();
        else
          psymon.pW2();
        break;
      case 6:
        if(flip >= 0 && flip < flipTime)
          psymon.pA1();
        else if(flip >= flipTime && flip < flipTime * 2)
          psymon.pA2();
        else if(flip >= flipTime * 2 && flip < flipTime * 3)
          psymon.pA3();
        else
          psymon.pA4();
        break;
      case 7:
        if(flip >= 0 && flip < flipTime)
          psymon.pS1();
        else if(flip >= flipTime && flip < flipTime * 2)
          psymon.pS2();
        else if(flip >= flipTime * 2 && flip < flipTime * 3)
          psymon.pS1();
        else
          psymon.pS2();
        break;
      case 8:
        if(flip >= 0 && flip < flipTime)
          psymon.pD1();
        else if(flip >= flipTime && flip < flipTime * 2)
          psymon.pD2();
        else if(flip >= flipTime * 2 && flip < flipTime * 3)
          psymon.pD3();
        else
          psymon.pD4();
        break;
    }
  }
}
