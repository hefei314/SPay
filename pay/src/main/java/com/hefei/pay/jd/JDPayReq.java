package com.hefei.pay.jd;

import android.app.Activity;

import com.jdpaysdk.author.JDPayAuthor;

/**
 * <pre>
 *     author: hefei
 *     time  : 2020/03/16
 *     desc  : 京东支付请求参数
 * </pre>
 */
public class JDPayReq {

    // 上下文
    private Activity activity;
    // 订单号
    private String orderId;
    // 商户号
    private String merchant;
    // appId
    private String appId;
    // 商户端的验签
    private String signData;
    // 业务数据
    private String extraInfo;

    public JDPayReq(Activity activity, String orderId, String merchant, String appId,
                    String signData, String extraInfo) {
        this.activity = activity;
        this.orderId = orderId;
        this.merchant = merchant;
        this.appId = appId;
        this.signData = signData;
        this.extraInfo = extraInfo;
    }

    /**
     * 京东支付
     */
    public void pay() {
        JDPayAuthor jdPayAuthor = new JDPayAuthor();
        jdPayAuthor.author(activity, orderId, merchant, appId, signData, extraInfo);
    }

    public static class Builder {
        // 上下文
        private Activity activity;
        // 订单号
        private String orderId;
        // 商户号
        private String merchant;
        // appId
        private String appId;
        // 商户端的验签
        private String signData;
        // 业务数据
        private String extraInfo;

        public Builder with(Activity activity) {
            this.activity = activity;
            return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setMerchant(String merchant) {
            this.merchant = merchant;
            return this;
        }

        public Builder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder setSignData(String signData) {
            this.signData = signData;
            return this;
        }

        public Builder setExtraInfo(String extraInfo) {
            this.extraInfo = extraInfo;
            return this;
        }

        public JDPayReq create() {
            return new JDPayReq(
                    this.activity,
                    this.orderId,
                    this.merchant,
                    this.appId,
                    this.signData,
                    this.extraInfo);
        }
    }
}
