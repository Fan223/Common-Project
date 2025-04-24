package fancy.toolkit.function;

import fancy.toolkit.reflect.ReflectUtils;
import fancy.toolkit.text.StringUtils;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

/**
 * {@code Lambda} 工具类.
 *
 * @author Fan
 * @since 2025/2/21 14:32
 */
public class LambdaUtils {

    private LambdaUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 获取方法名.
     *
     * @param func 函数式接口
     * @return {@link String}
     * @author Fan
     * @since 2025/2/24 9:35
     */
    public static <T> String getMethodName(BaseFunction<T, ?> func) {
        return resolve(func).getImplMethodName();
    }

    /**
     * 解析获取 {@link SerializedLambda} 对象
     *
     * @param func {@link Serializable} 对象
     * @return {@link SerializedLambda}
     * @author Fan
     * @since 2025/2/24 9:36
     */
    private static SerializedLambda resolve(Serializable func) {
        // Lambda 表达式序列化时, JVM 会添加一个 writeReplace() 方法, 返回一个 SerializedLambda, 真正被序列化的对象
        // 该对象包含了 Lambda 表达式的所有信息, 比如函数名 implMethodName 等
        return ReflectUtils.invoke(func, "writeReplace");
    }

    /**
     * 获取字段名.
     *
     * @param func 函数式接口
     * @return {@link String}
     * @author Fan
     * @since 2025/2/24 9:48
     */
    public static <T> String getFieldName(BaseFunction<T, ?> func) {
        String methodName = getMethodName(func);
        if (methodName.startsWith("get") || methodName.startsWith("set")) {
            return StringUtils.removePrefixAndLowerFirst(methodName, methodName.substring(0, 3));
        } else if (methodName.startsWith("is")) {
            return StringUtils.removePrefixAndLowerFirst(methodName, methodName.substring(0, 2));
        } else {
            throw new IllegalArgumentException("Invalid Getter or Setter name: " + methodName);
        }
    }
}
