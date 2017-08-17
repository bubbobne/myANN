package it.andreis.daniele.neuron;

import org.junit.Assert;
import org.junit.Test;

public class NeuronsTest {
	private double delta = 0.00001;

	@Test
	public void simpleSum() {
		int dim = 3;
		double[] numbers = { 0.1, 0.5, 1 };
		double[] weight = { 0.1, 0.1, 0.1 };
		Neuron n = new SumNeuron(ActivationFunction.SIGMOID, dim);
		n.setWeight(weight);
		n.getValue(numbers);
		Neuron n2 = new SumNeuron(ActivationFunction.SIGMOID, dim);
		n2.setWeight(weight);
		double expValue = 0.5399148845555657;
		double stepValue = 1.0;
		double linearValue = 0.16;
		Assert.assertEquals(0.16, n.evaluateIndipendentVariable(numbers), delta);
		Assert.assertEquals(0.16, n2.evaluateIndipendentVariable(numbers), delta);
		Assert.assertEquals(expValue, n2.getValue(numbers), delta);
		Assert.assertEquals(expValue, n.getValue(numbers), delta);
		n.setF(ActivationFunction.STEP);
		n2.setF(ActivationFunction.STEP);
		Assert.assertEquals(stepValue, n.getValue(numbers), delta);
		Assert.assertEquals(stepValue, n2.getValue(numbers), delta);
		n.setF(ActivationFunction.LINEAR);
		n2.setF(ActivationFunction.LINEAR);
		Assert.assertEquals(linearValue, n.getValue(numbers), delta);
		Assert.assertEquals(linearValue, n2.getValue(numbers), delta);
	}

	@Test
	public void loopVsStream() {
		java.util.Random r = new java.util.Random();
		int dim = 20000000;
		double[] numbers = r.doubles(dim).toArray();
		double[] weight = r.doubles(dim).toArray();
		Neuron n = new SumNeuron(ActivationFunction.SIGMOID, dim);
		n.setWeight(weight);
		n.getValue(numbers);
		Neuron n2 = new SumNeuron(ActivationFunction.SIGMOID, dim);
		n2.setWeight(weight);
		Assert.assertEquals(n.getValue(numbers), n2.getValue(numbers), delta);
	}
}
