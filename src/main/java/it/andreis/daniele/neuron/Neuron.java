package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

public abstract class Neuron {
	public ToDoubleFunction<Double> getF() {
		return f;
	}

	public void setF(ToDoubleFunction<Double> f) {
		this.f = f;
	}

	ToDoubleFunction<Double> f = null;

	public Neuron(ToDoubleFunction<Double> f) {
		this.f = f;
	}

	protected abstract double evaluateIndipendentVariable(double[] input);

	public double getValue(double[] input) {
		return f.applyAsDouble(evaluateIndipendentVariable(input));
	}
}
