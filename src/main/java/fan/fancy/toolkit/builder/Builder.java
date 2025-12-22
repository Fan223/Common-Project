package fan.fancy.toolkit.builder;

/**
 * 建造者模式接口.
 *
 * @param <T> 目标类型
 * @author Fan
 */
public interface Builder<T> {

    /**
     * 建造目标实例.
     *
     * @return {@link T}
     */
    T build();
}
