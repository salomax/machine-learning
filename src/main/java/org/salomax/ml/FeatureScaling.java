package org.salomax.ml;

import java.util.function.BiFunction;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * https://en.wikipedia.org/wiki/Feature_scaling
 * 
 * “Standardization or Min-Max scaling?” - There is no obvious answer to this question: it really depends on the application.
 * 
 * For example, in clustering analyses, standardization may be especially crucial 
 * in order to compare similarities between features based on certain distance measures. 
 * Another prominent example is the Principal Component Analysis, where we usually prefer 
 * standardization over Min-Max scaling, since we are interested in the components 
 * that maximize the variance (depending on the question and if the PCA computes 
 * the components via the correlation matrix instead of the covariance matrix; 
 * but more about PCA in my previous article).
 * 
 * However, this doesn’t mean that Min-Max scaling is not useful at all! 
 * A popular application is image processing, where pixel intensities 
 * have to be normalized to fit within a certain range (i.e., 0 to 255 for the RGB color range). 
 * Also, typical neural network algorithm require data that on a 0-1 scale.
 * 
 * http://sebastianraschka.com/Articles/2014_about_feature_scaling.html
 */
public class FeatureScaling {
	
	private boolean scaled;
	private DataSet dataSet;
	private DescriptiveStatistics[] features;
	
	public FeatureScaling(DataSet dataSet) {
		this.dataSet = dataSet;
		this.summarize(dataSet);
	}
	
	protected void summarize(DataSet dataSet) {
		// TODO init proper the array
		this.features = new DescriptiveStatistics[] { new DescriptiveStatistics() };
		
		int index;
		for (Data data : dataSet.getData()) {
			index = 0;
			for (Double feature : data.getFeatures()) {
				features[index++].addValue(feature);
			}
		}
	}
	
	public void standardization() {
		normalize((value, j) -> standardization(value, j));
	}
	
	public void rescaling() {
		normalize((value, j) -> rescaling(value, j));
	}
	
	private void normalize(BiFunction<Double, Integer, Double> function) {
		
		if (scaled) {
			throw new IllegalStateException("Data set was scaled already");
		}
		
		for (Data data : this.dataSet.getData()) {
			for (int j = 0; j < data.getFeatures().size(); j++) {
				data.getFeatures().set(j, function.apply(data.getFeatures().get(j), j));
			}
		}	
		scaled = !scaled;
	}

	protected Double standardization(Double value, int featureIndex) {
		return (value - this.features[featureIndex].getMean()) / this.features[featureIndex].getStandardDeviation();
	}

	protected Double rescaling(Double value, int featureIndex) {
		return (value - this.features[featureIndex].getMean()) / (this.features[featureIndex].getMax() - this.features[featureIndex].getMin());
	}

}
