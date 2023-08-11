package cn.tiakon.java.leetcode.simple;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * last time   : 2020/8/14 18:54
 *
 * @author tiankai.me@gmail.com on 2020/8/14 18:54.
 */
public class LC1108DefangIPAddress {

    // 3 ms	38 MB
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    // 0 ms	37.3 MB
    public String defangIPaddrPlus(String address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                s.append("[.]");
            } else {
                s.append(address.charAt(i));
            }
        }
        return s.toString();
    }
}
