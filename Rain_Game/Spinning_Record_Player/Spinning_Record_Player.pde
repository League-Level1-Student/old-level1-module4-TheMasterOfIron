PImage pictureOfRecord;                        //as member variable
void setup(){
        size(600,600);                                 //in setup method
        pictureOfRecord= loadImage("record.png");      //in setup method
}
void draw(){
        image(pictureOfRecord, 0, 0);  //in draw method
}
