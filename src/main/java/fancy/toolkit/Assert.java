package fancy.toolkit;

import java.util.function.Supplier;

/**
 * 断言工具类. 断言某些对象或值是否符合规范, 否则抛出异常, 用于变量验证.
 *
 * @author Fan
 * @since 2025/2/19 10:49
 */
public class Assert {

    private Assert() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 断言对象是否为空, 如果不为空则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.isNull(value); </pre>
     *
     * @param obj 要检查的对象
     * @author Fan
     * @since 2025/2/19 11:03
     */
    public static <T> void isNull(T obj) {
        isNull(obj, "The parameter must be null.");
    }

    /**
     * 断言对象是否为空, 如果不为空则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.isNull(value, "The value must be null"); </pre>
     *
     * @param obj     要检查的对象
     * @param message 异常信息
     * @param args    异常信息参数
     * @author Fan
     * @since 2025/2/19 11:06
     */
    public static <T> void isNull(T obj, String message, Object... args) {
        isNull(obj, () -> new IllegalArgumentException(String.format(message, args)));
    }

    /**
     * 断言对象是否为空, 如果不为空则抛出由 {@link Supplier} 提供的异常.
     * <pre>
     *     Assert.isNull("value", () -> {
     *         // To query relation message.
     *         return new IllegalArgumentException("Relation message to return.");
     *     });
     * </pre>
     *
     * @param obj      要检查的对象
     * @param supplier 异常提供者
     * @author Fan
     * @since 2025/2/19 11:07
     */
    public static <T, X extends Throwable> void isNull(T obj, Supplier<? extends X> supplier) throws X {
        if (null != obj) {
            throw supplier.get();
        }
    }

    /**
     * 断言对象是否不为空, 如果为空则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.isNotNull(value); </pre>
     *
     * @param obj 要检查的对象
     * @return {@link T}
     * @author Fan
     * @since 2025/2/19 11:16
     */
    public static <T> T isNotNull(T obj) {
        return isNotNull(obj, "The parameter must not be null.");
    }

    /**
     * 断言对象是否不为空, 如果为空则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.isNotNull(value, "The value must not be null"); </pre>
     *
     * @param obj     要检查的对象
     * @param message 异常信息
     * @param args    异常信息参数
     * @return {@link T}
     * @author Fan
     * @since 2025/2/19 11:17
     */
    public static <T> T isNotNull(T obj, String message, Object... args) {
        return isNotNull(obj, () -> new IllegalArgumentException(String.format(message, args)));
    }

    /**
     * 断言对象是否不为空, 如果为空则抛出由 {@link Supplier} 提供的异常.
     * <pre>
     *     Assert.isNull("value", () -> {
     *         // To query relation message.
     *         return new IllegalArgumentException("Relation message to return.");
     *     });
     * </pre>
     *
     * @param obj      要检查的对象
     * @param supplier 异常提供者
     * @return {@link T}
     * @author Fan
     * @since 2025/2/19 11:12
     */
    public static <T, X extends Throwable> T isNotNull(T obj, Supplier<? extends X> supplier) throws X {
        if (null == obj) {
            throw supplier.get();
        }
        return obj;
    }

    /**
     * 断言是否为真, 如果不为真则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.isTrue(i > 0); </pre>
     *
     * @param expression 要检查的表达式
     * @author Fan
     * @since 2025/2/19 11:53
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "The expression must be true.");
    }

    /**
     * 断言是否为真, 如果不为真则抛出 {@link IllegalArgumentException} 异常.
     * <pre> Assert.isTrue(i > 0, "The value must be greater than zero."); </pre>
     *
     * @param expression 要检查的表达式
     * @param message    异常信息
     * @param args       异常信息参数
     * @author Fan
     * @since 2025/2/19 11:54
     */
    public static void isTrue(boolean expression, String message, Object... args) {
        isTrue(expression, () -> new IllegalArgumentException(String.format(message, args)));
    }

    /**
     * 断言是否为真, 如果不为真则抛出由 {@link Supplier} 提供的异常.
     * <pre> Assert.isTrue(i > 0, IllegalArgumentException::new); </pre>
     *
     * @param expression 要检查的表达式
     * @param supplier   异常提供者
     * @author Fan
     * @since 2025/2/19 11:50
     */
    public static <X extends Throwable> void isTrue(boolean expression, Supplier<? extends X> supplier) throws X {
        if (!expression) {
            throw supplier.get();
        }
    }

    /**
     * 断言值是否在指定范围内, 如果不在则抛出 {@link IllegalArgumentException} 异常.
     *
     * @param value 要检查的值
     * @param min   最小值
     * @param max   最大值
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 14:16
     */
    public static long checkBetween(long value, long min, long max) {
        return checkBetween(value, min, max, "The value must be between %d and %d.");
    }

    /**
     * 断言值是否在指定范围内, 如果不在则抛出 {@link IllegalArgumentException} 异常.
     *
     * @param value   要检查的值
     * @param min     最小值
     * @param max     最大值
     * @param message 异常信息
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 14:16
     */
    public static long checkBetween(long value, long min, long max, String message) {
        return checkBetween(value, min, max, () -> new IllegalArgumentException(String.format(message, min, max)));
    }

    /**
     * 断言值是否在指定范围内, 如果不在则抛出由 {@link Supplier} 提供的异常.
     *
     * @param value    要检查的值
     * @param min      最小值
     * @param max      最大值
     * @param supplier 异常提供者
     * @return {@code long}
     * @author Fan
     * @since 2025/2/19 11:57
     */
    public static <X extends Throwable> long checkBetween(long value, long min, long max, Supplier<? extends X> supplier) throws X {
        if (value < min || value > max) {
            throw supplier.get();
        }
        return value;
    }
}
