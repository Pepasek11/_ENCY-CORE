package cz.csob.ency.workflow.entry.model;

import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

public interface EncyWorkflowedModel<T> extends BaseModel<T> {
    String getState();

    long getStateByUserId();

    String getStateByUserName();

    String getStateByUserUuid();

    Date getStateDate();

    void setState(String state);

    void setStateByUserId(long userId);

    void setStateByUserName(String userName);

    void setStateByUserUuid(String userUuid);

    void setStateDate(Date date);

    long getPrimaryKey();

    long getCompanyId();

    long getGroupId();
}
