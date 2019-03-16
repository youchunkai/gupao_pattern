package com.gupaoedu.proxy.dynamicProxy.gpProxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:KEVIN
 * Time:2019/3/16
 */
public class GPProxy {

    public static final String ln = "\r\n ";

    /*newProxyInstance
    * 该方法就是用来 获得一个代理对象
    * */
    public static Object newProxyInstance(GPClassLoader gpClassLoader, Class[] interfaces, GPInvocationHandler h) {


        //D:\code\项目搭建\designpattern\src\main\java\com\gupaoedu\proxy\dynamicProxy\gpProxy
        //1:动态生成 java文件

        //2 Java文件输出磁盘

        //3 把生成的java文件编译成 class文件

        //4 编译生成的class文件加载到jvm中来

        //5 返回字节码重组以后的新的代理对象
        try {
            String src = generateSrc(interfaces);

            String filePath = GPProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter writer = new FileWriter(file);
            writer.write(src);
            writer.flush();
            writer.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null,null,iterable);
            task.call();
            manager.close();

            Class proxyClass = gpClassLoader.findClass(file.getName());
            Constructor constructor = proxyClass.getConstructor(GPInvocationHandler.class);
            file.delete();

            return constructor.newInstance(h);

        } catch (Exception e) {

        }

        return null;
    }

    private static String generateSrc(Class[] interfaces) {

        StringBuffer sb = new StringBuffer();
        System.out.println(interfaces[0].getResource("/"));
        System.out.println(interfaces[0].getName());
        System.out.println(interfaces[0].getPackage());
        sb.append(interfaces[0].getPackage() + ";" + ln);
        // 导入实现的接口包
        for (int i = 0; i < interfaces.length; i++) {
            sb.append("import " + interfaces[i].getName() + ";" + ln);
        }
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements ");
        for (int i = 0; i < interfaces.length; i++) {
            sb.append(interfaces[i].getSimpleName());
            if(i < interfaces.length-1){
                sb.append(",");
            }else{
                sb.append(" {" + ln);
            }
        }

        sb.append("GPInvocationHandler h;" + ln);
        sb.append("public $Proxy0(GPInvocationHandler h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);

        for (Class clz:interfaces ) {

            for (Method m : clz.getMethods()) {
                Class<?>[] params = m.getParameterTypes();

                StringBuffer paramNames = new StringBuffer();
                StringBuffer paramValues = new StringBuffer();
                StringBuffer paramClasses = new StringBuffer();

                for (int i = 0; i < params.length; i++) {
                    Class clazz = params[i];
                    String type = clazz.getName();
                    String paramName = toLowerFirstCase(clazz.getSimpleName());
                    paramNames.append(type + " " +  paramName);
                    paramValues.append(paramName);
                    paramClasses.append(clazz.getName() + ".class");
                    if(i > 0 && i < params.length-1){
                        paramNames.append(",");
                        paramClasses.append(",");
                        paramValues.append(",");
                    }
                }

                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
                sb.append("try{" + ln);
                sb.append("Method m = " + clz.getSimpleName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
                sb.append((hasReturn(m.getReturnType()) ? " " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
                sb.append("}catch(Error ex) { }");
                sb.append("catch(Throwable e){" + ln);
                sb.append("throw new UndeclaredThrowableException(e);" + ln);
                sb.append("}");
                //sb.append(getReturnEmptyCode(m.getReturnType()));
                sb.append("}");
            }
            sb.append("}" + ln);

        }

        return sb.toString();

    }

    private static boolean hasReturn(Class<?> clazz){
        return clazz != Void.class;
    }


    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == Void.class){
            return "";
        }else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }


    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
