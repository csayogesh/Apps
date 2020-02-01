package com.lib.csv;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CsvFileReaderTests {

    @Test
    public void simpleReaderHeaderTests() throws IOException {
        CsvFileReader reader = new CsvFileReader("src/test/java/com/lib/csv/reader_test.csv");
        assertEquals("column1", reader.getValue("column1"));
        assertEquals("column4", reader.getValue("column4"));
        if(reader.readNext()) {
            assertEquals("cell2", reader.getValue("column2"));
            assertEquals("cell3", reader.getValue("column3"));
        }
        assertFalse(reader.readNext());
    }
}
