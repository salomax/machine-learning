package org.salomax.ml;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by marcos.salomao on 25/12/16.
 */
public class LinearRegression {

    private List<Double> thetas = new ArrayList<>();

    public void setTheta(int index, Double theta) {
        MathAssert.suchThat(index, value -> value >= 0);
        this.thetas.add(index, theta);
    }

    public Double predication(Hypothesis hypothesis, List<Double> axeX) {
        return hypothesis.h(this.thetas, axeX);
    }
}
