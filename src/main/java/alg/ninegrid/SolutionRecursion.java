package alg.ninegrid;

import java.util.Set;

public class SolutionRecursion {

	private NineGrid nineGrid;

	public SolutionRecursion(int[][] initGrid) {
		nineGrid = new NineGrid();
		nineGrid.init(initGrid);
	}

	public int calculate() {
		Grid grid = nineGrid.findEmptyGrid();
		while (grid != null) {
			Set<Integer> fillDataSet = nineGrid.getAvailableFillData(grid);

			if (fillDataSet.isEmpty()) {
				return NineGrid.EXECUTE_FAILURE;
			}

			int result = fillGrid(grid, fillDataSet);
			if (result == NineGrid.EXECUTE_FAILURE) {
				return NineGrid.EXECUTE_FAILURE;
			}

			grid = nineGrid.findEmptyGrid();
		}
		return NineGrid.EXECUTE_SUCCESS;
	}

	private int fillGrid(Grid grid, Set<Integer> fillDataSet) {
		for (int data : fillDataSet) {
			grid.setValue(data);
			grid.setExitsData(true);

			if (calculate() == NineGrid.EXECUTE_FAILURE) {
				grid.setValue(0);
				grid.setExitsData(false);
				continue;
			}
			return NineGrid.EXECUTE_SUCCESS;
		}
		return NineGrid.EXECUTE_FAILURE;
	}

	public String output() {
		return nineGrid.output();
	}
}