/*  
https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/bishu-and-his-girlfriend/ */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/
import java.util.*;

class Main {
    static List< ArrayList<Integer> > Adj;
	static boolean[] girlsCountries;
	static boolean[] visited;
	static int[] level;
	
	public static void main(String[] args){
		
		//Begin initialization 
		Scanner scanner = new Scanner(System.in);
		int numOfCountries;
		numOfCountries = scanner.nextInt();
		girlsCountries = new boolean[numOfCountries + 1];
		visited = new boolean[numOfCountries + 1];
		level = new int[numOfCountries + 1];
		Adj = new ArrayList< ArrayList<Integer> >(numOfCountries + 1);
		for(int i = 0; i < numOfCountries+1; i++){
			Adj.add(new ArrayList<Integer>());
		}

		for(int i = 0; i < numOfCountries -1; i++){
			int country1, country2;
			country1 = scanner.nextInt();
			country2 = scanner.nextInt();
			// Add 2nd country to 1st's neighbor list
			Adj.get(country1).add(country2);
			Adj.get(country2).add(country1);
		}
		
		int numOfGirls = scanner.nextInt();
		//System.out.println("Num of girls is: " + numOfGirls);
		for(int i = 0; i < numOfGirls; i++){
			//System.out.println("For loop num: " + i);
            int x = scanner.nextInt();
			//System.out.println("X in for loop is: " + x);
			girlsCountries[x] = true;
		}
		//end of initialization 
		
		//Test
		//System.out.println("time for testing!!");
		for(int i = 0; i < numOfCountries+1; i++){
		  if( Adj.get(i).size() != 0 ){
		    for(int j = 0; j < Adj.get(i).size(); j++){
		      //System.out.println(Adj.get(i).get(j));
		    }
		  }
		}
		
		//The actual BFS-Method
		//System.out.println("Start BFS");
		Queue<Integer> frontier = new LinkedList<Integer>();
		int lvl = 1;
		frontier.add(1);
		//System.out.println("Begin the while loop");
		while( !frontier.isEmpty() ){
			Queue<Integer> next = new LinkedList<Integer>();
			int size = frontier.size();
			for(int i = 0; i < size; i++){
				int currentIndex = frontier.poll();
				ArrayList<Integer> currentList = Adj.get(currentIndex);
				int numOfCurrentsNeighbors = Adj.get(currentIndex).size();
				for(int j = 0; j < numOfCurrentsNeighbors; j++){
					int v = currentList.get(j);
					//System.out.println(v);
					if(visited[v] == false){
						next.add(v);
						level[v] = lvl;
						visited[v] = true;
					}
				}
			}
			lvl++;
			frontier = next;
		}
		
		//Now lets find the closest living girl
		int min = numOfCountries;
		int closest =  numOfCountries;
		//System.out.println("Now lets find the closest");
		for(int i = girlsCountries.length - 1; i >= 0; i--){
		  //System.out.println(i);
			if(girlsCountries[i] == true ){
			  //System.out.println("Found a true: " + i);
				if(level[i] <= min){
					min = level[i];
					closest = i;
				}
			}
		}
		
		//System.out.println("The closest girl is: " + closest);
		//System.out.println("The level is: " + level[closest]);
		System.out.println(closest);
		scanner.close();
	}
}