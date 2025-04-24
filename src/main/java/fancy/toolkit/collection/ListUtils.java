package fancy.toolkit.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@link List} 工具类.
 *
 * @author Fan
 * @since 2025/2/17 16:04
 */
public class ListUtils {

    private ListUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 通过参数构建 {@link List}.
     *
     * @param items 列表元素
     * @return {@link List<T>}
     * @author Fan
     * @since 2025/2/17 16:21
     */
    @SafeVarargs
    public static <T> List<T> of(T... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}
