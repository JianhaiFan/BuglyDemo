package com.xiaofan.buglydemo.application;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by fanjianhai on 2017/5/21.
 */

public class SampleApplication extends TinkerApplication {

    public SampleApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.xiaofan.buglydemo.application.SampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
