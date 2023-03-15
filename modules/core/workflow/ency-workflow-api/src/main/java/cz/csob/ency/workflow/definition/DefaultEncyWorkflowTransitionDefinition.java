package cz.csob.ency.workflow.definition;

import cz.csob.ency.workflow.annotation.EncyWorkflowTransition;

public class DefaultEncyWorkflowTransitionDefinition implements EncyWorkflowTransitionDefinition {

    public DefaultEncyWorkflowTransitionDefinition(EncyWorkflowTransition transitionAnnotation, String parentNodeName) {
        this._sourceStateName = parentNodeName;
        init(transitionAnnotation);
    }

    @Override
    public String getCssIcon() {
        return this._cssIcon;
    }

    @Override
    public String getCssIconColor() {
        return this._cssIconColor;
    }

    @Override
    public String getDescription() {
        return this._description;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public long getOrder() {
        return this._order;
    }

    @Override
    public void setOrder(long order) {
        this._order = order;
    }

    @Override
    public String getSourceStateName() {
        return _sourceStateName;
    }

    @Override
    public String getTargetStateName() {
        return _targetStateName;
    }

    @Override
    public String getTitle() {
        return this._title;
    }

    private void init(EncyWorkflowTransition transition) {
        this._cssIcon = transition.cssIcon();
        this._cssIconColor = transition.cssIconColor();
        this._description = transition.description();
        this._targetStateName = transition.targetStateName();
        this._name = transition.name();
        this._title = transition.title();
        this._order = transition.order();
    }

    private String _cssIcon;
    private String _cssIconColor;
    private String _description;
    private String _name;
    private long _order;
    private String _sourceStateName = "";
    private String _targetStateName = "";
    private String _title;

}
