<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
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
          <h2><span>Login</span></h2>
        </div>
        <div class="article">
          <s:form method="post" theme="simple">
          <ol>
          <li>
            <label for="email">Email Address (required)</label>
            <s:textfield id="EMAIL" name="EMAIL" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="password">Password (required)</label>
            <s:password id="PASSWORD" name="PASSWORD" cssClass="text" theme="simple"></s:password>
          </li>
          <li>
            <div class="clr"></div>
            <s:submit name="action" id="action" value="Login" theme="simple" cssStyle="border:solid 1px grey; margin-top:20px;"/>
          </li>
          </ol>
          </s:form>
          <br/><s:actionmessage />
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>

  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
