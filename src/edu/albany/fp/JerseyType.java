package edu.albany.fp;

public enum JerseyType {
	BASEBALL(SportsJersey.BASEBALL),
	FOOTBALL(SportsJersey.FOOTBALL),
	BASKETBALL(SportsJersey.BASKETBALL),
	HOCKEY(SportsJersey.HOCKEY);
	
		
	
	private SportsJersey sport;
	
	JerseyType(SportsJersey sport){
		this.sport = sport;
		
	}
	
	public SportsJersey getSport() {
		return sport;
	}
	
}
	
	enum SportsJersey{
		BASEBALL,
		FOOTBALL,
		BASKETBALL,
		HOCKEY;
	
	}
	
	


