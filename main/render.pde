class render {
  PImage Psymon,Whyatt;
  color defaultBackground = 30;
  void loadFriends(PImage p, PImage w) {
    Psymon=p;
    Whyatt=w;
  }
  void playerUp() {
    image(Psymon,width/2-16,height/2-16,32,32);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  void playerDown() {
    image(Psymon,width/2-16,height/2-16,32,32);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  void playerLeft() {
    image(Psymon,width/2-16,height/2-16,32,32);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  void playerRight() {
    image(Psymon,width/2-16,height/2-16,32,32);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  void map(int x,int y) {
    fill(0);
    ellipse(x,y,400,400);
  }
  void minimap() {
    fill(0,0,255);
    rect(100,100,width-200,height-200);
  }
  void inventory() {
    fill(0,255,0);
    rect(100,100,width-200,height-200);
  }
}
