package com.hefei.pay.up;

import android.app.Activity;

import com.unionpay.UPPayAssistEx;

/**
 * <pre>
 *     author: hefei
 *     time  : 2020/03/16
 *     desc  : 银联支付请求参数
 * </pre>
 */
public class UPPayReq {

    public static final String UP_SERVER_MODE_TEST = "01";
    public static final String UP_SERVER_MODE_OFFICIAL = "00";

    // 上下文
    private Activity activity;
    // 订单号
    private String tn;
    // 支付环境
    // “00” – 银联正式环境
    // “01” – 银联测试环境，该环境中不发生真实交易
    private String serverMode;

    public UPPayReq(Activity activity, String tn, String serverMode) {
        this.activity = activity;
        this.tn = tn;
        this.serverMode = serverMode;
    }

    /**
     * 银联支付
     */
    public void pay() {
        UPPayAssistEx.startPay(activity, null, null, tn, serverMode);
    }

    public static class Builder {
        // 上下文
        private Activity activity;
        // 订单号
        private String tn;
        // 支付环境
        // “00” – 银联正式环境
        // “01” – 银联测试环境，该环境中不发生真实交易
        private String serverMode = UP_SERVER_MODE_OFFICIAL;

        public Builder with(Activity activity) {
            this.activity = activity;
            return this;
        }

        public Builder setTn(String tn) {
            this.tn = tn;
            return this;
        }

        public Builder setServerMode(String serverMode) {
            this.serverMode = serverMode;
            return this;
        }

        public UPPayReq create() {
            return new UPPayReq(
                    this.activity,
                    this.tn,
                    this.serverMode);
        }
    }
}
