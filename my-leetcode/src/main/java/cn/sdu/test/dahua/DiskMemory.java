package cn.sdu.test.dahua;

import java.util.Random;

/**
 * @author icatzfd
 * Created on 2020/9/7 21:32.
 */
public class DiskMemory {
    private int totalSize;

    public int getSize() {
        return (new Random().nextInt(3) + 1) * 100;//加一是为了防止获取磁盘大小为0，不符合常理
    }

    public void setSize(int size) {
        totalSize += size;
    }

    public int getTotalSize() {
        return totalSize;
    }
}
