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

public class main extends PApplet {

PGraphics Map, //set up map images
PsymonW, PsymonA, PsymonS, PsymonD, //Psymon default stances
PsymonWw1, PsymonAw1, PsymonSw1, PsymonDw1, //Psymon anamation images
PsymonWw2, PsymonAw2, PsymonSw2, PsymonDw2,
WhyattW, WhyattA, WhyattS, WhyattD, //Whyatt default stances
WhyattWw1, WhyattAw1, WhyattSw1, WhyattDw1, //Whyatt anamation
WhyattWw2, WhyattAw2, WhyattSw2, WhyattDw2;
int playerSize, scale, walkSpeed, //size and scale for player
mapSizeX, mapSizeY, //size of window
x, y, flip, flipFrames; //x and y for player as well as other movement related ints
 /*
 1 = [w] up
 2 = [a] left
 3 = [s] down
 4 = [d] left
 */

public void setup() {
  walkSpeed=5; //how fast Psymon walks
  flip=0; //count till flipFrames
  flipFrames=5; //amout of frames till anamations move to next frame
  mapSizeX=840; //window size x
  mapSizeY=640; //window size y
  x=x-mapSizeX/2; //starting x position
  y=y-mapSizeX/2; //starting y position
  scale=4; //scale images up and down
  playerSize=32; //default player size (of origonal pixelart)
   //window size
  //fullScreen();
  //create sprite sizes
    PsymonW = createGraphics(playerSize*scale,playerSize*scale);
    PsymonA = createGraphics(playerSize*scale,playerSize*scale);
    PsymonS = createGraphics(playerSize*scale,playerSize*scale);
    PsymonD = createGraphics(playerSize*scale,playerSize*scale);
    PsymonWw1 = createGraphics(playerSize*scale,playerSize*scale);
    PsymonWw2 = createGraphics(playerSize*scale,playerSize*scale);
    PsymonAw1 = createGraphics(playerSize*scale,playerSize*scale);
    PsymonAw2 = createGraphics(playerSize*scale,playerSize*scale);
    PsymonSw1 = createGraphics(playerSize*scale,playerSize*scale);
    PsymonSw2 = createGraphics(playerSize*scale,playerSize*scale);
    PsymonDw1 = createGraphics(playerSize*scale,playerSize*scale);
    PsymonDw2 = createGraphics(playerSize*scale,playerSize*scale);
    WhyattW = createGraphics(playerSize*scale,playerSize*scale);
    WhyattA = createGraphics(playerSize*scale,playerSize*scale);
    WhyattS = createGraphics(playerSize*scale,playerSize*scale);
    WhyattD = createGraphics(playerSize*scale,playerSize*scale);
    WhyattWw1 = createGraphics(playerSize*scale,playerSize*scale);
    WhyattWw2 = createGraphics(playerSize*scale,playerSize*scale);
    WhyattAw1 = createGraphics(playerSize*scale,playerSize*scale);
    WhyattAw2 = createGraphics(playerSize*scale,playerSize*scale);
    WhyattSw1 = createGraphics(playerSize*scale,playerSize*scale);
    WhyattSw2 = createGraphics(playerSize*scale,playerSize*scale);
    WhyattDw1 = createGraphics(playerSize*scale,playerSize*scale);
    WhyattDw2 = createGraphics(playerSize*scale,playerSize*scale);
  Map = createGraphics(mapSizeX*scale,mapSizeY*scale); //create map sprite
  render(); //loads files
}
public void draw() {
  image(Map,x,y); //load map
  switch(key) { //when player is not moving, this is the way Psymon is facing
    default: image(PsymonW,356,256);
    break; case 'w': image(PsymonW,356,256);
    break; case 'a': image(PsymonA,356,256);
    break; case 's': image(PsymonS,356,256);
    break; case 'd': image(PsymonD,356,256);
    break;
  }
  if(keyPressed) { //when player is moving, this is the anamation
    switch(key) {
      default: image(PsymonW,356,256);
      break; case 'w': if(!boarderUp()) {y=y+walkSpeed;} background(30); image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonWw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonWw2,356,256);flip++;} else {image(PsymonW,356,256);flip=0;}
      break; case 'a': if(!boarderLeft()) {x=x+walkSpeed;} background(30); image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonAw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonAw2,356,256);flip++;} else {image(PsymonA,356,256);flip=0;}
      break; case 's': if(!boarderDown()) {y=y-walkSpeed;} background(30); image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonSw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonSw2,356,256);flip++;} else {image(PsymonS,356,256);flip=0;}
      break; case 'd': if(!boarderRight()) {x=x-walkSpeed;} background(30); image(Map,x,y);
        if(flip>=0 && flip<=flipFrames) {image(PsymonDw1,356,256);flip++;} else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonDw2,356,256);flip++;} else {image(PsymonD,356,256);flip=0;}
      break;
    }
  }
  System.out.println("y: " + y + " x: " + x);
}

public boolean boarderUp() { //any boarders that would stop the player from moving up would result in true
  if(y>=280) {
    return true;
  } else { //System.out.println("y: " + y + " x: " + x);
    return false;
  }
}
public boolean boarderLeft() { //etc
  if(x>=384) {
    return true;
  } else { //System.out.println("y: " + y + " x: " + x);
    return false;
  }
}
public boolean boarderDown() { //etc
  if(y<=-1755) {
    return true;
  } else { //System.out.println("y: " + y + " x: " + x);
    return false;
  }
}
public boolean boarderRight() { //etc
  if(x<=-2489) {
    return true;
  } else { //System.out.println("y: " + y + " x: " + x);
    return false;
  }
}

public void render() { //load assets
  PsymonW.beginDraw();
  PsymonW.noStroke();
  PsymonW.image(loadImage("Psymon-behind.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonW.endDraw();
  PsymonA.beginDraw();
  PsymonA.noStroke();
  PsymonA.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonA.endDraw();
  PsymonS.beginDraw();
  PsymonS.noStroke();
  PsymonS.image(loadImage("Psymon-front.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonS.endDraw();
  PsymonD.beginDraw();
  PsymonD.noStroke();
  PsymonD.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonD.endDraw();

  PsymonWw1.beginDraw();
  PsymonWw1.noStroke();
  PsymonWw1.image(loadImage("Psymon-behind-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonWw1.endDraw();
  PsymonWw2.beginDraw();
  PsymonWw2.noStroke();
  PsymonWw2.image(loadImage("Psymon-behind-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonWw2.endDraw();
  PsymonAw1.beginDraw();
  PsymonAw1.noStroke();
  PsymonAw1.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw1.endDraw();
  PsymonAw2.beginDraw();
  PsymonAw2.noStroke();
  PsymonAw2.image(loadImage("Psymon-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw2.endDraw();
  PsymonSw1.beginDraw();
  PsymonSw1.noStroke();
  PsymonSw1.image(loadImage("Psymon-front-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonSw1.endDraw();
  PsymonSw2.beginDraw();
  PsymonSw2.noStroke();
  PsymonSw2.image(loadImage("Psymon-front-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonSw2.endDraw();
  PsymonDw1.beginDraw();
  PsymonDw1.noStroke();
  PsymonDw1.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw1.endDraw();
  PsymonDw2.beginDraw();
  PsymonDw2.noStroke();
  PsymonDw2.image(loadImage("Psymon-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw2.endDraw();

/* Cut off render for Whyatt while sprites are in development
  WhyattW.beginDraw();
  WhyattW.noStroke();
  WhyattW.image(loadImage("Whyatt-behind.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattW.endDraw();
  WhyattA.beginDraw();
  WhyattA.noStroke();
  WhyattA.image(loadImage("Whyatt-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattA.endDraw();
  WhyattS.beginDraw();
  WhyattS.noStroke();
  WhyattS.image(loadImage("Whyatt-front.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattS.endDraw();
  WhyattD.beginDraw();
  WhyattD.noStroke();
  WhyattD.image(loadImage("Whyatt-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattD.endDraw();

  WhyattWw1.beginDraw();
  WhyattWw1.noStroke();
  WhyattWw1.image(loadImage("Whyatt-behind-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattWw1.endDraw();
  WhyattWw2.beginDraw();
  WhyattWw2.noStroke();
  WhyattWw2.image(loadImage("Whyatt-behind-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattWw2.endDraw();
  WhyattAw1.beginDraw();
  WhyattAw1.noStroke();
  WhyattAw1.image(loadImage("Whyatt-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattAw1.endDraw();
  WhyattAw2.beginDraw();
  WhyattAw2.noStroke();
  WhyattAw2.image(loadImage("Whyatt-side-left.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattAw2.endDraw();
  WhyattSw1.beginDraw();
  WhyattSw1.noStroke();
  WhyattSw1.image(loadImage("Whyatt-front-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattSw1.endDraw();
  WhyattSw2.beginDraw();
  WhyattSw2.noStroke();
  WhyattSw2.image(loadImage("Whyatt-front-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattSw2.endDraw();
  WhyattDw1.beginDraw();
  WhyattDw1.noStroke();
  WhyattDw1.image(loadImage("Whyatt-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattDw1.endDraw();
  WhyattDw2.beginDraw();
  WhyattDw2.noStroke();
  WhyattDw2.image(loadImage("Whyatt-side-right.png"),0,0,playerSize*scale,playerSize*scale);
  WhyattDw2.endDraw();
  */

  Map.beginDraw();
  Map.noStroke();
  Map.image(loadImage("template_map.png"),x,y,mapSizeX*scale,mapSizeY*scale);
  Map.endDraw();
}
  public void settings() {  size(840,640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
