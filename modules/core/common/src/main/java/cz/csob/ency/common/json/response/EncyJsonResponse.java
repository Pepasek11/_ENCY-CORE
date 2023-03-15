package cz.csob.ency.common.json.response;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

import java.util.Collection;
import java.util.Map;

public class EncyJsonResponse {

    public EncyJsonResponse(Object data) {
        this.data = data;
        this.success = true;
    }


    public EncyJsonResponse(boolean success, Object data) {
        setData(data);
        setSuccess(success);
    }

    public EncyJsonResponse(boolean success, String message, Object data) {
        setData(data);
        setSuccess(success);
        setMessage(message);
    }

    public EncyJsonResponse(boolean success, String message, String error, Object data) {
        setData(data);
        setSuccess(success);
        setMessage(message);
        setError(error);
    }

    public EncyJsonResponse(Exception exception) {
        setData(StringPool.BLANK);
        setError(exception.getMessage());
        setMessage(exception.getMessage());
        setSuccess(false);
    }

    public static EncyJsonResponse failure(String message) {
        return new EncyJsonResponse(false, message);
    }

    public static EncyJsonResponse failure(Exception exception) {
        return new EncyJsonResponse(exception);
    }

    public static EncyJsonResponse failure(String message, Exception exception) {
        return new EncyJsonResponse(false, message, exception.getMessage(), null);
    }

    public static EncyJsonResponse success(Object data) {
        return new EncyJsonResponse(true, "success", data);
    }

    public static EncyJsonResponse success(String message, Object data) {
        return new EncyJsonResponse(true, message, data);
    }

    public Object getData() {
        return data;
    }

    public EncyJsonResponse setData(Object data) {
//        if (data instanceof Map) {
//            this.data = JSONFactoryUtil.createJSONObject((Map<?, ?>) data);
//        } else if (data instanceof Collection) {
//            this.data = JSONFactoryUtil.createJSONArray((Collection<?>) data);
//        } else {
            this.data = data;
//        }
        return this;
    }

    public String getError() {
        return error;
    }

    public EncyJsonResponse setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public EncyJsonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public EncyJsonResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    private Object data = StringPool.BLANK;
    private String error = null;
    private String message = StringPool.BLANK;
    private boolean success = false;

}
