package cn.hutool.core.utillearn;

import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.math3.optim.univariate.BrentOptimizer;
import org.omg.CORBA.PUBLIC_MEMBER;

public class PrimitiveArrayUtilLearn {
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 生成重新定义的数组<br>
     * 调整后的数组，扩展占位或者截取
     *
     * @param array
     * @param newSize
     * @return
     */

    public static byte[] resize(byte[] array, int newSize) {
        if (newSize < 0) {
            return array;
        }
        final byte[] newArray = new byte[newSize];
        if (newSize > 0 && array.length > 0) {
            System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        }
        return newArray;
    }

    /**
     * 将各个数组合并在一起<br>
     * 忽略null的数组
     *
     * @param arrays
     * @return
     */

    public static byte[] addAll(byte[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int length = 0;
        for (byte[] array : arrays) {
            if (array != null)
                length += array.length;
        }
        final byte[] result = new byte[length];
        length = 0;
        for (byte[] array : arrays) {
            if (array != null) {
                System.arraycopy(array, 0, result, length, array.length);
                length += array.length;
            }
        }
        return result;
    }

    /**
     * 将各个数组合并在一起<br>
     * 忽略null的数组
     *
     * @param arrays
     * @return
     */
    public static int[] addAll(int[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int length = 0;
        for (int[] array : arrays) {
            if (array != null) {
                length += array.length;
            }
        }
        final int[] result = new int[length];
        length = 0;
        for (int[] array : arrays) {
            System.arraycopy(array, 0, result, length, array.length);
            length += array.length;
        }
        return result;
    }

    /**
     * 将各个数组合并在一起<br>
     * 忽略null的数组
     *
     * @param arrays
     * @return
     */
    public static long[] addAll(long[]... arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int length = 0;
        for (long[] array : arrays) {
            if (null != array) {
                length += array.length;
            }
        }
        long[] result = new long[length];
        length = 0;
        for (long[] array : arrays) {
            if (null != array) {
                System.arraycopy(array, 0, result, length, array.length);
                length += array.length;

            }
        }
        return result;
    }

    /**
     * 将各个数组合并到一起<br>
     * 忽略null的空数组
     *
     * @param arrays
     * @return
     */
    public static double[] addAll(double[]... arrays) {
        if (arrays.length == 1)
            return arrays[0];
        int length = 0;
        for (double[] array : arrays) {
            if (null != array) {
                length += array.length;
            }
        }
        final double[] result = new double[length];
        length = 0;
        for (double[] array : arrays) {
            if (null != array) {
                System.arraycopy(array, 0, result, length, array.length);
                length += array.length;
            }
        }
        return result;
    }

    //-------------------------------------------------------------------range
    public static int[] range(int excludeEnd) {
        return range(0, excludeEnd, 1);
    }

    public static int[] range(int includeStart, int excludeEnd) {
        return range(includeStart, excludeEnd, 1);
    }

    public static int[] range(int includeStart, int excludeEnd, int step) {
        if (includeStart > excludeEnd) {
            int emp = includeStart;
            includeStart = excludeEnd;
            excludeEnd = emp;
        }
        if (step < 1)
            step = 1;
        int deviation = excludeEnd - includeStart;
        int length = deviation / step;
        if (deviation % step != 0)
            length += 1;
        int[] range = new int[length];
        for (int i = 0; i < length; i++) {
            range[i] = includeStart;
            includeStart += step;
        }
        return range;
    }
// ----------------------------------------------------------------------split


    public static int indexOf(long[] array, long value) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean contains(long[] array, long value) {
        return indexOf(array, value) > -1;
    }

    public static Integer[] wrap(int... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Integer[0];
        }
        final Integer[] result = new Integer[length];
        for (int i = 0; i < length; i++) {
            result[i] = values[i];
        }
        return result;
    }

    public static int[] unWrap(Integer... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new int[0];
        }
        final int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = ObjectUtil.defaultIfNull(values[i], 0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] initNum = {1, 2, 3};
        Integer[] result = wrap(null);
        System.err.println(result.length);

    }
}
