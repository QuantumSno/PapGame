int scale, flipTime, flip, zone, x, y, walkSpeed;
Psymon psymon;
Map map;
ui ui;
boolean move;
void setup() {
  move = true;
  size(840, 640);
  flipTime = 5;
  flip = 0;
  zone = 0;
  x = 0;
  y = 0;
  walkSpeed = 5;
  imageMode(CENTER);
  psymon = new Psymon();
  map = new Map();
  ui = new ui();
  image(map.m(), x, y);
  image(psymon.pS(), width / 2, height / 2);
}
void draw() {
  if (flip >= flipTime * 4)
  flip = 0;
  if (keyPressed)
    if (move)
        keyPressed();
  if (zone == 1) {
    image(map.m(), x, y);
    image(psymon.pS(), width / 2, height / 2);
    image(ui.tab1(), width / 2, height / 2);
  } else if (zone == 2) {
    image(map.m(), x, y);
    image(psymon.pS(), width / 2, height / 2);
    image(ui.tab2(), width / 2, height / 2);
  } else if (zone == 3) {
    image(map.m(), x, y);
    image(psymon.pS(), width / 2, height / 2);
    image(ui.tab3(), width / 2, height / 2);
  }
}

  void keyPressed() {
  if (keyPressed)
    image(map.m(), x, y);
  flip++;
  switch (key) {
    default: image(psymon.pS(), width / 2, height / 2);
    break;
    case 'w':
      if (move) {
        y = y + walkSpeed;
        if (!map.boarderUp())
          if (flip >= 0 && flip < flipTime)
            image(psymon.pW1(), width / 2, height / 2);
          else if (flip >= flipTime && flip < flipTime * 2)
            image(psymon.pW2(), width / 2, height / 2);
          else if (flip >= flipTime * 2 && flip < flipTime * 3)
            image(psymon.pW1(), width / 2, height / 2);
          else
            image(psymon.pW2(), width / 2, height / 2);
      }
    break;
    case 'a':
      if (move) {
        x = x + walkSpeed;
        if (!map.boarderLeft())
          if (flip >= 0 && flip < flipTime)
            image(psymon.pA1(), width / 2, height / 2);
          else if (flip >= flipTime && flip < flipTime * 2)
            image(psymon.pA2(), width / 2, height / 2);
          else if (flip >= flipTime * 2 && flip < flipTime * 3)
            image(psymon.pA3(), width / 2, height / 2);
          else
            image(psymon.pA4(), width / 2, height / 2);
      }
    break;
    case 's':
      if (move) {
        y = y - walkSpeed;
        if (!map.boarderDown())
          if (flip >= 0 && flip < flipTime)
            image(psymon.pS1(), width / 2, height / 2);
          else if (flip >= flipTime && flip < flipTime * 2)
            image(psymon.pS2(), width / 2, height / 2);
          else if (flip >= flipTime * 2 && flip < flipTime * 3)
            image(psymon.pS1(), width / 2, height / 2);
          else
            image(psymon.pS2(), width / 2, height / 2);
      }
    break;
    case 'd':
      if (move) {
        x = x - walkSpeed;
        if (!map.boarderRight())
          if (flip >= 0 && flip < flipTime)
            image(psymon.pD1(), width / 2, height / 2);
          else if (flip >= flipTime && flip < flipTime * 2)
            image(psymon.pD2(), width / 2, height / 2);
          else if (flip >= flipTime * 2 && flip < flipTime * 3)
            image(psymon.pD3(), width / 2, height / 2);
          else
          image(psymon.pD4(), width / 2, height / 2);
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
  image(map.m(), x, y);
  switch (key) {
    default: image(psymon.pS(), width / 2, height / 2);
    break;
    case 'w':
      image(psymon.pW(), width / 2, height / 2);
      if (zone == 2)
        zone = 1;
      if (zone == 3)
        zone = 2;
    break;
    case 'a':
      image(psymon.pA(), width / 2, height / 2);
    break;
    case 's':
      image(psymon.pS(), width / 2, height / 2);
      if (zone == 1)
        zone = 2;
      if (zone == 2)
        zone = 3;
    break;
    case 'd':
      image(psymon.pD(), width / 2, height / 2);
    break;
    case ENTER:
      if (zone == 1)
      zone = 0;
      move=true;
    break;
  }
}
