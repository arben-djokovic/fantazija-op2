package me.fit.exception;

public enum ProizvodStatus {
	EXISTS("Proizvod vec postoji");
	
	private String label;

	private ProizvodStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
