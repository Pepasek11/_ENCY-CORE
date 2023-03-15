package cz.csob.ency.cds.demands.web.internal.upload;

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.document.library.kernel.exception.FileExtensionException;
import com.liferay.document.library.kernel.exception.FileSizeException;
import com.liferay.document.library.kernel.exception.InvalidFileException;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringUtil;
import cz.csob.ency.cds.demands.configuration.CdsDemandsConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Component(
        configurationPid = "cz.csob.ency.cds.demands.configuration.CdsDemandsConfiguration",
        service = CdsDemandUploadValidator.class
)
public class CdsDemandUploadValidator {
    private static final long _FILE_LENGTH_MB = 1024 * 1024;

    public String[] getGuestUploadFileExtensions() {
        return cdsDemandConfiguration.allowedAttachmentsFileExtensions();
    }

    public long getGuestUploadMaximumFileSize() {

        return cdsDemandConfiguration.maxAttachmentSize() * _FILE_LENGTH_MB;
    }

    public void validateFileExtension(String fileName)
            throws FileExtensionException {

        List<String> guestUploadFileExtensions = Arrays.asList(
                getGuestUploadFileExtensions());

        Stream<String> guestUploadFileExtensionStream =
                guestUploadFileExtensions.stream();

        Optional<String> guestUploadFileExtensionOptional =
                guestUploadFileExtensionStream.filter(
                        guestUploadFileExtension -> StringUtil.equalsIgnoreCase(
                                FileUtil.getExtension(fileName),
                                StringUtil.trim(guestUploadFileExtension))
                ).findFirst();

        if (!guestUploadFileExtensionOptional.isPresent()) {
            throw new FileExtensionException(
                    "Invalid file extension for " + fileName);
        }
    }

    public void validateFileSize(File file, String fileName)
            throws FileSizeException, InvalidFileException {

        if (file == null) {
            throw new InvalidFileException("File is null for " + fileName);
        }

        long guestUploadMaximumFileSize = getGuestUploadMaximumFileSize();

        if (file.length() > guestUploadMaximumFileSize) {
            throw new FileSizeException(
                    StringBundler.concat(
                            "File ", fileName,
                            " exceeds the maximum permitted size of ",
                            (double) guestUploadMaximumFileSize / _FILE_LENGTH_MB,
                            " MB"));
        }
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        cdsDemandConfiguration = Configurable.createConfigurable(
                CdsDemandsConfiguration.class, properties);
    }

    protected volatile CdsDemandsConfiguration cdsDemandConfiguration;
}
