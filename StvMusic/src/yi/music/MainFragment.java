
package yi.music;

import yi.music.util.LogUtil;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        LogUtil.d("MainFragment onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.d("MainFragment onCreateView");
        return inflater.inflate(R.layout.fragement_main, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.d("MainFragment onViewCreated");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        LogUtil.d("MainFragment onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d("MainFragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.d("MainFragment onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("MainFragment onDestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.d("MainFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.d("MainFragment onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.d("MainFragment onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d("MainFragment onDestroyView");
    }

}
