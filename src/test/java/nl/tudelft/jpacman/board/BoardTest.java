package nl.tudelft.jpacman.board;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BoardTest {
    private Board board;
    private Square[][] grid;
    @BeforeEach
    void setBoard(){
        grid = new Square[][] { { new BasicSquare() } };
        // Initialize the board with the grid
        board = new Board(grid);
    }
    @Test
    void testsize(){
        assertThat(board).isNotNull();
        // Ensure the board is not null
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.squareAt(0, 0)).isInstanceOf(BasicSquare.class);
    }

    @Test
    void testBoardWithNullSquare() {
        // Create a 1x1 grid with a null square
        Square[][] nullGrid = new Square[][] { { null } };

        // Initialize a new board with the grid containing the null square
        board = new Board(nullGrid);

        // Test that accessing the null square throws a NullPointerException or another exception
        assertThatThrownBy(() -> board.squareAt(0, 0))
            .isInstanceOf(NullPointerException.class);  // Change exception if board handles it differently
    }
}
