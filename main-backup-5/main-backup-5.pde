PGraphics Map, //set up map images
PsymonW, PsymonA, PsymonS, PsymonD, //Psymon default stances
PsymonWw1, PsymonAw1, PsymonSw1, PsymonDw1, //Psymon anamation images
PsymonWw2, PsymonAw2, PsymonSw2, PsymonDw2,
PsymonAw3, PsymonAw4, PsymonDw3, PsymonDw4,
WhyattW, WhyattA, WhyattS, WhyattD, //Whyatt default stances
WhyattWw1, WhyattAw1, WhyattSw1, WhyattDw1, //Whyatt anamation
WhyattWw2, WhyattAw2, WhyattSw2, WhyattDw2,
Menu1, Menu2, Menu3; //menu settings
int playerSize, scale, walkSpeed, //size and scale for player
mapSizeX, mapSizeY, //size of window
x, y, flip, flipFrames, //x and y for player as well as other movement related ints
 /*
 1 = [w] up
 2 = [a] left
 3 = [s] down
 4 = [d] left
 */
zone;
  /*
   ZONE KEY:
   0 = default map
   1 = menu 1
   2 = menu 2
   3 = menu 3
  */
//text variables
String text;
ArrayList<item> inventory;
void setup() {
  inventory = new ArrayList<item>();
  background(30);
  imageMode(CENTER);
  setText(); //gives all text variables their text
  zone=0; //sets to default map since waking up anamation is not set up yet
  walkSpeed=5; //how fast Psymon walks
  flip=0; //count till flipFrames
  flipFrames=5; //amout of frames till anamations move to next frame
  mapSizeX=840; //window size x
  mapSizeY=640; //window size y
  x=mapSizeX/2; //starting x position
  y=mapSizeY/2; //starting y position
  scale=4; //scale images up and down
  playerSize=32; //default player size (of origonal pixelart)
  //fullScreen();
  size(840,640); //window size
  render(); //loads files
}
void draw() {
  if(zone==0) {
    image(Map,x,y);
    switch(key) { //when player is not moving, this is the way Psymon is facing
      default: image(PsymonS,width/2,height/2);
      break; case 'w': image(PsymonW,width/2,height/2);
      break; case 'a': image(PsymonA,width/2,height/2);
      break; case 's': image(PsymonS,width/2,height/2);
      break; case 'd': image(PsymonD,width/2,height/2);
      break;
    }
    if(keyPressed) { //when player is moving, this is the anamation
      switch(key) {
        default: image(PsymonW,width/2,height/2);
        break; case 'w': if(!boarderUp()) {y=y+walkSpeed;} image(Map,x,y);
          if(flip>=0 && flip<=flipFrames) {image(PsymonWw1,width/2,height/2);flip++;}
          else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonWw2,width/2,height/2);flip++;}
          else {image(PsymonW,width/2,height/2);flip=0;}
        break; case 'a': if(!boarderLeft()) {x=x+walkSpeed;} image(Map,x,y);
          if(flip>=0 && flip<=flipFrames) {image(PsymonAw1,width/2,height/2);flip++;}
          else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonAw2,width/2,height/2);flip++;}
          else if (flip>flipFrames*2 && flip<=flipFrames*3){image(PsymonAw3,width/2,height/2);flip++;}
          else if (flip>flipFrames*3 && flip<=flipFrames*4){image(PsymonAw4,width/2,height/2);flip++;}
          else {image(PsymonA,width/2,height/2);flip=0;}
        break; case 's': if(!boarderDown()) {y=y-walkSpeed;} image(Map,x,y);
          if(flip>=0 && flip<=flipFrames) {image(PsymonSw1,width/2,height/2);flip++;}
          else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonSw2,width/2,height/2);flip++;}
          else {image(PsymonS,width/2,height/2);flip=0;}
        break; case 'd': if(!boarderRight()) {x=x-walkSpeed;} image(Map,x,y);
          if(flip>=0 && flip<=flipFrames) {image(PsymonDw1,width/2,height/2);flip++;}
          else if (flip>flipFrames && flip<=flipFrames*2){image(PsymonDw2,width/2,height/2);flip++;}
          else if (flip>flipFrames*2 && flip<=flipFrames*3){image(PsymonDw3,width/2,height/2);flip++;}
          else if (flip>flipFrames*3 && flip<=flipFrames*4){image(PsymonDw4,width/2,height/2);flip++;}
          else {image(PsymonD,width/2,height/2);flip=0;}
        break; case 'e': interact();
        break; case TAB: zone=1;
        break;
      }
    }
  } else if(zone==1) {
    image(Map,x,y);
    image(PsymonS,width/2,height/2);
    image(Menu1,width/2,height/2);
    if(keyPressed) {
      switch (key) {
        default:
        break; case 'w': zone=1; delay(50);
        break; case 's': zone=2; delay(50);
        break; case ENTER:
        break;
      }
    }
  } else if(zone==2) {
    image(Map,x,y);
    image(PsymonS,width/2,height/2);
    image(Menu2,width/2,height/2);
    if(keyPressed) {
      switch (key) {
        default:
        break; case 'w': zone=1; delay(50);
        break; case 's': zone=3; delay(50);
        break; case ENTER:
        break;
      }
    }
  } else if(zone==3) {
    image(Map,x,y);
    image(PsymonS,width/2,height/2);
    image(Menu3,width/2,height/2);
    if(keyPressed) {
      switch (key) {
        default:
        break; case 'w': zone=2; delay(50);
        break; case 's': zone=3; delay(50);
        break; case ENTER:
        break;
      }
    }
  }
}

void interact() { //when interact button pressed, what happens?
  if(x>=0 && x<=0 && y>=0 && x<=0)
    zone=2;
   else if(x>=0 && x<=0 && y>=0 && x<=0)
    zone=3;
   else
    zone=1;
}

boolean boarderUp() { //any boarders that would stop the player from moving up would result in true
  if(y>=1240)
    return true;
   else //System.out.println("y: " + y + " x: " + x);
    return false;
}
boolean boarderLeft() { //etc
  if(x>=1660-16)
    return true;
   else //System.out.println("y: " + y + " x: " + x);
    return false;
}
boolean boarderDown() { //etc
  if(y<=-895)
    return true;
   else //System.out.println("y: " + y + " x: " + x);
    return false;
}
boolean boarderRight() { //etc
  if(x<=-1245+16)
    return true;
   else //System.out.println("y: " + y + " x: " + x);
    return false;
}
void wakeUp() { //waking up anamation

}
void render() {
  //create sprite sizes
  PsymonW = createGraphics(playerSize*scale,playerSize*scale);
  PsymonA = createGraphics(playerSize*scale,playerSize*scale);
  PsymonS = createGraphics(playerSize*scale,playerSize*scale);
  PsymonD = createGraphics(playerSize*scale,playerSize*scale);
  PsymonWw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonWw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw3 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonAw4 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonSw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonSw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw1 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw2 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw3 = createGraphics(playerSize*scale,playerSize*scale);
  PsymonDw4 = createGraphics(playerSize*scale,playerSize*scale);
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
  Menu1 = createGraphics(width,height);
  Menu2 = createGraphics(width,height);
  Menu3 = createGraphics(width,height);

  //Psymon
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
  PsymonAw1.image(loadImage("Psymon-side-left-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw1.endDraw();
  PsymonAw2.beginDraw();
  PsymonAw2.noStroke();
  PsymonAw2.image(loadImage("Psymon-side-left-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw2.endDraw();
  PsymonAw3.beginDraw();
  PsymonAw3.noStroke();
  PsymonAw3.image(loadImage("Psymon-side-left-walking-3.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw3.endDraw();
  PsymonAw4.beginDraw();
  PsymonAw4.noStroke();
  PsymonAw4.image(loadImage("Psymon-side-left-walking-4.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonAw4.endDraw();
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
  PsymonDw1.image(loadImage("Psymon-side-right-walking-1.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw1.endDraw();
  PsymonDw2.beginDraw();
  PsymonDw2.noStroke();
  PsymonDw2.image(loadImage("Psymon-side-right-walking-2.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw2.endDraw();
  PsymonDw3.beginDraw();
  PsymonDw3.noStroke();
  PsymonDw3.image(loadImage("Psymon-side-right-walking-3.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw3.endDraw();
  PsymonDw4.beginDraw();
  PsymonDw4.noStroke();
  PsymonDw4.image(loadImage("Psymon-side-right-walking-4.png"),0,0,playerSize*scale,playerSize*scale);
  PsymonDw4.endDraw();

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

  Menu1.beginDraw();
  Menu1.noStroke();
  Menu1.image(loadImage("menu-1.png"),0,0,width,height);
  Menu1.endDraw();
  Menu2.beginDraw();
  Menu2.noStroke();
  Menu2.image(loadImage("menu-2.png"),0,0,width,height);
  Menu2.endDraw();
  Menu3.beginDraw();
  Menu3.noStroke();
  Menu3.image(loadImage("menu-3.png"),0,0,width,height);
  Menu3.endDraw();
}
void setText() { //sets all text variables
  text="text";
}
