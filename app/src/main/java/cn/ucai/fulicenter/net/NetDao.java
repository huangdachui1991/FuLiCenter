package cn.ucai.fulicenter.net;

import android.content.Context;

import cn.ucai.fulicenter.I;
import cn.ucai.fulicenter.bean.NewGoodsBean;

/**
 * Created by huangdachui on 2016/10/18.
 */
public class NetDao {
    public static void downloadNewGoods(Context context,int pageId,OkHttpUtils.OnCompleteListener listener){
        OkHttpUtils utils=new OkHttpUtils(context);
        utils.setRequestUrl(I.REQUEST_FIND_NEW_BOUTIQUE_GOODS)
            .addParam(I.NewAndBoutiqueGoods.CAT_ID,String.valueOf(I.CAT_ID))
            .addParam(I.PAGE_SIZE,String.valueOf(I.PAGE_SIZE_DEFAULT))
            .targetClass(NewGoodsBean[].class)
            .execute(listener);
    }
}
