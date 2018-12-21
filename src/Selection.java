package com.example.shockdotjava.selecthelper;

import android.content.Intent;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

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

	//-----------------unfinished-------------------------------

	public void clacScore(Selection setting)
	{
		Random random = new Random();
		this.score = random.nextInt();
	}

}
