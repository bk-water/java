package com.koabs.bytecode;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @Author koabs
 * @Date 2018/11/28.
 * @Describe
 */
public class AddSecurityCheckMethodAdapter extends MethodAdapter {

    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
        super(mv);
    }

    public void visitCode() {
        visitMethodInsn(Opcodes.INVOKESTATIC, "com.koabs.bytecode.SecurityChecker",
                "checkSecurity", "()V");
    }

}
