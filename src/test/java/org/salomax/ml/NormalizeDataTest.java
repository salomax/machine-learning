package org.salomax.ml;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NormalizeDataTest {
	
	@Test
	public void rescaling() {
		
		DataSet dataSet = new SimpleDataSet();
		dataSet.add(1.0, 1.0);
		dataSet.add(2.0, 2.0);
		dataSet.add(3.0, 3.0);
		dataSet.add(4.0, 4.0);
		dataSet.add(5.0, 5.0);
		dataSet.add(5.0, 6.0);
		
		FeatureScaling featureScaling = new FeatureScaling(dataSet);
		featureScaling.rescaling();
		

		List<Double> result = new ArrayList<>();
		result.add(-0.5);
		result.add(-0.3);
		result.add(-0.1);
		result.add(0.1);
		result.add(0.3);
		result.add(0.5);
		
		for (int index = 0; index < dataSet.getData().size(); index++) {
			Assert.assertThat(dataSet.get(index).getFeatures().get(0), 
					CoreMatchers.equalTo(result.get(index)));
		}

		
	}

	@Test
	public void standardization() {
		
		DataSet dataSet = new SimpleDataSet();
		for (double i = 1.0; i <= 10; i++) {
			dataSet.add(i, i);
		}
		
		FeatureScaling featureScaling = new FeatureScaling(dataSet);
		featureScaling.standardization();
		
		List<Double> result = new ArrayList<>();
		result.add(-1.4863010829205867);
		result.add(-1.1560119533826787);
		result.add(-0.8257228238447705);
		result.add(-0.49543369430686224);
		result.add(-0.1651445647689541);
		result.add(0.1651445647689541);
		result.add(0.49543369430686224);
		result.add(0.8257228238447705);
		result.add(1.1560119533826787);
		result.add(1.4863010829205867);
				
		for (int index = 0; index < dataSet.getData().size(); index++) {
			Assert.assertThat(dataSet.get(index).getFeatures().get(0), 
					CoreMatchers.equalTo(result.get(index)));
		}
		
	}
	
}
