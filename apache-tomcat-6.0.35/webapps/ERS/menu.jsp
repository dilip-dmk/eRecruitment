<%@taglib prefix="s2" uri="/struts-tags" %>

<ul>
	<s2:if test='#session.user.CATEGORY=="A"'>
		<li ><a href="#">Advertisement</a></li>
		<li ><a href="#">Question</a></li>
		<li><a href="profile.action">Profile</a></li>
		<li><a href="#">Settings</a></li>
		<li><a href="logout.action">Logout</a></li>
	</s2:if>
	<s2:elseif test='#session.user.CATEGORY=="E"'>
		<li ><a href="#">Vacancy</a></li>
		<li ><a href="#">Resume</a></li>
		<li><a href="#">Online Exam</a></li>
		<li><a href="#">Settings</a></li>
		<li><a href="logout.action">Logout</a></li>
	</s2:elseif>
	<s2:elseif test='#session.user.CATEGORY=="J"'>
		<li ><a href="#">Vacancy</a></li>
		<li ><a href="#">Resume</a></li>
		<li><a href="#">Profile</a></li>
		<li><a href="#">Settings</a></li>
		<li><a href="logout.action">Logout</a></li>
	</s2:elseif>
	<s2:else>
		<li><a href="aboutERS.action">About ERS</a></li>
		<li><a href="aboutDeveloper.action">About Developer</a></li>
		<li><a href="login.action">Login</a></li>
		<li><a href="registerNow.action">Register Now</a></li>
		<li><a href="contactUs.action">Contact Us</a></li>
	</s2:else>
</ul>
