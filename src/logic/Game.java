package logic;

import javax.swing.*;
import java.awt.*;


public class Game {
    private String TOP;
    private String BOTTOM;
    private String LEFT_SIDE;
    private String RIGHT_SIDE;
    private String OVERALL;

    //GETTERS AND SETTERS


    public void setOVERALL(String OVERALL) {
        this.OVERALL = OVERALL;
    }

    public void setTOP(String TOP) {
        this.TOP = TOP;
    }

    public void setBOTTOM(String BOTTOM) {
        this.BOTTOM = BOTTOM;
    }

    public void setLEFT_SIDE(String LEFT_SIDE) {
        this.LEFT_SIDE = LEFT_SIDE;
    }

    public void setRIGHT_SIDE(String RIGHT_SIDE) {
        this.RIGHT_SIDE = RIGHT_SIDE;
    }

    public String getRIGHT_SIDE() {
        return RIGHT_SIDE;
    }

    public String getBOTTOM() {
        return BOTTOM;
    }

    public String getLEFT_SIDE() {
        return LEFT_SIDE;
    }

    public String getTOP() {
        return TOP;
    }

    public String getOVERALL() {
        return OVERALL;
    }

    public void checkWin(JButton[][] but, int maxSize){
        int longestSequenceBlack;
        int longestSequenceWhite;
        int x = 1;
        int counter = 0;
        boolean topSequenceBlack = true;
        boolean sideSequenceBlack = true;
        boolean sideSequenceWhite = true;
        boolean bottomSequenceWhite = true;
        Color color = new JButton().getBackground();

        //Check top sequence of black boxes
        while(x<=maxSize)
        {
            longestSequenceBlack = Integer.parseInt(but[0][x].getText());
            for(int i = 1; i <=maxSize; i++)
            {

                if(but[i][x].getBackground() == Color.BLACK)
                {
                    counter++;
                }
                else
                {
                    counter =0;
                }
                if(counter > longestSequenceBlack)
                {
                    topSequenceBlack = false;
                    break;
                }
                else
                {
                    topSequenceBlack = true;
                }
            }
            //System.out.println(topSequenceBlack);
            if(!topSequenceBlack)
                break;
            counter = 0;
            x++;
        }
        if(topSequenceBlack)
            setTOP("GOOD");
        else
            setTOP("BAD");

        longestSequenceBlack=0;
        x=1;
        counter=0;

        //check side sequence of black boxes
        while(x<=maxSize)
        {
            longestSequenceBlack = Integer.parseInt(but[x][0].getText());
            for(int j = 1; j <=maxSize; j++)
            {

                if(but[x][j].getBackground() == Color.BLACK)
                {
                    counter++;
                }
                else
                {
                    counter =0;
                }
                if(counter > longestSequenceBlack)
                {
                    sideSequenceBlack = false;
                    break;
                }
                else
                {
                    sideSequenceBlack = true;
                }
            }
            //System.out.println(sideSequenceBlack);
            if(!sideSequenceBlack)
                break;
            counter = 0;
            x++;
        }
        if(sideSequenceBlack)
            setLEFT_SIDE("GOOD");
        else
            setLEFT_SIDE("BAD");

        x=1;
        counter=0;

        while(x<=maxSize)
        {
            longestSequenceWhite = Integer.parseInt(but[x][maxSize+1].getText());
            for(int j = 1; j <=maxSize; j++)
            {

                if(but[x][j].getBackground() == new JButton().getBackground())
                {
                    counter++;
                }
                else
                {
                    counter=0;
                }
                if(counter > longestSequenceWhite)
                {
                    sideSequenceWhite = false;
                    break;
                }
                else
                {
                    sideSequenceWhite= true;
                }
            }
            //System.out.println(sideSequenceBlack);
            if(!sideSequenceWhite)
                break;
            counter = 0;
            x++;
        }
        if(sideSequenceWhite)
            setRIGHT_SIDE("GOOD");
        else
            setRIGHT_SIDE("BAD");

        x=1;
        counter=0;
        longestSequenceWhite=0;

        while(x<=maxSize)
        {
            longestSequenceWhite = Integer.parseInt(but[maxSize+1][x].getText());
            for(int j = 1; j <=maxSize; j++)
            {

                if(but[j][x].getBackground() == color)
                {
                    counter++;
                }
                else
                {
                    counter=0;
                }
                if(counter > longestSequenceWhite)
                {
                    bottomSequenceWhite = false;
                    break;
                }
                else
                {
                    bottomSequenceWhite= true;
                }
            }
            //System.out.println(sideSequenceBlack);
            if(!bottomSequenceWhite)
                break;
            counter = 0;
            x++;
        }
        if(bottomSequenceWhite)
            setBOTTOM("GOOD");
        else
            setBOTTOM("BAD");

        if(topSequenceBlack && bottomSequenceWhite && sideSequenceBlack && sideSequenceWhite)
            setOVERALL("WIN");
        else
            setOVERALL("LOSE");





    }

}
