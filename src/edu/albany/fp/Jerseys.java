package edu.albany.fp;

public class Jerseys implements Comparable<Jerseys> {
	
	//suggested retail price
	double srp;
	//our price
	double op;
	
	JerseyTeams team;
	JerseySize size;
	JerseyCondition cond;
	JerseyType jerseyType;
	
	enum JerseyTeams{
		YANKEES,
		METS,
		KNICKS,
		NETS,
		GIANTS,
		JETS,
		BILLS,
		RANGERS,
		ISLANDERS;
		
	}
	
	enum JerseySize{
		SMALL,
		MEDIUM,
		LARGE,
		XLARGE,
		XXLARGE;
	}
	
	
	enum JerseyCondition{
		NEW,
		GOOD,
		AUTHENTIC,
		REUSED;
		
		
	}
	
	public Jerseys(double srp, double op, JerseyType jerseyType, JerseyTeams team, JerseySize size, JerseyCondition cond) {
		this.srp = srp;
		this.op =op;
		this.jerseyType = jerseyType;
		this.team = team;
		this.size = size;
		this.cond = cond;
		
	}
	
	public int compareTo(Jerseys j) {
		// compareTo returns sign numbers
		if(this.jerseyType.compareTo(j.jerseyType) <= -1) {
			return -1;
		}
		else if(this.jerseyType.compareTo(j.jerseyType) >= 1) {
			return 1;
			}
		if(this.team.compareTo(j.team) <= -1) {
			return -1;
		}
		else if(this.team.compareTo(j.team) >= 1) {
			return 1;
			}
		else {
		return 0;
		}
	}
	
	
	
	

}
