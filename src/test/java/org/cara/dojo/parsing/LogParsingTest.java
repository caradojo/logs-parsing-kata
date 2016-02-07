package org.cara.dojo.parsing;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.approvaltests.Approvals;
import org.junit.Test;

public class LogParsingTest {
	
	private static final String LOG_FILE_NAME = "data.log";	

	@Test
	public void parse_integration_test() throws Exception
	{
		// Given
		Path pathInputLogFile = FileSystems.getDefault().getPath("src/test/resources", LOG_FILE_NAME);		
		LogParsing parsing = new LogParsing();
		Path pathOutputLogFile = FileSystems.getDefault().getPath("target/test-classes/",
				"data-parsed.log");
		Files.deleteIfExists(pathOutputLogFile);
		Files.createFile(pathOutputLogFile);
		
		// When
		parsing.parse(pathInputLogFile, pathOutputLogFile);
		
		
		// Then
		String content = new String(Files.readAllBytes(pathOutputLogFile));
		Approvals.verify(content);
	}
	
}
