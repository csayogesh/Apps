package com.tagger.exporters.com.tagger;

import com.mpatric.mp3agic.ID3v2;

public enum ID3v2Tag implements ID3v2TagGetter, ID3v2TagSetter {
    Track {
        public void setTag(ID3v2 tag, String value) {
            tag.setTrack(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getTrack();
        }
    }, Artist {
        public void setTag(ID3v2 tag, String value) {
            tag.setArtist(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getArtist();
        }
    }, Title {
        public void setTag(ID3v2 tag, String value) {
            tag.setTitle(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getTitle();
        }
    }, Album {
        public void setTag(ID3v2 tag, String value) {
            tag.setAlbum(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getAlbum();
        }
    }, Year {
        public void setTag(ID3v2 tag, String value) {
            tag.setYear(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getYear();
        }
    }, Genre {
        public void setTag(ID3v2 tag, String value) {
            tag.setGenre(Integer.parseInt(value));
        }

        public String getTag(ID3v2 tag) {
            return String.valueOf(tag.getGenre());
        }
    }, Comment {
        public void setTag(ID3v2 tag, String value) {
            tag.setComment(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getComment();
        }
    }, Lyrics {
        public void setTag(ID3v2 tag, String value) {
            tag.setLyrics(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getLyrics();
        }
    }, Composer {
        public void setTag(ID3v2 tag, String value) {
            tag.setComposer(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getComposer();
        }
    }, Publisher {
        public void setTag(ID3v2 tag, String value) {
            tag.setPublisher(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getPublisher();
        }
    }, OriginalArtist {
        public void setTag(ID3v2 tag, String value) {
            tag.setOriginalArtist(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getOriginalArtist();
        }
    }, AlbumArtist {
        public void setTag(ID3v2 tag, String value) {
            tag.setAlbumArtist(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getAlbumArtist();
        }
    },
    Copyright {
        public void setTag(ID3v2 tag, String value) {
            tag.setCopyright(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getCopyright();
        }
    }, Url {
        public void setTag(ID3v2 tag, String value) {
            tag.setUrl(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getUrl();
        }
    }, Encoder {
        public void setTag(ID3v2 tag, String value) {
            tag.setEncoder(value);
        }

        public String getTag(ID3v2 tag) {
            return tag.getEncoder();
        }
    };
}
