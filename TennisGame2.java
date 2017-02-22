
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
        if (scoreIsTied(player1Points, player2Points))
            literalScore = getTieResult(player1Points);
        if (scoreIsDeuce(player1Points, player2Points))
            literalScore = "Deuce";
        if (playerIsWinningToCero(player1Points, player2Points))
        {
            P1res = getPlayerLiteralPoints(player1Points);
            P2res = "Love";
            literalScore = P1res + "-" + P2res;
        }
        if (playerIsWinningToCero(player2Points, player1Points))
        {
            P2res = getPlayerLiteralPoints(player2Points);
            P1res = "Love";
            literalScore = P1res + "-" + P2res;
        }  
        if (playerIsWinning(player1Points, player2Points))
        {
            P1res = getPlayerLiteralPoints(player1Points);
            P2res = getPlayerLiteralPoints(player2Points);
            literalScore = P1res + "-" + P2res;
        }
        if (playerIsWinning(player2Points, player1Points))
        {
            P2res = getPlayerLiteralPoints(player2Points);
            P1res = getPlayerLiteralPoints(player1Points);
            literalScore = P1res + "-" + P2res;
        }
        if (playerHasAdvantage(player1Points, player2Points))
            literalScore = "Advantage player1";
        if (playerHasAdvantage(player2Points, player1Points))
            literalScore = "Advantage player2";
        if (playerWon(player1Points, player2Points))
            literalScore = "Win for player1";
        if (playerWon(player2Points, player1Points))
            literalScore = "Win for player2";
        return literalScore;
    }

	private boolean playerWon(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	private boolean playerHasAdvantage(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}

	private boolean playerIsWinning(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>secondPlayerPoints && firstPlayerPoints < 4 && secondPlayerPoints > 0;
	}

	private boolean playerIsWinningToCero(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > 0 && secondPlayerPoints==0;
	}

	private boolean scoreIsDeuce(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints==secondPlayerPoints && firstPlayerPoints>=3;
	}

	private boolean scoreIsTied(int fisrtPlayerPoints, int secondPlayerPoints) {
		return fisrtPlayerPoints == secondPlayerPoints && fisrtPlayerPoints < 4;
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


	private String getTieResult(int points) {
		String literal = "";
		if (points==0)
			literal = "Love";
		if (points==1)
			literal = "Fifteen";
		if (points==2)
			literal=  "Thirty";
		literal += "-All";
		return literal;
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