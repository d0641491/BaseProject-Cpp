package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Setting
{
    private ArrayList<Selection> setting;
    private int weight[][];
    public final static int NUM_OF_TYPES = 3;

    public Setting()
    {
        setting = new ArrayList<Selection>(NUM_OF_TYPES);
        this.weight = new int[NUM_OF_TYPES][5];
        for(int i = 0; i < NUM_OF_TYPES; i++)
        {
            Selection temp = new Selection("Unset");
            setting.add(temp);
            Arrays.fill(this.weight[i],0);
        }

    }

    public Selection getSettingByType(String Type)
    {
        for(int i = 0; i < NUM_OF_TYPES; i++)
        {
            if(this.setting.get(i).SelectionName().equals(Type))
                return this.setting.get(i);
        }
        return null;
    }

    public int getWeight(String type, int answerIndex)
    {
        for(int i = 0; i < NUM_OF_TYPES; i++)
        {
            if(this.setting.get(i).SelectionName().equals(type))
                return this.weight[i][answerIndex];
        }
        return -1;
    }

    public void setSettingByType(String type, Selection setting, int weight[])
    {
        for(int i = 0; i < NUM_OF_TYPES; i++)
        {
            if(this.setting.get(i).SelectionName().equals(type))
            {
                this.setting.set(i, setting);
                this.weight[i] = Arrays.copyOf(weight,5);
                return;
            }

        }

        for(int i = 0; i < NUM_OF_TYPES; i++)
        {
            if(this.setting.get(i).SelectionName().equals("Unset"))
            {
                this.setting.set(i, setting);
                this.weight[i] = Arrays.copyOf(weight,5);
                return;
            }
        }
    }
}
