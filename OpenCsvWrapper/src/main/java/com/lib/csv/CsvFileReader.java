package com.lib.csv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvFileReader {
    private CSVReader reader;
    private String[] currentRecord = null;
    private Map<String, Integer> attributeIndices = new HashMap<String, Integer>();

    public CsvFileReader(String filepath) throws IOException {
        reader = new CSVReader(new FileReader(filepath));
        String[] header = reader.readNext();
        if (header != null)
            for (int i = 0; i < header.length; i++) {
                attributeIndices.put(header[i], i);
            }
        currentRecord = header;
    }

    public boolean readNext() throws IOException {
        currentRecord = reader.readNext();
        return currentRecord != null;
    }

    public String getValue(String attrName) {
        if (currentRecord != null && attributeIndices.containsKey(attrName)) {
            Integer index = attributeIndices.get(attrName);
            return currentRecord[index];
        }
        return null;
    }

    public void close() throws IOException {
        reader.close();
    }
}
