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
          <h2><span>Available Profiles</span></h2>
          <a href="createProfile.action">Create</a> | <a href="searchProfile.action">Search</a> | <a href="allProfile.action">List</a>
          <div style="height: 300px; overflow: auto;">
          <table width="100%">
          	<tr style="background-color:#00adeb; color: #FFFFFF;">
          		<th width="40px">#</th>
          		<th width="80px">Category</th>
          		<th width="140px">Name</th>
          		<th>Email Address</th>
          		<th width="80px">Mobile</th>
          		<th width="60px">Status</th>
          		<th>&nbsp;</th>
          	</tr>
          	<s:iterator value="userList" status="userPojo">
          	<s:if test="#userPojo.count % 2 ==0">
          		<tr style="background-color:#F0F8FF; color: navy;">
          	</s:if>
          	<s:else>
          		<tr style="background-color:#E6E6FA; color: navy;">
          	</s:else>
          	
          		<th><s:property value="#userPojo.count"/></th>
          		<td>
          			<s:if test='CATEGORY=="A"'>Administrator</s:if><s:elseif test='CATEGORY=="E"'>Employer</s:elseif><s:elseif test='CATEGORY=="J"'>Job Seeker</s:elseif><s:else>Unknown</s:else>
          		</td>
          		<td><s:property value="NAME"/></td>
          		<td><s:property value="EMAIL"/></td>
          		<td><s:property value="MOBILE"/></td>
          		<td style="text-align: center;">
          			<s:if test='IS_ACTIVE=="Y"'>Active</s:if><s:elseif test='IS_ACTIVE=="N"'>Inactive</s:elseif><s:else>Unknown</s:else>
          		</td>
          		<td style="text-align: center;"><a href="editProfile.action?action=edit&USER_ID=<s:property value='USER_ID'/>">Edit</a></td>
          	</tr>
          	</s:iterator>
          </table>
          </div>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  
  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
