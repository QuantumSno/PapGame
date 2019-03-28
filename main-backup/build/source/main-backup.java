import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class main-backup extends PApplet {
  public void setup() {
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
    noLoop();
  }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "main-backup" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
