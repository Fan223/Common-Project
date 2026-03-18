package fan.fancy.toolkit.builder;

import com.sun.source.tree.Tree;
import fan.fancy.toolkit.collection.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@link Tree} 建造者类.
 *
 * @param <T> 树节点类型
 * @param <K> 树节点 ID 类型
 * @author Fan
 */
public final class TreeBuilder<T, K> implements Builder<List<T>> {

    /**
     * 树节点列表.
     */
    private final List<T> source;

    /**
     * 树节点 ID 获取器.
     */
    private final Function<T, K> idGetter;

    /**
     * 树节点父 ID 获取器.
     */
    private final Function<T, K> parentIdGetter;

    /**
     * 树节点子节点获取器.
     */
    private final Function<T, List<T>> childrenGetter;

    /**
     * 全参构造方法.
     *
     * @param source         树节点列表
     * @param idGetter       树节点 ID 获取器
     * @param parentIdGetter 树节点父 ID 获取器
     * @param childrenGetter 树节点子节点获取器
     */
    private TreeBuilder(List<T> source,
                        Function<T, K> idGetter,
                        Function<T, K> parentIdGetter,
                        Function<T, List<T>> childrenGetter) {
        this.source = source;
        this.idGetter = idGetter;
        this.parentIdGetter = parentIdGetter;
        this.childrenGetter = childrenGetter;
    }

    /**
     * 返回 {@link TreeBuilder} 实例.
     *
     * @param source         树节点列表
     * @param idGetter       树节点 ID 获取器
     * @param parentIdGetter 树节点父 ID 获取器
     * @param childrenGetter 树节点子节点获取器
     * @param <T>            树节点类型
     * @param <K>            树节点 ID 类型
     * @return {@link TreeBuilder}
     */
    public static <T, K> TreeBuilder<T, K> builder(List<T> source,
                                                   Function<T, K> idGetter,
                                                   Function<T, K> parentIdGetter,
                                                   Function<T, List<T>> childrenGetter) {
        return new TreeBuilder<>(source, idGetter, parentIdGetter, childrenGetter);
    }

    @Override
    public List<T> build() {
        if (CollectionUtils.isEmpty(source)) {
            return source;
        }
        // 把节点列表转换为 Map
        Map<K, T> map = source.stream().collect(Collectors.toMap(idGetter, Function.identity(), (a, _) -> a));

        List<T> tree = new ArrayList<>();
        for (T node : source) {
            // 获取当前节点的父节点
            K parentId = parentIdGetter.apply(node);
            T parent = map.get(parentId);

            // 父节点为空, 则当前节点为顶级节点, 直接添加到树形列表中.
            if (parent == null) {
                tree.add(node);
            } else {
                // 父节点不为空, 则将当前节点添加到父节点的子节点中.
                childrenGetter.apply(parent).add(node);
            }
        }
        return tree;
    }
}
