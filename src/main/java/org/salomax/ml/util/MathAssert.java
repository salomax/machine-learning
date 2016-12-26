package org.salomax.ml.util;

import java.util.function.Predicate;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class MathAssert {

    public static <T> void suchThat(T value, Predicate<T> predicate) {
        if (!predicate.test(value)) {
            throw new IllegalArgumentException(String.format("value %d is illegal", value));
        }
    }

}
