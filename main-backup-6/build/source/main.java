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


ArrayList<sprite> sprites;
int x, y,
playerSize, mapX, mapY, scale;
public void setup() {
  imageMode(CENTER);
  //fullScreen();
  
  setVariables();
  sprites = new ArrayList<sprite>();
  loadSprites();
}
public void draw() {
  image(f("m"), width/2, height/2);
  image(f("pf"), width/2, height/2);

}
public PImage f(String find) {
  for(int t=0; t<sprites.size(); t++)
    if(sprites.get(t).getName() == find)
      return sprites.get(t).out();
  return sprites.get(0).out();
}
public void setVariables() {
  x=0;
  y=0;
  mapX=840;
  mapY=640;
  playerSize=32;
  scale=4;
}

public void loadSprites() {
  //load menus
  sprites.add(new sprite(loadImage("menu-1.png"), width, height, "mu1"));
  sprites.add(new sprite(loadImage("menu-2.png"), width, height, "mu2"));
  sprites.add(new sprite(loadImage("menu-3.png"), width, height, "mu3"));

  //load Psymons
  sprites.add(new sprite(loadImage("Psymon-behind-walking-1.png"), playerSize*scale, playerSize*scale, "pbw1"));
  sprites.add(new sprite(loadImage("Psymon-behind-walking-2.png"), playerSize*scale, playerSize*scale, "pbw2"));
  sprites.add(new sprite(loadImage("Psymon-behind.png"), playerSize*scale, playerSize*scale, "pb"));

  sprites.add(new sprite(loadImage("Psymon-front-walking-1.png"), playerSize*scale, playerSize*scale, "pfw1"));
  sprites.add(new sprite(loadImage("Psymon-front-walking-2.png"), playerSize*scale, playerSize*scale, "pfw2"));
  sprites.add(new sprite(loadImage("Psymon-front.png"), playerSize*scale, playerSize*scale, "pf"));

  sprites.add(new sprite(loadImage("Psymon-side-left-walking-1.png"), playerSize*scale, playerSize*scale, "pslw1"));
  sprites.add(new sprite(loadImage("Psymon-side-left-walking-2.png"), playerSize*scale, playerSize*scale, "pslw2"));
  sprites.add(new sprite(loadImage("Psymon-side-left-walking-3.png"), playerSize*scale, playerSize*scale, "pslw3"));
  sprites.add(new sprite(loadImage("Psymon-side-left-walking-4.png"), playerSize*scale, playerSize*scale, "pslw4"));
  sprites.add(new sprite(loadImage("Psymon-side-left.png"), playerSize*scale, playerSize*scale, "psl"));

  sprites.add(new sprite(loadImage("Psymon-side-right-walking-1.png"), playerSize*scale, playerSize*scale, "psrw1"));
  sprites.add(new sprite(loadImage("Psymon-side-right-walking-2.png"), playerSize*scale, playerSize*scale, "psrw2"));
  sprites.add(new sprite(loadImage("Psymon-side-right-walking-3.png"), playerSize*scale, playerSize*scale, "psrw3"));
  sprites.add(new sprite(loadImage("Psymon-side-right-walking-4.png"), playerSize*scale, playerSize*scale, "psrw4"));
  sprites.add(new sprite(loadImage("Psymon-side-right.png"), playerSize*scale, playerSize*scale, "psr"));

  sprites.add(new sprite(loadImage("template_map.png"), mapX*scale, mapY*scale, "m"));
}
class item {
  String item;
  public item(String i) {
    item=i;
  }
  public String returnName() {
    return item;
  }

}
class sprite {
  PImage sprite;
  PGraphics render;
  String name;
  int x,y, sizeX, sizeY;
  public sprite(PImage s, int o, int p, String n) {
    sprite=s;
    sizeX=o;
    sizeY=p;
    name=n;
    Gload();
  }
  //set name from file name
  public void setCords(int o, int p) {
    x=o;
    y=p;
  }
  public void Gload() {
    render = createGraphics(sizeX,sizeY);
    render.beginDraw();
    render.noStroke();
    render.image(sprite, 0, 0, sizeX, sizeY);
    render.endDraw();
  }
  public String getName() {
    return name;
  }
  public PGraphics out() {
    return render;
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
