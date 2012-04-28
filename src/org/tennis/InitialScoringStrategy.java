package org.tennis;

public class InitialScoringStrategy implements ScoringStrategy
{
	private static final String[] scores = {"0", "15", "30", "40"};
	private static final int INDEX_OF_40 = scores.length - 1;

	private int aScoreIndex = 0;
	private int bScoreIndex = 0;

	private final TennisGame tennisGame;

	public InitialScoringStrategy(TennisGame tennisGame)
	{
		this.tennisGame = tennisGame;
	}

	@Override
	public void aScores()
	{
		aScoreIndex++;
		checkForDeuce();
	}

	@Override
	public void bScores()
	{
		bScoreIndex++;
		checkForDeuce();
	}

	private void checkForDeuce()
	{
		if (isDeuce())
			tennisGame.deuce();
	}

	@Override
	public String getScore()
	{
		if (aWon())
			return "A Wins";

		if (bWon())
			return "B Wins";

		return runningScore();
	}

	private String runningScore()
	{
		return scores[aScoreIndex] + "-" + scores[bScoreIndex];
	}

	private boolean aWon()
	{
		return aScoreIndex == scores.length;
	}

	private boolean bWon()
	{
		return bScoreIndex == scores.length;
	}

	private boolean isDeuce()
	{
		return aScores40() && bScores40();
	}

	private boolean aScores40()
	{
		return aScoreIndex == INDEX_OF_40;
	}

	private boolean bScores40()
	{
		return bScoreIndex == INDEX_OF_40;
	}
}
