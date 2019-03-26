import java.util.*;
render r = new render();
color defaultBackground = 30;
int playerX,playerY;

void setup() {
  background(defaultBackground); //sets default background of entire project
  size(800,600); //sets window size
  playerX=width/2;
  playerY=height/2;
}
void draw() {
  r.map(playerX,playerY); //moves player around the map
  checkTriggers(); //checks if player does anything from enter a building to come across a friend
  keyboardInput(); //switch case for all keyboard inputs
}

void keyboardInput() { //movement controles for player
  if(keyPressed) {
    switch(key) {
      //movement controles
      case 'w':
        playerY++;
        r.playerUp();
          break;
      case 'a':
        playerX++;
        r.playerLeft();
          break;
      case 's':
        playerY--;
        r.playerLeft();
          break;
      case 'd':
        playerX--;
        r.playerRight();
          break;

      //extra keys
      case 'm':
        //draw minimap
          break;
      case 'i':
        //draw inventory
          break;
    }
  }
}

void checkTriggers() {
  //check for pokestops
  //check for pokemon jump in grass

}
