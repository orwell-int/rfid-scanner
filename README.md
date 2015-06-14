[![Build Status](https://travis-ci.org/orwell-int/rfid-scanner.svg?branch=master)](https://travis-ci.org/orwell-int/rfid-scanner) [![Stories in Ready](https://badge.waffle.io/orwell-int/robots.png?label=ready&title=Ready)](https://waffle.io/orwell-int/robots) [![Coverage Status](https://img.shields.io/coveralls/orwell-int/rfid-scanner.svg)](https://coveralls.io/r/orwell-int/rfid-scanner)
rfid scanner
===============

This is a stand alone code running on a NXT robot. It register all RFID values read by a RFID sensor and put them in a file.
Use of a leJOS binary like nxjbrowser on a PC make it possible to download the file to then process the data.

Checkout the code
-----------------
Get the sources
```
git clone git@github.com:orwell-int/rfid-scanner.git
```

Get the submodules
```
git submodule update --init --recursive
```

local setup for coveralls
-------------------------
Run with maven
--------------
Prerequisite: have jdk-7+ installed on your machine
```
javac -version
>javac 1.7.xxx

java -version                                                         
>java version "1.7.xxx"
```

Install maven:
```
sudo apt-get install maven
```

Download leJOS tar.gz
```
wget -nc --no-check-certificate http://sourceforge.net/projects/lejos/files/lejos-NXJ/0.9.1beta/leJOS_NXJ_0.9.1beta-3.tar.gz/download -O ./leJOS_NXJ_0.9.1beta-3.tar.gz
tar -xvf leJOS_NXJ_0.9.1beta-3.tar.gz
export NXJ_HOME=leJOS_NXJ_0.9.1beta-3
```

Run maven install, providing the name of your NXT device on which you want to run the program
```
mvn validate
mvn clean install -Drobotname=YourRobotNameHere
```


