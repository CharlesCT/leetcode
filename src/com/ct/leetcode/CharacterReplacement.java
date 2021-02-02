package com.ct.leetcode;

/**
 * Created by CT on 2021/2/2.
 */
public class CharacterReplacement {

    /**
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
     * 总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     *
     * 思路;声明两个指针 left和right 对于left和right我们应该有对应的查找内容 声明一个max来保存当前出现最多的字符
     * 则 max + k 就当作当前 left ~right 的最长字符串，
     * 如果 max + k < right -left,则left左移，因为最多的字符加上K已经是最大的了
     * 不管如何我们都一直右移
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int left  = 0;
        int right = 0;
        int maxCount = 0;
        int set[] = new int[26];//只出现大写字母
        while (right < s.length()){
            set[s.charAt(right) - 'A'] ++;
            maxCount = Math.max(set[s.charAt(right) - 'A'],maxCount);
            if (maxCount + k < right -left+1){
                set[s.charAt(left) -'A'] --;
                left++;
            }
            right ++;
        }
        return right - left;
    }


}
