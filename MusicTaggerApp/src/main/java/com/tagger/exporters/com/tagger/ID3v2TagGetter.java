package com.tagger.exporters.com.tagger;

import com.mpatric.mp3agic.ID3v2;

public interface ID3v2TagGetter {
    String getTag(ID3v2 tag);
}
