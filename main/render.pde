class render {
  color defaultBackground = 30;

  void playerUp() {
    fill(255,0,0);
    rect(width/2,height/2,20,20);
  }
  void playerDown() {
    fill(255,0,0);
    rect(width/2,height/2,20,20);
  }
  void playerLeft() {
    fill(255,0,0);
    rect(width/2,height/2,20,20);
  }
  void playerRight() {
    fill(255,0,0);
    rect(width/2,height/2,20,20);
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
