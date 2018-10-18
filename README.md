# Basic_Assignment

Developer Pelewe Modika

Software you need to install on your machine before running this project are:
* SDK ( JDK version 10.0.2 ) 
* SCM ( git version 2.19.0 )
* Build tool (maven version 3.5.4 )

To download the above softwares :

	JDK :
To download JDK use this link https://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html
Instructions on setting up the environment use this link https://www.java.com/en/download/help/path.xml
To check if jdk is installed and its version on command prompt use -> javac --version

	GIT :
To download git go to https://git-scm.com/downloads
To check if git is installed and its version on command prompt use -> git version

	MAVEN :
Go to this site https://maven.apache.org/download.cgi to download maven and install it.
To check if maven is installed and its version on command prompt use -> mvn --version


After installing the softwares and cloning the repository:

using command prompt :
	Go to the directoty of the cloned project using cd keyword.
	To build the project type -> mvn clean package
	To run the project type -> java -jar Application.jar filename_samplenumber.txt startid
	eg. java -jar Application.jar sample_1.txt 500
	
