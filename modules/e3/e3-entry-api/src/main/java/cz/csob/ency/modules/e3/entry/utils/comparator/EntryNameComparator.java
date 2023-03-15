package cz.csob.ency.modules.e3.entry.utils.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import cz.csob.ency.modules.e3.entry.model.E3Entry;

public class EntryNameComparator extends OrderByComparator<E3Entry> {

    public static final String ORDER_BY_ASC = "E3Entry.name ASC";

    public static final String ORDER_BY_DESC = "E3Entry.name DESC";

    public static final String[] ORDER_BY_FIELDS = {"name"};

    public EntryNameComparator() {
        this(false);
    }

    public EntryNameComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(E3Entry entry1, E3Entry entry2) {
        String title1 = entry1.getName();
        String title2 = entry2.getName();

        int value = title1.compareTo(title2);

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
    public String[] getOrderByFields() {
        return ORDER_BY_FIELDS;
    }

    @Override
    public boolean isAscending() {
        return _ascending;
    }

    private final boolean _ascending;


}
