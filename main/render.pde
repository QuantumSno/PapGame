class render {
  PImage Psymon,Whyatt,Map;
  color defaultBackground = 30;
  int ss,scale;
  void loadFriends(PImage p, PImage w,PImage m) {
    Psymon=p;
    Whyatt=w;
    Map=m;
    scale=4;
    ss=32;
  }
  void playerUp() {
    image(Psymon,width/2-16,height/2-16,ss*scale,ss*scale);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  void playerDown() {
    image(Psymon,width/2-16,height/2-16,ss*scale,ss*scale);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  void playerLeft() {
    image(Psymon,width/2-16,height/2-16,ss*scale,ss*scale);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  void playerRight() {
    image(Psymon,width/2-16,height/2-16,ss*scale,ss*scale);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  void map(int x,int y) {
    image(Map,x,y,640*scale,480*scale);
    //fill(0); ellipse(x,y,400,400);
  }
    void inventory() {
    fill(0,255,0);
    rect(100,100,width-200,height-200);
  }
}
