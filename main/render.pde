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
  void minimap() { //loop minimap draw functions until user presses 'm' again
    //drawMinimap();
    
  }
    /*
    void drawMinimap() { //this will act as the draw function for minimap
      while (keyPressed==false && key=='m') {
        fill(0,255,0);
        rect(width/2,height/2,width-100,height-100);
      }
    }
    */
  void inventory() { //loops minimap draw function until user presses 'i' again
    //drawInventory();

  }
    /*
    void drawInventory() { //this will act as the draw funciton for inventory
      if(keyPressed) {
        if(key=='i') {  }
      } else {
        fill(0,0,255);
        rect(width/2,height/2,200,200);
        drawInventory();
      }
    }
    */
}
