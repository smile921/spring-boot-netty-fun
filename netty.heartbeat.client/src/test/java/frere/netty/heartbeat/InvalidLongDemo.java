/**
 * 
 */
package frere.netty.heartbeat;

/**
 * @author frere
 *
 */

public class InvalidLongDemo {
    long count = 0;

    public static void main(String[] args) {
        // LoadMaker.makeLoad();

        InvalidLongDemo demo = new InvalidLongDemo();

        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        for (int i = 0; ; i++) {
            long l = i;
            demo.count = l << 32 | l;
        }
    }

    ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {
//        @Override
        public void run() {
            int c = 0;
            for (int i = 0; ; i++) {
                long l = count;
                long high = l >>> 32;// 无符号右移位32位
                long low = l & 0xFFFFFFFFL;
                if (high != low) {
                    c++;
                    System.err.printf("Fuck! Got invalid long!! check time=%s, happen time=%s(%s%%), count value=%s|%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, high, low);
                } else {
                    // 如果去掉这个输出，则在我的开发机上没有观察到invalid long
                    System.out.printf("Emm... %s|%s\n", high, low);
                }
            }
        }
    }

//Emm... 2125461958|2125461958
//Emm... 2125478369|2125478369
//Emm... 2125492656|2125492656
//Fuck! Got invalid long!! check time=103529, happen time=1(9.6591294E-4%), count value=4294967295|2151869205
//Fuck! Got invalid long!! check time=103530, happen time=2(0.0019318071%), count value=4294967295|2154481199
//Fuck! Got invalid long!! check time=103531, happen time=3(0.0028976828%), count value=4294967295|2154697444
}
