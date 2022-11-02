package kr.co_itwill.mediagroup;

public class MediagroupDTO {
    public int getMediagroupno() {
        return mediagroupno;
    }

    public void setMediagroupno(int mediagroupno) {
        this.mediagroupno = mediagroupno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MediagroupDTO{" +
                "mediagroupno=" + mediagroupno +
                ", title='" + title + '\'' +
                '}';
    }

    private int mediagroupno;
    private String title;
}
