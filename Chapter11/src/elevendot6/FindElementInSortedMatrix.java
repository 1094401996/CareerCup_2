/**
 * CareerCup 11.6
 * Given a matrix in which each row and each column is sorted, write a method to find an 
 * element in it.
 * 
 * assumption : each row and column is in increasing order
 * 
 * method: 
 * if the start of column is greater than the element, then x is to the left of the column
 * if the end of column  is less than the element , then x is to the right of the column
 * if the start of the row is greater than the element, the x is above the row
 * if the end of the row is less than the element , then x is below the row
 */


package elevendot6;

public class FindElementInSortedMatrix {
	
	
	
	public static void main(String[] args){
        int[][] matrix= {{15,20,40,85},{20,35,80,95}
        ,{30,55,95,105},{40,80,100,120}};

        int target = 300;
        Result r = findElement(matrix,target);
        if(r.isContained){
                System.out.println("matrix[" + r.row + "][" + r.column + "] = " + matrix[r.row][r.column]);
        }else{
                System.out.println("No such element");
                
        }
}
	
	
	public static Result findElement(int[][]matrix,int target){
		int column = matrix[0].length - 1;
		int row = 0;
		
		while(column >= 0 && row < matrix.length){
			if(matrix[row][column] == target){
				return new Result(row,column,true);
			}
			else if(matrix[row][column] > target){
				column--;
			}else{
				row++;
			}
		
		}
		return new Result(row,column,false);
	}

}


class Result{
	int row;
	int column;
	boolean isContained = false;
	
	Result(int row, int column,boolean isContained){
		this.row = row;
		this.column = column;
		this.isContained = isContained;
	}
}
