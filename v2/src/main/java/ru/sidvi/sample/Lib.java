package ru.sidvi.sample;

/**
 * @author Vitaly Sidorov mail@vitaly-sidorov.com
 */
public class Lib implements ILib {

    public String func1() {
        return "func1 from Lib2";
    }

    public String func2() {
        return new OtherClass().getValue();
    }
}
