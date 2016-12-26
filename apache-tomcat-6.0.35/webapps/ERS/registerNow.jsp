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
          <h2><span>User Registration</span></h2>
        </div>
        <div class="article">
          <s:form method="post" theme="simple">
          <ol>
          <li>
          	<label for="category">Category (required)</label>
            <s:select id="CATEGORY" name="CATEGORY" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'E':'Employer','J':'Job Seekers'}" headerKey="0" headerValue="--Select Category--"></s:select>
          </li>
          <li>
            <label for="name">Name (required)</label>
            <s:textfield id="NAME" name="NAME" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="address">Address (required)</label>
            <s:textarea id="ADDRESS" name="ADDRESS" rows="4" cols="50" theme="simple"></s:textarea>
          </li>
          <li>
            <label for="city">City (required)</label>
            <s:textfield id="CITY" name="CITY" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="state">State (required)</label>
            <s:textfield id="STATE" name="STATE" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="email">Email Address (required)</label>
            <s:textfield id="EMAIL" name="EMAIL" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="mobile">Mobile (required)</label>
            <s:textfield id="MOBILE" name="MOBILE" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <s:submit name="action" id="action" cssClass="send" theme="simple" value="Save" cssStyle="border:solid 1px grey;"/>
            <div class="clr"></div>
          </li>
          </ol>
          </s:form>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  
  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
