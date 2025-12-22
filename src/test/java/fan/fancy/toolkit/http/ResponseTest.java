package fan.fancy.toolkit.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * {@link Response} 测试类.
 *
 * @author Fan
 */
class ResponseTest {

    @Test
    void constructor_nullMessage_throwsException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Response<>(200, null, "data"));
    }

    @Test
    void of_withHttpStatus_createsResponseWithStatusCodeAndMessage() {
        Response<String> response = Response.of(HttpStatus.OK, "data");

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals("OK", response.message());
        Assertions.assertEquals("data", response.data());
    }

    @Test
    void of_withCodeAndMessage_createsResponseWithNullData() {
        Response<String> response = Response.of(404, "Not Found");

        Assertions.assertEquals(404, response.code());
        Assertions.assertEquals("Not Found", response.message());
        Assertions.assertNull(response.data());
    }

    @Test
    void success_noArgs_returnsSuccessResponseWithNullData() {
        Response<Object> response = Response.success();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals("OK", response.message());
        Assertions.assertNull(response.data());
    }

    @Test
    void success_withData_returnsSuccessResponseWithData() {
        Response<String> response = Response.success("result");

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals("OK", response.message());
        Assertions.assertEquals("result", response.data());
    }

    @Test
    void success_withMessageAndData_returnsCustomSuccessResponse() {
        Response<String> response = Response.success("Custom message", "data");

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals("Custom message", response.message());
        Assertions.assertEquals("data", response.data());
    }

    @Test
    void fail_noArgs_returnsFailResponseWithDefaultMessage() {
        Response<Object> response = Response.fail();

        Assertions.assertEquals(500, response.code());
        Assertions.assertEquals("Internal Server Error", response.message());
        Assertions.assertNull(response.data());
    }

    @Test
    void fail_withMessage_returnsFailResponseWithCustomMessage() {
        Response<Object> response = Response.fail("Error occurred");

        Assertions.assertEquals(500, response.code());
        Assertions.assertEquals("Error occurred", response.message());
    }

    @Test
    void fail_withCodeAndMessage_returnsCustomFailResponse() {
        Response<Object> response = Response.fail(503, "Service unavailable");

        Assertions.assertEquals(503, response.code());
        Assertions.assertEquals("Service unavailable", response.message());
    }

    @Test
    void badRequest_withMessage_returns400Response() {
        Response<Object> response = Response.badRequest("Invalid input");

        Assertions.assertEquals(400, response.code());
        Assertions.assertEquals("Invalid input", response.message());
    }

    @Test
    void unauthorized_withMessage_returns401Response() {
        Response<Object> response = Response.unauthorized("Auth required");

        Assertions.assertEquals(401, response.code());
        Assertions.assertEquals("Auth required", response.message());
    }

    @Test
    void forbidden_withMessage_returns403Response() {
        Response<Object> response = Response.forbidden("Access denied");

        Assertions.assertEquals(403, response.code());
        Assertions.assertEquals("Access denied", response.message());
    }

    @Test
    void notFound_withMessage_returns404Response() {
        Response<Object> response = Response.notFound("Resource not found");

        Assertions.assertEquals(404, response.code());
        Assertions.assertEquals("Resource not found", response.message());
    }

    @Test
    void isSuccess_with2xxCode_returnsTrue() {
        Assertions.assertTrue(Response.of(200, "OK").isSuccess());
        Assertions.assertTrue(Response.of(201, "Created").isSuccess());
        Assertions.assertTrue(Response.of(299, "Custom").isSuccess());
    }

    @Test
    void isSuccess_withNon2xxCode_returnsFalse() {
        Assertions.assertFalse(Response.of(199, "Message").isSuccess());
        Assertions.assertFalse(Response.of(300, "Message").isSuccess());
        Assertions.assertFalse(Response.of(400, "Message").isSuccess());
        Assertions.assertFalse(Response.of(500, "Message").isSuccess());
    }

    @Test
    void isFail_with2xxCode_returnsFalse() {
        Assertions.assertFalse(Response.of(200, "OK").isFail());
    }

    @Test
    void isFail_withNon2xxCode_returnsTrue() {
        Assertions.assertTrue(Response.of(400, "Bad Request").isFail());
        Assertions.assertTrue(Response.of(500, "Error").isFail());
    }
}