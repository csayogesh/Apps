package com.lib.file;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DirectoryTraverserTest {
    @Test
    public void testDirectoryTravel() {
        String path = "/Volumes/unix/workplace/MyApps/FileUtils/src/test/java/com/lib/file/testdir";
        DirectoryTraverser dt =
                new DirectoryTraverser(path);

        List<String> ls = dt.getListOfFiles(false, false);
        assertEquals(ls.size(), 2);
        for (String str : ls)
            assertTrue(str.contains(path));

        ls = dt.getListOfFiles(true, false);
        assertEquals(ls.size(), 3);
        for (String str : ls)
            assertTrue(str.contains(path));

        ls = dt.getListOfFiles(false, true);
        assertEquals(ls.size(), 1);
        for (String str : ls)
            assertTrue(str.contains(path));

        ls = dt.getListOfFiles(true, true);
        assertEquals(ls.size(), 2);
        for (String str : ls)
            assertTrue(str.contains(path));
    }
}
