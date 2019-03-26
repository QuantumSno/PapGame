import java.util.*;
render r = new render();
color defaultBackground = 30;
int playerX,playerY;
boolean canMove;
int playerRender;
  /*
  1 left
  2 down
  3 right
  4 up
  */

void setup() {
  background(defaultBackground); //sets default background of entire project
  size(800,600); //sets window size
  playerX=width/2;
  playerY=height/2;
  playerRender=2;
}
void draw() {
  r.map(playerX,playerY); //moves player around the map
  checkTriggers(); //checks if player does anything from enter a building to come across a friend
  //movement(); //main movement controles for player
  //keybinds(); //'open map' 'open inventory' etc.
  if(canMove) {
    switch(playerRender) {
      case 1:
        r.playerLeft();
        break;
      case 2:
        r.playerDown();
        break;
      case 3:
        r.playerRight();
        break;
      case 4:
        r.playerUp();
        break;
    }
  }
}
/*
void movement() { //movement controles for player
  if(keyPressed) {
    if(key=='w') {
      playerY--;
      r.playerUp();
    } else if(key=='a') {
      playerX++;
      r.playerLeft();
    } else if(key=='s') {
      playerY++;
      r.playerDown();
    } else if(key=='d') {
      playerX--;
      r.playerLeft();
    }
  }
}
*/
void keyPressed() {
  if(key=='w') {
    playerY=playerY-5;
    playerRender=4;
  } else if(key=='a') {
    playerX=playerX-5;
    playerRender=1;
  } else if(key=='s') {
    playerY=playerY+5;
    playerRender=2;
  } else if(key=='d') {
    playerX=playerX+5;
    playerRender=3;
  }

  else if(key=='m') {
    r.drawMinimap();
    canMove=false;
  } else if(key=='i') {
    r.drawInventory();
    canMove=false;
  }
}
void keyReleased() {
  if(key==)
}
/*
void keybinds() { //access controles like opening inventory or minimap
  if(keyPressed) {
    if(key=='m') {
      r.minimap();
    } if(key=='i') {
      r.drawInventory();
    }
  }
}
*/
void checkTriggers() {
  //check for pokestops
  //check for pokemon jump in grass

}
