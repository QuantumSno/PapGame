  class renderTests {
  boolean boarderUp() { //any boarders that would stop the player from moving up would result in true
    if(y>=1240)
      return true;
     else //System.out.println("y: " + y + " x: " + x);
      return false;
  }
  boolean boarderLeft() { //etc
    if(x>=1660-16)
      return true;
     else //System.out.println("y: " + y + " x: " + x);
      return false;
  }
  boolean boarderDown() { //etc
    if(y<=-895)
      return true;
     else //System.out.println("y: " + y + " x: " + x);
      return false;
  }
  boolean boarderRight() { //etc
    if(x<=-1245+16)
      return true;
     else //System.out.println("y: " + y + " x: " + x);
      return false;
  }
}
