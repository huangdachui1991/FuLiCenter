package cn.ucai.fulicenter.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.fragment.NewGoodsFragment;
import cn.ucai.fulicenter.utils.L;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.layout_new_goods)
    RadioButton layoutNewGoods;
    @Bind(R.id.layout_boutique)
    RadioButton layoutBoutique;
    @Bind(R.id.layout_category)
    RadioButton layoutCategory;
    @Bind(R.id.layout_cart)
    RadioButton layoutCart;
    @Bind(R.id.layout_personal_center)
    RadioButton layoutPersonalCenter;

    RadioButton[] radiobtn;
    int index;
    int currentIndex;
    Fragment[] mFragments;
    NewGoodsFragment mNewGoodsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initFragment();
    }

    private void initFragment() {
        mFragments=new Fragment[5];
        mNewGoodsFragment=new NewGoodsFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container,new NewGoodsFragment())
                .show(mNewGoodsFragment)
                .commit();
    }

    private void initView() {
        radiobtn=new RadioButton[5];
        radiobtn[0]=layoutNewGoods;
        radiobtn[1]=layoutBoutique;
        radiobtn[2]=layoutCategory;
        radiobtn[3]=layoutCart;
        radiobtn[4]=layoutPersonalCenter;
    }

    public void onCheckedChange(View view) {
        switch (view.getId()){
            case R.id.layout_new_goods:
                index=0;
                break;
            case R.id.layout_boutique:
                index=1;
                break;
            case R.id.layout_category:
                index=2;
                break;
            case R.id.layout_cart:
                index=3;
                break;
            case R.id.layout_personal_center:
                index=4;
                break;
        }
        if(index!=currentIndex){
            setRadioButtonStatus();
            currentIndex=index;
        }
    }

    private void setRadioButtonStatus() {
        for(int i=0;i<radiobtn.length;i++){
            if(i==index){
                radiobtn[i].setChecked(true);
            }else{
                radiobtn[i].setChecked(false);
            }
        }
    }


}
