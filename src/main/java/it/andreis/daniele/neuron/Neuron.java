package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

/**
 * 
 * 
 * 
 * @author Daniele Andreis 18 Aug 2017
 */
public abstract class Neuron {
	/**
     * 
     */
	private ToDoubleFunction<Double> activationFunction = null;
	/**
	 * 
	 */
	protected double[] weights;
	/**
	 * 
	 */
	protected int nInput = 0;

	/**
	 * 
	 * @param f
	 * @param dim
	 */
	public Neuron(ToDoubleFunction<Double> f, int dim) {
		this.activationFunction = f;
		this.nInput = dim;
	}

	/*
	 * 
	 */
	private Neuron() {
	};

	/**
	 * 
	 * @return
	 */
	public ToDoubleFunction<Double> getActivationFunctions() {
		return this.activationFunction;
	}

	/**
	 * 
	 * @param f
	 */
	public void setActivationFunction(ToDoubleFunction<Double> f) {
		this.activationFunction = f;
	}

	/**
	 * 
	 * @return
	 */
	public double[] getWeights() {
		return weights;
	}

	/**
	 * 
	 * @param weight
	 */
	public void setWeights(double[] weight) {
		checkArrayDimension(weight);
		this.weights = weight;
	}

	/**
	 * 
	 * @param array
	 */
	protected void checkArrayDimension(double[] array) {
		if (array.length != nInput) {
			throw new IllegalArgumentException("wrong dimensions");
		}
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	protected abstract double evaluateIndipendentVariable(double[] input);

	/**
	 * 
	 * @param input
	 * @return
	 */
	public double getOutput(double[] input) {
		return activationFunction.applyAsDouble(evaluateIndipendentVariable(input));
	}

}
