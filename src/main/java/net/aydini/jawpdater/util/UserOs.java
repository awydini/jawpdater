package net.aydini.jawpdater.util;

/**utility class representing user's os
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class UserOs {

	/** The os the user is running */
	private  final String OS;

	public UserOs() {
		OS = System.getProperty("os.name").toLowerCase();
	}
	
	/**
	 * 
	 * @return os name
	 */
	public String getOsName()
	{
		return OS;
	}
	
	
	/**
	 * Check if os is windows.
	 * 
	 * @return true if the users os is windows
	 */
	public boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	/**
	 * Check if os is mac.
	 * 
	 * @return true if the users os is mac
	 */
	public boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	/**
	 * Check if os is unix.
	 * 
	 * @return true if the users os is linux or unix
	 */
	public boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}
	
    public String getPathSeperator()
    {
        
        if (isWindows()) return "\\";
        return "/";

    }
}
