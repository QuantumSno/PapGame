class AI {
  int active=100;
  boolean gunnawalk() {
    if(int(random(1, active))==1) {
      //System.out.println("true");
      return true;
    }
    else
      return false;
  }
  int walk() {
    //System.out.println("walking");
    return int(random(5, active/2));
  }
  int direction() {
    return int(random(1,5));
  }
  String voice() {
    return "text";
  }
}
