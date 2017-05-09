package io.github.ducduyn31.geneticALG;

import java.util.Random;

public class DNA {
	
	private char[] genes;
	
	public DNA(int lenght){
		genes = new char[lenght];
		for(int i = 0; i < lenght; i++){
			Random r = new Random();
			genes[i] = (char) (r.nextInt(26) + 97);
		}
	}
	
	public String getPhrase(){
		return String.copyValueOf(genes);
	}
	
	public float fitness(String target){
		int score = 0;
	     for (int i = 0; i < genes.length; i++) {
	        if (genes[i] == target.charAt(i)) {
	          score++;
	        }
	     }
	     
	     return (float)score / (float)target.length();
	}
	
	public DNA crossOver(DNA mate){
		DNA child = new DNA(genes.length);
		
		Random r = new Random();
		int mid = r.nextInt(genes.length);
		
		for(int i = 0; i< genes.length; i++){
			if( i < mid )
				child.genes[i] = genes[i];
			else
				child.genes[i] = mate.genes[i];
		}
		
		return child;
	}
	
	public void mutate(float rate){
		for(int i = 0; i < genes.length; i++){
			if(Math.random() < rate){
				Random r = new Random();
				genes[i] = (char) (r.nextInt(26) + 97);
			}
		}
	}

}
