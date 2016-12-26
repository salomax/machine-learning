package org.salomax.ml.data;

import org.salomax.ml.util.MathAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class SimpleDataSet implements DataSet {

    private List<Data> data = new ArrayList<>();

    public void add(Data data) {
        MathAssert.suchThat(data.getFeatures().size(), size -> size > 0);
        this.data.add(data);
    }

    @Override
    public void add(Double target, Double... features) {
        this.add(new Data(target, features));
    }

    @Override
    public List<Data> getData() {
        return this.data;
    }

    @Override
    public Data get(int i) {
        MathAssert.suchThat(i, value -> value >= 0);
        return this.data.get(i);
    }

    @Override
    public Integer size() {
        return this.data.size();
    }

}
