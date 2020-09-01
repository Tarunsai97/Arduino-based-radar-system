import processing.serial.*;
import processing.opengl.*;
import toxi.geom.*;
import toxi.processing.*;

ToxiclibsSupport gfx;


Serial port;
String serialAngle;
String serialDistance;
String serialData;
float objectDistance;
int radarAngle, radarDistance;
int index=0;

void setup() 
{
  size (1280, 720);
  gfx = new ToxiclibsSupport(this);
  smooth();
  
  //println(Serial.list());
  
  //String portName = Serial.list()[0];
  String portName = "COM4";
  port = new Serial(this, portName, 9600);
  
  //port = new Serial(this,"COM4", 9600);
  port.bufferUntil('#');
}

void draw() 
{
  //fill(10,255,10);
  noStroke();
  
  fill(0,4); 
  rect(0, 0, 1280, 720);
  fill(10,255,10);
  
  //Radar Arcs and Lines
  pushMatrix();
  
  translate(640,666);
  noFill();
  strokeWeight(2);
  stroke(10,255,10);  
  arc(0,0,1200,1200,PI,TWO_PI);
  arc(0,0,934,934,PI,TWO_PI);
  arc(0,0,666,666,PI,TWO_PI);
  arc(0,0,400,400,PI,TWO_PI);
  strokeWeight(4);
  line(-640,0,640,0);
  line(0,0,-554,-320);
  line(0,0,-320,-554);
  line(0,0,0,-640);
  line(0,0,320,-554);
  line(0,0,554,-320);
  
  popMatrix();
 
  //Ultrasonic Lines
  pushMatrix();
  
  strokeWeight(5);
  stroke(10,255,10);
  translate(640,666);
  line(0,0,640*cos(radians(radarAngle)),-640*sin(radians(radarAngle)));
  
  popMatrix();

  //Object Detection Lines
  pushMatrix();
  
  translate(640,666);
  strokeWeight(5);
  stroke(255,10,10); // red color
  objectDistance = radarDistance*15;

  if(radarDistance<40)
  {
    line(objectDistance*cos(radians(radarAngle)),-objectDistance*sin(radians(radarAngle)),633*cos(radians(radarAngle)),-633*sin(radians(radarAngle)));
  }
  
  popMatrix();
}

void serialEvent (Serial port) 
{
  serialData = port.readStringUntil('#');
  serialData = serialData.substring(0,serialData.length()-1);
  
  index = serialData.indexOf("*");
  
  serialAngle= serialData.substring(0, index);
  serialDistance= serialData.substring(index+1, serialData.length());
  
  radarAngle = int(serialAngle);
  radarDistance = int(serialDistance);
}
