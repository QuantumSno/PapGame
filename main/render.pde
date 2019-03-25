class render {
  color defaultBackground = 30;

  void playerUp() {
    rect(width/2,height/2,20,20);
  }
  void playerDown() {
    rect(width/2,height/2,20,20);
  }
  void playerLeft() {
    rect(width/2,height/2,20,20);
  }
  void playerRight() {
    rect(width/2,height/2,20,20);
  }
  void map(int x,int y) {
    ellipse(x,y,400,400);
  }
  void minimap() {
    //loop minimap draw functions until user presses 'm' again
  }
    void drawMinimap() {
      //this will act as the draw function for minimap
    }
  void inventory() {
  //loops minimap draw function until user presses 'i' again
  }
    void drawInventory() {
      //this will act as the draw funciton for inventory
    }
}
