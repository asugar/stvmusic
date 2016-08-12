
package yi.music;

public enum MainTab {

    ME(1, R.string.mine_songs, R.drawable.ic_upward_mine, MineFragment.class),

    DISCOVERY(2, R.string.discovery_songs, R.drawable.ic_upward_discovery, DiscoveryFragment.class),
    
    MAIN(0, R.string.main_songs, R.drawable.e, MainFragment.class),

    SEARCH(3, R.string.search_songs, R.drawable.ic_upward_search, SearchFragment.class),

    LOCAL(4, R.string.local_songs, R.drawable.ic_upward_local, LocalFragment.class);

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
