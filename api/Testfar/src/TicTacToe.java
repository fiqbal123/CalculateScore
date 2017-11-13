import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	
	   public static boolean checkWinCondition(String[][] arr) {
		  return (arr[0][0]==arr[0][1] && arr[0][0]==arr[0][2] || arr[0][0]==arr[1][0] && arr[0][0]==arr[2][0] || arr[0][0]==arr[1][1] && arr[0][0]==arr[2][2] || 
				   arr[0][1]==arr[1][1] && arr[0][1]==arr[2][1] || arr[1][0]==arr[1][1] && arr[1][0]==arr[1][2] || arr[2][0]==arr[1][1] && arr[2][0]==arr[0][2] 
						   || arr[2][0]==arr[2][1] && arr[2][0]==arr[2][2] || arr[0][2]==arr[1][2] && arr[0][2]==arr[2][2]);
		   
	   }
	   
	   public static void FillArray(String[][] arr){
		   Integer inc=1;
		    for (Integer i = 0; i < arr.length; i++){
		    	for(int j=0;j<arr.length;j++)
		    	{
		    	arr[i][j]=inc.toString();
		    	inc++;
		    	}
		    }
		}
	
	public static void main(String[] args) throws IOException {
		
			   
		   String[][] arr= new String[3][3];	   
		   
		   FillArray(arr);
		   
		   showStatus(arr);		   
		   
		   Scanner input = new Scanner(System.in);
		   int s1;
		   String userAMark="x";
		   String userBMark="y";
		   
		   for(int i=0; i<9; i++) {
			   
			   if(i % 2==0) {
				   System.out.println("User 1- Please enter number where you wud want to put your mark");
				   s1 = Integer.parseInt(input.nextLine());
				   Pair coordinate= getCoordinatesOfNumbers(s1);
				   arr[coordinate.getX()][coordinate.getY()]=userAMark;
			   }
			   else {
				   System.out.println("User 2- Please enter number where you wud want to put your mark");
				   s1 = Integer.parseInt(input.nextLine());
				   Pair coordinate= getCoordinatesOfNumbers(s1);
				   arr[coordinate.getX()][coordinate.getY()]=userBMark;
			   }
			   
			   if (i >= 4) {
				  if(checkWinCondition(arr)) {
					  if (i % 2==0) {
						  System.out.println("User 1 wins the game!");
						  showStatus(arr);
						  break;
					  }
					  else {
						  System.out.println("User 2 wins the game!");
						  showStatus(arr);
						  break;
					  }
				  }
			   }
			  if(i ==8) {
				   System.out.println("The game is drawn");
			   }
			
			   
			   
			   showStatus(arr);
		   }	   
		   
		  
		
	}

	private static void showStatus(String[][] arr) {
		for(int i=0; i <arr.length; i++) {
			   for(int j=0; j< arr.length; j++) {
				   System.out.print(arr[i][j] + " ");
			   }
			   System.out.println();
		   }
	}
	
	public static Pair getCoordinatesOfNumbers(Integer num) {
		
		switch(num) {
		case 1: 
			return new Pair(0, 0);
        case 2:  
			return new Pair(0, 1);
        case 3:  
			return new Pair(0, 2);
        case 4:  
			return new Pair(1, 0);
        case 5:  
			return new Pair(1, 1);
        case 6:  
			return new Pair(1, 2);
        case 7:  
			return new Pair(2, 0);
        case 8:  
			return new Pair(2, 1);
        case 9:  
			return new Pair(2, 2);
        default: return null;
		}
		
	}

}
