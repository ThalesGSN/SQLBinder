package br.com.sqlbinder.reader;

import java.lang.reflect.Field;

import br.com.sqlbinder.annotations.QueryRepository;
import br.com.sqlbinder.exception.QueryReadException;
import br.com.sqlbinder.queries.Queries;

public class QueryReaderManager {
	public static void populateFields() {
		for(Field field : Queries.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(QueryRepository.class)) {
				field.setAccessible(true);
				System.out.println(field.getName());
				String path = field.getAnnotation(QueryRepository.class).path();
				try {
					field.set(null, QueryReader.readQueryFrom(path));
				} catch (IllegalArgumentException | IllegalAccessException | QueryReadException e) {
					e.printStackTrace();
				}
				try {
					System.out.println(field.get(null));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		populateFields();
	}
}
