
package happy.linhdn.tikinow.util;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class Utility {
    public static Observable<Long> delayExecute(int delayTimeInMillisecond) {
        return Observable
                .just((Observable.OnSubscribe<Long>) subscriber -> {
                    subscriber.onNext(0L);
                    subscriber.onCompleted();
                })
                .delay(delayTimeInMillisecond, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .countLong();
//        return Observable
//                .create((Observable.OnSubscribe<Long>) subscriber -> {
//                    subscriber.onNext(0L);
//                    subscriber.onCompleted();
//                })
//                .delay(delayTimeInMillisecond, TimeUnit.MILLISECONDS)
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread());
    }


    public static int getRandomColor() {
        Random random = new Random();
        int number = random.nextInt(Constant.HOT_KEY_LIST_COLOR.length);
        return Constant.HOT_KEY_LIST_COLOR[number % Constant.HOT_KEY_LIST_COLOR.length];
    }
}
