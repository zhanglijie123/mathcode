package exerciseOne.lru;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
// 1。 有二十个账户。每个账户初始余额10000元。
// 2。 有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
// 3。 每个线程执行100次转账操作。
// 4。 最后请打印出二十个账户的余额。

public class Main1 {
    public static class Accounts {
        // 银行里面有账户序列化就是从0 - 19
        private volatile int[] account = new int[] {10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
            10000, 10000, 10000, 10000, 10000, 10000, 1000, 1000};
        public CountDownLatch latch = new CountDownLatch(1000);
        public int[] getAccount() {
            return account;
        }
        public void setAccount(int[] account) {
            this.account = account;
        }
        public synchronized void transfer() {
            int N = account.length;
            //这个查询来源账户，实际中以查询数据库或者前面传参为准
            int from = (int) (Math.random() * N);
            //这个查询目的账户，实际中以查询数据库或者前面传参为准
            int to = (int) (Math.random() * N);
            //转账金额，实际以前面传参为准
            int howMoney = (int) (Math.random() * 100);
            int fromSum =  account[from];
            if (fromSum <= howMoney) {
                latch.countDown();
                throw new RuntimeException("账户余额不足");
            } else {
                account[from] = account[from] - howMoney;
                account[to] = account[to] + howMoney;
                latch.countDown();
                System.out.println("账户"+from+" 给账户 "+to+" 转账"+howMoney+" 元转账成功");
            }
        }
    }

    public static class Task implements Runnable {
        public Accounts accounts;
        public RedisLock lock;


        public Task(Accounts accounts ) {
            this.accounts = accounts;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                if(RedisLock.setLock("a.lock")) {
                    for (int i = 0; i < 100; i++) {
                        accounts.transfer();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    RedisLock.releaseLock("a.lock");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    //分布式锁对象  1 表示上锁我占有    0表示空闲没人持有  这里使用io文件代替redis
    public static class RedisLock {
        public static synchronized boolean  setLock(String file) throws IOException {
          //setNx px  可以使用红锁+看门狗续租

            FileInputStream in = new FileInputStream(file);
            int read = in.read();
            if(read==49){
                return false;//表示已经被别人占有
            }else{
                FileOutputStream out = new FileOutputStream(file);
                out.write("1".getBytes());//"1"==49
                return true;
            }
        }

        public static  synchronized boolean releaseLock(String file ) throws IOException {
           //remove  释放锁
            FileOutputStream out = new FileOutputStream(file);
            out.write("0".getBytes());//"1"==49
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Accounts accounts = new Accounts();

        Task task = new Task(accounts );

        for(int i=0;i<10;i++){
            new Thread(task).start();

        }
        /* accounts.latch.await();
        printAccount(accounts);*/
        Thread.sleep(4000);
        printAccount(accounts);

    }


    private static void printAccount( Accounts account) {
        for(int i=0;i<account.getAccount().length;i++){
            System.out.println("账户"+i+"的余额"+account.getAccount()[i]);
        }
    }
}