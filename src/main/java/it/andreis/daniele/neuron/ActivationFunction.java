package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

/**
 * A collection of activation functions.
 * 
 * @author Daniele Andreis 17 Aug 2017
 */

enum ActivationFunction implements ToDoubleFunction<Double> {
	STEP {
		@Override
		public double applyAsDouble(Double value) {
			return value >= 0 ? 1.0 : 0.0;
		}
	},
	LINEAR {
		@Override
		public double applyAsDouble(Double value) {
			return value;
		}
	},
	SIGMOID {
		@Override
		public double applyAsDouble(Double value) {
			return 1.0 / (1.0 + Math.exp(-value));
		}

	}

}