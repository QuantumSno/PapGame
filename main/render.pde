class render {
  PImage PsymonW,PsymonA,PsymonS,PsymonD,
  WhyattW,WhyattA,WhyattS,WhyattD,
  Map,
  PsymonOld
  ;
  int psymonSize, scale, mapSizeX, mapSizeY;
  public render(int ps, int s, int mX, int mY) {
    //require input
    psymonSize = ps;
    scale = s;
    mapSizeX = mX;
    mapSizeY = mY;
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
  void MAINRENDER() {
    image(Map,width/2-(mapSizeX*scale/2),height/2-(mapSizeY*scale/2),mapSizeX*scale,mapSizeY*scale);
    Psymon();
  }
  void Psymon() {
    image(PsymonW,width/2-(psymonSize*scale/2),height/2-(psymonSize*scale/2),psymonSize*scale,psymonSize*scale);

  }
}
