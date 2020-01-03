package logic;

import javax.swing.*;
import java.awt.*;


public class Game {
    private boolean TOP, BOTTOM, LEFT_SIDE, RIGHT_SIDE, OVERALL;

    //GETTERS AND SETTERS

    public void setOVERALL(boolean OVERALL) {
        this.OVERALL = OVERALL;
    }

    public void setTOP(boolean TOP) {
        this.TOP = TOP;
    }

    public void setBOTTOM(boolean BOTTOM) {
        this.BOTTOM = BOTTOM;
    }

    public void setLEFT_SIDE(boolean LEFT_SIDE) {
        this.LEFT_SIDE = LEFT_SIDE;
    }

    public void setRIGHT_SIDE(boolean RIGHT_SIDE) {
        this.RIGHT_SIDE = RIGHT_SIDE;
    }

    public boolean getRIGHT_SIDE() {
        return RIGHT_SIDE;
    }

    public boolean getBOTTOM() {
        return BOTTOM;
    }

    public boolean getLEFT_SIDE() {
        return LEFT_SIDE;
    }

    public boolean getTOP() {
        return TOP;
    }

    public boolean getOVERALL() {
        return OVERALL;
    }

    public void checkWin(JButton[][] but, int maxSize){
        int longestSequenceBlack, longestSequenceWhite;
        int x = 1, counter = 0;
        boolean topSequenceBlack = true, bottomSequenceWhite = true;
        boolean sideSequenceBlack = true, sideSequenceWhite = true;

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
            setTOP(true);
        else
            setTOP(false);

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
            setLEFT_SIDE(true);
        else
            setLEFT_SIDE(false);

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
            setRIGHT_SIDE(true);
        else
            setRIGHT_SIDE(false);

        x=1;
        counter=0;

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
            if(!bottomSequenceWhite)
                break;
            counter = 0;
            x++;
        }
        if(bottomSequenceWhite)
            setBOTTOM(true);
        else
            setBOTTOM(false);

        if(topSequenceBlack && bottomSequenceWhite && sideSequenceBlack && sideSequenceWhite)
            setOVERALL(true);
        else
            setOVERALL(false);
    }

}
