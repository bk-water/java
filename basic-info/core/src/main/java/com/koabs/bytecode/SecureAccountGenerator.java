package com.koabs.bytecode;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

/**
 * @Author koabs
 * @Date 2018/11/29.
 * @Describe
 */
public class SecureAccountGenerator {
    private static class AccountGeneratorClassLoader extends ClassLoader {
        public Class defineClassFromClassFile(String className,
                                              byte[] classFile) throws ClassFormatError {
            return defineClass("Account$EnhancedByASM", classFile, 0,
                    classFile.length);
        }
    }


    private static AccountGeneratorClassLoader classLoader =
            new AccountGeneratorClassLoader();

    private static Class secureAccountClass;

    public Account generateSecureAccount() throws Exception {
        if (null == secureAccountClass) {
            ClassReader cr = new ClassReader("com.koabs.bytecode.Account");
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassAdapter classAdapter = new AddSubSecurityCheckClassAdapter(cw);
            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
            byte[] data = cw.toByteArray();
            secureAccountClass = classLoader.defineClassFromClassFile(
                    "Account$EnhancedByASM",data);
        }
        return (Account) secureAccountClass.newInstance();
    }


}
