package com.example.shockdotjava.selecthelper;


import java.util.ArrayList;


public class Selection implements Comparable<Selection>
{
	private String name;
	private ArrayList<String> Answers;
	private int selectedTimes;
	private int score;

	public Selection(String name)
	{
		this.name = name;
		Answers = new ArrayList<>();
		this.selectedTimes = 0;
	}

	public void beenSelected()
	{
		this.selectedTimes++;
	}

	public int getSelectedTimes()
	{
		return this.selectedTimes;
	}

	public String SelectionName()
	{
		return this.name;
	}

	public String getAnswerOf(int index)
	{
		return this.Answers.get(index);
	}

	public void setAnswerOf(int index, String answer)
	{
		this.Answers.set(index, answer);
	}

	public void addAnswerToSelection(String answer)
	{
		this.Answers.add(answer);
	}

	public ArrayList<String> getAnswers()
	{
		return this.Answers;
	}

	public int getScore()
	{
		return this.score;
	}

	@Override
	public int compareTo(Selection other) {
		return this.score - other.score;
	}

	public void clacScore(Selection setting)
	{
		switch(setting.SelectionName())
		{
			case "Food" :
				this.score = FoodTypeScore(setting);
				break;
			case "Drink" :
				this.score = DrinkTypeScore(setting);
				break;
			case "Other" :
				this.score = OtherTypeScore(setting);
				break;
		}
	}
	//-----------------unfinished-------------------------------
	private int FoodTypeScore(Setting setting)
	{
		int score = 0;
		
		score += (Integer.parseInt(setting.setting.get(0).getAnswerOf(0))-Integer.parseInt(this.getAnswerOf(0)) / 50 ) * setting.getWeight("Food", 0);//price score
		if(setting.setting.get(0).getAnswerOf(1).equals(this.getAnswerOf(1)))
		{
			score += setting.getWeight("Food", 1);
		}
		if(setting.setting.get(0).getAnswerOf(2).equals(this.getAnswerOf(2)))
		{
			score += setting.getWeight("Food", 2);
		}
		if(setting.setting.get(0).getAnswerOf(3).equals(this.getAnswerOf(3)))
		{
			score += setting.getWeight("Food", 3);
		}
		
		score += (Integer.parseInt(setting.setting.get(0).getAnswerOf(4))-Integer.parseInt(this.getAnswerOf(4))) * setting.getWeight("Food", 4);//time score
		score += this.selectedTimes / 5;
		
		return score;
	}

	private int DrinkTypeScore(Setting setting)
	{
		int score = 0;
		
		score += (Integer.parseInt(setting.setting.get(1).getAnswerOf(0))-Integer.parseInt(this.getAnswerOf(0)) / 10 ) * setting.getWeight("Drink", 0);//price score
		if(setting.setting.get(1).getAnswerOf(1).equals(this.getAnswerOf(1)))
		{
			score += setting.getWeight("Drink", 1);
		}
		if(setting.setting.get(1).getAnswerOf(2).equals(this.getAnswerOf(2)))
		{
			score += setting.getWeight("Drink", 2);
		}
		if(setting.setting.get(1).getAnswerOf(3).equals(this.getAnswerOf(3)))
		{
			score += setting.getWeight("Drink", 3);
		}
		
		score += (Integer.parseInt(setting.setting.get(1).getAnswerOf(4))-Integer.parseInt(this.getAnswerOf(4))) * setting.getWeight("Drink", 4);//time score
		score += this.selectedTimes / 5;
		return score;
	}

	private int OtherTypeScore(Setting setting)
	{
		int score = 0;
		
		score += (Integer.parseInt(setting.setting.get(2).getAnswerOf(0))-Integer.parseInt(this.getAnswerOf(0)) / 50 ) * setting.getWeight("Otherk", 0);//price score
		
		score += (Integer.parseInt(setting.setting.get(2).getAnswerOf(1))-Integer.parseInt(this.getAnswerOf(1))) * setting.getWeight("Other", 1);//time score
		score += this.selectedTimes / 5;
		return score;
	}

}
