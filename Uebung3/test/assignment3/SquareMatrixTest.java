package assignment3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;

import assignment3.SquareMatrix.InitStrategy;

public class SquareMatrixTest {
	
	SquareMatrix matrix1;
	SquareMatrix matrix2;
	SquareMatrix matrix3;
	
	@Before
	public void setup(){
		matrix1 = new SquareMatrix(4, InitStrategy.Plus);
		matrix2 = new SquareMatrix(4, InitStrategy.Minus);
		matrix3 = new SquareMatrix(5, InitStrategy.Random);
		
	}
	
	@Test
	public void testMin() {
		assertEquals(0d, matrix1.min(), 0);
		assertEquals(-3d, matrix2.min(), 0);
		for (int i = 0; i < matrix1.size(); i++) {
			for (int j = 0; j < matrix1.size(); j++){
				matrix1.set(i, j, Double.NaN);
			}
		}
		assertEquals(Double.POSITIVE_INFINITY, matrix1.min(), 0);
	}
	
	@Test
	public void testMax() {
		assertEquals(6d, matrix1.max(), 0);
		assertEquals(3d, matrix2.max(), 0);
		for (int i = 0; i < matrix1.size(); i++) {
			for (int j = 0; j < matrix1.size(); j++){
				matrix1.set(i, j, Double.NaN);
			}
		}
		assertEquals(Double.NEGATIVE_INFINITY, matrix1.max(), 0);
	}
	
	@Test
	public void testMultiplyWithScalar() {
		boolean test = true;
		SquareMatrix testmatrix = matrix1.multiply(3.0);
		SquareMatrix result = new SquareMatrix(4, InitStrategy.Plus);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.size(); j++){
				result.set(i, j, result.get(i, j)*3.0);
				if (result.get(i, j) != testmatrix.get(i, j)){
					test = false;
				}
			}
		}
		assertTrue(test);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMultiplyWithMatrixExc() {
		
		matrix1.multiply(matrix3);
	}
	
	@Test
	public void testMultiplyWithMatrix() {
		SquareMatrix result = new SquareMatrix(4, InitStrategy.Zero);
		
	}
	
}
