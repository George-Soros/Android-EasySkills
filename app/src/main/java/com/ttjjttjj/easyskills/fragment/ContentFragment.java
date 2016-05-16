package com.ttjjttjj.easyskills.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ttjjttjj.easyskills.R;
import com.ttjjttjj.easyskills.Utils.EditTextUtils;
import com.ttjjttjj.easyskills.Utils.TextViewUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/4/27 0027.
 */
public class ContentFragment extends Fragment {


    @Bind(R.id.edit_show)
    EditText mEditShow;
    @Bind(R.id.txt_sepcial)
    TextView mTextSpecial;
    @Bind(R.id.str_test)
    TextView mStrTest;
    @Bind(R.id.test_filesize)
    TextView mTestFileSize;

    private static final String TAG = "ContentFragment";

    private Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //避免使用getActivity的时候，出现空指针，利用全局的变量
        this.mActivity = activity;
    }

    /**这个onAttach(Content context) 6.0才能使用, 如果在低版本会不执行*/
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        //避免使用getActivity的时候，出现空指针，利用全局的变量
//        this.mActivity = (Activity)context;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LayoutInflater layoutInflater = LayoutInflater.from(mActivity);
        View view = layoutInflater.inflate(R.layout.fragment_txt, null);
        ButterKnife.bind(this, view);

        setEditKeySoft();

        initEvent();

        initData();

        return view;
    }

    private void setEditKeySoft(){
        EditTextUtils.getSoftKey(mEditShow, mActivity);
        Toast.makeText(mActivity, "软键盘打开了", Toast.LENGTH_SHORT).show();
    }

    private void initEvent(){
        mTextSpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "点击了", Toast.LENGTH_SHORT).show();
                TextViewUtils.setNotClick(mTextSpecial);
            }
        });
    }

    private void initData(){

        /** 测试 "%!$s" 的使用*/
        mStrTest.setText(String.format(
                getString(R.string.client_update_version), "1.0"));

        /**计算filesize*/
        mTestFileSize.setText("文件大小:"+
                Formatter.formatShortFileSize(mActivity, 3456789));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
