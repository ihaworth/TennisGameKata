package org.tennis;

public class TennisGame
{
	private final static String[] scores = {"0", "15", "30", "40"};

	private int aScoreIndex = 0;
	private int bScoreIndex = 0;

	public String getScore()
	{
		if (advantageA())
			return "Advantage A";

		if (advantageB())
			return "Advantage B";

		if (deuce())
			return "Deuce";

		if (aScoreIndex >= scores.length)
			return "A Wins";

		if (bScoreIndex >= scores.length)
			return "B Wins";

		return scores[aScoreIndex] + "-" + scores[bScoreIndex];
	}

	private boolean advantageA()
	{
		return aScoreIndex == scores.length && bScoreIndex == scores.length - 1;
	}

	private boolean advantageB()
	{
		return aScoreIndex == scores.length - 1 && bScoreIndex == scores.length;
	}

	private boolean deuce()
	{
		return aScoreIndex == scores.length - 1 && bScoreIndex == scores.length - 1;
	}

	public void aScores()
	{
		if (advantageB())
			bScoreIndex--;
		else
			aScoreIndex++;
	}

	public void bScores()
	{
		if (advantageA())
			aScoreIndex--;
		else
			bScoreIndex++;
	}
}
