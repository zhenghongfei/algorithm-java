package alg.ninegrid;

import org.junit.Assert;
import org.junit.Test;

public class NineGridTestCase {

	@Test
	public void test001() {
		int[][] initGrid = { 
				{ 7, 8, 0, 2, 3, 0, 1, 0, 5 }, 
				{ 6, 0, 1, 0, 0, 0, 7, 0, 0 },
				{ 9, 5, 0, 0, 0, 0, 0, 0, 0 },
				{ 3, 0, 0, 0, 0, 1, 6, 5, 0 },
				{ 0, 2, 0, 5, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 9, 6, 8, 7, 0, 3, 2, 0 },
				{ 0, 0, 0, 0, 6, 0, 9, 0, 8 },
				{ 0, 4, 0, 0, 0, 0, 0, 7, 6 } };
		
		SolutionStack solution = new SolutionStack(initGrid);
		int result = solution.calculate();

		Assert.assertEquals(NineGrid.EXECUTE_SUCCESS,result);
		
		System.out.println(solution.output());
	}
	
	@Test
	public void test002() {
		int[][] initGrid = { 
				{ 0, 0, 8, 3, 0, 9, 1, 0, 0 }, 
				{ 9, 0, 0, 0, 6, 0, 0, 0, 4 },
				{ 0, 0, 7, 5, 0, 4, 8, 0, 0 },
				{ 0, 3, 6, 0, 0, 0, 5, 4, 0 },
				{ 0, 0, 1, 0, 0, 0, 6, 0, 0 },
				{ 0, 4, 2, 0, 0, 0, 9, 7, 0 },
				{ 0, 0, 5, 9, 0, 7, 3, 0, 0 },
				{ 6, 0, 0, 0, 1, 0, 0, 0, 8 },
				{ 0, 0, 4, 6, 0, 8, 2, 0, 0 } };
		
		SolutionStack solution = new SolutionStack(initGrid);
		int result = solution.calculate();
		Assert.assertEquals(NineGrid.EXECUTE_SUCCESS,result);
		
		System.out.println(solution.output());
	}
	
	@Test
	public void test003() {
		int[][] initGrid = { 
				{ 8, 9, 0, 1, 7, 0, 0, 0, 0 }, 
				{ 6, 0, 4, 9, 0, 0, 0, 8, 0 },
				{ 0, 0, 0, 0, 0, 0, 6, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 4, 3, 0 },
				{ 0, 3, 0, 4, 0, 8, 0, 1, 0 },
				{ 0, 1, 2, 7, 0, 0, 0, 0, 0 },
				{ 0, 0, 9, 0, 0, 0, 0, 0, 0 },
				{ 0, 5, 0, 0, 0, 7, 9, 0, 4 },
				{ 0, 0, 0, 0, 6, 9, 0, 2, 7 } };
		

		SolutionStack solution = new SolutionStack(initGrid);
		int result = solution.calculate();
		Assert.assertEquals(NineGrid.EXECUTE_SUCCESS,result);
		
		System.out.println(solution.output());
	}
}