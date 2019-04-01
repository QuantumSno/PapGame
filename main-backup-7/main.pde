int scale, flipTime, flip, zone, x, y, walkSpeed;
Psymon psymon;
Map map;
ui ui;
boolean move;
void setup() {
  move = true;
  size(840, 640);
  flipTime = 10;
  flip = 0;
  zone = 0;
  x = 0;
  y = 0;
  walkSpeed = 5;
  imageMode(CENTER);
  psymon = new Psymon();
  map = new Map();
  ui = new ui();
  map.m(x,y);
  psymon.pS();
}
void draw() {
  if(flip >= flipTime * 4)
  flip = 0;
  if(keyPressed)
    if(move)
        keyPressed();
  if(zone == 1) {
    map.m(x,y);
    psymon.pS();
    ui.tab1();
  } else if(zone == 2) {
    map.m(x,y);
    psymon.pS();
    ui.tab2();
  } else if(zone == 3) {
    map.m(x,y);
    psymon.pS();
    ui.tab3();
  }
}

  void keyPressed() {
  if(keyPressed)
    map.m(x,y);
  flip++;
  switch (key) {
    default: psymon.pS();
    break;
    case 'w':
      if(move) {
        y = y + walkSpeed;
        if(!map.boarderUp())
          if(flip >= 0 && flip < flipTime)
            psymon.pW1();
          else if(flip >= flipTime && flip < flipTime * 2)
            psymon.pW2();
          else if(flip >= flipTime * 2 && flip < flipTime * 3)
            psymon.pW1();
          else
            psymon.pW2();
      }
    break;
    case 'a':
      if(move) {
        x = x + walkSpeed;
        if(!map.boarderLeft())
          if(flip >= 0 && flip < flipTime)
            psymon.pA1();
          else if(flip >= flipTime && flip < flipTime * 2)
            psymon.pA2();
          else if(flip >= flipTime * 2 && flip < flipTime * 3)
            psymon.pA3();
          else
            psymon.pA4();
      }
    break;
    case 's':
      if(move) {
        y = y - walkSpeed;
        if(!map.boarderDown())
          if(flip >= 0 && flip < flipTime)
            psymon.pS1();
          else if(flip >= flipTime && flip < flipTime * 2)
            psymon.pS2();
          else if(flip >= flipTime * 2 && flip < flipTime * 3)
            psymon.pS1();
          else
            psymon.pS2();
      }
    break;
    case 'd':
      if(move) {
        x = x - walkSpeed;
        if(!map.boarderRight())
          if(flip >= 0 && flip < flipTime)
            psymon.pD1();
          else if(flip >= flipTime && flip < flipTime * 2)
            psymon.pD2();
          else if(flip >= flipTime * 2 && flip < flipTime * 3)
            psymon.pD3();
          else
          psymon.pD4();
      }
    break;
    case TAB:
      zone = 1;
      delay(100);
      move = false;
    break;
  }
}
void keyReleased() {
  map.m(x,y);
  switch (key) {
    default: psymon.pS();
    break;
    case 'w':
      psymon.pW();
      if(zone == 2)
        zone = 1;
      if(zone == 3)
        zone = 2;
    break;
    case 'a':
      psymon.pA();
    break;
    case 's':
      psymon.pS();
      if(zone == 1)
        zone = 2;
      if(zone == 2)
        zone = 3;
    break;
    case 'd':
      psymon.pD();
    break;
    case ENTER:
      if(zone == 1)
      zone = 0;
      move=true;
    break;
  }
}
