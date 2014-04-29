package springapp.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PriceIncreaseValidator implements Validator {
	private int DEFAULT_MIN_PERCENTAGE = 0;
	private int DEFAULT_MAX_PERCENTAGE = 50;
	private int minPercentage = DEFAULT_MIN_PERCENTAGE;
	private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

	@Override
	public boolean supports(Class classz) {
		// TODO Auto-generated method stub
		return PriceIncrease.class.equals(classz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		PriceIncrease pIncrease = (PriceIncrease) object;
		if (pIncrease == null) {
			errors.rejectValue("percentage", "error.not-specified", null,
					"Required Value");
		} else if (pIncrease.getPercentage() > maxPercentage) {
			errors.rejectValue("percentage", "error-too-high",
					new Object[] { new Integer(maxPercentage) },
					"Percentage too high");

		} else if (pIncrease.getPercentage() < minPercentage) {
			errors.rejectValue("percentage", "error-too-low",
					new Object[] { new Integer(minPercentage) },
					"Percentage too low");

		}

	}

	public void setMaxPercentage(int maxPercentage) {
		this.maxPercentage = maxPercentage;
	}

	public void setMinPercentage(int minPercentage) {
		this.minPercentage = minPercentage;
	}

	public int getMaxPercentage() {
		return maxPercentage;
	}

	public int getMinPercentage() {
		return minPercentage;
	}

}
