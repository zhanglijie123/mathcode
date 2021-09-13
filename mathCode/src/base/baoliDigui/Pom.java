package base.baoliDigui;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/25 0025 0:48
 */
public class Pom {

        public  double myPow(double x, int n) {
            long N =n;///
            if(N<0){
                x = 1/x;
                N = -N;
            }
            return fastCaculate(x,N);

        }

        private  double fastCaculate(double x, long i) {
            if(i==0){
                return  1.0;///
            }
            double result = fastCaculate(x, i / 2);///
            if(i%2==1) {
                result = result * result * x;
                return result;
            }else {
                return result*result;
            }
        }

}
