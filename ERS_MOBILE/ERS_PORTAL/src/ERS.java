
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class ERS extends MIDlet implements CommandListener
{
	private Display display;
	private Ticker welcometicker=new Ticker("Welcome to E Recruitment System");;
	private Form mainForm, loginForm,registerForm, SearchForm, resultForm;
	private Command login,login1, Register,Register1,BackFromRegister,submit, backfromMainMenu, search, backFromSearch, backFromResult;
	 private Command exitCommand = new Command("Exit", Command.EXIT, 1);
	 private Command backCommand=new Command("Back", Command.BACK, 1);
	 private TextField txtEmail, txtPassword,txtName,txtAddress,txtState,txtCity,txtMobile;
	 private TextField txtjobTitle, txtSkill;
	 private TextBox txtPAddress;
	 private List MenuList;
	 String url=null;
	public ERS() 
	{
		display=Display.getDisplay(this);
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException 
	{
		notifyDestroyed();
	}

	protected void pauseApp() {
		
	}

	protected void startApp() throws MIDletStateChangeException 
	{
		mainPage();
		
		display.setCurrent(mainForm);
	}

	
		

	public void commandAction(Command c, Displayable d) 
	{
		
				if (c == exitCommand) {
		            try {
						destroyApp(true);
					} catch (MIDletStateChangeException e) {
						e.printStackTrace();
					}
		        }
			else if(c.getLabel().equalsIgnoreCase("Login") && c.getPriority()==2)
				{
					makeLoginForm();
					display.setCurrent(loginForm);
				}
			else if(c.getLabel().equalsIgnoreCase("Register") && c.getPriority()==3)
				{
				registrationForm();
				display.setCurrent(registerForm);
				}
			else if(c==backCommand) {
					mainPage();
				display.setCurrent(mainForm);
			}
			else if (c==login1 && c.getPriority()==1) 
			{///////  Write the code for login
				
				new Thread()
				{
					public void run()
					{
						try {
							url="http://localhost:8081/ERS_Mobile_Web/LoginServlet?EMAIL="+txtEmail.getString()+"&PASSWORD="+txtPassword.getString()+"&METHOD=login";
							if(checkUserResult(url))
							{System.out.println(checkUserResult(url));
								mainMenu();
								display.setCurrent(MenuList);
							}
							else {
								System.out.println("User ID Not Found");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}.start();
				
			}
				
			else if (c==BackFromRegister) {
				makeLoginForm();
				display.setCurrent(mainForm);
			}	
			else if (c==Register1) {////Code for registration goes here
				
			}
			else if (c==backfromMainMenu) 
			{
					mainPage();
					display.setCurrent(mainForm);
			}
			else if(c==submit && c.getPriority()==1)
			{
				System.out.println("List Value: "+MenuList.getString(MenuList.getSelectedIndex()));
				if(MenuList.getString(MenuList.getSelectedIndex()).equalsIgnoreCase("Search Jobs"))
				{////// Code for searching JObs
					System.out.println("reached to search");
					Search();
					display.setCurrent(SearchForm);
				}
				else if(MenuList.getString(MenuList.getSelectedIndex()).equalsIgnoreCase("View Saved Jobs"))
				{
					
				}
				else if(MenuList.getString(MenuList.getSelectedIndex()).equalsIgnoreCase("View Recommended Jobs"))
				{
					
				}
				else if(MenuList.getString(MenuList.getSelectedIndex()).equalsIgnoreCase("VView Skills"))
				{
					
				}
				else if(MenuList.getString(MenuList.getSelectedIndex()).equalsIgnoreCase("View Applied Jobs"))
				{
					
				}
				
			}
		
		else if (c==backFromSearch && c.getPriority()==0) 
		{
			mainMenu();
			display.setCurrent(MenuList);
		}
				
		else if (c==backFromResult && c.getPriority()==1) {
			mainMenu();
			display.setCurrent(MenuList);
		}
		else if (c==search && c.getPriority()==1) 
		{searchResult();
			display.setCurrent(resultForm);
			///////Search Result for the jobs, 
			url="http://localhost:8081/ERS_Mobile_Web/LoginServlet?JOBTITLE="+txtjobTitle.getString()+"&JOBSKILL="+txtSkill.getString()+"&METHOD=searchJob";
			new Thread()
			{
				public void run()
				{
					try {
						resultForm.append(getData(url));
					} catch (Exception e) {
						resultForm.append("Exception " + e);
					}
				}
			}.start();
			
		}
				
	
	}
	
	private void mainPage()
	{
		
		mainForm=new Form("E Recruitment System");
		mainForm.setTicker(welcometicker);
		login=new Command("Login", Command.SCREEN, 2);
		mainForm.addCommand(login);
		Register=new Command("Register", Command.SCREEN, 3);
		mainForm.addCommand(Register);
		mainForm.addCommand(exitCommand);
		mainForm.setCommandListener(this);
	}
	
	private void searchResult()
	{
		resultForm=new Form("E Recruitment System");
		resultForm.setTicker(welcometicker);
		backFromResult=new Command("Back", Command.BACK, 1);
		resultForm.addCommand(backFromResult);
		resultForm.setCommandListener(this);
	}
	
	
	private void makeLoginForm()
	{
		loginForm=new Form("Login Here Please");
		loginForm.setTicker(welcometicker);
		login1=new Command("Login", Command.SCREEN, 1);
		loginForm.addCommand(login1);
		loginForm.addCommand(backCommand);
		txtEmail=new TextField("Emial ID", "", 30, TextField.EMAILADDR);
		txtPassword=new TextField("Password", "", 20, TextField.PASSWORD);
		loginForm.append(txtEmail);
		loginForm.append(txtPassword);
		loginForm.setCommandListener(this);
	}
	
	private void registrationForm()
	{
		registerForm=new Form("register Here");
		registerForm.setTicker(welcometicker);
		Register1=new Command("Register", Command.SCREEN, 2);
		BackFromRegister=new Command("Back", Command.BACK, 1);
		registerForm.addCommand(BackFromRegister);
		registerForm.addCommand(Register1);
		txtEmail=new TextField("Emial ID", "", 30, TextField.EMAILADDR);//String
		txtName=new TextField("Name", "", 30, TextField.ANY);//String
		txtAddress=new TextField("Address", "", 100, TextField.ANY);//string
		txtCity=new TextField("City", "", 40, TextField.ANY);//string
		txtState=new TextField("Address", "", 40, TextField.ANY);//String
		txtMobile=new TextField("Mobile Number", "", 30, TextField.PHONENUMBER);//int
		
		registerForm.append(txtEmail);
		registerForm.append(txtName);
		registerForm.append(txtAddress);
		registerForm.append(txtCity);
		registerForm.append(txtState);
		registerForm.append(txtMobile);
		registerForm.setCommandListener(this);
	}
	
	private void mainMenu()
	{
		
		MenuList=new List("E Recruitment System", List.IMPLICIT);
		MenuList.setTicker(welcometicker);
		String[] jobseekerMenu={"Search Jobs", "View Saved Jobs", "View Recommended Jobs","View Skills","View Applied Jobs"};
		for(int i=0;i<jobseekerMenu.length;i++)
		{
			MenuList.append(jobseekerMenu[i], null);
		}
		submit=new Command("Submit", Command.SCREEN, 1);
		backfromMainMenu=new Command("Logout", Command.BACK, 0);
		MenuList.addCommand(submit);
		MenuList.addCommand(backfromMainMenu);
		MenuList.setCommandListener(this);
		
	}

	private void Search()
	{
		SearchForm=new Form("Search Job Here");
		SearchForm.setTicker(welcometicker);
		txtjobTitle=new TextField("Job Title", "", 40, TextField.ANY);
		txtSkill=new TextField("Skill", "", 30, TextField.ANY);
		search=new Command("Search", Command.SCREEN, 1);
		backFromSearch=new Command("Back", Command.BACK, 0);
		SearchForm.append(txtjobTitle);
		SearchForm.append(txtSkill);
		SearchForm.addCommand(backFromSearch);
		SearchForm.addCommand(search);
		SearchForm.setCommandListener(this);
	}
	
		
	private void ViewSavedJobs()
	{
		
	}
	
	private void ViewSkills()
	{
		
	}
	
	private void ViewAppliedJobs()
	{
		
	}
	
	private void ViewRecommendedJobs()
	{
		
	}
	
	private boolean checkUserResult(String url) throws IOException
	{
		HttpConnection c=null;
		InputStream is=null;
		StringBuffer b=new StringBuffer();
		try {
			 c = (HttpConnection)Connector.open(url);
	   		 c.setRequestMethod(HttpConnection.GET);
	   		 c.setRequestProperty("User-Agent","Profile/MIDP-1.0 Configuration/CLDC-1.0");
	   		 c.setRequestProperty("Content-Language", "en-CA");
	   		 is = c.openDataInputStream();
	   		 int ch;    		 
	   		 while ((ch = is.read()) != -1) 
	   		 {
	   			 b.append((char) ch);
	   		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 finally 
	   	 {
	   		 if(is!= null) 
	   		 {
	             is.close();
	   		 }
	   		 if(c != null) 
	   		 {
	   			 c.close();
	   		 }
	   	 }
		if(b.toString().equalsIgnoreCase("true"))
			return true;
		else {
			return false;
		}
	}
	
	
	private String getData(String url) throws IOException
	{
		HttpConnection c=null;
		InputStream is=null;
		StringBuffer b=new StringBuffer();
		try {
			 c = (HttpConnection)Connector.open(url);
	   		 c.setRequestMethod(HttpConnection.GET);
	   		 c.setRequestProperty("User-Agent","Profile/MIDP-1.0 Configuration/CLDC-1.0");
	   		 c.setRequestProperty("Content-Language", "en-CA");
	   		 is = c.openDataInputStream();
	   		 int ch;    		 
	   		 while ((ch = is.read()) != -1) 
	   		 {
	   			 b.append((char) ch);
	   		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 finally 
	   	 {
	   		 if(is!= null) 
	   		 {
	             is.close();
	   		 }
	   		 if(c != null) 
	   		 {
	   			 c.close();
	   		 }
	   	 }
		return b.toString();
	}
	
}
