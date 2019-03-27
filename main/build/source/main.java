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

/*
Foil By Patty, William, and Ben
Images by Patty and William
Code by Ben
*/
PImage Psymon,Whyatt;

render r = new render();
int defaultBackground = 30;
int playerX,playerY,playerSpeed;
boolean canMove;
char render;

public void setup() {
  background(defaultBackground); //sets default background of entire project
   //sets window size
  playerX=width/2;
  playerY=height/2;
  playerSpeed=5;
  Psymon = loadImage("Psymon-1.png.png");
  Whyatt = loadImage("Whyatt-1.png.png");
  r.loadFriends(Psymon,Whyatt);
}

public void draw() {
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

public void defaultDraw() { //essentially 'draw'
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
  r.map(playerX,playerY); //moves player around the map
  checkTriggers(); //checks if player does anything from enter a building to come across a friend

}

public void checkTriggers() {
  //check for pokestops
  //check for pokemon jump in grass

}
class inventory {
  public void draw() {
    fill(0,255,0);
    rect(width/2,height/2,width-100,height-2);
  }
}
class minimap {
  public void draw() {
    fill(0,0,255);
    rect(width/2,height/2,width-100,height-2);
  }
}
class render {
  PImage Psymon,Whyatt;
  int defaultBackground = 30;
  public void loadFriends(PImage p, PImage w) {
    Psymon=p;
    Whyatt=w;
  }
  public void playerUp() {
    image(Psymon,width/2-16,height/2-16,32,32);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  public void playerDown() {
    image(Psymon,width/2-16,height/2-16,32,32);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  public void playerLeft() {
    image(Psymon,width/2-16,height/2-16,32,32);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  public void playerRight() {
    image(Psymon,width/2-16,height/2-16,32,32);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  public void map(int x,int y) {
    fill(0);
    ellipse(x,y,400,400);
  }
  public void minimap() {
    fill(0,0,255);
    rect(100,100,width-200,height-200);
  }
  public void inventory() {
    fill(0,255,0);
    rect(100,100,width-200,height-200);
  }
}
  public void settings() {  size(840,640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
