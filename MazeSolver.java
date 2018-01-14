import data_structures.*;
/*  
 Program #3
 Megan Respicio
 cssc0935
*/
public class MazeSolver {
	 private Stack<GridCell> stack; 
	 private Queue<GridCell> queue;
	 private MazeGrid grid;
	 private int dim; 
	 public static void main(String [] args) {
		    new MazeSolver(30);
		}
	public MazeSolver(int dimension){
		grid = new MazeGrid(this, dimension);
		stack = new Stack<GridCell>();
		queue = new Queue<GridCell>(); 
		dim = dimension; 
	}
	public boolean cellChecker(GridCell cellCheck){
		return (grid.isValidMove(cellCheck) && !cellCheck.wasVisited());
	}
	public boolean markCellDistance(GridCell markCell, int cellDist){
		markCell.setDistance(cellDist);
		grid.markDistance(markCell);
		queue.enqueue(markCell);
		return true;
	}
	public void mark(){
		GridCell cellBlockMark;
		GridCell tmp = grid.getCell(0,0);
		grid.getCell(0,0).setDistance(0);
		queue.enqueue(tmp);
		while(!queue.isEmpty()) {		
			cellBlockMark = queue.dequeue();
			int X = cellBlockMark.getX();
			int Y = cellBlockMark.getY();
			int cellDistance = cellBlockMark.getDistance()+1;
			
			if(cellChecker(grid.getCell(X, Y-1))){
				GridCell top = grid.getCell(X, Y-1);	
				markCellDistance(top, cellDistance);
			}
			if(cellChecker(grid.getCell(X-1, Y))){
				GridCell left = grid.getCell(X-1, Y);
				markCellDistance(left, cellDistance);	
			}
			if(cellChecker(grid.getCell(X+1, Y))){
				GridCell right = grid.getCell(X+1, Y);
				markCellDistance(right, cellDistance);
			}	
			if(cellChecker(grid.getCell(X, Y+1))){
				GridCell bottom = grid.getCell(X, Y+1);
				markCellDistance(bottom, cellDistance);
			} 
		} 
	} 
	public int adjCellDistance(GridCell adjCell){
		if(grid.isValidMove(adjCell))
			return adjCell.getDistance();
		return -1;
	}
	public boolean move(){
		GridCell cellBlockMove = grid.getCell(dim-1, dim-1);
		int distance = cellBlockMove.getDistance();
		if(distance == -1) 
			return false;	
		stack.push(cellBlockMove);	
		while(distance != 0) {
			cellBlockMove = stack.peek();
			int X = cellBlockMove.getX();
			int Y = cellBlockMove.getY();
			int topNum = adjCellDistance(grid.getCell(X, Y-1));
			int leftNum = adjCellDistance(grid.getCell(X-1, Y));
			int rightNum = adjCellDistance(grid.getCell(X+1, Y));
			int botNum = adjCellDistance(grid.getCell(X, Y+1));
			if(topNum == distance-1)
				stack.push(grid.getCell(X, Y-1));
			else if(leftNum == distance-1)
				stack.push(grid.getCell(X-1, Y));
			else if(rightNum == distance-1)
				stack.push(grid.getCell(X+1, Y));
			else if(botNum == distance-1)
				stack.push(grid.getCell(X, Y+1));
			cellBlockMove = stack.peek();
			distance--;
		    }
		while(!stack.isEmpty()) {
			grid.markMove(stack.pop());
		    }
		return true;
	}
	public void reset(){
		queue.makeEmpty();
		stack.makeEmpty();
	}
}


