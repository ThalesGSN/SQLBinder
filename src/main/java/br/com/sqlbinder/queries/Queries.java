package br.com.sqlbinder.queries;

import br.com.sqlbinder.annotations.QueryRepository;

public class Queries {
	@QueryRepository(path = "test.sql")
	public static String queryTest;
	
	private Queries() {
		throw new IllegalStateException("Utility class.");
	}
}
