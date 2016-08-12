
package yi.music;

import yi.music.util.LogUtil;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SearchFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        LogUtil.d("MineFragment onCreate");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.d("MineFragment onViewCreated");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.d("MineFragment onCreateView");
        return inflater.inflate(R.layout.fragement_search, null);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        LogUtil.d("MineFragment onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("MineFragment onCreate");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d("MineFragment onCreate");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.d("MineFragment onCreate");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.d("MineFragment onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.d("MineFragment onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d("MineFragment onCreate");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.d("MineFragment onCreate");
    }

}
