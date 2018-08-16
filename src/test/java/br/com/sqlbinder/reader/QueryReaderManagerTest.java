package br.com.sqlbinder.reader;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.sqlbinder.queries.Queries;

public class QueryReaderManagerTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFieldInitialization_success() {
		System.out.println(Queries.queryTest);
		QueryReaderManager.populateFields();
		String expected = "SELECT * FROM TBL_TEST";
		String actual = Queries.queryTest;
		assertEquals(expected, actual);
	}
}
