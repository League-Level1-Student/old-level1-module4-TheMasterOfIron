float x = 100;
float y = 100;
int worms = 0;
void draw(){
if(mousePressed){
worms++;
}
  background(0, 0, 0);
  makeMagical();
for(int i=0;i<worms;i++){
    fill(frameCount,i,0);
    stroke(frameCount,i,0);
    ellipse(x,y,10,10);
    x = getWormX(i);
    y = getWormY(i);
  }
}
void setup(){
  size(500, 500);;
    background(0, 0, 0);
}
float frequency = .008;
    float noiseInterval = PI;

    void makeMagical() {
        fill( 0, 0, 0, 10 );
        rect(0, 0, width, height);
        noStroke();
    }

    float getWormX(int i) {
        return map(noise(i*noiseInterval + frameCount * frequency), 0, 1, 0, width);
    }

    float getWormY(int i) {
        return map(noise(i*noiseInterval+1 + frameCount * frequency), 0, 1, 0, height);
    }
