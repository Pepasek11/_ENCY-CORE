package cz.csob.ency.cds.demands.web.internal.upload;

import com.liferay.document.library.kernel.exception.FileExtensionException;
import com.liferay.document.library.kernel.exception.FileNameException;
import com.liferay.document.library.kernel.exception.FileSizeException;
import com.liferay.document.library.kernel.exception.InvalidFileException;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UploadResponseHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;

@Component(service = CdsDemandUploadResponseHandler.class)
public class CdsDemandUploadResponseHandler implements UploadResponseHandler {

    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandUploadResponseHandler.class);

    @Override
    public JSONObject onFailure(
            PortletRequest portletRequest, PortalException portalException)
            throws PortalException {

        JSONObject jsonObject = _defaultUploadResponseHandler.onFailure(
                portletRequest, portalException);

        String errorMessage = StringPool.BLANK;

        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        if (portalException instanceof FileExtensionException) {
            errorMessage = themeDisplay.translate(
                    "please-enter-a-file-with-a-valid-extension-x",
                    StringUtil.merge(
                            _uploadValidator.getGuestUploadFileExtensions(),
                            StringPool.COMMA_AND_SPACE));
        } else if (portalException instanceof FileNameException) {
            errorMessage = themeDisplay.translate(
                    "please-enter-a-file-with-a-valid-file-name");
        } else if (portalException instanceof FileSizeException) {
            errorMessage = themeDisplay.translate(
                    "please-enter-a-file-with-a-valid-file-size-no-larger-than-x",
                    LanguageUtil.formatStorageSize(
                            _uploadValidator.getGuestUploadMaximumFileSize(),
                            themeDisplay.getLocale()));
        } else if (portalException instanceof InvalidFileException) {
            errorMessage = themeDisplay.translate("please-enter-a-valid-file");
        } else {
            errorMessage = themeDisplay.translate(
                    "an-unexpected-error-occurred-while-uploading-your-file");
            _log.warn(portalException);
        }

        jsonObject.put("error", portalException.getClass().getSimpleName());
        jsonObject.put("message", errorMessage);

        return jsonObject;
    }

    @Override
    public JSONObject onSuccess(
            UploadPortletRequest uploadPortletRequest, FileEntry fileEntry)
            throws PortalException {

        JSONObject jsonObject = _defaultUploadResponseHandler.onSuccess(
                uploadPortletRequest, fileEntry);

        jsonObject.put("file", fileEntry);

        return jsonObject;
    }
    @Reference(target = "(upload.response.handler.system.default=true)")
    private UploadResponseHandler _defaultUploadResponseHandler;
    @Reference
    private CdsDemandUploadValidator _uploadValidator;
}
