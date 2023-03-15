package cz.csob.ency.workflow.definition;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.workflow.annotation.EncyWorkflowState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultEncyWorkflowStateDefinition implements EncyWorkflowStateDefinition {
    private final static Log _log = LogFactoryUtil.getLog(DefaultEncyWorkflowStateDefinition.class);

    public DefaultEncyWorkflowStateDefinition(
            EncyWorkflowState nodeAnnotation) {
        init(nodeAnnotation);
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
    public String getCssLabelColor() {
        return this._cssLabelColor;
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public String getTitle(String languageId) {
        return _title;
    }

    @Override
    public final List<EncyWorkflowTransitionDefinition> getTransitions() {
        return this._transitions;
    }

    @Override
    public boolean isEditable() {
        return this._editable;
    }

    @Override
    public boolean isFinal() {
        return this._final;
    }

    @Override
    public boolean isInitial() {
        return this._initial;
    }

    @Override
    public boolean isPermanent() {
        return this._permanent;
    }

    @Override
    public boolean isSearchable() {
        return this._searchable;
    }

    @Override
    public String toString() {
        return "DefaultEncyWorkflowStateDefinition{" +
                "_cssIcon='" + _cssIcon + '\'' +
                ", _cssIconColor='" + _cssIconColor + '\'' +
                ", _cssLabelColor='" + _cssLabelColor + '\'' +
                ", _editable='" + _editable + '\'' +
                ", _description='" + _description + '\'' +
                ", _final=" + _final +
                ", _initial=" + _initial +
                ", _name='" + _name + '\'' +
                ", _permanent='" + _permanent + '\'' +
                ", _searchable='" + _searchable + '\'' +
                ", _title='" + _title + '\'' +
                ", _transitions=" + _transitions +
                '}';
    }

    private void init(EncyWorkflowState state) {

        this._cssIcon = state.cssIcon();
        this._cssIconColor = state.cssIconColor();
        this._cssLabelColor = state.cssLabelColor();
        this._description = state.description();
        this._editable = state.isEditable();
        this._final = state.isFinal();
        this._initial = state.isInitial();
        this._name = state.name();
        this._permanent = state.isPermanent();
        this._searchable = state.isSearchable();
        this._title = state.title();

        AtomicLong order = new AtomicLong(1000);
        Arrays.stream(state.transitions()).sequential().forEach(transition -> {
            // @todo catch init errors from nodes/transitions creation

            EncyWorkflowTransitionDefinition transitionEntry =
                    new DefaultEncyWorkflowTransitionDefinition(transition, this._name);

            if (transitionEntry.getOrder() <= 0) {
                transitionEntry.setOrder(order.getAndAdd(1000));
            }

            _transitions.add(transitionEntry);
        });
    }

    private String _cssIcon;
    private String _cssIconColor;
    private String _cssLabelColor;
    private String _description;
    private boolean _editable;
    private boolean _final;
    private boolean _initial;
    private String _name;
    private boolean _permanent;
    private boolean _searchable;
    private String _title;
    private List<EncyWorkflowTransitionDefinition> _transitions = new ArrayList<>();

}
