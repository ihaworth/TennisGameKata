package org.tennis;

public class TennisGame
{
	private ScoringStrategy scoringStrategy = new InitialScoringStrategy(this);

	public String getScore()
	{
		return scoringStrategy.getScore(this);
	}

	public void aScores()
	{
		scoringStrategy.aScores();
	}

	public void bScores()
	{
		scoringStrategy.bScores();
	}

	public void deuce()
	{
		scoringStrategy = new DeuceScoringStrategy();
	}
}
