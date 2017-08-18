package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

/**
 * A collection of activation functions.
 * 
 * <li>STEP function</li>
 * 
 * <li>LINEAR y=x</li>
 * 
 * <li>SIGMOID y=1/(1+e^(-x))</li>
 * 
 * @author Daniele Andreis 17 Aug 2017
 */

enum ActivationFunction implements ToDoubleFunction<Double> {
	/**
	 * x>=0 y=1.0 <br>
	 * x<0 y=0.0
	 */
	STEP {
		@Override
		public double applyAsDouble(Double value) {
			return value >= 0 ? 1.0 : 0.0;
		}
	},
	/**
	 * y=x
	 */
	LINEAR {
		@Override
		public double applyAsDouble(Double value) {
			return value;
		}
	},
	/**
	 * y=1/(1+e^(-x))
	 */
	SIGMOID {
		@Override
		public double applyAsDouble(Double value) {
			return 1.0 / (1.0 + Math.exp(-value));
		}

	}

}