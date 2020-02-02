package com.lib.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryTraverser {
    private File directory;

    public DirectoryTraverser(String directoryPath) {
        this.directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory())
            throw new RuntimeException("Path " + directoryPath + " does not exist or is not a directory");
    }

    public List<String> getListOfFiles(boolean recursive, boolean fileFilter) {
        String[] files = directory.list();
        List<String> listOfFiles = new ArrayList<String>();
        for (String file : files) {
            String fullPath = directory.getAbsolutePath() + "/" + file;
            File fileObj = new File(fullPath);
            if (fileFilter) {
                if (fileObj.isFile())
                    listOfFiles.add(fullPath);
            } else listOfFiles.add(fullPath);
            if (fileObj.isDirectory() && recursive)
                listOfFiles.addAll(new DirectoryTraverser(fullPath).getListOfFiles(recursive, fileFilter));
        }
        return listOfFiles;
    }
}
