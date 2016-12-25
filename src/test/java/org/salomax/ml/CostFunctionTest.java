package org.salomax.ml;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class CostFunctionTest {

    @Test
    public void hypothese() {

        Hypothesis h = (thetas, x) -> thetas.get(0) + thetas.get(1) * x.get(0);

        LinearRegression linearRegression = new LinearRegression();
        linearRegression.setTheta(0, 1.0);
        linearRegression.setTheta(1, 1.0);

        Double predication = linearRegression.predication(h, Arrays.asList(1.0, 1.0));

        Assert.assertThat(predication, CoreMatchers.equalTo(2.0));

    }

    @Test
    public void costFunction() {

        DataSet dataSet = new SimpleDataSet();
        dataSet.add(1.0, 1.0);
        dataSet.add(2.0, 2.0);
        dataSet.add(3.0, 3.0);

        CostFunction costFunction = new CostFunction(dataSet);

        LinearRegression linearRegression = new LinearRegression();
        linearRegression.setTheta(0, 1.0);
        linearRegression.setTheta(1, 1.0);

        Hypothesis h = (thetas, x) -> thetas.get(0) + thetas.get(1) * x.get(0);

        Double costFunctionValue = costFunction.calculate(linearRegression, h);

    }

}
