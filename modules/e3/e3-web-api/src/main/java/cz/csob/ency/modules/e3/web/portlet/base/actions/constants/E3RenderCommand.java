package cz.csob.ency.modules.e3.web.portlet.base.actions.constants;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.RenderRequest;
import java.util.Locale;

public class E3RenderCommand {


    public final static String EMPTY_COMMAND = "/";
    public final static String VIEW_COMMAND = "/e3/view";
    public final static String VIEW_ENTRY_COMMAND = "/e3/view_entry";
    public final static String EDIT_ENTRY_COMMAND = "/e3/edit_entry";

    public final static E3RenderCommand EMPTY = new E3RenderCommand();
    public final static E3RenderCommand VIEW = new E3RenderCommand(VIEW_COMMAND);
    public final static E3RenderCommand VIEW_ENTRY = new E3RenderCommand(VIEW_ENTRY_COMMAND);
    public final static E3RenderCommand EDIT_ENTRY = new E3RenderCommand(EDIT_ENTRY_COMMAND);

    private final static String VIEW_PATH = "/e3/view.jsp";
    private final static String VIEW_ENTRY_PATH = "/e3/view_entry.jsp";
    private final static String EDIT_ENTRY_PATH = "/e3/edit_entry.jsp";

    private String _name;

    public E3RenderCommand() {
        _name = EMPTY_COMMAND;
    }

    /**
     * Construct E3 MVC Render Command. E3 MVC Render Command names are
     * always lower case names that begin with path /e3/, except of the empty command.
     **/
    public E3RenderCommand(String mvcRenderCommandName) {
        init(mvcRenderCommandName);
    }

    private void init(String mvcRenderCommandName) {
        if (Validator.isBlank(mvcRenderCommandName)
                || mvcRenderCommandName.equals(EMPTY_COMMAND))
            _name = EMPTY_COMMAND;
        else if (!mvcRenderCommandName.startsWith("/e3/"))
            _name = "/e3/" + mvcRenderCommandName.toLowerCase(Locale.ROOT);
        else
            _name = mvcRenderCommandName.toLowerCase(Locale.ROOT);
    }

    public E3RenderCommand(RenderRequest renderRequest) {
        String mvcRenderCommandName = ParamUtil.getString(
                renderRequest, "mvcRenderCommandName", EMPTY_COMMAND);
        init(mvcRenderCommandName);
    }

    public String getDefaultPath() {
        if (this.equals(EMPTY) || this.equals(VIEW)) {
            return VIEW_PATH;
        } else if (this.equals(VIEW_ENTRY)) {
            return VIEW_ENTRY_PATH;
        } else if (this.equals(EDIT_ENTRY)) {
            return EDIT_ENTRY_PATH;
        }

        return StringPool.BLANK;
    }

    /**
     * Returns a String representation of this E3 MVC Render Command. E3 MVC Render Command names are
     * always lower case names that begin with path /e3/, except of the empty command.
     *
     * @return String representation of this E3 MVC Render Command
     */
    public String toString() {
        return _name;
    }

    /**
     * Returns the hash code value for this portlet mode. The hash code is constructed by producing the hash value of the
     * String value of this mode.
     *
     * @return hash code value for this portlet mode
     */

    public int hashCode() {
        return _name.hashCode();
    }

    /**
     * Compares the specified object with this portlet mode for equality. Returns <code>true</code> if the Strings
     * <code>equals</code> method for the String representing the two portlet modes returns <code>true</code>.
     *
     * @param object the portlet mode to compare this portlet mode with
     * @return true, if the specified object is equal with this portlet mode
     */

    public boolean equals(Object object) {
        if (object instanceof E3RenderCommand)
            return _name.equals(((E3RenderCommand) object)._name);
        else if (object instanceof String)
            return _name.equals((String) object);
        else
            return false;
    }
}
