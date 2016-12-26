import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class ApplicationFormMainClass extends MIDlet implements CommandListener
{
	Display display = Display.getDisplay(this);
	TextField t1 = new TextField("Name","",20,TextField.ANY);
	TextField t2 = new TextField("Mobile","",20,TextField.PHONENUMBER);
	TextField t3 = new TextField("Email","",20,TextField.EMAILADDR);
	
	
	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
	}

	protected void pauseApp() {
		// TODO Auto-generated method stub
		
	}

	protected void startApp() throws MIDletStateChangeException 
	{
		
		Form form = new Form("Application Form");
		form.append(t1);
		form.append(t2);
		form.append(t3);
		form.addCommand(new Command("Submit",Command.OK,2));
		form.addCommand(new Command("Reset",Command.OK,3));
		form.addCommand(new Command("Close",Command.OK,1));
		form.setCommandListener(this);
		display.setCurrent(form);
	}

	public void commandAction(Command c, Displayable d) 
	{
		System.out.println(c.getLabel());
		if(c.getLabel().equalsIgnoreCase("submit"))
		{
			System.out.println("Name = " + t1.getString());
			System.out.println("Mobile No = " + t2.getString());
			System.out.println("Email = " + t3.getString());
		}
		else if(c.getLabel().equalsIgnoreCase("reset"))
		{
			t1.setString("");
			t2.setString("");
			t3.setString("");
		}
		else if(c.getLabel().equalsIgnoreCase("close"))
		{
			try
			{
				destroyApp(true);
				display.setCurrent(null);
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	

}
