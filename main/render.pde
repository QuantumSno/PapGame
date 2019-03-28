class render {
  PImage PsymonW, PsymonA, PsymonS, PsymonD,
  WhyattW, WhyattA, WhyattS, WhyattD,
  Map,
  PsymonOld
  ;
  /*
  PGraphics PsymonW, PsymonA, PsymonS, PsymonD,
  WhyattW, WhyattA, WhyattS, WhyattD,
  Map,
  PsymonOld
  ;
  */
  int psymonSize, scale, mapSizeX, mapSizeY, mapX, mapY,direction;
  public render(int ps, int s, int msX, int msY, int mX, int mY) {
    //require input
    psymonSize = ps;
    scale = s;
    mapSizeX = msX;
    mapSizeY = msY;
    mapX = mX;
    mapY = mY;
    //just set up
    PsymonW = loadImage("Psymon-front.png");
    PsymonA = loadImage("Psymon-side-left.png");
    PsymonS = loadImage("Psymon-behind.png");
    PsymonD = loadImage("Psymon-side-right.png");
    PsymonOld = loadImage("Psymon-old.png");
    WhyattW = loadImage("Whyatt.png");
    /*
    WhyattA = loadImage("Whyatt-
    WhyattS = loadImage("Whyatt-
    WhyattD = loadImage("Whyatt-
    */
    Map = loadImage("template_map.png");
  }

  void MAINRENDER(int renderZone) {
    switch (renderZone) {
      default:
        image(Map,mapX,mapY,mapSizeX*scale,mapSizeY*scale);
        Psymon();
      break; case 0:
        image(Map,mapX,mapY,mapSizeX*scale,mapSizeY*scale);
        Psymon();
      break;
    }
    image(Map,mapX,mapY,mapSizeX*scale,mapSizeY*scale);
    Psymon();
  }

  void updateXY(int o, int p) {
    mapX=o;
    mapY=p;
  }
  void updateDirection(int t) {
    direction=t;
  }

  void Psymon() {
    switch (direction) {
      default:
        image(PsymonW,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break; case 1:
        image(PsymonS,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break; case 2:
        image(PsymonA,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break; case 3:
        image(PsymonW,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break; case 4:
        image(PsymonD,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);
      break;
    }

  }
}
