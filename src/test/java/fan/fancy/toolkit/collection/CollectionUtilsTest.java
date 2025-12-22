package fan.fancy.toolkit.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * {@link CollectionUtils} 测试类.
 *
 * @author Fan
 */
class CollectionUtilsTest {

    @Nested
    class IsEmptyTests {
        @Test
        void isEmpty_nullCollection_returnsTrue() {
            Assertions.assertTrue(CollectionUtils.isEmpty(null));
        }

        @Test
        void isEmpty_emptyCollection_returnsTrue() {
            Assertions.assertTrue(CollectionUtils.isEmpty(Collections.emptyList()));
        }

        @Test
        void isEmpty_nonEmptyCollection_returnsFalse() {
            Assertions.assertFalse(CollectionUtils.isEmpty(Arrays.asList(1, 2, 3)));
        }

        @Test
        void isNotEmpty_nullCollection_returnsFalse() {
            Assertions.assertFalse(CollectionUtils.isNotEmpty(null));
        }

        @Test
        void isNotEmpty_emptyCollection_returnsFalse() {
            Assertions.assertFalse(CollectionUtils.isNotEmpty(Collections.emptyList()));
        }

        @Test
        void isNotEmpty_nonEmptyCollection_returnsTrue() {
            Assertions.assertTrue(CollectionUtils.isNotEmpty(Arrays.asList(1, 2, 3)));
        }
    }

    @Nested
    class JoinTests {
        @Test
        void join_noDelimiter_returnsJoinedString() {
            List<String> list = Arrays.asList("a", "b", "c");
            Assertions.assertEquals("abc", CollectionUtils.join(list));
        }

        @Test
        void join_nullCollection_returnsEmptyString() {
            Assertions.assertEquals("", CollectionUtils.join(null));
        }

        @Test
        void join_emptyCollection_returnsEmptyString() {
            Assertions.assertEquals("", CollectionUtils.join(Collections.emptyList()));
        }

        @Test
        void join_withDelimiter_returnsDelimitedString() {
            List<String> list = Arrays.asList("a", "b", "c");
            Assertions.assertEquals("a,b,c", CollectionUtils.join(list, ","));
        }

        @Test
        void join_withNullElement_treatsAsEmpty() {
            List<String> list = Arrays.asList("a", null, "c");
            Assertions.assertEquals("a,,c", CollectionUtils.join(list, ","));
        }

        @Test
        void join_withPrefixAndSuffix_returnsFormattedString() {
            List<String> list = Arrays.asList("a", "b", "c");
            Assertions.assertEquals("[a,b,c]", CollectionUtils.join(list, ",", "[", "]"));
        }

        @Test
        void join_emptyCollectionWithPrefixSuffix_returnsEmptyString() {
            Assertions.assertEquals("", CollectionUtils.join(Collections.emptyList(), ",", "[", "]"));
        }

        @Test
        void join_nullCollectionWithPrefixSuffix_returnsEmptyString() {
            Assertions.assertEquals("", CollectionUtils.join(null, ",", "[", "]"));
        }

        @Test
        void join_withNumbers_convertsToString() {
            List<Integer> list = Arrays.asList(1, 2, 3);
            Assertions.assertEquals("1-2-3", CollectionUtils.join(list, "-"));
        }

        @Test
        void joinEach_withPrefixAndSuffix_wrapsEachElement() {
            List<String> list = Arrays.asList("a", "b", "c");
            Assertions.assertEquals("'a','b','c'", CollectionUtils.joinEach(list, ",", "'", "'"));
        }

        @Test
        void joinEach_nullCollection_returnsEmptyString() {
            Assertions.assertEquals("", CollectionUtils.joinEach(null, ",", "'", "'"));
        }

        @Test
        void joinEach_emptyCollection_returnsEmptyString() {
            Assertions.assertEquals("", CollectionUtils.joinEach(Collections.emptyList(), ",", "'", "'"));
        }

        @Test
        void joinEach_withNullElement_treatsAsEmpty() {
            List<String> list = Arrays.asList("a", null, "c");
            Assertions.assertEquals("'a',,'c'", CollectionUtils.joinEach(list, ",", "'", "'"));
        }

        @Test
        void joinEach_withNumbers_convertsAndWraps() {
            List<Integer> list = Arrays.asList(1, 2, 3);
            Assertions.assertEquals("(1),(2),(3)", CollectionUtils.joinEach(list, ",", "(", ")"));
        }

        @Test
        void joinEach_emptyDelimiter_concatenatesWrappedElements() {
            List<String> list = Arrays.asList("a", "b");
            Assertions.assertEquals("[a][b]", CollectionUtils.joinEach(list, "", "[", "]"));
        }
    }
}
