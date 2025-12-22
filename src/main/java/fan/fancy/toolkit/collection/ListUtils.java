package fan.fancy.toolkit.collection;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@link List} 工具类.
 *
 * @author Fan
 */
@UtilityClass
public class ListUtils {

    /**
     * 使用传入的元素创建一个可变的 {@link List}.
     *
     * @param elements 元素
     * @param <E>      元素类型
     * @return {@link List}
     */
    @SafeVarargs
    public static <E> List<E> of(E... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }
}
