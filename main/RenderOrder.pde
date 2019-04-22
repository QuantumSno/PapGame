class RenderOrder {
    float s;
    Psymon psymon;
    Map map;
    ui ui;
    Whyatt whyatt;
    Surman surman;
    int wd, wdt, wdd, ws;
  public RenderOrder(int x, int y) {
    ws=3;
    psymon = new Psymon();
    map = new Map();
    ui = new ui();
    whyatt = new Whyatt(0,0);
    surman= new Surman();
    map.m(x,y);
    psymon.pS();
  }

  void render(int zone, int x, int y, int direction, int hammer, int dmg, boolean doDmg, int frame) {
    map.m(x,y);
    if(zone==0) {
      aiTests();
      whyatt();
      psymon();
    } else if(zone==1) {
      map.m(x, y);
      whyatt();
      psymon();
      ui.tab1();
    } else if(zone==2) {
      map.m(x, y);
      whyatt();
      psymon();
      ui.tab2();
    } else if(zone==3) {
      map.m(x, y);
      whyatt();
      psymon();
      ui.tab3();
    } else if(zone==4) {
      background(40);
      if(doDmg) {
        surman.hit(dmg);
        delay(100);
        psymon.dmg(surman.dmg());
      }
      switch(hammer) {
        default: psymon.pB1();
        break; case 1: psymon.pB1();
        break; case 2: psymon.pB2();
        break; case 3: psymon.pB3();
        break; case 4: psymon.pB4();
        break; case 5: psymon.pB5();
        break; case 6: psymon.pB6();
        break;
      }
      surman.s();
      textAlign(CENTER, CENTER);
      textSize(32);
      fill(255,0,0);
      text(psymon.hp(), width/4, height-height/4);
      text(surman.hp(), width-width/4, height-height/4);
    }
  }
  void aiTests() {
    whyatt();
  }
  int shp() { return surman.hp(); }
  void shpr() { surman.reset(); }
  String wvoice() {
    return whyatt.voice(int(random(1,4)));
  }
  boolean wrange(int x, int y) {
    return whyatt.range(x,y);
  }
  int wgetX() {
    return whyatt.getX();
  }
  int wgetY() {
    return whyatt.getY();
  }
  void whyatt() {
    if(whyatt.gunnawalk()) {
      wd=whyatt.walk();
      wdd=whyatt.direction();
      wdt=0;
    }
    if(wdt<wd) {
      switch(wdd) {
        case 1:
          whyatt.update(whyatt.getX(),whyatt.getY()+ws);
          if(frame==1)
            whyatt.wS1(x, y);
          else if(frame==2)
            whyatt.wS2(x, y);
          else if(frame==3)
            whyatt.wS1(x, y);
          else
            whyatt.wS2(x, y);
          flip++;
          break;
        case 2:
          whyatt.update(whyatt.getX()-ws,whyatt.getY());
          if(frame==1)
            whyatt.wS1(x, y);
          else if(frame==2)
            whyatt.wS2(x, y);
          else if(frame==3)
            whyatt.wS1(x, y);
          else
            whyatt.wS2(x, y);
          flip++;
          break;
        case 3:
          whyatt.update(whyatt.getX(),whyatt.getY()-ws);
          if(frame==1)
            whyatt.wS1(x, y);
          else if(frame==2)
            whyatt.wS2(x, y);
          else if(frame==3)
            whyatt.wS1(x, y);
          else
            whyatt.wS2(x, y);
          flip++;
          break;
        case 4:
          whyatt.update(whyatt.getX()+ws,whyatt.getY());
          if(frame==1)
            whyatt.wS1(x, y);
          else if(frame==2)
            whyatt.wS2(x, y);
          else if(frame==3)
            whyatt.wS1(x, y);
          else
            whyatt.wS2(x, y);
          flip++;
          break;
      }
      wdt++;
    } else {
      switch(wdd) {
        default: whyatt.wS(x, y); break;
        case 1: whyatt.wS(x, y); break;
        case 2: whyatt.wS(x, y); break;
        case 3: whyatt.wS(x, y); break;
        case 4: whyatt.wS(x, y); break;
      }
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
        if(frame==1)
          psymon.pW1();
        else if(frame==2)
          psymon.pW2();
        else if(frame==3)
          psymon.pW1();
        else
          psymon.pW2();
        break;
      case 6:
        if(frame==1)
          psymon.pA1();
        else if(frame==2)
          psymon.pA2();
        else if(frame==3)
          psymon.pA3();
        else
          psymon.pA4();
        break;
      case 7:
        if(frame==1)
          psymon.pS1();
        else if(frame==2)
          psymon.pS2();
        else if(frame==3)
          psymon.pS1();
        else
          psymon.pS2();
        break;
      case 8:
        if(frame==1)
          psymon.pD1();
        else if(frame==2)
          psymon.pD2();
        else if(frame==3)
          psymon.pD3();
        else
          psymon.pD4();
        break;
    }
  }
}
