/*
 * Copyright 2023 李冲. All rights reserved.
 *
 */

package work.lichong.test.config;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeSerialization;
import work.lichong.test.MybatisPlusNativeApplication;
import work.lichong.test.controller.TestController;
import work.lichong.test.service.UserService;

/**
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 2023/11/01 23:01
 */
public class LambdaRegistrationFeature implements Feature {

    @Override
    public void duringSetup(DuringSetupAccess access) {
        // TODO 这里需要将lambda表达式所使用的成员类都注册上来,具体情况视项目情况而定,一般扫描@Controller和@Service的会多点.
        RuntimeSerialization.registerLambdaCapturingClass(MybatisPlusNativeApplication.class);
        RuntimeSerialization.registerLambdaCapturingClass(TestController.class);
        RuntimeSerialization.registerLambdaCapturingClass(UserService.class);
    }

}
