class boarders {
  int x1, y1, x2, y2, direction;
  /*
  1= up
  2= left
  3= down
  4= right
  */
  public boarders(int ix1, int iy1, int ix2, int iy2, int idirection) {
    x1=ix1;
    y1=iy1;
    x2=ix2;
    y2=iy2;
    direction=idirection;
  }
  int getD() { return direction; }
  int getX1() { return x1; }
  int getY1() { return y1; }
  int getX2() { return x2; }
  int getY2() { return y2; }

  void update(int x, int y) {
      x1+=x;
      y1+=y;
      x2+=x;
      y2+=y;
  }
}
