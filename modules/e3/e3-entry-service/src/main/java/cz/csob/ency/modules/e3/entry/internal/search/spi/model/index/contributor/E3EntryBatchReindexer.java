package cz.csob.ency.modules.e3.entry.internal.search.spi.model.index.contributor;

public interface E3EntryBatchReindexer {
    public void reindex(String appClass, long companyId);
}
