/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

/**
 *
 * @author Florent
 */
public class Board {
    private Case[] tiles = new Case[16];

    public Board(String config) {
        for (int i = 0, n = config.length(); i < n; i++)
        {
            char c = config.charAt(i);
            tiles[i] = new Case(i % 4, i % 4, c, i + 1);
        }
    }
    
    public void Show()
    {
        String line = "";
        for (Case tile : tiles)
        {
            line+= tile.getLetter();
            if (tile.getRow() == 3)
            {
                System.out.println(line);
                line = "";
            }
        }
    }
    
}
