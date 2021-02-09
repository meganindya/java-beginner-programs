import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Vector;
public class Checkers extends Applet
{
    public void init()
    {
        setLayout(null);
        setBackground(new Color(0,150,0));
        CheckersCanvas board = new CheckersCanvas();
        add(board);
        board.newGameButton.setBackground(Color.lightGray);
        add(board.newGameButton);
        board.resignButton.setBackground(Color.lightGray);
        add(board.resignButton);
        board.message.setForeground(Color.green);
        board.message.setFont(new Font("Serif", Font.BOLD, 14));
        add(board.message);
        board.setBounds(20,20,164,164);
        board.newGameButton.setBounds(210, 60, 100, 30);
        board.resignButton.setBounds(210, 120, 100, 30);
        board.message.setBounds(0, 200, 330, 30);
    }
}
class CheckersCanvas extends Canvas implements ActionListener, MouseListener
{
    Button resignButton;
    Button newGameButton;
    Label message;
    CheckersData board;
    boolean gameInProgress;
    int currentPlayer;
    int selectedRow, selectedCol;
    CheckersMove[] legalMoves;
    public CheckersCanvas()
    {
        setBackground(Color.black);
        addMouseListener(this);
        setFont(new  Font("Serif", Font.BOLD, 14));
        resignButton = new Button("Resign");
        resignButton.addActionListener(this);
        newGameButton = new Button("New Game");
        newGameButton.addActionListener(this);
        message = new Label("",Label.CENTER);
        board = new CheckersData();
        doNewGame();
    }
    public void actionPerformed(ActionEvent evt)
    {
        Object src = evt.getSource();
        if (src == newGameButton)
            doNewGame();
        else if (src == resignButton)
            doResign();
    }
    void doNewGame()
    {
        if (gameInProgress == true)
        {
            message.setText("Finish the current game first!");
            return;
        }
        board.setUpGame();
        currentPlayer = CheckersData.RED;
        legalMoves = board.getLegalMoves(CheckersData.RED);
        selectedRow = -1;
        message.setText("Red:  Make your move.");
        gameInProgress = true;
        newGameButton.setEnabled(false);
        resignButton.setEnabled(true);
        repaint();
    }
    void doResign()
    {
        if (gameInProgress == false)
        {
            message.setText("There is no game in progress!");
            return;
        }
        if (currentPlayer == CheckersData.RED)
            gameOver("RED resigns.  BLACK wins.");
        else
            gameOver("BLACK resigns.  RED wins.");
    }
    void gameOver(String str)
    {
        message.setText(str);
        newGameButton.setEnabled(true);
        resignButton.setEnabled(false);
        gameInProgress = false;
    }
    void doClickSquare(int row, int col)
    {
        for (int i = 0; i < legalMoves.length; i++)
            if (legalMoves[i].fromRow == row && legalMoves[i].fromCol == col)
            {
                selectedRow = row;
                selectedCol = col;
                if (currentPlayer == CheckersData.RED)
                    message.setText("RED:  Make your move.");
                else
                    message.setText("BLACK:  Make your move.");
                repaint();
                return;
            }
        if (selectedRow < 0)
        {
            message.setText("Click the piece you want to move.");
            return;
        }
        for (int i = 0; i < legalMoves.length; i++)
            if (legalMoves[i].fromRow == selectedRow && legalMoves[i].fromCol == selectedCol
            && legalMoves[i].toRow == row && legalMoves[i].toCol == col) {
                doMakeMove(legalMoves[i]);
                return;
            }
            message.setText("Click the square you want to move to.");
    }
    void doMakeMove(CheckersMove move)
    {
        board.makeMove(move);
        if (move.isJump())
        {
            legalMoves = board.getLegalJumpsFrom(currentPlayer,move.toRow,move.toCol);
            if (legalMoves != null) {
                if (currentPlayer == CheckersData.RED)
                    message.setText("RED:  You must continue jumping.");
                else
                    message.setText("BLACK:  You must continue jumping.");
                selectedRow = move.toRow;
                selectedCol = move.toCol;
                repaint();
                return;
            }
        }
        if (currentPlayer == CheckersData.RED)
        {
            currentPlayer = CheckersData.BLACK;
            legalMoves = board.getLegalMoves(currentPlayer);
            if (legalMoves == null)
                gameOver("BLACK has no moves.  RED wins.");
            else if (legalMoves[0].isJump())
                message.setText("BLACK:  Make your move.  You must jump.");
            else
                message.setText("BLACK:  Make your move.");
        }
        else
        {
            currentPlayer = CheckersData.RED;
            legalMoves = board.getLegalMoves(currentPlayer);
            if (legalMoves == null)
                gameOver("RED has no moves.  BLACK wins.");
            else if (legalMoves[0].isJump())
                message.setText("RED:  Make your move.  You must jump.");
            else
                message.setText("RED:  Make your move.");
        }
        selectedRow = -1;
        if (legalMoves != null)
        {
            boolean sameStartSquare = true;
            for (int i = 1; i < legalMoves.length; i++)
                if (legalMoves[i].fromRow != legalMoves[0].fromRow
                || legalMoves[i].fromCol != legalMoves[0].fromCol) {
                    sameStartSquare = false;
                    break;
            }
            if (sameStartSquare) {
                selectedRow = legalMoves[0].fromRow;
                selectedCol = legalMoves[0].fromCol;
            }
        }
        repaint();
    }
    public void update(Graphics g)
    {
        paint(g);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        g.drawRect(0,0,getSize().width-1,getSize().height-1);
        g.drawRect(1,1,getSize().width-3,getSize().height-3);
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                if ( row % 2 == col % 2 )
                    g.setColor(Color.lightGray);
                else
                    g.setColor(Color.gray);
                g.fillRect(2 + col*20, 2 + row*20, 20, 20);
                switch (board.pieceAt(row,col)) {
                    case CheckersData.RED:
                    g.setColor(Color.red);
                    g.fillOval(4 + col*20, 4 + row*20, 16, 16);
                    break;
                    case CheckersData.BLACK:
                    g.setColor(Color.black);
                    g.fillOval(4 + col*20, 4 + row*20, 16, 16);
                    break;
                    case CheckersData.RED_KING:
                    g.setColor(Color.red);
                    g.fillOval(4 + col*20, 4 + row*20, 16, 16);
                    g.setColor(Color.white);
                    g.drawString("K", 7 + col*20, 16 + row*20);
                    break;
                    case CheckersData.BLACK_KING:
                    g.setColor(Color.black);
                    g.fillOval(4 + col*20, 4 + row*20, 16, 16);
                    g.setColor(Color.white);
                    g.drawString("K", 7 + col*20, 16 + row*20);
                    break;
                }
            }
        }
        if (gameInProgress)
        {
            g.setColor(Color.cyan);
            for (int i = 0; i < legalMoves.length; i++)
                g.drawRect(2 + legalMoves[i].fromCol*20, 2 + legalMoves[i].fromRow*20, 19, 19);
            if (selectedRow >= 0) {
                g.setColor(Color.white);
                g.drawRect(2 + selectedCol*20, 2 + selectedRow*20, 19, 19);
                g.drawRect(3 + selectedCol*20, 3 + selectedRow*20, 17, 17);
                g.setColor(Color.green);
                for (int i = 0; i < legalMoves.length; i++) {
                    if (legalMoves[i].fromCol == selectedCol && legalMoves[i].fromRow == selectedRow)
                        g.drawRect(2 + legalMoves[i].toCol*20, 2 + legalMoves[i].toRow*20, 19, 19);
                }
            }
        }
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(164, 164);
    }
    public Dimension getMinimumSize()
    {
        return new Dimension(164, 164);
    }
    public void mousePressed(MouseEvent evt)
    {
        if (gameInProgress == false)
            message.setText("Click \"New Game\" to start a new game.");
        else {
            int col = (evt.getX() - 2) / 20;
            int row = (evt.getY() - 2) / 20;
            if (col >= 0 && col < 8 && row >= 0 && row < 8)
                doClickSquare(row,col);
        }
    }
    public void mouseReleased(MouseEvent evt) { }
    public void mouseClicked(MouseEvent evt) { }
    public void mouseEntered(MouseEvent evt) { }
    public void mouseExited(MouseEvent evt) { }
}
class CheckersMove
{
    int fromRow, fromCol;
    int toRow, toCol;
    CheckersMove(int r1, int c1, int r2, int c2)
    {
        fromRow = r1;
        fromCol = c1;
        toRow = r2;
        toCol = c2;
    }
    boolean isJump()
    {
        return (fromRow - toRow == 2 || fromRow - toRow == -2);
    }
}
class CheckersData
{
    public static final int
    EMPTY = 0,
    RED = 1,
    RED_KING = 2,
    BLACK = 3,
    BLACK_KING = 4;
    private int[][] board;
    public CheckersData()
    {
        board = new int[8][8];
        setUpGame();
    }
    public void setUpGame()
    {
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                if ( row % 2 == col % 2 )
                {
                    if (row < 3)
                        board[row][col] = BLACK;
                    else if (row > 4)
                        board[row][col] = RED;
                    else
                        board[row][col] = EMPTY;
                }
                else
                    board[row][col] = EMPTY;
            }
        }
    }
    public int pieceAt(int row, int col)
    {
        return board[row][col];
    }
    public void setPieceAt(int row, int col, int piece)
    {
        board[row][col] = piece;
    }
    public void makeMove(CheckersMove move)
    {
        makeMove(move.fromRow, move.fromCol, move.toRow, move.toCol);
    }
    public void makeMove(int fromRow, int fromCol, int toRow, int toCol)
    {
        board[toRow][toCol] = board[fromRow][fromCol];
        board[fromRow][fromCol] = EMPTY;
        if (fromRow - toRow == 2 || fromRow - toRow == -2)
        {
            int jumpRow = (fromRow + toRow) / 2;
            int jumpCol = (fromCol + toCol) / 2;
            board[jumpRow][jumpCol] = EMPTY;
        }
        if (toRow == 0 && board[toRow][toCol] == RED)
            board[toRow][toCol] = RED_KING;
        if (toRow == 7 && board[toRow][toCol] == BLACK)
            board[toRow][toCol] = BLACK_KING;
    }
    public CheckersMove[] getLegalMoves(int player)
    {
        if (player != RED && player != BLACK)
            return null;
        int playerKing;
        if (player == RED)
            playerKing = RED_KING;
        else
            playerKing = BLACK_KING;
        Vector moves = new Vector();
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                if (board[row][col] == player || board[row][col] == playerKing)
                {
                    if (canJump(player, row, col, row+1, col+1, row+2, col+2))
                        moves.addElement(new CheckersMove(row, col, row+2, col+2));
                    if (canJump(player, row, col, row-1, col+1, row-2, col+2))
                        moves.addElement(new CheckersMove(row, col, row-2, col+2));
                    if (canJump(player, row, col, row+1, col-1, row+2, col-2))
                        moves.addElement(new CheckersMove(row, col, row+2, col-2));
                    if (canJump(player, row, col, row-1, col-1, row-2, col-2))
                        moves.addElement(new CheckersMove(row, col, row-2, col-2));
                }
            }
        }
        if (moves.size() == 0)
        {
            for (int row = 0; row < 8; row++)
            {
                for (int col = 0; col < 8; col++)
                {
                    if (board[row][col] == player || board[row][col] == playerKing)
                    {
                        if (canMove(player,row,col,row+1,col+1))
                            moves.addElement(new CheckersMove(row,col,row+1,col+1));
                        if (canMove(player,row,col,row-1,col+1))
                            moves.addElement(new CheckersMove(row,col,row-1,col+1));
                        if (canMove(player,row,col,row+1,col-1))
                            moves.addElement(new CheckersMove(row,col,row+1,col-1));
                        if (canMove(player,row,col,row-1,col-1))
                            moves.addElement(new CheckersMove(row,col,row-1,col-1));
                    }
                }
            }
        }
        if (moves.size() == 0)
            return null;
        else
        {
            CheckersMove[] moveArray = new CheckersMove[moves.size()];
            for (int i = 0; i < moves.size(); i++)
                moveArray[i] = (CheckersMove)moves.elementAt(i);
            return moveArray;
        }
    }
    public CheckersMove[] getLegalJumpsFrom(int player, int row, int col)
    {
        if (player != RED && player != BLACK)
            return null;
        int playerKing;
        if (player == RED)
            playerKing = RED_KING;
        else
            playerKing = BLACK_KING;
        Vector moves = new Vector();
        if (board[row][col] == player || board[row][col] == playerKing)
        {
            if (canJump(player, row, col, row+1, col+1, row+2, col+2))
                moves.addElement(new CheckersMove(row, col, row+2, col+2));
            if (canJump(player, row, col, row-1, col+1, row-2, col+2))
                moves.addElement(new CheckersMove(row, col, row-2, col+2));
            if (canJump(player, row, col, row+1, col-1, row+2, col-2))
                moves.addElement(new CheckersMove(row, col, row+2, col-2));
            if (canJump(player, row, col, row-1, col-1, row-2, col-2))
                moves.addElement(new CheckersMove(row, col, row-2, col-2));
        }
        if (moves.size() == 0)
            return null;
        else
        {
            CheckersMove[] moveArray = new CheckersMove[moves.size()];
            for (int i = 0; i < moves.size(); i++)
                moveArray[i] = (CheckersMove)moves.elementAt(i);
            return moveArray;
        }
    }
    private boolean canJump(int player, int r1, int c1, int r2, int c2, int r3, int c3)
    {
        if (r3 < 0 || r3 >= 8 || c3 < 0 || c3 >= 8)
            return false;
        if (board[r3][c3] != EMPTY)
            return false;
        if (player == RED)
        {
            if (board[r1][c1] == RED && r3 > r1)
                return false;
            if (board[r2][c2] != BLACK && board[r2][c2] != BLACK_KING)
                return false;
            return true;
        }
        else
        {
            if (board[r1][c1] == BLACK && r3 < r1)
                return false;
            if (board[r2][c2] != RED && board[r2][c2] != RED_KING)
                return false;
            return true;
        }
    }
    private boolean canMove(int player, int r1, int c1, int r2, int c2)
    {
        if (r2 < 0 || r2 >= 8 || c2 < 0 || c2 >= 8)
            return false;
        if (board[r2][c2] != EMPTY)
            return false;
        if (player == RED)
        {
            if (board[r1][c1] == RED && r2 > r1)
                return false;
            return true;
        }
        else
        {
            if (board[r1][c1] == BLACK && r2 < r1)
                return false;
            return true;
        }
    }
}