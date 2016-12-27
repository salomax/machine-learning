package org.salomax.ml;

import org.junit.Test;

import Jama.Matrix;

/**
 * Created by marcos.salomao on 27/12/16.
 */
public class NormalEquationTest {
	
    @Test
    public void calculateThetas() {
    	
        DataSet dataSet = new SimpleDataSet();
        dataSet.add(1.0, 1.0);
        dataSet.add(2.0, 2.0);
        dataSet.add(3.0, 3.0);
        
        // theta = (Xt X)-1 Xt y
        
        double[][] arrayX = {{1.0, 1.0}, {1.0, 2.0}, {1.0, 3.0}};
        double[][] arrayY = {{1.0}, {2.0}, {3.0}};

        Matrix X = new Matrix(arrayX);
        Matrix y = new Matrix(arrayY);
        
        Matrix R = (X.transpose().times(X)).inverse().times(X.transpose().times(y));
        
        System.out.println(R);
    	
    }

}
