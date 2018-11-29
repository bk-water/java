package com.koabs.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * @Author koabs
 * @Date 2018/11/29.
 * @Describe
 */
public class APP {

    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
        // 添加Transformer
        inst.addTransformer(new FirstAgent());
    }

}
