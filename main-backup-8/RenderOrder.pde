class RenderOrder {
    int scale, flipTime, flip, zone, x, y, walkSpeed;
    boolean move;
    Psymon psymon;
    Map map;
    ui ui;
    Whyatt whyatt;
  public RenderOrder() {
    psymon = new Psymon();
    map = new Map();
    ui = new ui();
    whyatt = new Whyatt(500,500);
    map.m(x,y);
    psymon.pS();
    grabVariables();
  }
  void grabVariables(
    int s, ft, f, z, o, p, ws;
    boolean m;
    ) {
      scale=s;
      flipTime=ft;
      flip=f;
      zone=z;
      x=o;
      y=y;
      walkSpeed=ws;
      move=m;

  }
  void render() {

  }
}
