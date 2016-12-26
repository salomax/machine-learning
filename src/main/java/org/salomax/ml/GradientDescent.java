package org.salomax.ml;

import org.salomax.ml.data.Data;
import org.salomax.ml.data.DataSet;
import org.salomax.ml.util.MathAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public class GradientDescent {

    private static final Logger logger = Logger.getLogger(GradientDescent.class.getName());

    public Minimum minimize(final DataSet dataTraining, Hypothesis hypothesis, Double learningRate, Integer maxInterations) {



        MathAssert.suchThat(dataTraining.size(), v -> v > 0);

        List<Data> dataSet = new ArrayList<>(dataTraining.getData());
        addOnesColumn(dataSet);
        int m = dataSet.size();
        int featuresSize = dataSet.get(0).getFeatures().size();

        LinearRegression linearRegression = new LinearRegression();

        // initialize thetas
        for (int i = 0; i < featuresSize; i++) {
            linearRegression.setTheta(i, 0.0);
        }

        Double[] thetasTemp = new Double[featuresSize];
        int interations = 0;

        do {

            Arrays.fill(thetasTemp, 0.0);

            for (Data data : dataSet) {

                for (int j = 0; j < data.getFeatures().size(); j++) {
                    thetasTemp[j] += (1.0/m) * (linearRegression.predication(hypothesis, data.getFeatures()) - data.getTarget()) * data.getFeature(j);
                }

            }

            for (int i = 0; i < thetasTemp.length; i++) {
                linearRegression.subtractTheta(i, learningRate * thetasTemp[i]);
                logger.info(String.format("\nTheta(%d) = %f", i, linearRegression.getTheta(i)));
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

    private void addOnesColumn(List<Data> dataSet) {
        for (Data data : dataSet) {
            data.getFeatures().add(0, 1.0);
        }
    }

}
