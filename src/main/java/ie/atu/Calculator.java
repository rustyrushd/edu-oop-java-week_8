package ie.atu;

public class Calculator {
    public int add(int firstNum, int secondNum) {
        return Math.addExact(firstNum, secondNum);
    }

    public int sub(int firstNum, int secondNum) {
        return Math.subtractExact(firstNum, secondNum);
    }
}
