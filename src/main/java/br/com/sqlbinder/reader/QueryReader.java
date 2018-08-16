package br.com.sqlbinder.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import br.com.sqlbinder.exception.QueryReadException;


public class QueryReader {
	
	private QueryReader() {
		// do nothing here
	}
	
	
	public static String readQueryFrom(String queryPath) throws QueryReadException  {
        InputStream input = QueryReader.class.getResourceAsStream("/resources/" + queryPath);
        
        if (input == null) {
            input = QueryReader.class.getClassLoader().getResourceAsStream(queryPath);
        }
        
        if(input == null) {
        	throw new QueryReadException("Query not found at: " + queryPath);
        }
        
        String query;
		try {
			query = getStringFromInputStream(input);
		} catch (IOException e) { 
			throw new QueryReadException("There was an IO error: ", e);
		}
        
        return query;

    }
	
	private static String getStringFromInputStream(InputStream input) throws IOException {
        StringBuilder textBuilder = new StringBuilder();
            
    	Charset charset = Charset.forName(StandardCharsets.UTF_8.name());
    	
    	Reader reader = new BufferedReader(new InputStreamReader(input, charset)); 
        int charNum = 0;
        
        while((charNum = reader.read()) != -1) {
            textBuilder.append((char) charNum);
        }
	
        return textBuilder.toString();
	}
	
}
