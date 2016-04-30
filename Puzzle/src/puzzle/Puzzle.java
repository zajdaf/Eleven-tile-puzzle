/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Florent fz41
 */
public class Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        String[] tasks =
        {
            "**dd*daa*bddbbc_2**dd*aa_*bbdbcdd.txt",
            "**ab*_ac*dddbbdd2**bc*daa*bdd_bdd.txt",
            "**bc*ddd*dabbd_a2**_c*bbd*ddabdda.txt",
            "**dd*d_b*adabcdb2**da*add*b_dbcdb.txt",
            "**cb*_dd*bddbaad2**cb*abd*_dabddd.txt",
            "**a_*ddc*dabbddb2**c_*dab*dddbadb.txt",
            "**dd*bdd*bdaba_c2**dd*dda*b_abdbc.txt",
            "**dd*dad*bacbbd_2**dd*dad*b_dbacb.txt",
            "**ba*abd*d_dbdcd2**ba*dda*cddbdb_.txt",
            "**dd*bad*bdab_dc2**ad*bdd*d_abbdc.txt",
            "**_d*abd*bdcbdda2**dd*bdc*badba_d.txt",
            "**bd*cab*dadbd_d2**_b*abd*addbddc.txt",
            "**ad*dad*db_bdcb2**da*db_*ddabdbc.txt",
            "**dd*b_a*bddbdca2**dd*ad_*bdabbdc.txt",
            "**ab*b_a*dddbddc2**da*cbb*_dabddd.txt",
            "**db*cdd*d_abdab2**bd*cdd*baabd_d.txt"          
        };
        String initial, end;
        LinkedList<String> result;
        
        for (String board:tasks)
        {
            initial = board.substring(0,16);
            end = board.substring(17,33);
            result = solve(initial, end);
            generate(result, board);
        }
    }
    
    private static void generate(LinkedList<String> puzzle, String board) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(board.replace('*', '+'));
        for (int row = 0; row < 4; row++)
        {
            for (String state:puzzle)
                writer.print(state.substring(row * 4, row * 4 + 4) + " ");
            writer.println("");
        }
        writer.close();
    }
    
    private static LinkedList<String> solve(String initial, String end)
    {
        LinkedList<LinkedList<String>> possibilities = new LinkedList<LinkedList<String>>();
        LinkedList<String> current_path = new LinkedList<String>();
        String current_pos;
        LinkedList<String> next_moves;
        
        current_path.add(initial);
        possibilities.add(current_path);
        
        while (true)
        {
            current_path = possibilities.poll();
            current_pos = current_path.getLast();
            next_moves = move_around(current_pos);
            for (String move:next_moves)
            {
                if (!current_path.contains(move))
                {
                    LinkedList<String> new_path = new LinkedList<String>(current_path);
                    new_path.add(move);
                    if (move.equals(end))
                        return new_path;
                    possibilities.add(new_path);
                }
            }
        }
    }
    
    private static LinkedList<String> move_around(String board)
    {
        int free_tile = board.indexOf("_");
        LinkedList<String> possible_moves = new LinkedList<String>();
        
        if (free_tile % 4 != 0 && board.charAt(free_tile - 1) != '*')
            possible_moves.add(switcheroo(board, free_tile, free_tile - 1));
        if (free_tile % 4 != 3 && board.charAt(free_tile + 1) != '*')
            possible_moves.add(switcheroo(board, free_tile, free_tile + 1));
        if (free_tile - 4 >= 0 && board.charAt(free_tile - 4) != '*')
            possible_moves.add(switcheroo(board, free_tile, free_tile - 4));
        if (free_tile + 4 <= 15 && board.charAt(free_tile + 4) != '*')
            possible_moves.add(switcheroo(board, free_tile, free_tile + 4));
        return possible_moves;
    }
    
    private static String switcheroo(String board, int tile1, int tile2)
    {
        char[] c = board.toCharArray();
        char temp = c[tile1];

        c[tile1] = c[tile2];
        c[tile2] = temp;

        return new String(c);
    }
}
