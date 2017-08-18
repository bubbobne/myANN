package it.andreis.daniele.neuron;

import org.junit.Assert;
import org.junit.Test;

public class NeuronsTest {
	private double delta = 0.00001;

	/**
	 * Test for the neurons output
	 */
	@Test
	public void simpleSum() {
		int dim = 3;
		double[] numbers = { 0.1, 0.5, 1 };
		double[] weight = { 0.1, 0.1, 0.1 };
		Neuron n = new SumNeuron(ActivationFunction.SIGMOID, dim);
		n.setWeights(weight);
		n.getOutput(numbers);
		double expValue = 0.5399148845555657;
		double stepValue = 1.0;
		double linearValue = 0.16;
		Assert.assertEquals(0.16, n.evaluateIndipendentVariable(numbers), delta);
		Assert.assertEquals(expValue, n.getOutput(numbers), delta);
		n.setActivationFunction(ActivationFunction.STEP);
		Assert.assertEquals(stepValue, n.getOutput(numbers), delta);
		n.setActivationFunction(ActivationFunction.LINEAR);
		Assert.assertEquals(linearValue, n.getOutput(numbers), delta);
	}

}
