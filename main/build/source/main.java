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

public void setup() {
  background(defaultBackground); //sets default background of entire project
   //sets window size
  playerX=width/2;
  playerY=height/2;
}
public void draw() {
  r.map(playerX,playerY); //moves player around the map
  checkTriggers(); //checks if player does anything from enter a building to come across a friend
  keybinds(); //'open map' 'open inventory' etc.
  movement(); //main movement controles for player
}

public void movement() { //movement controles for player
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
public void keybinds() { //access controles like opening inventory or minimap
  if(keyPressed) {
    if(key=='m') {
      //open minimap
    } if(key=='i') {
      //open inventory
    }
  }
}
public void checkTriggers() {
  //check for pokestops
  //check for pokemon jump in grass

}
class render {
  int defaultBackground = 30;

  public void playerUp() {
    rect(width/2,height/2,20,20);
  }
  public void playerDown() {
    rect(width/2,height/2,20,20);
  }
  public void playerLeft() {
    rect(width/2,height/2,20,20);
  }
  public void playerRight() {
    rect(width/2,height/2,20,20);
  }
  public void map(int x,int y) {
    ellipse(x,y,400,400);
  }
  public void minimap() {
    //loop minimap draw functions until user presses 'm' again
  }
    public void drawMinimap() {
      //this will act as the draw function for minimap
    }
  public void inventory() {
  //loops minimap draw function until user presses 'i' again
  }
    public void drawInventory() {
      //this will act as the draw funciton for inventory
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
