
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
            literalScore = getDrawResult(literalScore);
        if (player1Points==player2Points && player1Points>=3)
            literalScore = "Deuce";
        if (player1Points > 0 && player2Points==0)
        {
            P1res = getPlayer1LiteralPoints(P1res);
            P2res = "Love";
            literalScore = P1res + "-" + P2res;
        }
        if (player2Points > 0 && player1Points==0)
        {
            P2res = getPlayer2LiteralPoints(P2res);
            P1res = "Love";
            literalScore = P1res + "-" + P2res;
        }  
        if (player1Points>player2Points && player1Points < 4)
        {
            P1res = getPlayer1LiteralPoints(P1res);
            P2res = getPlayer2LiteralPoints(P2res);
            literalScore = P1res + "-" + P2res;
        }
        if (player2Points>player1Points && player2Points < 4)
        {
            P2res = getPlayer2LiteralPoints(P2res);
            P1res = getPlayer1LiteralPoints(P1res);
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

	private String getPlayer2LiteralPoints(String P2res) {
		if (player2Points==1)
		    P2res="Fifteen";
		if (player2Points==2)
		    P2res="Thirty";
        if (player2Points==3)
            P2res="Forty";
		return P2res;
	}

	private String getPlayer1LiteralPoints(String P1res) {
        if (player1Points==1)
            P1res="Fifteen";
		if (player1Points==2)
		    P1res="Thirty";
		if (player1Points==3)
		    P1res="Forty";
		return P1res;
	}


	private String getDrawResult(String score) {
		if (player1Points==0)
		    score = "Love";
		if (player1Points==1)
		    score = "Fifteen";
		if (player1Points==2)
		    score = "Thirty";
		score += "-All";
		return score;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}