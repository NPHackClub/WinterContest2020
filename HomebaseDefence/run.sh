# code from vmso
# to make this shell script executable on macOS, do the following
# sudo chmod ugo+rx run.sh

# packaged version of Main.java
javac -d . HomebaseDefence.java StartScreen.java GameScreen.java EndScreen.java 
java -cp . com.homebasedefence.HomebaseDefence

# then type:
# ./run.sh


# notice: that a semi-colon separates the classpaths in Windows
#         a colon separates the classpaths in macOS
#         backslash separates folders in Windows
#         forwardslash separates folders in macOS and Linux
#         period separates packages (folders) in Java (all platforms)