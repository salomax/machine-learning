package org.salomax.ml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class SimpleDataSet implements DataSet {

    private List<Double> features = new ArrayList<>();

    public void add(Double... features) {
        this.features.addAll(Arrays.asList(features));
    }

}
