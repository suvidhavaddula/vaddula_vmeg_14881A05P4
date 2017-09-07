import org.json.simple.JSONObject;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class TestResult {
    public String output;
    public float score;

    public TestResult() {
        this.output = "";
        this.score = 0;
    }

    public void appendOutput(String chunk) {
        this.output += chunk;
    }

    public void calculateScore(int testsCount, int failuresCount) {
        this.score = ((float) testsCount - failuresCount) / testsCount * 100;
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();

        obj.put("output", this.output);
        obj.put("score", this.score);

        return obj;
    }
}

public class TestRunner {
    public static void main(String... args) throws ClassNotFoundException {
        Result result = JUnitCore.runClasses(TestSuite.class);
        TestResult tr = new TestResult();

        int failuresCount = 0;

        for (Failure failure : result.getFailures()) {
            tr.appendOutput("[FAIL] " + failure.getTrace() + "\n");
            failuresCount++;
        }

        int testsCount = result.getRunCount();
        tr.calculateScore(testsCount, failuresCount);

        System.out.println(tr.toJSONObject());
    }
}
