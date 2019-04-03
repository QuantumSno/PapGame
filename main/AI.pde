class AI {
  int active;
  void AI(int a) {
    active=a;
  }
  boolean gunnawalk() {
    if(int(random(0, active))==active)
      return true;
    else
      return false;
  }
  int walk() {
    return int(random(5, active/2));
  }
}
