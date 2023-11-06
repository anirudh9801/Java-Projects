package com.java.dsp;

public class TrainingFactory extends AbstractFactory {

	@Override
	public Training getDetails(String topic) {
		if(topic.equals("Java")) {
			return new JavaTraining();
		}
		if(topic.equals("Dotnet")) {
			return new DotnetTraining();
		}
		return null;
	}
	

}
