package com.hefei.pay.jd;

import com.jdpaysdk.author.Constants;
import com.jdpaysdk.author.JDPayAuthor;

/**
 * <pre>
 *     author: hefei
 *     time  : 2020/03/16
 *     desc  : 京东支付
 *
 *     // 京东支付请求
 *     JDPayReq jdPayReq = new JDPayReq.Builder()
 *             .with(MainActivity.this)
 *             .setOrderId(orderId)
 *             .setMerchant(merchant)
 *             .setAppId(appId)
 *             .setSignData(signData)
 *             .create();
 *
 *     JDPayAPI.getInstance().sendPayReq(jdPayReq);
 *
 *     在onActivityResult中：
 *
 *     // 京东支付结果回调
 *     if (resultCode == JDPayAPI.PAY_RESPONSE_CODE) {
 *         String jdResult = data.getStringExtra(JDPayAPI.JDP_PAY_RESULT);
 *         try {
 *             JSONObject resultJson = new JSONObject(jdResult);
 *             String payStatus = resultJson.getString(JDPayAPI.JDP_PAY_STATUS);
 *             if (JDPayAPI.JDP_PAY_SUCCESS.equalsIgnoreCase(payStatus)) {
 *                 // 支付成功
 *             } else if (JDPayAPI.JDP_PAY_FAIL.equalsIgnoreCase(payStatus)) {
 *                 // 支付失败
 *             } else if (JDPayAPI.JDP_PAY_CANCEL.equalsIgnoreCase(payStatus)) {
 *                 // 支付取消
 *             }
 *         } catch (JSONException e) {
 *             // 支付失败
 *         }
 *     }
 * </pre>
 */
public class JDPayAPI {

    public static final int PAY_RESPONSE_CODE = Constants.PAY_RESPONSE_CODE;

    public static final String JDP_PAY_RESULT = JDPayAuthor.JDPAY_RESULT;   // 支付结果

    public static final String JDP_PAY_STATUS = "payStatus";                // 支付状态

    public static final String JDP_PAY_SUCCESS = "JDP_PAY_SUCCESS";         // 支付成功
    public static final String JDP_PAY_FAIL = "JDP_PAY_FAIL";               // 支付失败
    public static final String JDP_PAY_CANCEL = "JDP_PAY_CANCEL";           // 支付取消

    /**
     * 获取京东支付API
     */
    private static final Object mLock = new Object();
    private static JDPayAPI mInstance;

    public static JDPayAPI getInstance() {
        if (mInstance == null) {
            synchronized (mLock) {
                if (mInstance == null) {
                    mInstance = new JDPayAPI();
                }
            }
        }
        return mInstance;
    }

    /**
     * 发送京东支付请求
     *
     * @param jdPayReq 请求参数
     */
    public void sendPayReq(JDPayReq jdPayReq) {
        jdPayReq.pay();
    }
}
