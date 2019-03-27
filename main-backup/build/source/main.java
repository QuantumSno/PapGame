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

/*
Maybe do some shit with PGraphics? May need to re-do a lot

https://processing.org/reference/PGraphics.html
https://processing.org/reference/createGraphics_.html
*/

PImage Psymon,Whyatt,Map;

render r = new render();
int defaultBackground = 30;
int playerX,playerY,playerSpeed;
boolean canMove;
char render;

public void setup() {
  background(defaultBackground); //sets default background of entire project
  
  //size(840,640); //sets window size
  playerX=width/2;
  playerY=height/2;
  playerSpeed=5;
  Psymon = loadImage("Psymon-1.png.png");
  Whyatt = loadImage("Whyatt-1.png.png");
  Map = loadImage("check_map_20_15_32_32.png");
  r.loadFriends(Psymon,Whyatt,Map);
}

public void draw() {
  frameRate(60); //locks framrate since movement was influenced by render speed
  if(canMove==false && render=='i') { //tests for opening up the inventory
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

public void checkTriggers() {
  //check for pokestops
  //check for pokemon jump in grass
}
class render {
  PImage Psymon,Whyatt,Map;
  int defaultBackground = 30;
  int ss,scale;
  public void loadFriends(PImage p, PImage w,PImage m) {
    Psymon=p;
    Whyatt=w;
    Map=m;
    scale=4;
    ss=32;
  }
  public void playerUp() {
    image(Psymon,width/2-16,height/2-16,ss*scale,ss*scale);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  public void playerDown() {
    image(Psymon,width/2-16,height/2-16,ss*scale,ss*scale);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  public void playerLeft() {
    image(Psymon,width/2-16,height/2-16,ss*scale,ss*scale);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  public void playerRight() {
    image(Psymon,width/2-16,height/2-16,ss*scale,ss*scale);
    //fill(255,0,0);  rect(width/2,height/2,20,20);
  }
  public void map(int x,int y) {
    image(Map,x,y,640*scale,480*scale);
    //fill(0); ellipse(x,y,400,400);
  }
    public void inventory() {
    fill(0,255,0);
    rect(100,100,width-200,height-200);
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
