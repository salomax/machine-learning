package org.salomax.ml;

import java.util.List;

/**
 * Created by marcos.salomao on 25/12/16.
 */
public interface DataSet {

    void add(Data data);

    void add(Double target, Double... features);

    List<Data> getData();

    Data get(int i);

    int size();

}
