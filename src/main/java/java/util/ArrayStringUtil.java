package java.util;

import day0111.Board;

public class ArrayStringUtil {

    public static int size(Board[] board) {
        return board.length;
    }


    // B. isEmpty()
    public static boolean isEmpty(Board[] board) {
        return size(board) == 0;
    }

    // C. get()
    public static Board get(Board[] board, int index) {

        return board[index];
    }

    // D. contains()
    public static boolean contains(Board[] board, Board element) {
        for (int i = 0; i < size(board); i++) {
            if (element == get(board, i)) {
                return true;
            }
        }
        return false;
    }

    // E. indexOf()
    public static int indexOf(Board[] board, Board element) {
        for (int i = 0; i < size(board); i++) {
            if (element == get(board, i)) {
                return i;
            }
        }
        return -1;
    }

    // F. add()
    public static Board[] add(Board[] board, Board element) {
        Board[] temp = new Board[size(board) + 1];
        for (int i = 0; i < size(board); i++) {
            temp[i] = get(board, i);
        }
        temp[size(board)] = element;

        return temp;
    }

    // G. add()
    public static Board[] add(Board[] board, int index, Board element) {
        Board[] temp = new Board[size(board) + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = get(board, i);
        }
        temp[index] = element;
        for (int i = index; i < size(board); i++) {
            temp[i + 1] = get(board, i);

        }
        temp = new Board[0];
        for (int i = 0; i < size(board); ) {
            if (i != index) {
                temp = add(temp, get(board, i));
            } else {
                temp = add(temp, element);
            }
        }

        return temp;
    }

    // H. set()
    public static Board set(Board[] board, int index, Board element) {
        Board original = get(board, index);
        board[index] = element;

        return original;
    }

    // I. removeByIndex()
    public static Board[] removeByIndex(Board[] board, int index) {
        Board[] temp = new Board[0];
        for (int i = 0; i < size(board); i++) {
            if (i != index) {
                temp = add(temp, get(board, i));
            }
        }

        return temp;

    }

    // J. removeByElement
    public static Board[] removeByElement(Board[] board, Board element) {
        return removeByIndex(board, indexOf(board, element));
    }

    // K. sort()
//    public static void sort(Board[] board) {
//        for (int i = 0; i < board.length - 1; i++) {
//            if (board[i] > board[i + 1]) {
//                int temp = board[i];
//                board[i] = board[i + 1];
//                board[i + 1] = temp;
//                i = -1;
//            }
//        }
//    }

}
