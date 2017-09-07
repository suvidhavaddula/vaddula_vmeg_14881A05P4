rm -rf out
mkdir out
javac src/*.java test/*.java && \
mv src/*.class test/*.class ./out && \
CLASSPATH=$CLASSPATH:./out java TestRunner