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
}
public void draw() {
  r.map(playerX,playerY); //moves player around the map
  checkTriggers(); //checks if player does anything from enter a building to come across a friend
  //movement(); //main movement controles for player
  //keybinds(); //'open map' 'open inventory' etc.
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
public void keyPressed() {
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
  public void minimap() { //loop minimap draw functions until user presses 'm' again
    //drawMinimap();
    
  }
    /*
    void drawMinimap() { //this will act as the draw function for minimap
      while (keyPressed==false && key=='m') {
        fill(0,255,0);
        rect(width/2,height/2,width-100,height-100);
      }
    }
    */
  public void inventory() { //loops minimap draw function until user presses 'i' again
    //drawInventory();

  }
    /*
    void drawInventory() { //this will act as the draw funciton for inventory
      if(keyPressed) {
        if(key=='i') {  }
      } else {
        fill(0,0,255);
        rect(width/2,height/2,200,200);
        drawInventory();
      }
    }
    */
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
