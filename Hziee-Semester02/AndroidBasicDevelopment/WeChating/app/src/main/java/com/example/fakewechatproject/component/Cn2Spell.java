package com.example.fakewechatproject.component;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

// 汉字转换位汉语拼音，英文字符不变
public class Cn2Spell {

    public static StringBuffer buffer = new StringBuffer();

    // 获取汉字字符串的汉语拼音，英文字符不变
    public static String getPinYin(String chines) {
        buffer.setLength(0);
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : nameChar) {
            if (c > 128) {
                try {
                    buffer.append(PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

}
