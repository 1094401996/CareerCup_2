package onedot7;

public class SetMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{0,1,2,3},{2,3,4,0}};
		setZero(matrix);
		for(int i = 0 ; i < matrix.length; i++){
			for(int j = 0 ; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void setZero(int[][]matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column =new boolean[matrix[0].length];
		for(int i = 0; i < row.length; i++)
			for(int j = 0 ; j < column.length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		for(int i = 0; i < row.length; i++)
			for(int j = 0 ; j < column.length; j++){
				if(row[i] == true || column[j] == true){
					matrix[i][j] = 0;
				}
			}
	}

}
