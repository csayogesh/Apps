package com.lib.csv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvFileWriter {
    private CSVWriter csvWriter;
    private Map<String, Integer> attrIndices = new HashMap<String, Integer>();
    private String[] currentRecord;
    private int unflushedRecords = 0;
    private static int BUFFER_RECORDS = 100;

    public CsvFileWriter(String filepath, String... attributes) throws IOException {
        csvWriter = new CSVWriter(new FileWriter(filepath));
        for (int i = 0; i < attributes.length; i++)
            attrIndices.put(attributes[i], i);
        csvWriter.writeNext(attributes);
        unflushedRecords++;
    }

    public CsvFileWriter startNewRecord() throws IOException {
        if (currentRecord != null) {
            csvWriter.writeNext(currentRecord);
            unflushedRecords++;
        }
        currentRecord = new String[attrIndices.size()];
        if (unflushedRecords % BUFFER_RECORDS == 0)
            csvWriter.flush();
        return this;
    }

    public CsvFileWriter addValue(String attrName, String attrValue) {
        if (attrIndices.containsKey(attrName) && currentRecord != null) {
            currentRecord[attrIndices.get(attrName)] = attrValue;
        }
        return this;
    }

    public void close() throws IOException {
        startNewRecord();
        csvWriter.flush();
        csvWriter.close();
    }
}
