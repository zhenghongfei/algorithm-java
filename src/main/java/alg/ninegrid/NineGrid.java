package alg.ninegrid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import alg.ninegrid.Grid;

public class NineGrid {

	public static final int EXECUTE_SUCCESS = 1;

	public static final int EXECUTE_FAILURE = 0;

	public static final int MAX_ROW_NUM = 9;

	public static final int MAX_COL_NUM = 9;

	private Grid[][] nineGrids = new Grid[9][9];

	public int init(int[][] datas) {
		if (datas == null) {
			return EXECUTE_FAILURE;
		}

		if (isInvalideRowNum(datas)) {
			return EXECUTE_FAILURE;
		}

		if (isInvalideColNum(datas)) {
			return EXECUTE_FAILURE;
		}

		for (int i = 0; i < MAX_ROW_NUM; i++) {
			for (int j = 0; j < MAX_COL_NUM; j++) {
				int value = datas[i][j];
				Grid grid = new Grid(i, j);
				grid.setValue(value);
				grid.setExitsData(value > 0);
				nineGrids[i][j] = grid;
			}
		}

		return EXECUTE_SUCCESS;
	}

	private boolean isInvalideRowNum(int[][] nineGridDatas) {
		return nineGridDatas.length != MAX_COL_NUM;
	}

	private boolean isInvalideColNum(int[][] nineGridDatas) {
		return nineGridDatas[0].length != MAX_ROW_NUM;
	}

	/**
	 * 当前实现是从(0,0)位置开始找没有填充数字的节点,可以优化为从某行或某列查找可以填充数字个数最少的点作为空节点
	 */
	public Grid findEmptyGrid() {
		for (int i = 0; i < MAX_ROW_NUM; i++) {
			for (int j = 0; j < MAX_COL_NUM; j++) {
				Grid grid = nineGrids[i][j];
				if (grid.isExitsData()) {
					continue;
				}
				return grid;
			}
		}
		return null;
	}

	public Set<Integer> getAvailableFillData(Grid grid) {

		List<Integer> fillDataList = new ArrayList<Integer>();

		// 计算当前行可以填充的数字
		for (int i = 1; i <= 9; i++) {
			boolean hasExists = false;
			for (int j = 0; j < MAX_COL_NUM; j++) {
				if (nineGrids[grid.getX()][j].getValue() == i) {
					hasExists = true;
					break;
				}
			}
			if (!hasExists) {
				fillDataList.add(i);
			}
		}

		// 去除当前列可以填充的数字
		for (int i = 0; i < fillDataList.size(); i++) {
			boolean hasExists = false;
			for (int x = 0; x < MAX_ROW_NUM; x++) {
				if (nineGrids[x][grid.getY()].getValue() == fillDataList.get(i).intValue()) {
					hasExists = true;
					break;
				}
			}
			if (hasExists) {
				fillDataList.remove(i);
				i--;
			}
		}

		// 去除三宫格可以填充的数字
		for (int i = 0; i < fillDataList.size(); i++) {
			boolean hasExists = false;

			int startX = (grid.getX() / 3) * 3;
			int startY = (grid.getY() / 3) * 3;
			for (int x = startX; x < (startX + 3); x++) {
				for (int y = startY; y < (startY + 3); y++) {
					if (nineGrids[x][y].getValue() == fillDataList.get(i).intValue()) {
						hasExists = true;
						break;
					}
				}
			}
			if (hasExists) {
				fillDataList.remove(i);
				i--;
			}
		}

		Set<Integer> fillDataSet = new HashSet<Integer>();

		for (int data : fillDataList) {
			fillDataSet.add(data);
		}

		return fillDataSet;
	}

	public NineGrid copy() {
		NineGrid nineGrid = new NineGrid();
		for (int i = 0; i < MAX_ROW_NUM; i++) {
			for (int j = 0; j < MAX_COL_NUM; j++) {
				Grid grid = this.nineGrids[i][j];
				nineGrid.nineGrids[i][j] = grid.copy();
			}
		}
		return nineGrid;
	}

	public String output() {
		StringBuilder output = new StringBuilder();
		output.append(" ------------------------------------");
		output.append(System.getProperty("line.separator"));
		for (int i = 0; i < MAX_ROW_NUM; i++) {
			for (int j = 0; j < MAX_COL_NUM; j++) {
				Grid grid = this.nineGrids[i][j];
				output.append(" | " + grid.getValue());
			}
			output.append(" |");
			output.append(System.getProperty("line.separator"));
			output.append(" ------------------------------------");
			output.append(System.getProperty("line.separator"));
		}
		return output.toString();
	}
}
