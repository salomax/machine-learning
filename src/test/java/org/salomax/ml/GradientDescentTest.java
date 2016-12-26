package org.salomax.ml;

import org.junit.Test;
import org.salomax.ml.data.DataSet;
import org.salomax.ml.data.SimpleDataSet;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class GradientDescentTest {

    @Test
    public void minimize() {

        DataSet dataSet = new SimpleDataSet();
        dataSet.add(1.0, 1.0);
        dataSet.add(2.0, 2.0);
        dataSet.add(3.0, 3.0);

        Hypothesis h = (thetas, features) -> thetas.get(0) * features.get(0) + thetas.get(1) * features.get(1);

        GradientDescent gradientDescent = new GradientDescent();

        Minimum minimum = gradientDescent.minimize(dataSet, h, 0.1, 1000);

//        Assert.assertThat(Precision.round(minimum.getCostFunction(), 2), CoreMatchers.equalTo(0.00));

    }

}
