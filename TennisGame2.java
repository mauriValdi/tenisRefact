
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getLiteralScore(){
    	String P1res = "";
    	String P2res = "";
        String literalScore = "";
        if (player1Points == player2Points && player1Points < 4)
            literalScore = getDrawResult(player1Points);
        if (player1Points==player2Points && player1Points>=3)
            literalScore = "Deuce";
        if (player1Points > 0 && player2Points==0)
        {
            P1res = getPlayerLiteralPoints(player1Points);
            P2res = "Love";
            literalScore = P1res + "-" + P2res;
        }
        if (player2Points > 0 && player1Points==0)
        {
            P2res = getPlayerLiteralPoints(player2Points);
            P1res = "Love";
            literalScore = P1res + "-" + P2res;
        }  
        if (player1Points>player2Points && player1Points < 4 && player2Points > 0)
        {
            P1res = getPlayerLiteralPoints(player1Points);
            P2res = getPlayerLiteralPoints(player2Points);
            literalScore = P1res + "-" + P2res;
        }
        if (player2Points>player1Points && player2Points < 4 && player1Points > 0)
        {
            P2res = getPlayerLiteralPoints(player2Points);
            P1res = getPlayerLiteralPoints(player1Points);
            literalScore = P1res + "-" + P2res;
        }
        if (player1Points > player2Points && player2Points >= 3)
            literalScore = "Advantage player1";
        if (player2Points > player1Points && player1Points >= 3)
            literalScore = "Advantage player2";
        if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
            literalScore = "Win for player1";
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
            literalScore = "Win for player2";
        return literalScore;
    }

	private String getPlayerLiteralPoints(int playerPoints) {
		if (playerPoints==1)
		    return "Fifteen";
		if (playerPoints==2)
		    return "Thirty";
        if (playerPoints==3)
            return "Forty";
		return "";
	}


	private String getDrawResult(int points) {
		String aux = "";
		if (points==0)
			aux = "Love";
		if (points==1)
			aux = "Fifteen";
		if (points==2)
			aux=  "Thirty";
		aux += "-All";
		return aux;
	}
    
    public void setPlayer1Score(int potins){
        
        for (int i = 0; i < potins; i++)
        {
            player1Score();
        }
            
    }
    
    public void setPlayer2Score(int points){
        
        for (int i = 0; i < points; i++)
        {
            player2Score();
        }
            
    }
    
    public void player1Score(){
        player1Points++;
    }
    
    public void player2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Score();
        else
            player2Score();
    }
}