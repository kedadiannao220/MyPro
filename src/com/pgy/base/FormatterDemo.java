package com.pgy.base;

import java.util.Formatter;

public class FormatterDemo {

    public static void main(String[] args) {
        Formatter format = new Formatter(System.out);
        FormatterTest(format);
        FormatStyle(format);
    }

    public static void FormatterTest(Formatter format) {
        String str = "Hello World";

        format.format("string: %s\n", str);
        format.format("boolean: %b\n", str);
        format.format("int : %d\n", Integer.parseInt("341"));
        format.format("char: %c\n", str.charAt(0));
        format.format("float: %f\n", Float.parseFloat("341"));
    }

    /**
     * %[argument_index$][flags][width][.precision]conversion
     * @param format
     */
    private static void FormatStyle(Formatter format) {
        format.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
    }
}
