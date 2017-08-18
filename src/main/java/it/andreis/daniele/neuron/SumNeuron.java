package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * 
 * 
 * @author Daniele Andreis
 * 
 *         18 Aug 2017
 */
public class SumNeuron extends Neuron {
	public SumNeuron(ToDoubleFunction<Double> f, int dim) {
		super(f, dim);
	}

	/**
	 * 
	 * 
	 * @param input
	 */
	@Override
	protected double evaluateIndipendentVariable(double[] input) {
		checkArrayDimension(weights);
		return DoubleStream.of(IntStream.range(0, weights.length).mapToDouble(i -> weights[i] * input[i]).toArray())
		        .parallel().sum();
	}

}
