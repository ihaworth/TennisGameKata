package org.tennis;

public class DeuceScoringStrategy implements ScoringStrategy
{
	private boolean advantageA = false;
	private boolean advantageB = false;

	private boolean aWon = false;
	private boolean bWon = false;

	@Override
	public String getScore()
	{
		if (aWon)
			return "A Wins";

		if (bWon)
			return "B Wins";

		if (advantageA)
			return "Advantage A";

		if (advantageB)
			return "Advantage B";

		return "Deuce";
	}

	@Override
	public void aScores()
	{
		if (advantageB)
			advantageB = false;
		else if (advantageA)
			aWon = true;
		else
			advantageA = true;
	}

	@Override
	public void bScores()
	{
		if (advantageA)
			advantageA = false;
		else if (advantageB)
			bWon = true;
		else
			advantageB = true;
	}
}
