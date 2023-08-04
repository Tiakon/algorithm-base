package cn.tiakon.java.zbook.chapter06.example01;

import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/**
 * https://cloud.tencent.com/developer/article/1731494
 * https://www.cnblogs.com/allensun/archive/2011/02/16/1956532.html
 * https://blog.csdn.net/yang353933546/article/details/122732903
 * https://segmentfault.com/a/1190000039995197?utm_source=sf-similar-article
 * https://www.inlighting.org/archives/java-implement-bloom-filter
 * https://juejin.cn/post/6937174232157650951
 * https://blog.csdn.net/jdsjlzx/article/details/43916241
 * https://www.jianshu.com/p/69a852b0468f
 * https://blog.csdn.net/bb_ji/article/details/124526978
 * 布隆过滤器
 */
public class BloomFilterDemo01 {

    private long n;   //数据总量
    private double p; //允许失误率
    private long m;   //布隆过滤器大小 m = -(n*lnp)/(ln2)^2
    private int k;    //哈希函数个数 k = ln2*(m/n)
    private long[] bitMap;    // 数据域 选用long[]意味着 m 最大为64*Integer.MAX_VALUE
    //Hash算法名称
    private static final String[] HASH_ALGORITHM = {
            "MD5", "SHA1", "MD2", "SHA-256", "SHA-384", "SHA-512", "SHA-224"
    };

    public BloomFilterDemo01() {
    }

    public BloomFilterDemo01(long n, double p) {
        this.n = n;
        this.p = p;
        this.m = -(long) Math.ceil(n * Math.log(p) / Math.pow(Math.log(2), 2));
        this.k = (int) (Math.log(2) * (this.m / n));
        this.bitMap = new long[(int) Math.ceil(this.m / 64.0)];
    }

    /**
     * 将bitMap中指定位 置1
     *
     * @param index 偏移量
     */
    public void setBit(long index) {
        int idx = (int) index / 64;
        int offSet = (int) index % 64;
        this.bitMap[idx] |= (long) 1 << (64 - offSet);
    }

    /**
     * 判断指定位置是否被set过
     *
     * @param index 偏移量
     * @return
     */
    public boolean getBit(long index) {
        int idx = (int) index / 64;
        int offSet = (int) index % 64;
        return (this.bitMap[idx] & 1L << (64 - offSet)) != 0;
    }

    /**
     * 将hash算法得到的byte[]转为long类型的在bitMap中的偏移量
     *
     * @param bytes
     * @return
     */
    public long changeByte2LongIndex(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return Math.abs(buffer.getLong() % this.m);
    }

    /**
     * 向过滤器放数据
     *
     * @param url
     * @throws Exception
     */
    public void put(String url) throws Exception {
        for (int i = 0; i < k && i < HASH_ALGORITHM.length; i++) {
            byte[] digest = MessageDigest.getInstance(HASH_ALGORITHM[i]).digest(url.getBytes());
            long index = changeByte2LongIndex(digest);
            setBit(index);
        }
    }

    /**
     * 判断数据是否在过滤器中
     *
     * @param url
     * @return
     */
    public boolean contains(String url) throws Exception {
        for (int i = 0; i < k && i < HASH_ALGORITHM.length; i++) {
            byte[] digest = MessageDigest.getInstance(HASH_ALGORITHM[i]).digest(url.getBytes());
            long index = changeByte2LongIndex(digest);
            if (!getBit(index)) return false;
        }
        return true;
    }

    @Test
    public void demo01Test() {
        BloomFilterDemo01 filter = new BloomFilterDemo01(20000, 0.001);
        try {
            filter.put("www.baidu.com");
            Assert.assertEquals(true, filter.contains("www.baidu.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}