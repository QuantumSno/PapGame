import java.util.*;
render r = new render();
color defaultBackground = 30;

void setup() {
  r.map();
  size(800,600);
}
void draw() {
  r.playerUp();
}
