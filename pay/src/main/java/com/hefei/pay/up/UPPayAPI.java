package com.hefei.pay.up;

/**
 * <pre>
 *     author: hefei
 *     time  : 2020/03/16
 *     desc  : 银联支付-普通支付
 *
 *     // 银联支付请求
 *     UPPayReq upPayReq = new UPPayReq.Builder()
 *             .with(MainActivity.this)
 *             .setTn(tn)
 *             .setServerMode(UPPayReq.UP_SERVER_MODE_OFFICIAL)
 *             .create();
 *
 *     UPPayAPI.getInstance().sendPayReq(upPayReq);
 *
 *     在onActivityResult中：
 *
 *     // 银联支付结果回调
 *     String result = data.getStringExtra(UPPayAPI.UP_PAY_RESULT);
 *     if (UPPayAPI.UP_PAY_SUCCESS.equalsIgnoreCase(result)) {
 *         // 支付成功
 *     } else if (UPPayAPI.UP_PAY_FAIL.equalsIgnoreCase(result)) {
 *         // 支付失败
 *     } else if (UPPayAPI.UP_PAY_CANCEL.equalsIgnoreCase(result)) {
 *         // 支付取消
 *     }
 * </pre>
 */
public class UPPayAPI {

    public static final String UP_PAY_RESULT = "pay_result";        // 支付结果

    public static final String UP_PAY_SUCCESS = "success";          // 支付成功
    public static final String UP_PAY_FAIL = "fail";                // 支付失败
    public static final String UP_PAY_CANCEL = "cancel";            // 支付取消

    /**
     * 获取银联支付API
     */
    private static final Object mLock = new Object();
    private static UPPayAPI mInstance;

    public static UPPayAPI getInstance() {
        if (mInstance == null) {
            synchronized (mLock) {
                if (mInstance == null) {
                    mInstance = new UPPayAPI();
                }
            }
        }
        return mInstance;
    }

    /**
     * 发送银联支付请求
     *
     * @param upPayReq 请求参数
     */
    public void sendPayReq(UPPayReq upPayReq) {
        upPayReq.pay();
    }
}
