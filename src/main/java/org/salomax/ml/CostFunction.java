package org.salomax.ml;

import org.salomax.ml.data.Data;
import org.salomax.ml.data.DataSet;
import org.salomax.ml.util.MathAssert;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class CostFunction {

    private DataSet dataSet;

    public CostFunction(DataSet dataSet) {
        MathAssert.suchThat(dataSet.size(), size -> size > 0);
        this.dataSet = dataSet;
    }

    public Double calculate(LinearRegression linearRegression, Hypothesis hypothesis) {

        int m = this.dataSet.size();

        Double temp = 0.0;
        for (Data data : this.dataSet.getData()) {
            temp += Math.pow(linearRegression.predication(hypothesis, data.getFeatures()) - data.getTarget(), 2);
        }

        Double costFunction = (1.0 / (2.0 * m)) * temp;

        return costFunction;
    }
}
