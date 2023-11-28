CPATH=".;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar"
JUNIT_CORE='org.junit.runner.JUnitCore'
TEST_CLASS='TestListExamples'

# Clear grading areas
rm -rf student-submission
rm -rf grading-area

mkdir grading-area

# Clone the ropository
git clone $1 student-submission &> grading-area/temp.txt
if [[ $? -ne 0 ]]
then
    echo 'Could not find repositiory: ' $1
    exit 1
else
    echo 'Finished cloning'
fi

# Copy student submission and unit tests
STUDENT_FILE=`find student-submission -name "ListExamples.java"`
if [[ $? -ne 0 ]]
then
    echo "No file named ListExamples.java in submission!"
    exit 1
fi

cp $TEST_CLASS.java grading-area/
cp $STUDENT_FILE grading-area/

# Start grading process
cd grading-area/

javac -cp $CPATH $TEST_CLASS.java ListExamples.java &> compile-error.txt

# Check if programm compiles
if [[ $? -ne 0 ]] 
then
    echo "Erorr during compilation, see result file for more details!"

    # Write results of grading
    echo "Compile Error: " > ../grading-result.txt
    cat compile-error.txt >> ../grading-result.txt
    exit 1
fi

java -cp $CPATH $JUNIT_CORE $TEST_CLASS &> test-result.txt

# Check JUnit tests results
if [[ $? -ne 0 ]]
then
    echo "Unit test failure, see result file for more details!"
else
    echo "All tests succeded! No errors found!"
fi

# Write results of grading
echo "Test Results: " > ../grading-result.txt
cat test-result.txt >> ../grading-result.txt
