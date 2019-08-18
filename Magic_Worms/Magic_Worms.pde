float x=100;
float y=100;
void draw(){

}
void setup(){
  size(500, 500);;
    background(0, 0, 0);
      for(int i=0;i<300;i++){
    fill(255,0,0);
    stroke(255,0,0);
    ellipse(x,y,10,10);
    x++;
    y++;
  }
}
