package worksapp.snake_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Milan
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SnakeGame snakeGame = new SnakeGame(scanner);
		long maxScore = snakeGame.findMaxScore();
		System.out.println(maxScore);
	}

}

class Grid {
	int n;// rows
	int m;// cols
	Cell[][] cells;

	public Grid(Scanner in) {
		n = in.nextInt();
		m = in.nextInt();
		cells = new Cell[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cells[i][j] = new Cell(in.nextInt(), i, j);
			}
		}
	}
}

class Cell {
	int value;
	int row;
	int col;

	public Cell(int value, int row, int col) {
		this.value = value;
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof Cell)) {
			return false;
		}
		Cell cell = (Cell) obj;

		if (cell.value == this.value && cell.row == this.row
				&& cell.col == this.col)
			return true;
		else
			return false;

	}

	public boolean isBlocked() {
		if (this.value == -1) {
			return true;
		}
		return false;
	}

}

class Snake {
	List<Cell> cells = new ArrayList<Cell>();
	List<Cell> blockedCells = new ArrayList<Cell>();
	List<Cell> clearedCell = new ArrayList<Cell>();// cells cleared due to
													// teleport

	public void add(Cell cell) {
		cells.add(cell);
	}

	public void clear() {
		clearedCell.addAll(cells);
		cells.clear();
	}

	public void addToBlockedCell(Cell cell) {
		blockedCells.add(cell);
	}

	public boolean isVisited(Cell cell) {
		if ((cells.contains(cell) || blockedCells.contains(cell) || clearedCell
				.contains(cell)))
			return true;
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Snake snake = new Snake();
		snake.blockedCells.addAll(this.blockedCells);
		snake.clearedCell.addAll(this.clearedCell);
		snake.cells.addAll(this.cells);
		return snake;
	}

	public void print() {
		String s = "[";
		for (int i = 0; i < this.cells.size(); i++) {
			s = s + cells.get(i).value + ",";
		}
		s = s + "]";
		System.out.println(s);
	}
}

class SnakeGame {

	Grid grid;
	List<Snake> snakes = new ArrayList<Snake>();

	public SnakeGame(Scanner in) {
		grid = new Grid(in);
	}

	public long findMaxScore() {
		// start from left
		for (int i = 0; i < grid.n; i++) {
			try {
				findAllSnakes(null, grid.cells[i][0]);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// print
		// for (int i = 0; i < snakes.size(); i++) {
		// snakes.get(i).print();
		// }

		return findMax(snakes);
	}

	public void findAllSnakes(Snake snake, Cell cell)
			throws CloneNotSupportedException {
		if (cell == null)
			return;// reached to right border and cannot go further right

		if (snake != null)
			snakes.add(snake);

		if ((snake == null || !snake.isVisited(cell)) && !cell.isBlocked()) {

			if (snake == null) {
				snake = new Snake();
			}

			Snake snake1 = (Snake) snake.clone();
			Cell upCell = goUp(snake1, cell);

			Snake snake2 = (Snake) snake.clone();
			Cell downCell = goDown(snake2, cell);

			Snake snake3 = (Snake) snake.clone();
			Cell rightCell = goRight(snake3, cell);
			findAllSnakes(snake1, upCell);
			findAllSnakes(snake2, downCell);
			findAllSnakes(snake3, rightCell);
		}

	}

	public Cell goUp(Snake snake, Cell cell) {
		if (cell.row - 1 >= 0) {
			Cell newCell = grid.cells[cell.row - 1][cell.col];
			if (!cell.isBlocked()) {

				snake.add(cell);
				return newCell;
			} else {
				snake.addToBlockedCell(cell);
				return newCell;// return same blocked cell
			}

		}// teleport
		else {
			if (!cell.isBlocked()) {

				snake.add(cell);

			} else {
				snake.addToBlockedCell(cell);

			}
			snake.clear();
			Cell newCell = grid.cells[grid.n - 1][cell.col];

			return newCell;
		}

	}

	public Cell goRight(Snake snake, Cell cell) {
		if (cell.col + 1 < grid.m) {
			Cell newCell = grid.cells[cell.row][cell.col + 1];
			if (!cell.isBlocked()) {
				snake.add(cell);
				return newCell;
			} else {
				snake.addToBlockedCell(cell);
				return newCell;
			}// return same cell if blocked
		}
		return null;// cannot go right
	}

	public Cell goDown(Snake snake, Cell cell) {
		if (cell.row + 1 < grid.n) {
			Cell newCell = grid.cells[cell.row + 1][cell.col];
			if (!cell.isBlocked()) {
				snake.add(cell);
				return newCell;
			} else {
				snake.addToBlockedCell(cell);
				return newCell;
			}
		}// teleport
		else {
			if (!cell.isBlocked()) {

				snake.add(cell);

			} else {
				snake.addToBlockedCell(cell);

			}
			snake.clear();
			Cell newCell = grid.cells[0][cell.col];
			return newCell;
		}

	}

	public long findMax(List<Snake> snakes) {
		long max = -1;
		Snake s = null;
		for (Snake snake : snakes) {
			long sum = 0;
			for (Cell cell : snake.cells) {
				sum = sum + cell.value;
			}
			if (sum > max) {
				max = sum;
				s = snake;
			}
		}
		// s.print();
		return max;

	}

}
