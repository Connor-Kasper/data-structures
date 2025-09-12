import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*The map interface is generic
         * The first type parameter is the key
         * The second type parameter is the value
         */
        Map<String, Color> favColors = new HashMap<>();

        //add elements to map

        favColors.put("Connor", Color.ORANGE);
        favColors.put("Sreeram", Color.GREEN);
        favColors.put("Kaitlyn", Color.GREEN);
        favColors.put("Cam", Color.BLUE);
        favColors.put("Nimai", Color.RED);
        //Two different keys can map to the same value
        favColors.put("Nimai", Color.YELLOW); //overwrites previous value

        // Create a set of keys in a map
        Set<String> keys = favColors.keySet();
        for(String key : keys)
        {
            System.out.println(key + "(" + key.hashCode() + ")" + ": " + favColors.get(key));
        }
    }
}
