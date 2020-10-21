package leetcode.String;

/**
 * leetcode
 * 2020/10/21 11:33
 * 长按按键匹配
 *
 * @author Frozen Chan
 * @since
 **/
public class Easy_925 {
    public boolean isLongPressedName(String name, String typed) {
        int nameLength = name.length();
        int typedLength = typed.length();
        int nameIndex = 0, typedIndex = 0;
        while (typedIndex < typedLength) {
            if (nameIndex < nameLength && name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                typedIndex ++;
                nameIndex ++;
            } else if (typedIndex > 0 && typed.charAt(typedIndex) == typed.charAt(typedIndex - 1)) {
                typedIndex ++;
            } else {
                return false;
            }
        }

        return nameIndex < nameLength ? false : true;
    }
}
