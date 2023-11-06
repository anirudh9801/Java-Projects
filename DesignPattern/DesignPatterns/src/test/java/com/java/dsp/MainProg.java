package com.java.dsp;

public class MainProg {
	public static void main(String[] args) {
		String topic = "Java";
		AbstractFactory factory = new TrainingFactory();
		Training result = factory.getDetails(topic);
		System.out.println(result.getTrainingDetails());
	}

}
