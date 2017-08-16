package it.andreis.daniele.neuron;

import java.util.function.ToDoubleFunction;

enum ActivationFunction implements ToDoubleFunction<Double> {
	STEP {

		@Override
		public double applyAsDouble(Double value) {
			if (value >= 0) {
				return 1.0;
			} else {
				return 0.0;
			}
		}
	},
	LINEAR {

		@Override
		public double applyAsDouble(Double value) {
			// TODO Auto-generated method stub
			return value;
		}

	},
	SIG {

		@Override
		public double applyAsDouble(Double value) {
			// TODO Auto-generated method stub
			return 1.0 / (1.0 + Math.exp(-value));
		}

	}

}