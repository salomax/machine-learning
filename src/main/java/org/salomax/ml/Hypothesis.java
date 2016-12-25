package org.salomax.ml;

import java.util.List;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public interface Hypothesis {

    Double h(List<Double> thetas, List<Double> x);

}
