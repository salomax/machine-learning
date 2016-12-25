package org.salomax.ml;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class CostFunction {

    private DataSet dataSet;

    public CostFunction(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public Double calculate(LinearRegression linearRegression, Hypothesis hypothesis) {
        return 0.0;
    }
}
