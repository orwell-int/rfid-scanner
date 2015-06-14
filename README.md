[![Build Status](https://travis-ci.org/orwell-int/robots.svg?branch=master)](https://travis-ci.org/orwell-int/robots) [![Stories in Ready](https://badge.waffle.io/orwell-int/robots.png?label=ready&title=Ready)](https://waffle.io/orwell-int/robots) [![Coverage Status](https://img.shields.io/coveralls/orwell-int/robots.svg)](https://coveralls.io/r/orwell-int/robots)
robots
===============

This is the code running one the NXT robots themselves.

Checkout the code
-----------------
Get the sources
```
git clone git@github.com:orwell-int/robots.git
```

Get the submodules
```
git submodule update --init --recursive
```

local setup for coveralls
-------------------------
Run with maven
--------------
Prerequiste: have jdk-7+ installed on your machine
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

Run maven install, specifing the name of your NXT device on which you want to run the program
```
mvn validate
mvn clean install -Drobotname=YourRobotNameHere
```


