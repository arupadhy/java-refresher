package lambdas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LazyErrorMessageTest {

    private String getErrorMsg() {
        System.out.println("some code to generate the actual error message");
        return "x should be true";
    }
    @Test
    void assertArgIsTrue() {
        boolean x = true;
        Assertions.assertTrue(x, getErrorMsg()); // 2nd arg is string itself and will be evaluated eagerly
    }

    @Test
    void assertArgIsTrueLazy() {
        boolean x = true;
        Assertions.assertTrue(x, () -> getErrorMsg()); // supplier used that will only be used when test fails to figure errorMsg
    }
}
