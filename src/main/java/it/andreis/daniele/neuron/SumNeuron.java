package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

public class SumNeuron extends Neuron {
	protected double[] weight;
	protected int nInput = 0;

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
		java.util.Random r = new java.util.Random();
		int dim = 20000;
		double[] numbers = r.doubles(dim).toArray();
		long start = System.currentTimeMillis();
		Neuron n = new SumNeuron(ActivationFunction.SIG, dim);
		System.out.println(n.getValue(numbers));
		long time = System.currentTimeMillis() - start;
		System.out.println(time);
		start = System.currentTimeMillis();
		Neuron n2 = new SumNeuron(ActivationFunction.SIG, dim);
		System.out.println(n2.getValue(numbers));
		time = System.currentTimeMillis() - start;
		System.out.println(time);

	}
}
