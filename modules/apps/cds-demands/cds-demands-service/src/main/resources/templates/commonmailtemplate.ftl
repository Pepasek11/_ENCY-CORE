<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>${mailInfo}</title>
</head>
<body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" offset="0"
      style="-webkit-text-size-adjust: none;margin: 0;padding: 0;width: 100%;">
<div style="margin: 0 auto">
    <table style="width:96%; background-color: #f8f8f8; border-color: #ccc; border-width: 1px 1px 1px 1px; border-style:solid;box-shadow: 3px 3px 6px 1px rgba(0,0,0,0.3); border-radius:6px; padding:4px; margin: 8px">
        <tr style="height:54px; background-color:#003164; padding:16px">
            <td style="padding-top:8px;">
                <div style="color: #fff; padding-left:16px; padding-bottom:0px;">

                    <span style="font-family: Arial,sans-serif; text-decoration: none; color: #fff;">${mailInfo}</span>
                    <br>
                    <br>
                    <div style="text-decoration: none; color: #fff; font-size:20px; font-family: Arial,sans-serif;">${entryName}</div>
                </div>
            </td>
        </tr>
        <tr>
            <td style="padding:16px;">
                <div style="color:rgba(0, 0, 0, 0.84); font-size: 100%; font-weight: 400; text-align:left; font-family: Arial,sans-serif;">
                    ${mailContent}
                </div>
                <#if entryLink?has_content>
                <table style="width:100%;">
                    <tr style="width:100%;">
                        <td align="center" bgcolor="#9C27B0"
                            style="font-size:12px; width:220px; background: #09c; padding-top: 6px; padding-right: 7px; padding-bottom: 6px; padding-left: 7px; -webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; font-weight:bold; text-decoration: none; font-family: Arial, sans-serif; ">
                            <a id="share_btn" href="${entryLink}"
                               style="color: #fff; text-decoration: none; padding: 8px 16px;">Přejít na stránku v
                                Ency</a></td>
                        <td></td>
                    </tr>
                </table>
                </#if>
                <br>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
