import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class Is3Letters implements StringChecker {
  public boolean checkString(String s) {
    return s.length() == 3;
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd1() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeRightEnd2() {
    List<String> left = Arrays.asList("b");
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("b");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeRightEnd3() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList("d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeRightEnd4() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeRightEnd5() {
    List<String> left = Arrays.asList("b", "d", "f");
    List<String> right = Arrays.asList("c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("b", "c", "d", "f");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter1() {
    List<String> input = Arrays.asList();
    List<String> filtered = ListExamples.filter(input, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilter2() {
    List<String> input = Arrays.asList("a", "b", "b");
    List<String> filtered = ListExamples.filter(input, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilter3() {
    List<String> input = Arrays.asList("a", "moon", "b");
    List<String> filtered = ListExamples.filter(input, new IsMoon());
    List<String> expected = Arrays.asList("moon");
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilter4() {
    List<String> input = Arrays.asList("a", "Moon", "b", "a", "Moon", "b", "boon", "doon", "a", "moon", "b");
    List<String> filtered = ListExamples.filter(input, new IsMoon());
    List<String> expected = Arrays.asList("Moon", "Moon", "moon");
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilter5() {
    List<String> input = Arrays.asList();
    List<String> filtered = ListExamples.filter(input, new Is3Letters());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilter6() {
    List<String> input = Arrays.asList("a", "b", "c");
    List<String> filtered = ListExamples.filter(input, new Is3Letters());
    List<String> expected = Arrays.asList();
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilter7() {
    List<String> input = Arrays.asList("12", "123", "1234", "321");
    List<String> filtered = ListExamples.filter(input, new Is3Letters());
    List<String> expected = Arrays.asList("123", "321");
    assertEquals(expected, filtered);
  }

  @Test(timeout = 500)
  public void testFilter8() {
    List<String> input = Arrays.asList(" ", "  ", "   ","1", "11", "111", "2", "22", "222");
    List<String> filtered = ListExamples.filter(input, new Is3Letters());
    List<String> expected = Arrays.asList("   ", "111", "222");
    assertEquals(expected, filtered);
  }
}
