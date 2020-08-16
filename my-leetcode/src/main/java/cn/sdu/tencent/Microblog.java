package cn.sdu.tencent;

import java.util.*;

/**
 * @author 张峰达
 * Created on 2020/8/13 10:32.
 */
class Record {
    public Record() {
    }

    public Record(String userA, String userB) {
        this.userA = userA;
        this.userB = userB;
    }

    // 表示userA关注userB
    String userA;
    String userB;
}

public class Microblog {
    static void GetTopUser(final List<Record> vecRecords,
                           String strUserMaxFollow, String strUserMaxFollowed) {
        //关注人数的map
        HashMap<String, Integer> follow = new HashMap<>();
        //粉丝数的map
        HashMap<String, Integer> followed = new HashMap<>();
        int maxFollow = 0, maxFollowed = 0;
        for (Record record : vecRecords) {
            String followUser = record.userA;
            String followedUesr = record.userB;
            //关注者
            Integer followTmp = follow.get(followUser);
            if (followTmp == null) {
                followTmp = 1;
            } else {
                followTmp++;
            }
            maxFollow = Math.max(followTmp, maxFollow);
            follow.put(followUser, followTmp);

            //被关注者
            Integer followedTmp = followed.get(followedUesr);
            if (followedTmp == null) {
                followedTmp = 1;
            } else {
                followedTmp++;
            }
            maxFollowed = Math.max(followedTmp, maxFollowed);
            followed.put(followedUesr, followedTmp);
        }
        for (String key : follow.keySet()) {
            if (follow.get(key) == maxFollow) {
                strUserMaxFollow = key;
                break;//题目只要求一个
            }

        }
        for (String key : followed.keySet()) {
            if (followed.get(key) == maxFollowed) {
                strUserMaxFollowed = key;
                break;
            }
        }
        System.out.println(strUserMaxFollow);
        System.out.println(strUserMaxFollowed);

    }

    public static void main(String[] args) {
        ArrayList<Record> records = new ArrayList<>();
        Record record = new Record("张三", "李四");
        records.add(record);
        record = new Record("张三", "王五");
        records.add(record);
        record = new Record("张三", "赵六");
        records.add(record);
        record = new Record("王五", "赵六");
        records.add(record);
        record = new Record("李四", "赵六");
        records.add(record);
        String strUserMaxFollow = "", strUserMaxFollowed = "";
        GetTopUser(records, strUserMaxFollow, strUserMaxFollowed);
    }
}