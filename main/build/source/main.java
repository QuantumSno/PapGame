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

public void setup() {
  r.map();
  
}
public void draw() {
  r.playerUp();
}
class render {
  int defaultBackground = 30;
  //public render() {  } //is this necesarry?

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
  public void map() {
    background(defaultBackground);
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
