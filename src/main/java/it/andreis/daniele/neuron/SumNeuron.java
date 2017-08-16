package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

public class SumNeuron extends Neuron {
	private double[] weight;
	private int nInput = 0;

	public SumNeuron(ToDoubleFunction<Double> f, int dim) {
		super(f);
		this.nInput = dim;
		this.weight = new double[this.nInput];
		for (int i = 0; i < nInput; i++) {
			this.weight[i] = Math.random();
		}
	}

	@Override
	protected double evaluateIndipendentVariable(double[] input) {
		// TODO Auto-generated method stub
		if (input.length != this.weight.length) {
			throw new IllegalArgumentException("");
		}
		double sum = 0;
		for (int i = 0; i < this.nInput; i++) {
			sum = +this.weight[i] * input[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		Neuron n = new SumNeuron(ActivationFunction.STEP, 3);
		System.out.println(n.getValue(new double[] { 0.0, 1.0, 2.0 }));
		n.setF(ActivationFunction.SIG);
		System.out.println(n.getValue(new double[] { 0.0, 1.0, 2.0 }));

	}
}
