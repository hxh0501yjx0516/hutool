package cn.hutool.core.utillearn;

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
         return new int[1];
    }



}
