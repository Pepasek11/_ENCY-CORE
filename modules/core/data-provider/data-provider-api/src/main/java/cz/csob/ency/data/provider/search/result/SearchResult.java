package cz.csob.ency.data.provider.search.result;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonSerialize
public class SearchResult<T> implements Serializable {
    public SearchResult() {
        _properties = new HashMap<>();
    }

    @JsonIgnore
    public SearchResult fail(String message) {
        _errorMessage = message;
        return this;
    }

    @JsonIgnore
    public SearchResult fail(Throwable error) {
        _success = false;
        _errorMessage = error.getMessage();
        return this;
    }

    public T getData() {
        return _data;
    }

    public SearchResult setData(T data) {
        _data = data;
        return this;
    }

    public String getErrorMessage() {
        return _errorMessage;
    }

    public SearchResult setErrorMessage(String errorMessage) {
        if (!Validator.isBlank(errorMessage)) {
            fail(errorMessage);
        }
        return this;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return _properties;
    }

    public SearchResult setProperties(Map<String, String> properties) {
        _properties = properties;
        return this;
    }

    public long getResultsEnd() {
        return _resultsEnd;
    }

    @JsonIgnore
    public SearchResult setResultsEnd(long resultsEnd) {
        _resultsEnd = resultsEnd;
        return this;
    }

    public long getResultsStart() {
        return _resultsStart;
    }

    public SearchResult setResultsStart(long resultsStart) {
        this._resultsStart = resultsStart;
        return this;
    }

    public boolean getSuccess() {
        return _success;
    }

    public long getTotalResults() {
        return _totalResults;
    }

    @JsonIgnore
    public SearchResult setTotalResults(long totalResults) {
        _totalResults = totalResults;
        return this;
    }

    @JsonIgnore
    public SearchResult setProperty(String name, String value) {
        _properties.put(name, value);
        return this;
    }

    private T _data;
    private String _errorMessage = StringPool.BLANK;
    private Map<String, String> _properties;
    private long _resultsEnd = -1;
    private long _resultsStart = -1;
    private boolean _success = true;
    private long _totalResults = 0;
}
