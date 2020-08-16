package cn.sdu.tencent;

import java.io.*;
import java.util.*;

/**
 * @author 张峰达
 * Created on 2020/8/13 10:43.
 */

public class SortandDeweight {
    //排序去重
    int FileUniq(String input_filename, String output_filename) throws IOException {
        File file = new File(input_filename);
        BufferedReader reader = null;
        BufferedWriter writer = null;
        Set<String> set = new HashSet<>();

        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        //去重
        while ((tempString = reader.readLine()) != null) {
            set.add(tempString);
        }
        reader.close();

        List<String> res = new ArrayList<>(set);
        Collections.sort(res);

        writer = new BufferedWriter(new FileWriter(output_filename));
        for (String str : res) {
            writer.write(str + "\r\n");
        }
        writer.close();
        return 0;
    }
}
