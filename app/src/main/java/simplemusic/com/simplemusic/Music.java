package simplemusic.com.simplemusic;

/**
 * Created by ITAsset on 5/22/17.
 */

public class Music {
    private String title;
    private String description;
    private int albumImg;

    public Music(String title, String description, int albumImg) {
        this.title = title;
        this.description = description;
        this.albumImg = albumImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAlbumImg() {
        return albumImg;
    }

    public void setAlbumImg(int albumImg) {
        this.albumImg = albumImg;
    }
}
