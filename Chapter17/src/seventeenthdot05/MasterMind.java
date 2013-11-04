package seventeenthdot05;

public class MasterMind {
	
	public static void main(String[]args){
		char[] solution = {'r','g','b','y'};
		char[] guess = {'g','g','r','r'};
		Result r = giveResult(solution, guess);
		System.out.println(r.hit +"   " + r.psudo);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.pow(2, 31));
	}

	public static Result giveResult(char[] solution, char[] guess){
		int hit = 0;
		int psedohit = 0;
		int[]solution_slots ={1,1,1,1};
		int[]guess_slots = {1,1,1,1};
		for(int i = 0 ; i < solution.length; i++){
			if(solution[i] == guess[i]){
				hit++;
				solution_slots[i] = 0;
				guess_slots[i] = 0;
				
			}
		}
		
		for(int i = 0 ; i < guess.length ; i++){
			if(guess_slots[i] == 1){
				for(int j = 0 ; j < solution.length ; j++){
					if(solution_slots[j] == 1){
						if(guess[i] == solution[j]){
							psedohit++;
							guess_slots[i] = 0;
							solution_slots[j] = 0;
						}
					}
				}
			}
		}
		
		return new Result(hit, psedohit);
	}
	
	
}


class Result{
	int hit;
	int psudo;
	Result(int hit, int psudo){
		this.hit = hit;
		this.psudo = psudo;
	}
}
