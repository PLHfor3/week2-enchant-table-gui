package com.gmail.prestonhigg17;

public class CalculateTableLevel
{
    private int numOfDetectedShelves;
    private int numOfBlockedShelves;

    public CalculateTableLevel(int numOfDetectedShelves, int numOfBlockedShelves)
    {
        this.numOfDetectedShelves = numOfDetectedShelves;
        this.numOfBlockedShelves = numOfBlockedShelves;
    }

    private int calculateActualNumberOfShelves()
    {
        return numOfDetectedShelves - numOfBlockedShelves;
    }

    public int[] getTableLevel()
    {
        int numShelves = calculateActualNumberOfShelves();
        int[] result = new int[3];
        switch (numShelves)
        {
            case 0 ->
            {
                result[0] = 1;
                result[1] = 6;
                result[2] = 8;
                return result;
            }
            case 1 ->
            {
                result[0] = 3;
                result[1] = 7;
                result[2] = 9;
                return result;
            }
            case 2 ->
            {
                result[0] = 3;
                result[1] = 8;
                result[2] = 11;
                return result;
            }
            case 3 ->
            {
                result[0] = 4;
                result[1] = 9;
                result[2] = 12;
                return result;
            }
            case 4 ->
            {
                result[0] = 4;
                result[1] = 10;
                result[2] = 14;
                return result;
            }
            case 5 ->
            {
                result[0] = 5;
                result[1] = 11;
                result[2] = 15;
                return result;
            }
            case 6 ->
            {
                result[0] = 5;
                result[1] = 12;
                result[2] = 17;
                return result;
            }
            case 7 ->
            {
                result[0] = 6;
                result[1] = 13;
                result[2] = 18;
                return result;
            }
            case 8 ->
            {
                result[0] = 6;
                result[1] = 14;
                result[2] = 20;
                return result;
            }
            case 9 ->
            {
                result[0] = 7;
                result[1] = 15;
                result[2] = 21;
                return result;
            }
            case 10 ->
            {
                result[0] = 7;
                result[1] = 16;
                result[2] = 23;
                return result;
            }
            case 11 ->
            {
                result[0] = 8;
                result[1] = 17;
                result[2] = 24;
                return result;
            }
            case 12 ->
            {
                result[0] = 8;
                result[1] = 18;
                result[2] = 26;
                return result;
            }
            case 13 ->
            {
                result[0] = 9;
                result[1] = 19;
                result[2] = 27;
                return result;
            }
            case 14 ->
            {
                result[0] = 9;
                result[1] = 20;
                result[2] = 29;
                return result;
            }
            case 15 - 24 ->
            {
                result[0] = 10;
                result[1] = 21;
                result[2] = 30;
                return result;
            }
            default ->
            {
            }
        }
        return result;
    }
}