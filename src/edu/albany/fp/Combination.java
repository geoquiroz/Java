package edu.albany.fp;
import java.util.ArrayList;

public class Combination<T> {
	 ArrayList<T> jerseyCombo;
	 ArrayList<Integer> where;

	    public Combination(ArrayList<T> list){
	        this.where = new ArrayList<Integer>();
	        this.where.add(1);
	        this.jerseyCombo = new ArrayList<T>();
	        this.jerseyCombo.addAll(list);
	    }

	    public ArrayList<T> nextComb(){
	        
	    	if(where.size() > jerseyCombo.size())
	            return null;
	    		ArrayList<T> comb = new ArrayList<T>();
	        for(int i = 0; i < where.size(); i++)
	            if(where.get(i) == 1)
	                comb.add(jerseyCombo.get(i));
	        		int i = 0;
	        		do{
	        			if(where.get(i) == 0)
	        				where.set(i, 1);
	        				else
	        					where.set(i, 0);
	        }
	        while(where.get(i++) == 0 && i < where.size());
	        if(i == where.size())
	        	where.add(1);
	        	return comb;
	    }
}
