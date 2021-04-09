package unacademy.SortingAndSearching;

// Working program using Reader Class

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SoringBySwapsSSWK01A {
    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] nums = new int[n];
            int[] temp = new int[n];

            for (int i = 0; i < n; i++)
                nums[i] = s.nextInt();
            System.out.println(inversionCount(nums, 0, n - 1, temp));
        }
    }

    private static long inversionCount(int[] nums, int left, int right, int[] temp) {

        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            count += inversionCount(nums, left, mid, temp);
            count += inversionCount(nums, mid + 1, right, temp);

            count += merge(nums, left, mid, right, temp);
        }

        return count;
    }

    private static long merge(int[] nums, int left, int mid, int right, int[] temp) {

        long count = 0;

//        int[] temp = new int[left + right + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];

                count += (mid - i + 1);
            }
        }

        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= right)
            temp[k++] = nums[j++];

        int p = 0;

        for (int x = left; x <= right; x++)
            nums[x] = temp[p++];

        return count;
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
} 
