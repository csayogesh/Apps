package com.tagger.exporters;

import com.tagger.exporters.com.tagger.ID3v2Tag;

/**
 * IDvTagExporter
 */
public interface IDv2TagExporter {
    /**
     *
     * @param sourceDirectorPath
     * @param options
     * @param destCsvFilePath
     */
    void exportAllTags(String sourceDirectorPath, String options, String destCsvFilePath);

    /**
     *
     * @param sourceDirectorPath
     * @param options
     * @param destCsvFilePath
     * @param tags
     */
    void exportTags(String sourceDirectorPath, String options, String destCsvFilePath, ID3v2Tag... tags);

    /**
     *
     * @param filepath
     * @param tags
     * @return
     */
    String[] exportTags(String filepath, ID3v2Tag... tags);
}
