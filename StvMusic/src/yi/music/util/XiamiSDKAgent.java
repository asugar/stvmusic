
package yi.music.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Pair;

import com.stv.music.service.Song;
import com.stv.music.util.Logger;
import com.stv.music.util.Util;
import com.xiami.music.model.RadioCategory;
import com.xiami.sdk.XiamiSDK;
import com.xiami.sdk.callback.StringCallback;
import com.xiami.sdk.entities.OnlineAlbum;
import com.xiami.sdk.entities.OnlineArtist;
import com.xiami.sdk.entities.OnlineCollect;
import com.xiami.sdk.entities.OnlineSong;
import com.xiami.sdk.entities.QueryInfo;
import com.xiami.sdk.entities.RankType;

public class XiamiSDKAgent {
    private static final String TAG = XiamiSDKAgent.class.getSimpleName();

    private static final String KEY = "b46e35ab936cf5b2ab45ca09c4f8f565";
    private static final String SECRET = "ffdec960843e2ba41633520b0184048d";

    private static final int RADIO_SOOTHING_TYPE_ID = 16;
    private static final long RADIO_SOOTHING_ID = 7;

    public static final int DEFAULT_RADIO_TYPE = RADIO_SOOTHING_TYPE_ID;
    public static final long DEFAULT_RADIO_ID = RADIO_SOOTHING_ID;

    public static final int DEFAULT_PAGE_SIZE = 20; // Range 20..50
    public static final int DEFAULT_FIRST_PAGE_INDEX = 0;

    private static XiamiSDK mXiamiSDK;
    private static XiamiSDKAgent mXiamiSDKAgent;

    private XiamiSDKAgent() {

    }

    private XiamiSDKAgent(Context context) {
        mXiamiSDK = new XiamiSDK(context, KEY, SECRET);
        mXiamiSDK.enableLog(true);
        Logger.d(TAG, "XiamiSDK enableLog true");
    }

    public static XiamiSDKAgent getInstance(Context context) {
        if (mXiamiSDKAgent == null) {
            mXiamiSDKAgent = new XiamiSDKAgent(context);
        }
        return mXiamiSDKAgent;
    }

    private Bitmap readAPIC(String filePath, Options options) {
        return mXiamiSDK.readAPIC(filePath, options);
    }

    private Map<String, String> readFileTags(String filePath) {
        return mXiamiSDK.readFileTags(filePath);
    }

    public Pair<QueryInfo, List<OnlineAlbum>> getWeekHotAlbumsSync(int pageSize, int pageIndex) {
        return mXiamiSDK.getWeekHotAlbumsSync(pageSize, pageIndex);
    }

    public List<OnlineSong> getRecommendSongsSync() {
        List<OnlineSong> OnlineSongs = null;
        try {
            OnlineSongs = mXiamiSDK.getRecommendSongsSync();
        } catch (Exception e) {
            Logger.w(TAG, "getRecommendSongsSync", e);
        }
        if (OnlineSongs == null) {
            OnlineSongs = new ArrayList<OnlineSong>();
        }
        return OnlineSongs;
    }

    public Pair<QueryInfo, java.util.List<OnlineCollect>> getCollectsRecommendSync(int pageSize, int pageIndex) {
        return mXiamiSDK.getCollectsRecommendSync(pageSize, pageIndex);
    }

    public List<RadioCategory> fetchRadioListsSync() {
        return mXiamiSDK.fetchRadioListsSync();
    }

    public OnlineAlbum getAlbumsDetailSync(long albumId) {
        return mXiamiSDK.getAlbumsDetailSync(albumId);
    }

    public OnlineCollect getCollectDetailSync(long collectId) {
        return mXiamiSDK.getCollectDetailSync(collectId);
    }

    public List<OnlineSong> getRankSongsSync(RankType rankType) {
        return mXiamiSDK.getRankSongsSync(rankType);
    }

    public Pair<QueryInfo, List<OnlineSong>> searchSongSync(String keywords) {
        return searchSongSync(keywords, DEFAULT_PAGE_SIZE, DEFAULT_FIRST_PAGE_INDEX);
    }

    public Pair<QueryInfo, List<OnlineSong>> searchSongSync(String keywords, int pageSize, int pageIndex) {
        pageSize = compareDefaultPageSize(pageSize);
        return mXiamiSDK.searchSongSync(keywords, pageSize, pageIndex);
    }

    public Pair<QueryInfo, List<OnlineArtist>> searchArtistsSync(String keywords) {
        return searchArtistsSync(keywords, DEFAULT_PAGE_SIZE, DEFAULT_FIRST_PAGE_INDEX);
    }

    public Pair<QueryInfo, List<OnlineArtist>> searchArtistsSync(String keywords, int pageSize, int pageIndex) {
        pageSize = compareDefaultPageSize(pageSize);
        return mXiamiSDK.searchArtistsSync(keywords, pageSize, pageIndex);
    }

    public Pair<QueryInfo, List<OnlineAlbum>> searchAlbumsSync(String keywords) {
        return searchAlbumsSync(keywords, DEFAULT_PAGE_SIZE, DEFAULT_FIRST_PAGE_INDEX);
    }

    public Pair<QueryInfo, List<OnlineAlbum>> searchAlbumsSync(String keywords, int pageSize, int pageIndex) {
        pageSize = compareDefaultPageSize(pageSize);
        return mXiamiSDK.searchAlbumsSync(keywords, pageSize, pageIndex);
    }

    public List<OnlineSong> findSongByNameSync(String songName, String artistName, String albumName) {
        return mXiamiSDK.findSongByNameSync(songName, artistName, albumName);
    }

    public void getLrcBySongId(long songId, StringCallback callback) {
        mXiamiSDK.getLrcBySongId(songId, callback);
    }

    public List<OnlineSong> fetchSongsByArtistIdSync(long id) {
        return mXiamiSDK.fetchSongsByArtistIdSync(id);
    }

    public Pair<QueryInfo, List<OnlineSong>> fetchSongsByArtistIdSync(long artistId, int pageSize, int pageIndex) {
        return mXiamiSDK.fetchSongsByArtistIdSync(artistId, pageSize, pageIndex);
    }

    public OnlineSong findSongByIdSync(long id) {
        return findSongByIdSync(id, OnlineSong.Quality.L);
    }

    private OnlineSong findSongByIdSync(long id, OnlineSong.Quality quality) {
        return mXiamiSDK.findSongByIdSync(id, quality);
    }

    public List<OnlineSong> getDefaultRadioSync() {
        return fetchRadioDetailSync(DEFAULT_RADIO_TYPE, DEFAULT_RADIO_ID);
    }

    public List<OnlineSong> fetchRadioDetailSync(int radioType, long radioId) {
        List<OnlineSong> onlineSongs = null;
        for (int i = 0; i < 10; i++) {
            onlineSongs = mXiamiSDK.fetchRadioDetailSync(radioType, radioId);
            if (onlineSongs != null && onlineSongs.size() > 0) {
                break;
            }
        }
        return onlineSongs;
    }

    public OnlineArtist fetchArtistDetailSync(long artistId) {
        return mXiamiSDK.fetchArtistDetailSync(artistId);
    }

    public Pair<QueryInfo, List<OnlineAlbum>> fetchAlbumsByArtistIdSync(long artistId, int pageSize, int pageIndex) {
        return mXiamiSDK.fetchAlbumsByArtistIdSync(artistId, pageSize, pageIndex);
    }

    public List<OnlineArtist> getRelatedArtist(int artistId, int limit) {
        List<OnlineArtist> artists = mXiamiSDK.getRelatedArtist(artistId, limit);
        return artists;
    }

    public Bitmap readSongTags(Song song) {
        String path = song.getPath();
        if (Util.isOnlineSong(path) || TextUtils.isEmpty(path)) {
            return null;
        }
        Bitmap bitmap = readAPIC(path, new BitmapFactory.Options());
        Map<String, String> tags = readFileTags(path);
        if (tags != null) {
            song.setTitle(tags.get("TITLE"));
            song.setAlbum(tags.get("ALBUM"));
            song.setArtist(tags.get("SINGER"));
        }
        return bitmap;
    }

    private int compareDefaultPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }
}
