package br.com.sqlbinder.reader;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.sqlbinder.exception.QueryReadException;


public class QueryReaderTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@InjectMocks
	private static QueryReader utils;
	
	@Spy
	private static QueryReader spyUtils;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void readQueryFromTestSucesso() throws FileNotFoundException, QueryReadException {
		String queryPath = "test.sql";
		String query = QueryReader.readQueryFrom(queryPath);
		assertEquals("select * from Test", query);
		
	}
	
	@Test(expected = QueryReadException.class)
	public void readQueryFromTestExcecao() throws FileNotFoundException, QueryReadException {
		String queryPath = "/random/path/that/does/not/exists.sql";
		
		QueryReader.readQueryFrom(queryPath);	
	}
	
}
