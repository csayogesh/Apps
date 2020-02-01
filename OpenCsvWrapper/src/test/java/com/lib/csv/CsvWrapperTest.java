package com.lib.csv;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CsvWrapperTest {
    @Test
    public void readerTest() throws IOException {
        CsvFileReader reader = new CsvFileReader("src/test/java/com/lib/csv/reader_test.csv");
        assertEquals("column1", reader.getValue("column1"));
        assertEquals("column4", reader.getValue("column4"));
        if (reader.readNext()) {
            assertEquals("cell2", reader.getValue("column2"));
            assertEquals("cell3", reader.getValue("column3"));
        }
        assertFalse(reader.readNext());
        reader.close();
    }

    @Test
    public void writerTest() throws IOException {
        // Delete old file
        String filename = "src/test/java/com/lib/csv/writer_test.csv";
        File file = new File(filename);
        if (file.exists())
            file.delete();

        // Write file
        CsvFileWriter writer = new CsvFileWriter(filename, "attr1", "attr2", "attr3", "attr4");
        for (int i = 0; i < 210; i++) {
            writer.startNewRecord();
            writer.addValue("attr1", "val1")
                    .addValue("attr3", "val3")
                    .addValue("attr4", "val4");
        }
        writer.close();

        // Verify file
        CsvFileReader reader = new CsvFileReader(filename);
        int i = 0;
        while (reader.readNext()) {
            assertEquals(reader.getValue("attr1"), "val1");
            assertEquals(reader.getValue("attr3"), "val3");
            assertEquals(reader.getValue("attr4"), "val4");
            assertEquals(reader.getValue("attr2"), "");
            i++;
        }
        assertEquals(i, 210);
        reader.close();
    }
}
