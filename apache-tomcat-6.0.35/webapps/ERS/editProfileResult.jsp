<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="main">

	<jsp:include page="header.jsp" />

  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>Edit Profile Result</span></h2>
          <a href="createProfile.action">Create</a> | <a href="searchProfile.action">Search</a> | <a href="allProfile.action">List</a><br/>
          <br/>
          <s:actionmessage />
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  
  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
