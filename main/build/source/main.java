import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class main extends PApplet {


render r = new render();
int defaultBackground = 30;
int playerX,playerY;
boolean canMove;
int playerRender;
  /*
  1 left
  2 down
  3 right
  4 up
  */

public void setup() {
  background(defaultBackground); //sets default background of entire project
   //sets window size
  playerX=width/2;
  playerY=height/2;
  playerRender=2;
  canMove=true;
}
public void draw() {
  r.map(playerX,playerY); //moves player around the map
  checkTriggers(); //checks if player does anything from enter a building to come across a friend
  keyboardInput(); //switch case for all keyboard inputs
}

public void keyboardInput() { //movement controles for player
  switch(key) {
    //movement controles
    case 'w':
      playerY++;
      r.playerUp();
        break;
    case 'a':
      playerX--;
      r.playerLeft();
        break;
    case 's':
      playerY--;
      r.playerLeft();
        break;
    case 'd':
      playerX++;
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

public void checkTriggers() {
  //check for pokestops
  //check for pokemon jump in grass

}
class render {
  int defaultBackground = 30;

  public void playerUp() {
    fill(255,0,0);
    rect(width/2,height/2,20,20);
  }
  public void playerDown() {
    fill(255,0,0);
    rect(width/2,height/2,20,20);
  }
  public void playerLeft() {
    fill(255,0,0);
    rect(width/2,height/2,20,20);
  }
  public void playerRight() {
    fill(255,0,0);
    rect(width/2,height/2,20,20);
  }
  public void map(int x,int y) {
    fill(0);
    ellipse(x,y,400,400);
  }
}
  public void settings() {  size(800,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
