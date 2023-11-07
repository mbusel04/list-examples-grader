CPATH=".;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar"
JUNIT_CORE='org.junit.runner.JUnitCore'
TEST_CLASS='TestListExamples'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission;
echo 'Finished cloning'

cp $TEST_CLASS.java grading-area/
cp student-submission/ListExamples.java grading-area/

cd grading-area/

javac -cp $CPATH $TEST_CLASS.java ListExamples.java;
# java -cp $CPATH $JUNIT_CORE $TEST_CLASS
TEST_RESULT=`java -cp $CPATH $JUNIT_CORE $TEST_CLASS | tail -10`;

echo $TEST_RESULT
