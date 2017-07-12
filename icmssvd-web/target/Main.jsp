<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
 	
 		<jsp:include page="/pages/restricted/application.jsp" >
 		 	<jsp:param name="flex_flash_major_version" value="11" />
  			<jsp:param name="flex_flash_minor_version" value="1" />
  			<jsp:param name="flex_flash_version_revision" value="0" />
  			<jsp:param name="flex_expressInstallSwf" value="playerProductInstall.swf" />
 			<jsp:param name="flex_application_bgcolor" value="#ffffff" />
 			<jsp:param name="flex_swf_name" value="Main" />
 			<jsp:param name="flex_swf_width" value="100%" />
 			<jsp:param name="flex_swf_height" value="100%" />
		</jsp:include>
 </html>
