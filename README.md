# Arduino-based-radar-system
In this project, I will show you how to design a simple Radar Application using Arduino and Processing. This Arduino Radar Project is implemented with the help of Processing Application.  

Radar is a long-range object detection system that uses radio waves to establish certain parameters of an object like its range, speed and position. Radar technology is used in aircrafts, missiles, marine, weather predictions and automobiles.

Even though the title says Arduino Radar Project, technically the project is based on Sonar technology as I will be using an Ultrasonic Sensor to determine the presence of any object in a particular range.

#Project Overview

The Arduino Radar Project is more of a visual project than it is a circuit implementation. Of course, I will be using different hardware like Arduino UNO, HC-SR04 Ultrasonic Sensor and a Servo Motor but the main aspect is the visual representation in the Processing Application.

If you remember, I have already used the Processing Application in one of the earlier Arduino Projects involving MPU-6050 Sensor. I suggest you to take a look at that project before proceeding (you don’t have to actually implement the project but understand the way it is implemented).

In the MPU-6050 Project, I have used Arduino to read the data from the MPU-6050 Sensor and send it to Processing Application through the COM Port (Serial Communication).

Based on the information received, a sketch in Processing will change the orientation of the model aircraft.

Taking the same concept here, I will collect the information from the Ultrasonic Sensor with the help of Arduino and pass it to Processing where a simple Graphics application is implemented to mimic a Radar Screen.
