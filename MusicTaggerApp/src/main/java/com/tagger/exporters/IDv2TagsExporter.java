package com.tagger.exporters;

import com.lib.file.DirectoryTraverser;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.opencsv.CSVWriter;
import com.tagger.exporters.com.tagger.ID3v2Tag;
import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class IDv2TagsExporter implements IDv2TagExporter {
    public void exportAllTags(String sourceDirectorPath, String options, String destCsvFilePath) {
        exportTags(sourceDirectorPath, options, destCsvFilePath, ID3v2Tag.values());
    }

    public void exportTags(String sourceDirectorPath, String options, String destCsvFilePath, ID3v2Tag... tags) {
        if (StringUtils.isBlank(options))
            options = StringUtils.EMPTY;
        options = options.toLowerCase();
        List<String> files = new DirectoryTraverser(sourceDirectorPath).getListOfFiles(true, true);
        try {
            String[] columnNames = new String[tags.length];
            for (int i = 0; i < tags.length; i++)
                columnNames[i] = tags[i].toString();
            CSVWriter outputFile = new CSVWriter(new FileWriter(destCsvFilePath));
            outputFile.writeNext(columnNames);
            for (String file : files) {
                try {
                    if (file.endsWith(".mp3")) {
                        String[] nextLine = exportTags(file, tags);
                        nextLine[0] = file;
                        outputFile.writeNext(nextLine);
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + file + " : " + e.getCause());
                }
            }
            outputFile.flush();
            outputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] exportTags(String filepath, ID3v2Tag... tags) {
        String[] record = new String[tags.length];
        try {
            Mp3File mp3File = new Mp3File(filepath);
            ID3v2 tag = mp3File.getId3v2Tag();
            for (int i = 0; i < tags.length && tag != null; i++)
                record[i] = tags[i].getTag(tag);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        return record;
    }

    public static void main(String[] args) {
        IDv2TagsExporter exporter = new IDv2TagsExporter();
        exporter.exportAllTags("/Users/bhosay/Desktop/Music", "", "/Users/bhosay/Desktop/musicTags.csv");
    }
}
