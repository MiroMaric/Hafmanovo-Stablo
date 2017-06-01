package stabla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cvorovi.Cvor;

public class BTreePrinter {
	
	public static String tekst = "";
	
    public static <T extends Comparable<?>> String printNode(Cvor root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        return tekst;
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Cvor> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Cvor> newNodes = new ArrayList<Cvor>();
        for (Cvor node : nodes) {
            if (node != null) {
                tekst+=node.simbol;//System.out.print(node.frekvencija);
                newNodes.add(node.levo);
                newNodes.add(node.desno);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                tekst+=" ";//System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        tekst+="\n";//System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).levo != null)
                    tekst+="/"; //System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).desno != null)
                    tekst+="\\";//System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            tekst+="\n";//System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            tekst+=" ";//System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Cvor node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.levo), BTreePrinter.maxLevel(node.desno)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}

