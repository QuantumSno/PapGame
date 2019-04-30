class AI {
  int active=100;
  boolean gunnawalk() {
    if(int(random(1, active))==1) {
      return true;
    } else
      return false;
  }
  int walk() {
    return int(random(5, active/2));
  }
  int direction() {
    return int(random(1, 5));
  }
  String voice() {
    return "text";
  }
  boolean range(int o, int p) {
    if(o>x+420-100 && o< x+420+100 && p>y+310-100 && p<y+310+100)
      return true;
    return false;
  }
}
