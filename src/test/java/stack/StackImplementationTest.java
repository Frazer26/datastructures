package stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

public class StackImplementationTest {
    private static final int TOP_ITEM = 1004;
    private static final int UNDER_TOP_ITEM = 1003;

    private Stack stackForTest;
    private int result;

    @Before
    public void Initialize() {
        stackForTest = new StackImplementation();
    }

    @Test(expected = EmptyStackException.class)
    public void whenCallPopMethodForEmptyStackThrowException() {
        stackForTest.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void whenCallPeekMethodForEmptyStackThrowException() {
        stackForTest.peek();
    }

    @Test
    public void whenCallPeekMethodRetrieveFirstItemInStack() {
        fillStack(stackForTest);

        result = (int) stackForTest.peek();
        assertEquals(TOP_ITEM, result);
    }

    @Test
    public void whenCallPopMethodRemovedTopItemFromStack() {
        fillStack(stackForTest);

        result = (int) stackForTest.pop();
        assertEquals(TOP_ITEM, result);
        assertEquals(UNDER_TOP_ITEM, stackForTest.peek());
    }

    @Test
    public void whenCallClearMethodTheStackIsEmpty() {
        fillStack(stackForTest);

        stackForTest.clear();
        assertTrue(isEmpty(stackForTest));
    }

    private void fillStack(Stack testStack) {
        testStack.push(1001);
        testStack.push(1002);
        testStack.push(1003);
        testStack.push(1004);
    }

    private Boolean isEmpty(Stack testStack) {
        int lengthOfTestedStack = testStack.toString().length();
        int lengthOfNewEmptyStack = new StackImplementation().toString().length();
        return lengthOfTestedStack == lengthOfNewEmptyStack;
    }
}
