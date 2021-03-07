package alg.ninegrid;

import java.util.Set;
import java.util.Stack;

public class SolutionStack {

	private NineGrid nineGrid;

	private Stack<NineGrid> nineGridStack = new Stack<NineGrid>();

	public SolutionStack(int[][] initGrid) {
		nineGrid = new NineGrid();
		nineGrid.init(initGrid);
	}

	public int calculate() {
		Grid grid = nineGrid.findEmptyGrid();
		while (grid != null) {
			Set<Integer> fillDataSet = nineGrid.getAvailableFillData(grid);

			if (fillDataSet.isEmpty()) {
				nineGrid = nineGridStack.pop();
				if (nineGrid == null) {
					return NineGrid.EXECUTE_FAILURE;
				}
			} else {
				int index = 0;
				for (int data : fillDataSet) {
					grid.setValue(data);
					grid.setExitsData(true);
					if (++index == fillDataSet.size()) {
						break;
					}
					nineGridStack.push(nineGrid.copy());
				}
			}
			grid = nineGrid.findEmptyGrid();
		}
		return NineGrid.EXECUTE_SUCCESS;
	}

	public String output() {
		return nineGrid.output();
	}
}