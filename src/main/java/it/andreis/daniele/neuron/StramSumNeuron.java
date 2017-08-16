package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StramSumNeuron extends SumNeuron {

	public StramSumNeuron(ToDoubleFunction<Double> f, int dim) {
		super(f, dim);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double evaluateIndipendentVariable(double[] input) {
		// TODO Auto-generated method stub

		if (input.length != this.weight.length) {
			throw new IllegalArgumentException("");
		}

		return DoubleStream.of(IntStream.range(0, weight.length).mapToDouble(i -> weight[i] * input[i]).toArray())
		        .sum();

	}

}
