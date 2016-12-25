package org.salomax.ml;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class GradientDescent {

    private static final Logger logger = Logger.getLogger(GradientDescent.class.getName());

    public Minimum minimize(DataSet dataSet, Hypothesis hypothesis, Double learningRate, Integer maxInterations) {

        int m = dataSet.size();

        LinearRegression linearRegression = new LinearRegression();
        linearRegression.setTheta(0, 0.0);
        linearRegression.setTheta(1, 0.0);

        Double temp;
        List<Double> thetas = new ArrayList();

        int interations = 0;
        do {

            thetas.clear();

            for (Data data : dataSet.getData()) {

                for (int j = 0; j < data.getFeatures().size() + 1; j++) {
                    if (j >= thetas.size()) {
                        thetas.add(j, 0.0);
                    }
                    temp = (1.0/m) * (linearRegression.predication(hypothesis, data.getFeatures()) - data.getTarget()) * data.getFeature(j - 1);
                    thetas.set(j, thetas.get(j) + temp);
                }

            }

            for (int i = 0; i < thetas.size(); i++) {
                linearRegression.subtractTheta(i, learningRate * thetas.get(i));
//                logger.info(String.format("\nTheta(%d) = %f", i, linearRegression.getTheta(i)));
            }

//            temp0 = 0.0;
//            temp1 = 0.0;
//
//            for (Data data : dataSet.getData()) {
//                temp0 += (1.0/m) * (linearRegression.predication(hypothesis, data.getFeatures()) - data.getTarget());
//                temp1 += (1.0/m) * (linearRegression.predication(hypothesis, data.getFeatures()) - data.getTarget()) * data.getFeatures().get(0);
//            }
//
//            linearRegression.subtractTheta(0, learningRate * temp0);
//            linearRegression.subtractTheta(1, learningRate * temp1);

            // TODO Converge
        } while(interations++ < maxInterations);

        return null;
    }

}
