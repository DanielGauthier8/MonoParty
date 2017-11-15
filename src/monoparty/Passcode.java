/*
 * @author Jesus L.
 */
public class Passcode {
	private String passcode;
	private int pXPos, oXPos, pYpos, oYPos, pPoints, oPoints;
	private Player newbie;
	private Opponent Boswer;
	
	
	public String createPasscode(){
		pXPos = newbie.getXPos();
		pYpos = newbie.getYPos();
		oXPos = Boswer.getXPos();
		oYPos = Boswer.getYPos();
		pPoints = newbie.getPoints();
		oPoints = Boswer.getPoints();
		
		passcode = "pXpos" + "pYpos" + "oXPos" + "oYPos" + "pPoints" + "oPoints";
		
		return passcode;
	}
	
	public String getPasscode(){
		passcode = createPasscode();
		
		return passcode;
	}
	
}
