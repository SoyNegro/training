package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * An e-commerce website contains a list of items. To mimic the logic of the website, a programmer
 * has a list and each item is in the form of a string array: [name, relevance, price].
 * After sorting the items by (name:0, relevance :1, price:2), the programmer is trying to find out
 * which are the first X elements of the sorted list.
 *
 * Given a list of items, the sort column (0 for sorting by name, 1 for relevance and 2 for price),
 * the sort order (0: ascending, 1: descending) and the number of items to be displayed,
 * determine a list of the item names in the specified order and display only the first X.
 *
 * Example
 * ⚫ there are n=3 items: items = [[item1, 10, 15], [item2, 3, 4], [item3, 17, 8]]
 *  - Sort them by relevance (sortParameter = 1) in ascending order (sortOrder = 0);
 *     items = [[item2, 3, 4], [item1, 10, 15], [item3, 17, 8]]
 *  - Display only the first 2 elements
 *   The result is the list [item2, item1].
 * */
public class WebsitePagination {
    public static void main(String[] args) {
        var list1 = List.of("awful","4","4000");
        var list2 = List.of("beautiful","2","2000");
        var list3 = List.of("charming","3","3000");
        var list4 = List.of("dreadful","1","1000");
        var list = List.of(list1,list2,list3,list4);
        System.out.println(fetchItemsToDisplay(list,0,0,2));
        System.out.println(fetchItemsToDisplay(list,1,1,2));
        System.out.println(fetchItemsToDisplay(list,2,1,2));
    }
    static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int x) {
        var list = new ArrayList<>(items);
        list.sort((a, b) -> {
            if (sortOrder == 1) return b.get(sortParameter).compareTo(a.get(sortParameter));
            return a.get(sortParameter).compareTo(b.get(sortParameter));
        });
        List<String> res = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            res.add(list.get(i).get(sortParameter));
        }
        return res;
    }
}
