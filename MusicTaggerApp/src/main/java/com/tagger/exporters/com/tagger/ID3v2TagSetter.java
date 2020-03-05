package com.tagger.exporters.com.tagger;

import com.mpatric.mp3agic.ID3v2;

public interface ID3v2TagSetter {
    void setTag(ID3v2 tag, String value);
}
