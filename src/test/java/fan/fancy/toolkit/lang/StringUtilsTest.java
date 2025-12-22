package fan.fancy.toolkit.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * {@link StringUtils} 测试类.
 *
 * @author Fan
 */
class StringUtilsTest {

    @Test
    void toString_nullOrString_returnsExpected() {
        Assertions.assertNull(StringUtils.toString(null));
        Assertions.assertEquals("test", StringUtils.toString("test"));
        Assertions.assertEquals("123", StringUtils.toString(new StringBuilder("123")));
    }

    @Test
    void toUpperCase_various_returnsUpperCase() {
        Assertions.assertNull(StringUtils.toUpperCase(null));
        Assertions.assertEquals("", StringUtils.toUpperCase(""));
        Assertions.assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        Assertions.assertEquals("HELLO", StringUtils.toUpperCase("HeLLo"));
    }

    @Test
    void toLowerCase_various_returnsLowerCase() {
        Assertions.assertNull(StringUtils.toLowerCase(null));
        Assertions.assertEquals("", StringUtils.toLowerCase(""));
        Assertions.assertEquals("hello", StringUtils.toLowerCase("HELLO"));
        Assertions.assertEquals("hello", StringUtils.toLowerCase("HeLLo"));
    }

    @Test
    void lowerFirst_various_lowersFirstChar() {
        Assertions.assertNull(StringUtils.lowerFirst(null));
        Assertions.assertEquals("", StringUtils.lowerFirst(""));
        Assertions.assertEquals("hello", StringUtils.lowerFirst("Hello"));
        Assertions.assertEquals("hELLO", StringUtils.lowerFirst("HELLO"));
        Assertions.assertEquals("a", StringUtils.lowerFirst("A"));
        Assertions.assertEquals("abc", StringUtils.lowerFirst("abc"));
    }

    @Test
    void upperFirst_various_uppersFirstChar() {
        Assertions.assertNull(StringUtils.upperFirst(null));
        Assertions.assertEquals("", StringUtils.upperFirst(""));
        Assertions.assertEquals("Hello", StringUtils.upperFirst("hello"));
        Assertions.assertEquals("HELLO", StringUtils.upperFirst("HELLO"));
        Assertions.assertEquals("A", StringUtils.upperFirst("a"));
        Assertions.assertEquals("Abc", StringUtils.upperFirst("Abc"));
    }

    @Test
    void toCamelCase_various_returnsCamelCase() {
        Assertions.assertNull(StringUtils.toCamelCase(null));
        Assertions.assertEquals("", StringUtils.toCamelCase(""));
        Assertions.assertEquals("helloWorld", StringUtils.toCamelCase("hello_world"));
        Assertions.assertEquals("helloWorld", StringUtils.toCamelCase("hello-world"));
        Assertions.assertEquals("helloWorldTest", StringUtils.toCamelCase("hello_world_test"));
        Assertions.assertEquals("abc", StringUtils.toCamelCase("ABC"));
    }

    @Test
    void toSnakeCase_various_returnsSnakeCase() {
        Assertions.assertNull(StringUtils.toSnakeCase(null));
        Assertions.assertEquals("", StringUtils.toSnakeCase(""));
        Assertions.assertEquals("hello_world", StringUtils.toSnakeCase("helloWorld"));
        Assertions.assertEquals("hello_world", StringUtils.toSnakeCase("HelloWorld"));
        Assertions.assertEquals("hello_world", StringUtils.toSnakeCase("hello-world"));
        Assertions.assertEquals("a_b_c", StringUtils.toSnakeCase("ABC"));
    }

    @Test
    void toKebabCase_various_returnsKebabCase() {
        Assertions.assertNull(StringUtils.toKebabCase(null));
        Assertions.assertEquals("", StringUtils.toKebabCase(""));
        Assertions.assertEquals("hello-world", StringUtils.toKebabCase("helloWorld"));
        Assertions.assertEquals("hello-world", StringUtils.toKebabCase("HelloWorld"));
        Assertions.assertEquals("hello-world", StringUtils.toKebabCase("hello_world"));
    }

    @Test
    void toUpperSnakeCase_various_returnsUpperSnakeCase() {
        Assertions.assertNull(StringUtils.toUpperSnakeCase(null));
        Assertions.assertEquals("", StringUtils.toUpperSnakeCase(""));
        Assertions.assertEquals("HELLO_WORLD", StringUtils.toUpperSnakeCase("helloWorld"));
        Assertions.assertEquals("HELLO_WORLD", StringUtils.toUpperSnakeCase("HelloWorld"));
    }

    @Test
    void removePrefix_various_removesPrefixIfExists() {
        Assertions.assertNull(StringUtils.removePrefix(null, "pre"));
        Assertions.assertEquals("test", StringUtils.removePrefix("test", null));
        Assertions.assertEquals("test", StringUtils.removePrefix("test", ""));
        Assertions.assertEquals("fix", StringUtils.removePrefix("prefix", "pre"));
        Assertions.assertEquals("prefix", StringUtils.removePrefix("prefix", "suf"));
        Assertions.assertEquals("", StringUtils.removePrefix("pre", "pre"));
        Assertions.assertEquals("ab", StringUtils.removePrefix("ab", "abc"));
    }

    @Test
    void removePrefixAndLowerFirst_various_removesPrefixAndLowersFirst() {
        Assertions.assertNull(StringUtils.removePrefixAndLowerFirst(null, "pre"));
        Assertions.assertEquals("test", StringUtils.removePrefixAndLowerFirst("Test", null));
        Assertions.assertEquals("fix", StringUtils.removePrefixAndLowerFirst("preFix", "pre"));
        Assertions.assertEquals("name", StringUtils.removePrefixAndLowerFirst("getName", "get"));
    }

    @Nested
    class IsEmptyTests {
        @Test
        void isEmpty_nullOrEmpty_returnsTrue() {
            Assertions.assertTrue(StringUtils.isEmpty(null));
            Assertions.assertTrue(StringUtils.isEmpty(""));
        }

        @Test
        void isEmpty_notEmpty_returnsFalse() {
            Assertions.assertFalse(StringUtils.isEmpty("a"));
            Assertions.assertFalse(StringUtils.isEmpty(" "));
        }

        @Test
        void isNotEmpty_nullOrEmpty_returnsFalse() {
            Assertions.assertFalse(StringUtils.isNotEmpty(null));
            Assertions.assertFalse(StringUtils.isNotEmpty(""));
        }

        @Test
        void isNotEmpty_notEmpty_returnsTrue() {
            Assertions.assertTrue(StringUtils.isNotEmpty("a"));
        }
    }

    @Nested
    class IsBlankTests {
        @Test
        void isBlank_nullOrBlank_returnsTrue() {
            Assertions.assertTrue(StringUtils.isBlank(null));
            Assertions.assertTrue(StringUtils.isBlank(""));
            Assertions.assertTrue(StringUtils.isBlank("   "));
            Assertions.assertTrue(StringUtils.isBlank("\t\n"));
        }

        @Test
        void isBlank_notBlank_returnsFalse() {
            Assertions.assertFalse(StringUtils.isBlank("a"));
            Assertions.assertFalse(StringUtils.isBlank(" a "));
        }

        @Test
        void isNotBlank_nullOrBlank_returnsFalse() {
            Assertions.assertFalse(StringUtils.isNotBlank(null));
            Assertions.assertFalse(StringUtils.isNotBlank("  "));
        }

        @Test
        void isNotBlank_notBlank_returnsTrue() {
            Assertions.assertTrue(StringUtils.isNotBlank("a"));
        }
    }
}