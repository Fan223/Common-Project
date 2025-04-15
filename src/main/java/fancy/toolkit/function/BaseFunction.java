package fancy.toolkit.function;

import java.io.Serializable;

/**
 * 基础函数式接口.
 *
 * @author Fan
 * @since 2025/2/21 14:28
 */
@FunctionalInterface
public interface BaseFunction<T, R> extends Serializable {

    R apply(T t);
}
