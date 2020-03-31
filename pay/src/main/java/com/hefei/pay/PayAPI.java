package com.hefei.pay;

import com.hefei.pay.ali.AliPayAPI;
import com.hefei.pay.ali.AliPayReq;
import com.hefei.pay.up.UPPayAPI;
import com.hefei.pay.up.UPPayReq;

/**
 * <pre>
 *     author: hefei
 *     time  : 2020/03/16
 *     desc  : 支付API
 * </pre>
 */
public class PayAPI {

    private static final Object mLock = new Object();
    private static PayAPI mInstance;

    public static PayAPI getInstance() {
        if (mInstance == null) {
            synchronized (mLock) {
                if (mInstance == null) {
                    mInstance = new PayAPI();
                }
            }
        }
        return mInstance;
    }

    /**
     * 支付宝支付请求
     *
     * @param aliPayReq 请求参数
     */
    public void sendPayRequest(AliPayReq aliPayReq) {
        AliPayAPI.getInstance().sendPayReq(aliPayReq);
    }

    /**
     * 银联支付请求
     *
     * @param upPayReq 请求参数
     */
    public void sendPayRequest(UPPayReq upPayReq) {
        UPPayAPI.getInstance().sendPayReq(upPayReq);
    }
}
