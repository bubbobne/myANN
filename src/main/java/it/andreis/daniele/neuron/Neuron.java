package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

public abstract class Neuron {
	ToDoubleFunction<Double> f = null;
	protected double[] weight;
	protected int nInput = 0;

	public Neuron(ToDoubleFunction<Double> f, int dim) {
		this.f = f;
		this.nInput = dim;
	}

	private Neuron() {
	};

	public ToDoubleFunction<Double> getF() {
		return this.f;
	}

	public void setF(ToDoubleFunction<Double> f) {
		this.f = f;
	}

	public double[] getWeight() {
		return weight;
	}

	public void setWeight(double[] weight) {
		checkArrayDimension(weight);
		this.weight = weight;
	}

	protected void checkArrayDimension(double[] array) {
		if (array.length != nInput) {
			throw new IllegalArgumentException("wrong dimensions");
		}
	}

	protected abstract double evaluateIndipendentVariable(double[] input);

	public double getValue(double[] input) {
		return f.applyAsDouble(evaluateIndipendentVariable(input));
	}

}
