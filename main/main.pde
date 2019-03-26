/*
Foil By Patty, William, and Ben
Images by Patty and William
Code by Ben
*/

import java.util.*;
render r = new render();
minimap m = new minimap();
inventory i = new inventory();
color defaultBackground = 30;
int playerX,playerY,playerSpeed;
boolean canMove;
char render;

void setup() {
  background(defaultBackground); //sets default background of entire project
  size(800,600); //sets window size
  playerX=width/2;
  playerY=height/2;
  playerSpeed=5;
}

void draw() {
  frameRate(60); //locks framrate since movement was influenced by render speed
  if(canMove==false && render=='m') { //tests for opening the minimap
    r.minimap();
    delay(50);
    if(keyPressed) {
      if(key=='m') {
        render='q';
      }
    }
  } else if(canMove==false && render=='i') { //tests for opening up the inventory
    r.inventory();
    delay(50);
    if(keyPressed) {
      if(key=='i') {
        render='q';
      }
    }
  } else { //would be in this draw function, but these tests need priority
    defaultDraw();
  }
  delay(50);
}

void defaultDraw() { //essentially 'draw'
  r.map(playerX,playerY); //moves player around the map
  checkTriggers(); //checks if player does anything from enter a building to come across a friend
  if(keyPressed) { //tests for all keybinds
    switch(key) {
      //movement controles
      case 'w':
        playerY=playerY+playerSpeed;
        r.playerUp();
          break;
      case 'a':
        playerX=playerX+playerSpeed;
        r.playerLeft();
          break;
      case 's':
        playerY=playerY-playerSpeed;
        r.playerLeft();
          break;
      case 'd':
        playerX=playerX-playerSpeed;
        r.playerRight();
          break;
        //extra keys
      case 'm':
        render='m';
          break;
      case 'i':
        render='i';
          break;
    }
  }
}

void checkTriggers() {
  //check for pokestops
  //check for pokemon jump in grass

}
