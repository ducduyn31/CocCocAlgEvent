package io.github.ducduyn31.geneticALG;

import java.util.ArrayList;

public class Population {
	
	private DNA[] dnas;
	private float mutate;
	private String target;
	private ArrayList<DNA> pool;
	
	public Population(short pop, float mutation, String target){
		this.dnas = new DNA[pop];
		this.mutate = mutation;
		this.target = target;
		
		for(short i = 0; i < pop; i++){
			dnas[i] = new DNA(target.length());
		}
		
		this.pool = new ArrayList<>();
	}

}
