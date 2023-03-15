package cz.csob.ency.modules.e3.entry.utils.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import cz.csob.ency.modules.e3.entry.model.E3Entry;

public class EntryModifiedDateComparator extends OrderByComparator<E3Entry> {

    public static final String ORDER_BY_ASC =
            "E3Entry.modifiedDate ASC, E3Entry.entryId ASC";

    public static final String[] ORDER_BY_CONDITION_FIELDS = {"modifiedDate"};

    public static final String ORDER_BY_DESC =
            "E3Entry.modifiedDate DESC, E3Entry.entryId DESC";

    public static final String[] ORDER_BY_FIELDS = {"modifiedDate", "entryId"};

    public EntryModifiedDateComparator() {
        this(false);
    }

    public EntryModifiedDateComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(E3Entry entry1, E3Entry entry2) {
        int value = DateUtil.compareTo(
                entry1.getModifiedDate(), entry2.getModifiedDate());

        if (value == 0) {
            if (entry1.getEntryId() < entry2.getEntryId()) {
                value = -1;
            } else if (entry1.getEntryId() > entry2.getEntryId()) {
                value = 1;
            }
        }

        if (_ascending) {
            return value;
        }

        return -value;
    }

    @Override
    public String getOrderBy() {
        if (_ascending) {
            return ORDER_BY_ASC;
        }

        return ORDER_BY_DESC;
    }

    @Override
    public String[] getOrderByConditionFields() {
        return ORDER_BY_CONDITION_FIELDS;
    }

    @Override
    public String[] getOrderByFields() {
        return ORDER_BY_FIELDS;
    }

    @Override
    public boolean isAscending() {
        return _ascending;
    }

    private final boolean _ascending;

}
