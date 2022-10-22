package org.pk.resume.builder.beans;

public class Projects {
	private String titte;
	private String guide;
	private String frontEnd;
	private String backEnd;
	public String getBackEnd() {
		return backEnd;
	}

	public void setBackEnd(String backEnd) {
		this.backEnd = backEnd;
	}

	private String inputs;
	private String outputs;
	private String description;
	
	public String getTitte() {
		return titte;
	}
	
	public void setTitte(String titte) {
		this.titte = titte;
	}
	
	public String getGuide() {
		return guide;
	}
	
	public void setGuide(String guide) {
		this.guide = guide;
	}
	
	public String getFrontEnd() {
		return frontEnd;
	}
	
	public void setFrontEnd(String frontEnd) {
		this.frontEnd = frontEnd;
	}
	
	public String getInputs() {
		return inputs;
	}
	
	public void setInputs(String inputs) {
		this.inputs = inputs;
	}
	
	public String getOutputs() {
		return outputs;
	}
	
	public void setOutputs(String outputs) {
		this.outputs = outputs;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Projects { Titte = " + this.titte + ",Guide = " + this.guide
					+ ",Front End = "+ this.frontEnd + ",Inputs = " + this.inputs
					+ ",Outputs = " + this.outputs + ",Description = " + this.description + " } ";
	}
	
 
}
