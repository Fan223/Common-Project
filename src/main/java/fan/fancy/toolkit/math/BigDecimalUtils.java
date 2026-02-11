package fan.fancy.toolkit.math;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

/**
 * {@link BigDecimal} 工具类.
 *
 * @author Fan
 */
@UtilityClass
public class BigDecimalUtils {

    public static BigDecimal toBigDecimal(Object value) {
        switch (value) {
            case null -> throw new IllegalArgumentException("值不能为空!");
            case BigDecimal bigDecimal -> {
                return bigDecimal;
            }
            case Integer i -> {
                return BigDecimal.valueOf(i);
            }
            case Long l -> {
                return BigDecimal.valueOf(l);
            }
            case Short s -> {
                return BigDecimal.valueOf(s.longValue());
            }
            case Byte b -> {
                return BigDecimal.valueOf(b.longValue());
            }
            case Double v -> {
                return BigDecimal.valueOf(v);
            }
            case Float f -> {
                return BigDecimal.valueOf(f.doubleValue());
            }
            case String s -> {
                String str = s.trim();
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("字符串为空!");
                }
                return new BigDecimal(str);
            }
            // 兜底 Number
            case Number n -> {
                // 转字符串避免精度问题
                return new BigDecimal(n.toString());
            }
            default -> throw new IllegalArgumentException("BigDecimal 不支持的转换类型: " + value.getClass());
        }
    }
}
