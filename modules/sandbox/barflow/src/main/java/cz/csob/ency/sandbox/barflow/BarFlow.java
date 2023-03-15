package cz.csob.ency.sandbox.barflow;

import cz.csob.ency.workflow.annotation.EncyWorkflow;
import cz.csob.ency.workflow.annotation.EncyWorkflowState;
import cz.csob.ency.workflow.annotation.EncyWorkflowTransition;
import cz.csob.ency.workflow.definition.BaseEncyWorkflowDefinition;
import cz.csob.ency.workflow.definition.EncyWorkflowDefinition;
import org.osgi.service.component.annotations.Component;

@EncyWorkflow(
        title = "Bar Flow Testing Worflow",
        description = "Single approver bar workflow. ",
        nodes = {
                @EncyWorkflowState(
                        name = "draft",
                        title = "Draft",
                        isInitial = true,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = "approve",
                                        title = "Approve",
                                        targetStateName = "published",
                                        cssIcon = "icon-ok",
                                        cssIconColor = "#008000"

                                ),
                                @EncyWorkflowTransition(
                                        name = "reject",
                                        title = "Reject",
                                        targetStateName = "rejected",
                                        cssIcon = "icon-remove",
                                        cssIconColor="#ff0000"
                                )
                        }
                ),
                @EncyWorkflowState(
                        name = "published",
                        title = "Published",
                        isFinal = true,
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = "update",
                                        title = "Update",
                                        targetStateName = "draft",
                                        cssIcon = "icon-reply",
                                        cssIconColor = "#008000"

                                )
                        }
                ),
                @EncyWorkflowState(
                        name = "rejected",
                        title = "Rejected",
                        isFinal = true
                )
                /*
                ,
                @EncyWorkflowState(
                        name = "tmp",
                        title = "tmp",
                        description = "Toto je popis",
                        cssIcon = "icon-times",
                        cssIconColor = "#123456",
                        cssLabelColor = "#654321",
                        transitions = {
                                @EncyWorkflowTransition(
                                        name = "tmp1",
                                        title = "tmp",
                                        description = "Toto je popis",
                                        cssIcon = "icon-times",
                                        cssIconColor = "#123456",
                                        targetStateName = "rejected"
                                )
                        }
                )
                 */
        }
)
@Component(immediate = true, service = EncyWorkflowDefinition.class)
public class BarFlow extends BaseEncyWorkflowDefinition {
}
