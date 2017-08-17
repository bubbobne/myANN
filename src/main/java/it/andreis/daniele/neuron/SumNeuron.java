package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

public class SumNeuron extends Neuron {
	public SumNeuron(ToDoubleFunction<Double> f, int dim) {
		super(f, dim);
	}

	@Override
	protected double evaluateIndipendentVariable(double[] input) {
		checkArrayDimension(weight);
		double sum = 0;
		for (int i = 0; i < this.nInput; i++) {
			sum = sum + this.weight[i] * input[i];
		}
		return sum;
	}

}
