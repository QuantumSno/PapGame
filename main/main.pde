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
  keybinds(); //'open map' 'open inventory' etc.
  movement(); //main movement controles for player
}

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
void keybinds() { //access controles like opening inventory or minimap
  if(keyPressed) {
    if(key=='m') {
      //open minimap
    } if(key=='i') {
      //open inventory
    }
  }
}
void checkTriggers() {
  //check for pokestops
  //check for pokemon jump in grass

}
