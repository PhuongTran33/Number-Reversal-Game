import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class ReversalGame {
	private List<Integer> gameList;

	public ReversalGame() {
		initialize();
	}



	public static int find( List<Integer>  a, int target)
	{
		for (int i = 0; i < a.size(); i++)
			if (a.get(i) == target)
				return i+1;

		return -1;
	}

	public void play() throws Exception {
		int i = 0;
		int moveCount = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("WELCOME TO REVERSAL GAME ");
		while (true) {
			System.out.println(gameList);
			System.out.println("Your goal is to get the digits in order with 1 on the left and 9 on the right");
			System.out.println("How many number you want to flip?\n (Enter 99 to quit. Enter 911 for solution.)");
			i = scanner.nextInt();

			if (i==911) 
			{

				for (int x= gameList.size();x>=0;x--)
				{
					int index = find(gameList,x);

					if (x!= index)
					{
						if (index!=1)  
						{
							System.out.println("Flip: "+ index);
							reverse(index);	
							moveCount++;            				           			
							System.out.println(gameList + "\n");
						}

						if(x!=1)
						{
							System.out.println("Flip: "+ x);
							reverse (x);
							moveCount++;
							System.out.println(gameList + "\n");
						}


					}

					if (isSorted()) 
					{
						System.out.println("Here is the solution after "+ moveCount+ " moves.");
						break;
					}


				}
				break;
			}

			if (i == 99) {
				break;
			}
			if (i < 2 || i > 9) {
				System.out.println("Invalid input");
			} else {
				moveCount++;
				reverse(i);
				if (isSorted()) {
					System.out.println("Congratulations you solved this in " + moveCount + " moves!");
					break;
				}
			}

		}
		scanner.close();
	}



	private void reverse(int position) {
		Collections.reverse(gameList.subList(0, position));
	}

	private boolean isSorted() {
		for (int i=0; i < gameList.size() - 1; ++i) {
			if (gameList.get(i).compareTo(gameList.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}

	private void initialize() {
		this.gameList = new ArrayList<Integer>(9);
		for (int i=1; i < 10; i++) {
			gameList.add(i);
		}
		while (isSorted()) {
			Collections.shuffle(gameList);
		}
	}


	public static void main(String[] args) {
		try {
			ReversalGame game = new ReversalGame();
			game.play();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}