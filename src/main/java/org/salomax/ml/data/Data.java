package org.salomax.ml.data;

import org.salomax.ml.util.MathAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class Data {

    private List<Double> features;
    private Double target;

    public Data(Double target, Double... features) {
        this.target = target;
        this.features = new ArrayList<>(Arrays.asList(features));
    }

    public List<Double> getFeatures() {
        return this.features;
    }

    public Double getTarget() {
        return target;
    }

    public Double getFeature(int index) {
        MathAssert.suchThat(index, i -> i >= 0);
        return this.getFeatures().get(index);
    }
}
