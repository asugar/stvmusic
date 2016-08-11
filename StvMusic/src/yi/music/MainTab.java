
package yi.music;

import android.support.v4.app.Fragment;

public enum MainTab {

    ME(0, R.string.mine_songs, R.drawable.ic_upward_mine, Fragment.class),

    DISCOVERY(0, R.string.discovery_songs, R.drawable.ic_upward_discovery, Fragment.class),

    SEARCH(0, R.string.search_songs, R.drawable.ic_upward_search, Fragment.class),

    LOCAL(0, R.string.local_songs, R.drawable.ic_upward_local, Fragment.class);

    private int index;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MainTab(int index, int resName, int resIcon, Class<?> clz) {
        this.index = index;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }

}
