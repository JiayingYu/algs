package sorting;

public class searchMatrix {
	public static Coord search(int[][] matrix, int key) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row <= matrix.length && col >= 0) {
			if (key == matrix[row][col])
				return new Coord(row, col);
			else if (key > matrix[row][col] ) 
				row++;
			else
				col--;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{2, 4 ,5, 9, 25},
				{4, 11, 32, 45, 50},
				{10, 25, 50, 64, 90},
				{20, 40, 55, 80, 99}
		};
		
		Coord coord = search(matrix, 55);
		System.out.println(coord.row + ", " +  coord.col);
	}
}

class Coord {
	int row;
	int col;
	
	public Coord(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

