package fan.fancy.toolkit.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * {@link CharUtils} 测试类.
 *
 * @author Fan
 */
class CharUtilsTest {

    @Test
    void isUpperCase_uppercaseChars_returnsTrue() {
        Assertions.assertTrue(CharUtils.isUpperCase('A'));
        Assertions.assertTrue(CharUtils.isUpperCase('Z'));
    }

    @Test
    void isUpperCase_lowercaseOrOtherChars_returnsFalse() {
        Assertions.assertFalse(CharUtils.isUpperCase('a'));
        Assertions.assertFalse(CharUtils.isUpperCase('1'));
        Assertions.assertFalse(CharUtils.isUpperCase(' '));
    }

    @Test
    void toUpperCase_lowercaseChar_returnsUppercase() {
        Assertions.assertEquals('A', CharUtils.toUpperCase('a'));
        Assertions.assertEquals('Z', CharUtils.toUpperCase('z'));
    }

    @Test
    void toUpperCase_alreadyUppercase_returnsUnchanged() {
        Assertions.assertEquals('A', CharUtils.toUpperCase('A'));
        Assertions.assertEquals('1', CharUtils.toUpperCase('1'));
    }

    @Test
    void toLowerCase_uppercaseChar_returnsLowercase() {
        Assertions.assertEquals('a', CharUtils.toLowerCase('A'));
        Assertions.assertEquals('z', CharUtils.toLowerCase('Z'));
    }

    @Test
    void toLowerCase_alreadyLowercase_returnsUnchanged() {
        Assertions.assertEquals('a', CharUtils.toLowerCase('a'));
        Assertions.assertEquals('1', CharUtils.toLowerCase('1'));
    }

    @Nested
    class IsBlankTests {
        @Test
        void isBlank_whitespaceChars_returnsTrue() {
            Assertions.assertTrue(CharUtils.isBlank(' '));
            Assertions.assertTrue(CharUtils.isBlank('\t'));
            Assertions.assertTrue(CharUtils.isBlank('\n'));
            Assertions.assertTrue(CharUtils.isBlank('\r'));
        }

        @Test
        void isBlank_nonWhitespaceChars_returnsFalse() {
            Assertions.assertFalse(CharUtils.isBlank('a'));
            Assertions.assertFalse(CharUtils.isBlank('Z'));
            Assertions.assertFalse(CharUtils.isBlank('0'));
        }

        @Test
        void isNotBlank_whitespaceChars_returnsFalse() {
            Assertions.assertFalse(CharUtils.isNotBlank(' '));
            Assertions.assertFalse(CharUtils.isNotBlank('\t'));
        }

        @Test
        void isNotBlank_nonWhitespaceChars_returnsTrue() {
            Assertions.assertTrue(CharUtils.isNotBlank('a'));
            Assertions.assertTrue(CharUtils.isNotBlank('1'));
        }
    }
}
