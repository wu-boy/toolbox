package org.wu.toolbox.collections;

/**
 * 数组工具类
 * @author wusq
 * @date 2020/8/30
 */
public class ArrayUtils {

	/**
     * 合并数组
	 * @param firstArray 第一个数组
	 * @param secondArray 第二个数组
	 * @return 合并后的数组
	 */
	public static byte[] concat(byte[] firstArray, byte[] secondArray) {
		byte[] result = null;
		if (firstArray == null || secondArray == null) {
			return result;
		}
		result = new byte[firstArray.length + secondArray.length];
		System.arraycopy(firstArray, 0, result, 0, firstArray.length);
		System.arraycopy(secondArray, 0, result, firstArray.length, secondArray.length);
		return result;
	}
}
