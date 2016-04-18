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
public class Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String initial, end;
        LinkedList<String> result;

        initial = "**dd*daa*bddbbc_";
        end = "onche";
        
        result = solve(initial, end);
        System.out.print(result);
    }
    
    private LinkedList<String> solve(String initial, String end)
    {
        LinkedList<LinkedList<String>> possibilities = new LinkedList<LinkedList<String>>();
        LinkedList<String> current_path = new LinkedList<String>()
        String current_pos;
        LinkedList<String> next_moves;
        
        current_path.add(initial);
        possibilities.add(current_path);
        
        while (42)
        {
            current_path = possibilities.poll();
            current_pos = current_path.getLast();
            if (current_pos == end)
                return current_path;
            next_moves = move_around(current_pos);
            for (String move:next_moves)
            {
                if (!current_path.contains(move))
                {
                    LinkedList<String> new_path = new LinkedList<String>(current_path);
                    new_path.add(move);
                    possibilities.add(new_path);
                }
            }
        }
    }
    
    private LinkedList<String> move_around(String board)
    {
        free_tile = board.indexOf("_");
        LinkedList<String> possible_moves = new LinkedList<String>;
        
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
    
    private String switcheroo(String board, int tile1, int tile2)
    {
        char[] c = board.toCharArray();
        char temp = c[tile1];

        c[tile1] = c[1];
        c[tile2] = temp;

        return new String(c);
    }
}
